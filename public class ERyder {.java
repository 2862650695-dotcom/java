
public class ERyder {
    
    private String bikeID;        
    private int batteryLevel;      
    private boolean isAvailable;    
    private double kmDriven;        
    public ERyder() {
        this.bikeID = "DEFAULT-001";
        this.batteryLevel = 100;    
        this.isAvailable = true;   
        this.kmDriven = 0.0;        
    }
    public ERyder(String bikeID, int batteryLevel, boolean isAvailable, double kmDriven) {
      
        this.bikeID = (bikeID != null && !bikeID.isEmpty()) ? bikeID : "UNKNOWN-000";
        this.batteryLevel = (batteryLevel >= 0 && batteryLevel <= 100) ? batteryLevel : 0;
        this.isAvailable = isAvailable;
        this.kmDriven = (kmDriven >= 0) ? kmDriven : 0.0;
    }

    public void showBikeInfo() {
        System.out.println("===== 电动自行车信息 =====");
        System.out.println("车辆ID：" + this.bikeID);
        System.out.println("电池电量：" + this.batteryLevel + "%");
        System.out.println("可用状态：" + (this.isAvailable ? "可用" : "不可用"));
        System.out.println("行驶里程：" + this.kmDriven + "公里");
        System.out.println("==========================\n");
    }

    public String getBikeID() {
        return bikeID;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public double getKmDriven() {
        return kmDriven;
    }

  
    public static void main(String[] args) {
        ERyder defaultBike = new ERyder();
        System.out.println("【默认配置车辆】");
        defaultBike.showBikeInfo();

       
        ERyder parameterBike = new ERyder("EB-002", 85, true, 25.8);
        System.out.println("【自定义配置车辆】");
        parameterBike.showBikeInfo();

     
        parameterBike.batteryLevel = 70; 
        System.out.println("【修改后电池电量】：" + parameterBike.getBatteryLevel() + "%");
    }
}