import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AdminPanel {
    private List<RegisteredUsers> registeredUsersList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void userManagementOptions() {
        while (true) {
            System.out.println("\nWelcome to E-Ryder Administrator Panel.");
            System.out.println("What do you want to do?");
            System.out.println("1. Add New Users");
            System.out.println("2. View Registered Users");
            System.out.println("3. Remove Registered Users");
            System.out.println("4. Update Registered Users");
            System.out.println("5. EXIT");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                choice = -1;
            }

            switch (choice) {
                case 1:
                    addNewUsers();
                    break;
                case 2:
                    viewRegisteredUsers();
                    break;
                case 3:
                    removeRegisteredUsers();
                    break;
                case 4:
                    updateRegisteredUsers();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again");
            }
        }
    }

    private void addNewUsers() {
        System.out.print("How many users would you like to add? ");
        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < number; i++) {
            System.out.println("\n--- Enter details for User " + (i + 1) + " ---");

            System.out.print("Full Name: ");
            String fullName = scanner.nextLine();

            System.out.print("Email Address: ");
            String emailAddress = scanner.nextLine();

            System.out.print("Date of Birth (YYYY-MM-DD): ");
            String dateOfBirth = scanner.nextLine();

            System.out.print("Card Number: ");
            String cardNumber = scanner.nextLine();

            System.out.print("Card Expiry Date: ");
            String cardExpiryDate = scanner.nextLine();

            System.out.print("Card Provider: ");
            String cardProvider = scanner.nextLine();

            System.out.print("CVV: ");
            String cvv = scanner.nextLine();

            System.out.print("User Type: ");
            String userType = scanner.nextLine();

            String[] lastThreeTrips = new String[3];
            for (int t = 0; t < 3; t++) {
                System.out.println("\n--- Trip " + (t + 1) + " ---");
                System.out.print("Trip Date (YYYY-MM-DD): ");
                String date = scanner.nextLine();

                System.out.print("Source: ");
                String source = scanner.nextLine();

                System.out.print("Destination: ");
                String destination = scanner.nextLine();

                System.out.print("Fare (€): ");
                String fare = scanner.nextLine();

                System.out.print("Feedback (can be empty): ");
                String feedback = scanner.nextLine();

                StringBuilder tripInfo = new StringBuilder();
                tripInfo.append("Date: ").append(date)
                        .append(", Source: ").append(source)
                        .append(", Destination: ").append(destination)
                        .append(", Fare (€): ").append(fare)
                        .append(", Feedback: ").append(feedback);

                lastThreeTrips[t] = tripInfo.toString();
            }

            RegisteredUsers user = new RegisteredUsers(
                    fullName, emailAddress, dateOfBirth,
                    cardNumber, cardExpiryDate, cardProvider,
                    cvv, userType, lastThreeTrips
            );
            registeredUsersList.add(user);
            System.out.println("User added successfully!");
        }
    }

    private void viewRegisteredUsers() {
        if (registeredUsersList.isEmpty()) {
            System.out.println("No registered users to display");
            return;
        }
        for (RegisteredUsers user : registeredUsersList) {
            System.out.println(user);
        }
    }

    private void removeRegisteredUsers() {
        if (registeredUsersList.isEmpty()) {
            System.out.println("No registered users to remove");
            return;
        }

        System.out.print("Enter email address to remove: ");
        String email = scanner.nextLine();
        boolean found = false;

        Iterator<RegisteredUsers> iterator = registeredUsersList.iterator();
        while (iterator.hasNext()) {
            RegisteredUsers user = iterator.next();
            if (user.getEmailAddress().equals(email)) {
                iterator.remove();
                found = true;
                System.out.println("User removed successfully!");
                break;
            }
        }
        if (!found) {
            System.out.println("No user found with this email address");
        }
    }

    private void updateRegisteredUsers() {
        if (registeredUsersList.isEmpty()) {
            System.out.println("No registered users to update");
            return;
        }

        System.out.print("Enter email address to update: ");
        String targetEmail = scanner.nextLine();
        RegisteredUsers targetUser = null;

        for (RegisteredUsers u : registeredUsersList) {
            if (u.getEmailAddress().equals(targetEmail)) {
                targetUser = u;
                break;
            }
        }

        if (targetUser == null) {
            System.out.println("No user found with this email address");
            return;
        }

        System.out.println("\n--- Update User (Press ENTER to keep old value) ---");

        System.out.print("Type new full name: ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            targetUser.setFullName(name);
        }

        System.out.print("Type new email address: ");
        String email = scanner.nextLine();
        if (!email.isEmpty()) {
            targetUser.setEmailAddress(email);
        }

        System.out.print("Type new date of birth: ");
        String dob = scanner.nextLine();
        if (!dob.isEmpty()) {
            targetUser.setDateOfBirth(dob);
        }

        System.out.print("Type new card number (0 for no change): ");
        String card = scanner.nextLine();
        if (!card.equals("0")) {
            targetUser.setCardNumber(card);
        }

        System.out.print("Type new card expiry date: ");
        String exp = scanner.nextLine();
        if (!exp.isEmpty()) {
            targetUser.setCardExpiryDate(exp);
        }

        System.out.print("Type new card provider: ");
        String prov = scanner.nextLine();
        if (!prov.isEmpty()) {
            targetUser.setCardProvider(prov);
        }

        System.out.print("Type new CVV (0 for no change): ");
        String cvv = scanner.nextLine();
        if (!cvv.equals("0")) {
            targetUser.setCvv(cvv);
        }

        System.out.print("Type new user type: ");
        String type = scanner.nextLine();
        if (!type.isEmpty()) {
            targetUser.setUserType(type);
        }

        System.out.println("User updated successfully!");
    }
}