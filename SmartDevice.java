
public abstract class SmartDevice {
    private String deviceID;
    private String roomName;
    private boolean isPowered;

    // constructor
    public SmartDevice() {
        deviceID = "N/A";
        roomName = "N/A";
    }

    public SmartDevice(String deviceID, boolean isPowered, String roomName) {
        this.deviceID = deviceID;
        this.isPowered = isPowered;
        this.roomName = roomName;
    }

    // Getters
    public String getDeviceID() {
        return deviceID;
    }

    public String getRoomName() {
        return roomName;
    }

    public boolean isIsPowered() {
        return isPowered;
    }

    // setters
    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void setIsPowered(boolean isPowered) {
        this.isPowered = isPowered;
    }

    // normal methods
    public void togglePower() {
        isPowered = !isPowered;
    }

    // abstract method. Child class must define.
    public abstract void displayStatus();

}