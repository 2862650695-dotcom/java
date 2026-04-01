import java.util.ArrayList;
import java.util.List;

public class ActiveRental {
    private List<String> activeRentalList;

    public ActiveRental() {
        this.activeRentalList = new ArrayList<>();
    }

    public void addRental(Bike bike, String userId) {
        activeRentalList.add("User: " + userId + " | Bike: " + bike.getBikeId());
    }

    public void removeRental(Bike bike, String userId) {
        activeRentalList.remove("User: " + userId + " | Bike: " + bike.getBikeId());
    }

    public boolean hasRental(Bike bike, String userId) {
        return activeRentalList.contains("User: " + userId + " | Bike: " + bike.getBikeId());
    }

    public List<String> getActiveRentalList() { return activeRentalList; }
}