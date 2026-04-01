import java.util.List;

public class BikeService {
    private BikeDatabase bikeDatabase;

    public BikeService(BikeDatabase bikeDatabase) {
        this.bikeDatabase = bikeDatabase;
    }

    public List<Bike> findAvailableBikes(String location) {
        if (!validateLocation(location)) {
            return List.of();
        }
        return bikeDatabase.getBikes().stream()
                .filter(bike -> bike.isAvailable() && bike.getLocation().equals(location))
                .toList();
    }

    public boolean validateLocation(String location) {
        return location != null && !location.isBlank() && bikeDatabase.getValidLocations().contains(location);
    }

    public boolean reserveBike(Bike bike) {
        if (bike.isAvailable()) {
            bike.setAvailable(false);
            bikeDatabase.updateBike(bike);
            return true;
        }
        return false;
    }

    public boolean releaseBike(Bike bike) {
        if (!bike.isAvailable()) {
            bike.setAvailable(true);
            bikeDatabase.updateBike(bike);
            return true;
        }
        return false;
    }
}