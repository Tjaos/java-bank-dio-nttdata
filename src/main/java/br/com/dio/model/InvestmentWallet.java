package br.com.dio.model;

import lombok.Getter;
import lombok.ToString;

import java.time.OffsetDateTime;
import java.util.UUID;
import java.util.stream.Stream;

import static br.com.dio.model.BankService.INVESTMENT;

@ToString
@Getter
public class InvestmentWallet extends Wallet{
    private final Investiment investiment;
    private final AccountWallet account;

    public InvestmentWallet(final Investiment investiment, final AccountWallet account, final long amount) {
        super(INVESTMENT);
        this.investiment = investiment;
        this.account = account;
        addMoney(account.reduceMoney(amount), getService(), "Investimento");
    }

    public void updateAmount(final long percent){
        var amount = getFunds() * percent / 100;
        var history = new MoneyAudit(UUID.randomUUID(), getService(), "Rendimentos", OffsetDateTime.now());
        var money = Stream.generate(()-> new Money(history)).limit(amount).toList();
        this.money.addAll(money);
    }

}
