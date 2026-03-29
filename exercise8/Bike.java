package Exercise8;
import java.time.LocalDateTime;

public class Bike {
    private String bikeID;
    private boolean isAvailable;
    private int batteryLevel;
    private LocalDateTime lastUsedTime;
    private String location;

    public Bike(String bikeID, boolean isAvailable, int batteryLevel, LocalDateTime lastUsedTime, String location) {
        this.bikeID = bikeID;
        this.isAvailable = isAvailable;
        this.batteryLevel = batteryLevel;
        this.lastUsedTime = lastUsedTime;
        this.location = location;
    }

    public String getBikeID() {
        return bikeID;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean available) {
        isAvailable = available;
    }

    public LocalDateTime getLastUsedTime() {
        return lastUsedTime;
    }

    public void setLastUsedTime(LocalDateTime lastUsedTime) {
        this.lastUsedTime = lastUsedTime;
    }

    public String getLocation() {
        return location;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "bikeID='" + bikeID + '\'' +
                ", isAvailable=" + isAvailable +
                ", batteryLevel=" + batteryLevel +
                ", lastUsedTime=" + lastUsedTime +
                ", location='" + location + '\'' +
                '}';
    }
}