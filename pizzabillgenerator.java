import java.util.*;

public class pizzabillgenerator {
    static int grandTotal;
    static int quantity;
    static int totalVegPizzas = 0;
    static int totalOnionPizzas = 0;
    static int totalChickenPizzas = 0;
    static int v;
    static int o;
    static int c;
    public void vegpizza(Scanner sc){
        System.out.println("----------------");
        System.out.print("Enter Quantity : ");
        int quantity=sc.nextInt();
        sc.nextLine();
        int pricePerPizza=100;
        int total=quantity*pricePerPizza;
        grandTotal += total;
        totalVegPizzas+=quantity;
        v=pricePerPizza;
        System.out.println("Total Bill ");
        System.out.println("Total Quantity :-"+quantity);
        System.out.println("Total bill :-"+total);



    }
    public void onionPizza(Scanner sc) {
        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();
        sc.nextLine();
        int pricePerPizza = 120; // Example price
        int total = quantity * pricePerPizza;
        grandTotal += total;
        totalOnionPizzas+=quantity;
        o=pricePerPizza;
        System.out.println("Total Bill for Onion Pizza: " + total);
        System.out.println("Quantity: " + quantity);
    }
    public void chickenPizza(Scanner sc) {
        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();
        sc.nextLine();
        int pricePerPizza = 150; // Example price
        int total = quantity * pricePerPizza;
        grandTotal += total;
        totalChickenPizzas+=quantity;
        c=pricePerPizza;
        System.out.println("Total Bill for Chicken Pizza: " + total);
        System.out.println("Quantity: " + quantity);
    }



    public static void main(String[] args) {
        pizzabillgenerator p=new pizzabillgenerator();
        boolean exit=false;
        Scanner sc=new Scanner(System.in);
        while (!exit){
            System.out.println("Please select an option:");
            System.out.println("1. Veg Pizza");
            System.out.println("2. Onion Pizza");
            System.out.println("3. Chicken Pizza");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");
            int choice=sc.nextInt();
            sc.nextLine();
            switch (choice){
            case 1:
                p.vegpizza(sc);
                break;
            case 2:
                p.onionPizza(sc);
                break;
            case 3:
                p.chickenPizza(sc);
                break;
            case 4 :
                exit=true;
                System.out.println("Your Total bill is :- "+grandTotal);
                System.out.println("Thank you please visit again");
                break;
            default:
                System.out.println("Invalid choice. Please select 1-4.");
                continue;
            }
            if (!exit){
                System.out.print("Do you want to add more :-[y/n] :-");
                String inp=sc.nextLine();
                if (inp.equalsIgnoreCase("n")){
                    exit=true;

                }
    
            }

        }
         System.out.println("\n----------------- Your Order Summary ---------------");
        if (totalVegPizzas > 0) {
            System.out.println("Veg Pizza: " + totalVegPizzas + " quantity ->"+"Price per pizza ->"+v+" -> Total amount of veg pizza ="+totalVegPizzas*v);
        }
        if (totalOnionPizzas > 0) {
            System.out.println("Onion Pizza: " + totalOnionPizzas + " quantity ->"+"Price per pizza ->"+o+"-> Total amount of onion pizza ="+totalOnionPizzas*o);
        }
        if (totalChickenPizzas > 0) {
            System.out.println("Chicken Pizza: " + totalChickenPizzas + " quantity ->"+"Price per pizza ->"+c+"-> Total amount of chicken pizza ="+totalChickenPizzas*c);
        }
        System.out.println("-------------------------------------------------");
        System.out.println("Your Total bill is :- " + grandTotal);
        System.out.println("Thank you please visit again");
        sc.close();
   

        
    }
    
}
