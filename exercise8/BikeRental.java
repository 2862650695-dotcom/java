package Exercise8;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class BikeRental {
    private boolean isRegisteredUser;
    private String emailAddress;
    private String location;
    private LocalDateTime tripStartTime;
    private String bikeID;
    private boolean locationValid;

    UserRegistration userReg = new UserRegistration();
    ActiveRental activeRental;
    LinkedList<ActiveRental> activeRentalsList = new LinkedList<>();

    public void simulateApplicationInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("This is the simulation of the e-bike rental process.");

        System.out.print("Is registered user? (true/false): ");
        isRegisteredUser = sc.nextBoolean();
        sc.nextLine();

        System.out.print("Enter email: ");
        emailAddress = sc.nextLine();

        System.out.print("Enter location: ");
        location = sc.nextLine();

        System.out.println("Simulating the analysis of the rental request.");
        bikeID = analyseRequest(isRegisteredUser, emailAddress, location);

        if (!locationValid) {
            sc.close();
            return;
        }

        System.out.println("Simulating e-bike reservation...");
        reserveBike(bikeID);

        System.out.println("Displaying the active rentals...");
        viewActiveRentals();

        System.out.println("Simulating the end of the trip...");
        removeTrip(bikeID);

        System.out.println("Displaying the active rentals after trip end...");
        viewActiveRentals();

        sc.close();
    }

    private String analyseRequest(boolean isRegistered, String email, String location) {
        if (isRegistered) {
            System.out.println("Welcome back, " + email + "!");
        } else {
            System.out.println("You're not our registered user. Please consider registering.");
            userReg.registration();
        }
        return validate(location);
    }

    private String validate(String location) {
        return validateLocation(location);
    }

    private String validateLocation(String location) {
        for (int i = 0; i < BikeDatabase.bikes.size(); i++) {
            Bike b = BikeDatabase.bikes.get(i);
            if (b.getLocation().equalsIgnoreCase(location) && b.isAvailable()) {
                System.out.println("A bike is available at the location you requested.");
                locationValid = true;
                return b.getBikeID();
            }
        }
        System.out.println("Sorry, no bikes are available at the location you requested. Please try again later.");
        locationValid = false;
        return null;
    }

    private void reserveBike(String bikeID) {
        if (bikeID != null) {
            for (int i = 0; i < BikeDatabase.bikes.size(); i++) {
                Bike b = BikeDatabase.bikes.get(i);
                if (b.getBikeID().equals(bikeID)) {
                    tripStartTime = LocalDateTime.now();
                    b.setIsAvailable(false);
                    b.setLastUsedTime(tripStartTime);
                    System.out.println("Reserving the bike with " + bikeID + ". Please follow the on-screen instructions.");

                    activeRental = new ActiveRental(bikeID, emailAddress, tripStartTime);
                    activeRentalsList.add(activeRental);
                    break;
                }
            }
        } else {
            System.out.println("Sorry, we're unable to reserve a bike at this time. Please try again later.");
        }
    }

    private void viewActiveRentals() {
        if (activeRentalsList.isEmpty()) {
            System.out.println("No active rentals at the moment.");
        } else {
            System.out.println("Active Rentals:");
            for (int i = 0; i < activeRentalsList.size(); i++) {
                System.out.println(activeRentalsList.get(i));
            }
        }
    }

    private void removeTrip(String bikeID) {
        Iterator<ActiveRental> it = activeRentalsList.iterator();
        while (it.hasNext()) {
            ActiveRental ar = it.next();
            if (ar.getBikeID().equals(bikeID)) {
                it.remove();
                break;
            }
        }

        for (int i = 0; i < BikeDatabase.bikes.size(); i++) {
            Bike b = BikeDatabase.bikes.get(i);
            if (b.getBikeID().equals(bikeID)) {
                b.setIsAvailable(true);
                b.setLastUsedTime(LocalDateTime.now());
                System.out.println("Your trip has ended. Thank you for riding with us.");
                break;
            }
        }
    }
}