# DIO Bank

Um sistema bancário simples desenvolvido em Java que permite gerenciar contas, realizar transações e administrar investimentos.

## 📋 Funcionalidades

### Gestão de Contas
- Criar conta com chaves PIX
- Realizar depósitos
- Efetuar saques
- Fazer transferências entre contas
- Consultar extrato/histórico de transações

### Gestão de Investimentos
- Criar novos tipos de investimentos
- Iniciar carteira de investimento
- Realizar aportes em investimentos
- Resgatar valores investidos
- Atualizar rendimentos dos investimentos
- Consultar carteiras de investimento

## 🚀 Como Executar

1. Certifique-se de ter o Java 21 instalado
2. Clone o repositório
3. Execute a classe `Main`

## 📌 Menu de Opções

Ao iniciar o programa, você terá acesso às seguintes opções:

1. **Criar uma conta**
   - Informe as chaves PIX (separadas por ';')
   - Digite o valor inicial de depósito

2. **Criar um investimento**
   - Informe a taxa do investimento
   - Digite o valor inicial mínimo

3. **Fazer um investimento**
   - Informe a chave PIX da conta
   - Digite o ID do investimento desejado

4. **Depositar na conta**
   - Informe a chave PIX
   - Digite o valor do depósito

5. **Sacar da conta**
   - Informe a chave PIX
   - Digite o valor do saque

6. **Transferência entre contas**
   - Informe a chave PIX de origem
   - Informe a chave PIX de destino
   - Digite o valor da transferência

7. **Investir**
   - Informe a chave PIX
   - Digite o valor a ser investido

8. **Sacar investimento**
   - Informe a chave PIX
   - Digite o valor a ser resgatado

9. **Listar contas**
   - Exibe todas as contas cadastradas

10. **Listar investimentos**
    - Exibe todos os tipos de investimentos disponíveis

11. **Listar carteiras de investimento**
    - Exibe todas as carteiras de investimento ativas

12. **Atualizar investimentos**
    - Atualiza os rendimentos de todos os investimentos

13. **Histórico de conta**
    - Informe a chave PIX para ver o extrato

14. **Sair**
    - Encerra o programa

## ⚠️ Regras de Negócio

- Uma conta pode ter múltiplas chaves PIX
- Chaves PIX são únicas no sistema
- Não é possível sacar ou transferir valores maiores que o saldo disponível
- Uma conta pode ter apenas uma carteira de investimento
- Os investimentos têm taxa de rendimento fixa
- É possível resgatar investimentos parcialmente ou totalmente

## 🔒 Tratamento de Erros

O sistema possui tratamento para as seguintes situações:
- Conta não encontrada
- Fundos insuficientes
- Chave PIX já em uso
- Conta já possui investimento
- Carteira de investimento não encontrada

## 💰 Modelo de Dados

- **AccountWallet**: Representa uma conta bancária
- **InvestmentWallet**: Representa uma carteira de investimento
- **Investment**: Define um tipo de investimento
- **Money**: Representa as transações monetárias
- **MoneyAudit**: Registra o histórico de transações

## 🤝 Contribuição

Sinta-se à vontade para contribuir com melhorias através de Pull Requests.
