package VendingMachine;
import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] snacks = {"Doritos", "Snickers", "Oreos", "Coke", "Skittles"};
        double[] prices = {2.00, 1.00, 3.00, 2.00, 1.00};

        System.out.println("Welcome to the Vending Machine!");
        System.out.println("Select a snack by entering its number.");
        System.out.println("-----------------------------------");

        for (int i = 0; i < snacks.length; i++) {
            System.out.printf("%d. %s - $%.2f%n", (i + 1), snacks[i], prices[i]);
        }

        System.out.print("\nEnter your choice (1-" + snacks.length + "): ");

        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.close();
            return;
        }

        int choice = scanner.nextInt();

        if (choice < 1 || choice > snacks.length) {
            System.out.println("Invalid selection. Please restart and try again.");
            scanner.close();
            return;
        }

        System.out.println("You selected: " + snacks[choice - 1]);
        System.out.printf("That will cost $%.2f%n", prices[choice - 1]);

        System.out.print("Enter amount of money inserted: ");

        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid money amount.");
            scanner.close();
            return;
        }

        double moneyInserted = scanner.nextDouble();

        if (moneyInserted < 0) {
            System.out.println("Money cannot be negative.");
            scanner.close();
            return;
        }

        if (moneyInserted < prices[choice - 1]) {
            System.out.println("Insufficient funds. Transaction canceled.");
            System.out.printf("Refunding $%.2f%n", moneyInserted);
            scanner.close();
            return;
        }

        scanner.nextLine(); // clear newline

        System.out.print("Confirm purchase? (yes/no): ");
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("yes")) {
            double change = moneyInserted - prices[choice - 1];

            System.out.println("Dispensing " + snacks[choice - 1] + "...");
            System.out.printf("Your change is: $%.2f%n", change);
            System.out.println("Enjoy your " + snacks[choice - 1] + "! Great choice!");
        } else {
            System.out.println("Transaction canceled.");
            System.out.printf("Refunding $%.2f%n", moneyInserted);
        }

        scanner.close();
    }
}