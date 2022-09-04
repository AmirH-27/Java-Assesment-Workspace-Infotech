package Task2;
@FunctionalInterface
public interface AccountService {
    public void transaction(String accNum, double amount);
    default void transfer(String accNum, double amount, Account account){}
}

