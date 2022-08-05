import java.util.*;

public class Account {
    private int balance;
    private int previousTransaction;
    private String customerName;
    private String customerId;

    public Account(String customerName, String customerId){
        this.customerName = customerName;
        this.customerId = customerId;
    }

    public void deposit(int amount){
        if(amount != 0){
            balance = balance+amount;
            previousTransaction = amount;
        }
    }

    public void withdraw(int amount){
        if(amount != 0){
            balance = balance-amount;
            previousTransaction = -amount;
        }
    }

    public void getPreviousTransaction(){
        if(previousTransaction > 0){
            System.out.println("Deposited "+previousTransaction);
        } else if(previousTransaction < 0){
            System.out.println("Withdrawn "+Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occured");
        }
    }

    public void calculateInterest(int years){
        double interestRate = .0185;
        double newBalance = (balance*interestRate*years)+balance;
        System.out.println("The current interest rate is " + (100*interestRate)+"%");
        System.out.println("After " + years + " years, your balance will be: " + newBalance);
    }

    public void showMenu(){
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, " + customerName + "!");
        System.out.println("Your ID is: " + customerId);
        System.out.println("");
        System.out.println("What would you like to do?");
        System.out.println("");
        System.out.println("A, Check your balance");
        System.out.println("B, Make a deposit");
        System.out.println("C, Make a withdrawal");
        System.out.println("D, View previous transaction");
        System.out.println("E, Calculate interest");
        System.out.println("F, Exit");

        do{
            System.out.println("");
            System.out.println("Enter an option: ");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println("");

            switch(option){
                //Let user to check balance
                case 'A':
                    System.out.println("=====================================");
                    System.out.println("Balance = $" + balance);
                    System.out.println("=====================================");
                    System.out.println("");
                    break;
                //Lets user to deposit amount
                case 'B':
                    System.out.println("Enter amount to deposit: ");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println("");
                    break;
                //Lets user withdraw amount
                case 'C':
                    System.out.println("Enter amount to withdraw");
                    int amount1 = scanner.nextInt();
                    withdraw(amount1);
                    System.out.println("");
                    break;
                //Allows user to view previous transaction
                case 'D':
                    System.out.println("=====================================");
                    getPreviousTransaction();
                    System.out.println("=====================================");
                    System.out.println("");
                    break;
                //Calculate accrued interest on the account after a number of years
                case 'E':
                    System.out.println("How many years of accrued interest: ");
                    int years = scanner.nextInt();
                    calculateInterest(years);
                    break;
                //Exits user account
                case 'F':
                    System.out.println("=====================================");
                    break;
                //Display error
                default:
                    System.out.println("Error: Invalid option. Please enter A, B, C, D, E");
                    break;
            }
        } while(option != 'F');
        System.out.println("Thank you for banking with us!");
    }

}
