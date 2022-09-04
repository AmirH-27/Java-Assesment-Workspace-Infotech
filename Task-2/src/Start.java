import Task2.Account;
import Task2.AccountServiceImp;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Start {
    static void Menu(){
        System.out.println("Welcome to the Bank");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer");
        System.out.println("5. Transaction History");
        System.out.println("6. User Details");
        System.out.println("7. Exit");
        System.out.println("-----------------------------");
    }

    public static void main(String[] args) {

        AccountServiceImp account = null;
        ArrayList<String> transactionHistory = new ArrayList<>();
        ArrayList<Account> accountList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int option = 0;
        Menu();
        while(option!=7){
            System.out.println("Enter your option: ");
            try {
                option = scanner.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("Invalid input");
                System.out.println("-----------------------------");
                scanner.nextLine();
                continue;
            }
            if(option==1){
                System.out.println("Enter your account number: ");
                String accNum = scanner.next();
                System.out.println("Enter your account name: ");
                String accName = scanner.next();
                System.out.println("Enter your account balance: ");
                try{
                    double balance = scanner.nextDouble();
                    account = new AccountServiceImp(new Account(accNum, accName, balance));
                    accountList.add(new Account(accNum, accName, balance));
                    System.out.println("Account created successfully");
                    System.out.println("-----------------------------");
                }
                catch (InputMismatchException e){
                    System.out.println("Invalid input");
                    System.out.println("-----------------------------");
                    scanner.nextLine();
                    break;
                }
            }
            else if(option==2){
                System.out.println("Enter your account number: ");
                String accNum = scanner.next();
                System.out.println("Enter your deposit amount: ");
                try{
                    double amount = scanner.nextDouble();
                    account.deposit.transaction(accNum, amount);
                    transactionHistory.add("Credited: " + amount+" to " + accNum);
                }
                catch (InputMismatchException e){
                    System.out.println("Invalid input");
                    System.out.println("-----------------------------");
                    scanner.nextLine();
                    break;
                }
            }
            else if(option==3){
                System.out.println("Enter your account number: ");
                String accNum = scanner.next();
                System.out.println("Enter your withdraw amount: ");
                try{
                    double amount = scanner.nextDouble();
                    account.withdraw.transaction(accNum, amount);
                    transactionHistory.add("Debited: " + amount+" from "+accNum);
                }
                catch (InputMismatchException e){
                    System.out.println("Invalid input");
                    System.out.println("-----------------------------");
                    scanner.nextLine();
                    break;
                }
            }
            else if(option==4){
                System.out.println("Enter your account number: ");
                String accNum = scanner.next();
                System.out.println("Enter your transfer amount: ");
                try{
                    double amount = scanner.nextDouble();
                    System.out.println("Enter the account number you want to transfer: ");
                    String accNum2 = scanner.next();
                    for (Account account1 : accountList) {
                        if (account1.getAccNum().equals(accNum2)) {
                            account.transfer(accNum, amount, account1);
                            transactionHistory.add("Transfer: " + amount);
                        }
                    }
                }
                catch (InputMismatchException e){
                    System.out.println("Invalid input");
                    System.out.println("-----------------------------");
                    scanner.nextLine();
                    break;
                }
            }
            else if(option==5){
                System.out.println("Transaction History");
                String accNum = scanner.next();
                for (String s : transactionHistory) {
                    if(accNum.equals(account.getAccNum())){
                        System.out.println(s);
                    }
                    System.out.println(s);
                }
                System.out.println("-----------------------------");
            }
            else if(option==6){
                for(Account acc: accountList){
                    System.out.println("Account Number: "+acc.getAccNum());
                    System.out.println("Account Name: "+acc.getAccName());
                    System.out.println("Account Balance: "+acc.getBalance());
                    System.out.println("-----------------------------");
                }
            }
        }
        if(option!=7){
            main(null);
        }
    }
}
