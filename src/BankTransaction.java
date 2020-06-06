import java.util.Scanner;

public class BankTransaction {
    public static void main(String[] args){

        Transaction obj1 = new Transaction("Evan", "DocH001");
        obj1.showMenu();

    }
}
class Transaction {
    double balance;
    double previousTransaction;
    String customerName;
    String customerId;

    Transaction(String cname, String cid) {
        customerName = cname;
        customerId = cid;
    }

    void deposit(double amount)
    {
        if(amount != 0)
        {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }
    void withdraw(double amount) {
        if(amount > balance) {
            System.out.println("Not enough money! Please try a smaller amount.");
        }
            else{
                balance = balance - amount;
                 previousTransaction = -amount;


            }
        }


    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occured");
        }
    }

        void showMenu()
        {
            char option='\0';
            Scanner scanner = new Scanner(System.in);

            System.out.println("Welcome "+customerName);
            System.out.println("Your ID is "+customerId);
            System.out.println("\n");
            System.out.println("A. Check Balance");
            System.out.println("B. Deposit");
            System.out.println("C. Withdraw");
            System.out.println("D. Previous Transaction");
            System.out.println("E. Exit");
            do {
                System.out.println("========================================");
                System.out.println("Enter an option");
                System.out.println("========================================");
                option = scanner.next().charAt(0);
                System.out.println("\n");

                switch (option) {

                    case 'A':
                        System.out.println("----------------------------------------");
                        System.out.println("Balance = " + balance);
                        System.out.println("----------------------------------------");
                        System.out.println("\n");
                        break;

                    case 'B':
                        System.out.println("----------------------------------------");
                        System.out.println("Enter an amount to deposit");
                        System.out.println("----------------------------------------B");
                        double amount = scanner.nextFloat();
                        double round1 = (Math.round(amount * 100));
                        deposit(round1/100);
                        System.out.println("\n");
                        break;

                    case 'C':
                        System.out.println("----------------------------------------");
                        System.out.println("Enter an amount to withdraw:");
                        System.out.println("----------------------------------------");
                        double amount2 = scanner.nextFloat();
                        double round2 = (Math.round(amount2 * 100));
                        withdraw (round2/100);
                        System.out.println("\n");
                        break;

                    case 'D':
                        System.out.println("----------------------------------------");
                        getPreviousTransaction();
                        System.out.println("----------------------------------------");
                        System.out.println("\n");
                        break;

                    case 'E':
                        System.out.println("****************************************");
                        break;

                    default:
                        System.out.println("Invalid Input! Please enter again.");
                        break;
                }




            }while(option != 'E');

            System.out.println("Thanks! Come again soon!");

        }

}

