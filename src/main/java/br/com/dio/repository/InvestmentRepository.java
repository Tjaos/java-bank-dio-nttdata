package br.com.dio.repository;

import br.com.dio.exception.AccountUseException;
import br.com.dio.exception.InvestmentNotFoundException;
import br.com.dio.exception.PixInUseException;
import br.com.dio.exception.WalletNotFoundException;
import br.com.dio.model.AccountWallet;
import br.com.dio.model.Investiment;
import br.com.dio.model.InvestmentWallet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static br.com.dio.repository.CommonsRepository.checkFundsForTransaction;

public class InvestmentRepository {

    private long nextId = 0;
    private final List<Investiment> investments = new ArrayList<>();
    private final List<InvestmentWallet> wallets = new ArrayList<>();

    public Investiment create(final long tax, final long initialFunds){
        this.nextId++;
        var investment = new Investiment(this.nextId, tax, initialFunds);
        investments.add(investment);
        return investment;
    }

    public InvestmentWallet initInvestment(final AccountWallet account, final long id){
        if (!wallets.isEmpty()) {
            var accountInUse = wallets.stream().map(InvestmentWallet::getAccount).toList();
            if (accountInUse.contains(account)) {
                throw new AccountUseException("A conta '" + account + "' já possui um investimento");
            }
        }

        var investment = findById(id);
        checkFundsForTransaction(account, investment.initialFunds());
        var wallet = new InvestmentWallet(investment, account, investment.initialFunds());
        wallets.add(wallet);
        return wallet;
    }

    public InvestmentWallet deposit(final String pix, final long funds){
        var wallet = findWalletByAccountPix(pix);
        wallet.addMoney(wallet.getAccount().reduceMoney(funds), wallet.getService(), "Deposito de investimento");
        return wallet;
    }

    public InvestmentWallet withdraw(final String pix, final long funds){
        var wallet = findWalletByAccountPix(pix);
        checkFundsForTransaction(wallet, funds);
        wallet.getAccount().addMoney(wallet.reduceMoney(funds), wallet.getService(), "Retirada de investimento");
        if (wallet.getFunds() == 0) wallets.remove(wallet);
        return wallet;
    }

    public void updateAmount(){
        wallets.forEach(w -> w.updateAmount(w.getInvestiment().tax()));
    }

    public Investiment findById(final long id){
        return investments.stream()
                .filter( a -> a.id() == id)
                .findFirst()
                .orElseThrow(
                        ()-> new InvestmentNotFoundException("O investimento '"+id+"' não foi encontrado")
                );
    }

    public InvestmentWallet findWalletByAccountPix(final String pix){
        return wallets.stream()
                .filter( w -> w.getAccount().getPix().contains(pix))
                .findFirst()
                .orElseThrow(
                        ()-> new WalletNotFoundException("A carteira não foi encontrada")
                );
    }

    public List<InvestmentWallet> listWallets(){
        return this.wallets;
    }

    public List<Investiment> list() {
        return Collections.unmodifiableList(investments);
    }

}
