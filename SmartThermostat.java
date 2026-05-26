public class SmartThermostat extends SmartDevice implements IControllable {
    private double targetTemperature;

    // constructor
    public SmartThermostat() {
        super();
    }

    public SmartThermostat(String deviceID, boolean isPowered, String roomName, double targetTemperature) {
        super(deviceID, isPowered, roomName);
        this.targetTemperature=targetTemperature;
    }

    // getter and setter
    public double getTargetTemperature() {
        return targetTemperature;
    }

    public void setTargetTemperature(double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }

    //daily methods
    @Override
    public void changeSetting (double targetTemperature) {
       this.setTargetTemperature(targetTemperature);
       System.out.println("Thermostat updated to " + this.targetTemperature + "°C");
    }

    @Override
    public void displayStatus() {
        System.out.println("------- Smart Thermostat Devices -------");
        System.out.println("ID: " + this.getDeviceID());
        System.out.println("Room: " + this.getRoomName());
        System.out.println("Target Temperature is " + this.targetTemperature);
    }

}