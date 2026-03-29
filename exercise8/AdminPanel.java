package Exercise8;

import java.util.Scanner;

public class AdminPanel {
    public void displayMenu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Admin Panel ===");
            System.out.println("1. Demo the Bike Rental System");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                BikeRental br = new BikeRental();
                br.simulateApplicationInput();
            } else if (choice == 2) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}