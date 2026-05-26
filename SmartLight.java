public class SmartLight extends SmartDevice implements IControllable {
    private int brightnessLevel;
    
    //constructor
    public SmartLight() {
        super();
    } 

    public SmartLight(String deviceID, boolean isPowered, String roomName,int brightnessLevel) {
        super(deviceID, isPowered, roomName);
        this.brightnessLevel = brightnessLevel;
    }


    // getter and setter
    public int getBrightnessLevel() {
        return brightnessLevel;
    }

    public void setBrightnessLevel(int brightnessLevel) {
        if (brightnessLevel >= 0 && brightnessLevel <= 100) {
            this.brightnessLevel = brightnessLevel;
        } else {
            System.out.println("The brightness must be an integer and between 1 and 100");
        }
        
    }

    //daily methods
    @Override
    public void changeSetting(double brightnessLevel) {
        int convertedBrightness = (int) brightnessLevel;
        this.setBrightnessLevel(convertedBrightness);

        System.out.println("Light's brightness updated to " + this.brightnessLevel + "%");
        
    }

    @Override
    public void displayStatus() {
        System.out.println("----------- Smart Light Devices ----------"); 
        System.out.println("ID: " + this.getDeviceID());
        System.out.println("Room: " + this.getRoomName());
        System.out.println("The Smart Light brightness level is " + this.brightnessLevel);
    }
}