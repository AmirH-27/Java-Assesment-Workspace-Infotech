package Task2;

import java.util.ArrayList;

public class AccountServiceImp extends Account implements AccountService{
    Account account;
    ArrayList<Trasaction> transactionHistory = new ArrayList<>();
    public AccountServiceImp(Account account) {
        super(account.getAccNum(), account.getAccName(), account.getBalance());
        this.account = account;
    }
    public AccountService deposit = (account, amount)->{
        if (amount > 0) {
            account.setBalance(getBalance() + amount);
            transactionHistory.add(new Trasaction("Deposit", account, amount));
            System.out.println("Deposit successful");
            System.out.println("-----------------------------");
        }
    };
    public AccountService withdraw = (account, amount)->{
        if (amount > 0 && amount <= getBalance()) {
            account.setBalance(getBalance()-amount);
            transactionHistory.add(new Trasaction("Withdraw", account, amount));
            System.out.println("Withdraw successful");
            System.out.println("-----------------------------");
        }
    };

    public void printTransactionHistory(Account account){
        for (Trasaction transaction : transactionHistory) {
            if (transaction.getAccount().getAccNum().equals(account.getAccNum())) {
                System.out.println(transaction.getType() + " " + transaction.getAmount());
            }
        }
    }

    @Override
    public void transaction(Account account, double amount) {}

    @Override
    public void transfer(Account acc1, double amount, Account acc2) {
        if(amount > 0 && amount <= getBalance()){
            acc1.setBalance(acc1.getBalance()-amount);
            transactionHistory.add(new Trasaction("Debit", acc1, amount, acc2));
            acc2.setBalance(acc2.getBalance() + amount);
            transactionHistory.add(new Trasaction("Credit", acc2, amount, acc1));
            System.out.println("Transfer successful");
            System.out.println("-----------------------------");
        }
    }

}
