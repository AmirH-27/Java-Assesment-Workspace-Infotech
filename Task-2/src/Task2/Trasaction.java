package Task2;

public class Trasaction {
    String type;
    Account account, accountTransferred;
    double amount;

    public Trasaction(String type, Account account, double amount) {
        this.type = type;
        this.account = account;
        this.amount = amount;
    }
    public Trasaction(String type, Account account, double amount, Account accountTransferred) {
        this.type = type;
        this.account = account;
        this.amount = amount;
        this.accountTransferred = accountTransferred;
    }
    public String getType() {
        return type;
    }
    public Account getAccount() {
        return account;
    }
    public double getAmount() {
        return amount;
    }
    public Account getAccountTransferred() {
        return accountTransferred;
    }

}
