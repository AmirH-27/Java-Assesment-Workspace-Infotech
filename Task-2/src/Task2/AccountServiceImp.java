package Task2;

public class AccountServiceImp extends Account implements AccountService{
    Account account;
    public AccountServiceImp(Account account) {
        super(account.getAccNum(), account.getAccName(), account.getBalance());
        this.account = account;
    }
    public AccountService deposit = (accNum, amount)->{
        if (amount > 0) {
            setBalance(getBalance() + amount);
            System.out.println("Deposit successful");
            System.out.println("-----------------------------");
        }
    };
    public AccountService withdraw = (accNum, amount)->{
        if (amount > 0 && amount <= getBalance()) {
            setBalance(getBalance()-amount);
            System.out.println("Withdraw successful");
            System.out.println("-----------------------------");
        }
    };

    @Override
    public void transaction(String accountId, double amount) {}

    @Override
    public void transfer(String accountId, double amount, Account account) {
        if(amount > 0 && amount <= getBalance()){
            setBalance(getBalance()-amount);
            account.setBalance(account.getBalance() + amount);
            System.out.println("Transfer successful");
            System.out.println("-----------------------------");
        }
    }

}
