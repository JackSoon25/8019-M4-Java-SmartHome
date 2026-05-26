public class SmartCCTV extends SmartDevice implements IControllable {
    private String resolution;
    private boolean isRecording;

    // constructor
    public SmartCCTV() {
        super(); 
        resolution = "N/A";
    }

    public SmartCCTV(String deviceID, boolean isPowered, String roomName,
        String resolution, boolean isRecording) {
        super(deviceID, isPowered, roomName);
        this.resolution = resolution;
        this.isRecording = isRecording;
    }

    
    // Getters
    public String getResolution() {
        return resolution;
    }

    public boolean isIsRecording() {
        return isRecording;
    }

    // Setters
    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public void setIsRecording(boolean isRecording) {
        this.isRecording = isRecording;
    }

    // daily methods
    @Override
    public void displayStatus() {
        System.out.println("-----SmartCCTV Devices-------");
        System.out.println("ID: " + this.getDeviceID());
        System.out.println("Room: " + this.getRoomName());
        System.out.println("Resolution: " + this.resolution);
        System.out.println("Recording: " + this.isRecording);
    }

    @Override
    public void changeSetting(double recordingValue) {
        this.isRecording = recordingValue != 0.0;
        System.out.println("Recording updated to " + this.isRecording);
    }
}