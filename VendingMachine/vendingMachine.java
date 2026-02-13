package VendingMachine;
import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Array of snack names
        String[] snacks = {"Doritos", "Snickers", "Oreos", "Coke", "Skittles"};
        
        // Array of prices
        double[] prices = {2.00, 1.00, 3.00, 2.00, 1.00};

        // Welcome message and instructions
        System.out.println("Welcome to the Vending Machine!");
        System.out.println("Please select a snack by entering the number next to the item.");
        System.out.println("-------------------------------------------");

        // Display snack menu
        for (int i = 0; i < snacks.length; i++) {
            System.out.println((i + 1) + ". " + snacks[i] + " - $" + prices[i]);
        }

        // User picks snack
        System.out.println("\nEnter your choice (1-" + snacks.length + "): ");
        int choice = scanner.nextInt();

        // Check if choice is valid
        if (choice >= 1 && choice <= snacks.length) {
            System.out.println("You selected: " + snacks[choice - 1]);
            System.out.println("That will cost $" + prices[choice - 1]);
        } else {
            System.out.println("Invalid selection. Please restart and try again.");
        }

        scanner.close();
    }
}