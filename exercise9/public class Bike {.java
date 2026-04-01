public class Bike {
    private String bikeId;
    private boolean isAvailable;
    private String location;

  
    public Bike(String bikeId, String location) {
        this.bikeId = bikeId;
        this.isAvailable = true;
        this.location = location;
    }

    public String getBikeId() { return bikeId; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
    public String getLocation() { return location; }

    @Override
    public String toString() { return bikeId; }
}