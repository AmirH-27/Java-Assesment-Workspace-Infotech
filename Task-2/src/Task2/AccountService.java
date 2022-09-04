package Task2;
@FunctionalInterface
public interface AccountService {
    public void transaction(Account account, double amount);
    default void transfer(Account acc1, double amount, Account acc2){}
}

