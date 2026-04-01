import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BikeDatabase {
    private List<Bike> bikes;
    private Set<String> validLocations;

    public BikeDatabase() {
        this.bikes = new ArrayList<>();
        this.validLocations = new HashSet<>();
      
        validLocations.add("Oulu Central");
        validLocations.add("Oulu University");
        bikes.add(new Bike("B001", "Oulu Central"));
        bikes.add(new Bike("B002", "Oulu University"));
    }

    public List<Bike> getBikes() { return bikes; }
    public Set<String> getValidLocations() { return validLocations; }
    public void updateBike(Bike bike) {}
}