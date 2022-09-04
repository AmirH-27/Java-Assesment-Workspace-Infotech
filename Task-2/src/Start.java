import Task2.Account;
import Task2.AccountServiceImp;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Start {
    static void Menu(){
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Transfer");
        System.out.println("4. Transaction History");
        System.out.println("5. User Details");
        System.out.println("6. Exit");
        System.out.println("-----------------------------");
    }

    public static void main(String[] args) {
        AccountServiceImp account1 = new AccountServiceImp(
                new Account("123456789", "Habib", 10000));//user1 with initial balance
        AccountServiceImp account2 = new AccountServiceImp(
                new Account("987654321", "Amir", 7000));//user2 used to transfer money from user 1

        ArrayList<String> transactionHistory = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int option = 0;
        Menu();
        while(option!=6){
            System.out.print("Enter your option: ");
            try {
                option = scanner.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid input");
                System.out.println("-----------------------------");
                break;
            }
            if(option==1){
                System.out.print("Enter amount to deposit: ");
                try{
                    double amount = scanner.nextDouble();
                    System.out.println("-----------------------------");
                    account1.deposit.transaction(account1.getAccNum(), amount);
                    transactionHistory.add(amount + " Credited to " + account1.getAccName()+" Account Number: "+account1.getAccNum());
                }
                catch (InputMismatchException e){
                    System.out.println("Invalid input");
                    System.out.println("-----------------------------");
                    break;
                }
            }
            else if(option==2){
                System.out.print("Enter amount to withdraw: ");
                try{
                    double amount = scanner.nextDouble();
                    System.out.println("-----------------------------");
                    account1.withdraw.transaction(account1.getAccNum(), amount);
                    transactionHistory.add(amount + " Debited to " + account1.getAccName()+" Account Number: "+account1.getAccNum());
                }
                catch (InputMismatchException e){
                    System.out.println("Invalid input");
                    System.out.println("-----------------------------");
                    break;
                }
            }
            else if(option==3){
                System.out.print("Enter amount to transfer: ");
                try{
                    double amount = scanner.nextDouble();
                    System.out.println("-----------------------------");
                    account1.transfer(account1.getAccNum(), amount, account2);
                    transactionHistory.add(amount + " Debited to " + account1.getAccName()+" Account Number: "+account1.getAccNum());
                    transactionHistory.add(amount + " Credited to " + account2.getAccName()+" Account Number: "+account2.getAccNum());
                }
                catch (InputMismatchException e){
                    System.out.println("Invalid input");
                    System.out.println("-----------------------------");
                    break;
                }
            }
            else if(option==4){
                System.out.println("Transaction History");
                int i =1;
                for (String s : transactionHistory) {
                    System.out.println(i+": "+s);
                    i++;
                }
            }
            else if(option==5){
                System.out.println("User Details");
                System.out.println("Account Number: " + account1.getAccNum());
                System.out.println("Account Name: " + account1.getAccName());
                System.out.println("Account Balance: " + account1.getBalance());
                System.out.println("-----------------------------");
            }
            else if(option==6){
                System.out.println("Thank you for using our service");
            }
            else if(option==0){
                Menu();
            }
        }
        if(option!=6){
            main(null);
        }
    }
}
