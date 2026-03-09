
public class ERyder {
    private String bikeID;
    private int batteryLevel;
    private boolean isAvailable;
    private double kmDriven;

    public ERyder() {
        bikeID = "DEFAULT_ID"; // Omit "this" (typical beginner writing style)
        batteryLevel = 100;
        isAvailable = true;
        kmDriven = 0.0;
    }

 
    public ERyder(String bikeID, int batteryLevel, boolean isAvailable, double kmDriven) {
        this.bikeID = bikeID;
        // Call setBatteryLevel to validate input (more robust than direct assignment)
        setBatteryLevel(batteryLevel); 
        this.isAvailable = isAvailable;
        // Add distance validation (beginners notice "negative distance" is illogical)
        if (kmDriven >= 0) {
            this.kmDriven = kmDriven;
        } else {
            System.out.println("Distance cannot be negative! Defaulted to 0 km.");
            this.kmDriven = 0.0;
        }
    }

    public void ride() {
        // Split condition into variable (easier for beginners to read)
        boolean canRide = isAvailable && (batteryLevel > 0);
        if (canRide) {
            System.out.println("✅ Bike " + bikeID + " is ready to ride! Current battery: " + batteryLevel + "%");
        } else {
            // Specific error message (beginners add context, AI uses generic messages)
            String reason = !isAvailable ? "bike is occupied" : "insufficient battery";
            System.out.println("❌ Bike " + bikeID + " cannot be ridden! Reason: " + reason);
        }
    }

    
    public void printBikeDetails() {
        System.out.println("===== Electric Bike [" + bikeID + "] Details =====");
        System.out.println("Current Battery Level: " + batteryLevel + "%");
        System.out.println("Availability Status: " + (isAvailable ? "Available" : "Unavailable"));
        // Format distance to 1 decimal place (beginners optimize output readability)
        System.out.println("Total Distance Driven: " + String.format("%.1f", kmDriven) + " km");
        System.out.println("==============================================");
    }

  
    public String getBikeID() {
        return bikeID;
    }

   
    public void setBikeID(String bikeID) {
        this.bikeID = bikeID;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

   
    public void setBatteryLevel(int batteryLevel) {
        if (batteryLevel >= 0 && batteryLevel <= 100) {
            this.batteryLevel = batteryLevel;
        } else {
            System.out.println("⚠️ Invalid battery level: " + batteryLevel + "! Must be between 0-100. Defaulted to 0%.");
            this.batteryLevel = 0; 
        }
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

  
    public double getKmDriven() {
        return kmDriven;
    }

  
    public void setKmDriven(double kmDriven) {
        if (kmDriven >= 0) {
            this.kmDriven = kmDriven;
        } else {
            System.out.println("⚠️ Distance cannot be negative! Value ignored.");
        }
    }
}

class Main {
    public static void main(String[] args) {
       
        System.out.println("---------- Test Default Bike ----------");
        ERyder defaultBike = new ERyder();
        defaultBike.printBikeDetails(); // Print default bike info
        defaultBike.ride(); // Test ride functionality for default bike

       
        System.out.println("\n---------- Test Custom Bike ----------");
        ERyder parameterBike = new ERyder("BIKE_001", 75, true, 125.5);
        parameterBike.ride(); // Test ride functionality for custom bike
        parameterBike.printBikeDetails(); // Print custom bike info

       
        System.out.println("\n---------- Test Invalid Values ----------");
        ERyder errorBike = new ERyder("BIKE_002", 120, false, -50); // Invalid battery + negative distance
        errorBike.setKmDriven(-10); // Test setter validation for negative distance
        errorBike.printBikeDetails();
    }
}
