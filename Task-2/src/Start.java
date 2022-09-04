import Task2.Account;
import Task2.AccountServiceImp;

import java.util.*;

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
        ArrayList<AccountServiceImp> accountList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int option = 0;
        while(option!=7){
            Menu();
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
                    accountList.add(account);
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
            else if(option==2) {
                System.out.println("Enter your account number: ");
                String accNum;
                accNum = scanner.next();
                boolean hasAccount = false;
                for (AccountServiceImp acc : accountList) {
                    if (acc.getAccNum().equals(accNum)) {
                        hasAccount = true;
                        if (hasAccount) {
                            System.out.println("Enter your deposit amount: ");
                            try {
                                double amount = scanner.nextDouble();
                                acc.deposit.transaction(acc, amount);
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input");
                                System.out.println("-----------------------------");
                                scanner.nextLine();
                                break;
                            }
                            break;
                        }
                    }
                }
                if(!hasAccount){
                    System.out.println("Account not found");
                    System.out.println("-----------------------------");
                }
            }
            else if(option==3){
                System.out.println("Enter your account number: ");
                String accNum;
                accNum = scanner.next();
                boolean hasAccount = false;
                for (AccountServiceImp acc : accountList) {
                    if (acc.getAccNum().equals(accNum)) {
                        hasAccount = true;
                        if (hasAccount) {
                            System.out.println("Enter your withdraw amount: ");
                            try {
                                double amount = scanner.nextDouble();
                                acc.withdraw.transaction(acc, amount);
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input");
                                System.out.println("-----------------------------");
                                scanner.nextLine();
                                break;
                            }
                            break;
                        }
                    }
                }
                if(!hasAccount){
                    System.out.println("Account not found");
                    System.out.println("-----------------------------");
                }
            }
            else if(option==4){
                System.out.println("Enter your account number: ");
                String accNum;
                accNum = scanner.next();
                boolean hasAccount = false;
                for(AccountServiceImp acc: accountList){
                    if(acc.getAccNum().equals(accNum)){
                        hasAccount = true;
                        if(hasAccount){
                            System.out.println("Enter your transfer amount: ");
                            try{
                                double amount = scanner.nextDouble();
                                System.out.println("Enter the account number you want to transfer: ");
                                String accNum2 = scanner.next();
                                for (AccountServiceImp account1 : accountList) {
                                    if (account1.getAccNum().equals(accNum2)) {
                                        acc.withdraw.transaction(acc, amount);
                                        account1.deposit.transaction(account1, amount);
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
                        break;
                    }
                }
                if(!hasAccount){
                    System.out.println("Account does not exist");
                }
            }
            else if(option==5){
                System.out.println("Enter your account number: ");
                String accNum;
                accNum = scanner.next();
                boolean hasAccount = false;
                System.out.println("Transaction History");
                for(Account acc: accountList){
                    if(acc.getAccNum().equals(accNum)){
                        hasAccount = true;
                        break;
                    }
                }
                if(hasAccount){
                    for(AccountServiceImp acc: accountList){
                        if(acc.getAccNum().equals(accNum)){
                            acc.printTransactionHistory(acc);
                            System.out.println("-----------------------------");
                        }
                    }
                }
                else{
                    System.out.println("Account does not exist");
                }
            }
            else if(option==6){
                System.out.println("Enter your account number: ");
                String accNum;
                try{
                    accNum = scanner.next();
                    boolean hasAccount = false;
                    for(AccountServiceImp acc: accountList){
                        if(acc.getAccNum().equals(accNum)){
                            hasAccount = true;
                            System.out.println("Account Number: "+acc.getAccNum());
                            System.out.println("Account Name: "+acc.getAccName());
                            System.out.println("Account Balance: "+acc.getBalance());
                            System.out.println("-----------------------------");
                            break;
                        }
                    }
                    if(!hasAccount){
                        System.out.println("Account does not exist");
                    }
                }
                catch (InputMismatchException e){
                    System.out.println("Invalid input");
                    System.out.println("-----------------------------");
                    scanner.nextLine();
                    break;
                }
            }
        }
        if(option!=7){
            main(null);
        }
    }
}
