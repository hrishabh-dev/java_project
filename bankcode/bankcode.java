package bankcode;
import java.util.*;

class BankAccount{
    String name;
    int accountnumber;
    double amount;
    double balance=0;
    boolean isregistered=false;

    void registerUser(Scanner sc){
        if (isregistered){
            System.out.println("User already registered");
            return;
        }
        System.out.println("User registration");
        System.out.println("-----------------------------------------");
        System.out.print("Enter your name  :-");
        this.name=sc.nextLine();
        System.out.print("Enter account number :-");
        this.accountnumber=sc.nextInt();
        sc.nextLine();
        isregistered=true;
        System.out.println("User registered - status -> ok");

    }

    void deposit(Scanner sc){
        if (isregistered==false){
            System.out.println("User is not registered");
            return;
        }
        System.out.print("Enter amount to deposit :-");
        int deposit=sc.nextInt();
        sc.nextLine();
        if (deposit>0){
            balance+=deposit;
            System.out.println("Amount deposited :-"+deposit);
            System.out.println("Total balance :-"+balance);
        }
        else{
            System.out.println("Invalid data");
        }
    }
    void withdrawn(Scanner sc){
        if (isregistered==false){
            System.out.println("User is not registered");
            return;
        }

        System.out.println("Enter amount to be withdrawn");
        int withdrawn=sc.nextInt();
        sc.nextLine();
        if (withdrawn>0 && withdrawn<=balance){
            balance=balance-withdrawn;
            System.out.println("Amount withdrawn :-"+withdrawn);
            System.out.println("Remaining balance :-"+balance);


        }
        else{
            System.out.println("Insufficient balance or invalid data");
        }

    }
    void check_balance(){
        if (isregistered==false){
            System.out.println("Please register yourself");
            return;
        }
        System.out.println("Total Balance :"+balance);
    }

}



public class bankcode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount();
        boolean exit = false;
        while (!exit) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. User registration");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    account.deposit(sc);
                    break;
                case 2:
                    account.withdrawn(sc);
                    break;
                case 3:
                    account.registerUser(sc);
                    break;
                case 4:
                    account.check_balance();
                    break;

                case 5:
                    exit = true;
                    System.out.println("Please visit again Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }

        sc.close();

        
    }
    
}
