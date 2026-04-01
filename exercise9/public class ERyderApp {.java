public class ERyderApp {
    public static void main(String[] args) {
       
        BikeDatabase bikeDatabase = new BikeDatabase();
        ActiveRental activeRental = new ActiveRental();
        RegisteredUsers registeredUsers = new RegisteredUsers();

        UserService userService = new UserService(registeredUsers);
        BikeService bikeService = new BikeService(bikeDatabase);
        RentalService rentalService = new RentalService(activeRental, bikeService);

        AdminPanel adminPanel = new AdminPanel(userService, bikeService, rentalService);
        adminPanel.displayMenu();
    }
}