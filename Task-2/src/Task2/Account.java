package Task2;

public class Account {

    private String accNum;
    private String accName;
    private double balance;

    public Account(String accNum, String accName, double balance) {
        this.accNum = accNum;
        this.accName = accName;
        this.balance = balance;
    }

    public String getAccNum() {
        return accNum;
    }

    public String getAccName() {
        return accName;
    }

    public double getBalance() {
        return balance;
    }
    //setter
    public void setBalance(double balance) {
        this.balance = balance;
    }

}
