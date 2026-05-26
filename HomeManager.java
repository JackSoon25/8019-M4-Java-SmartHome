
import java.util.ArrayList;
import java.util.Scanner;

public class HomeManager {

    private ArrayList<SmartDevice> deviceRegistry = new ArrayList<>();
    private Scanner inputScanner = new Scanner(System.in);

    // methods to keep the service running
    public void runMenu() {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n================ Choose Service ===============");
            System.out.println("1. Add; 2. Show; 3. Update; 4. Delete; 5. Exit");
            System.out.println("=================================================\n");
            int choice = inputScanner.nextInt();
            inputScanner.nextLine();

            switch (choice) {
                case 1:
                    addDevice();
                    break;
                case 2:
                    showDevice();
                    break;
                case 3:
                    updateDevice();
                    break;
                case 4:
                    deleteDevice();
                    break;
                case 5:
                    isRunning = false;
                    break;
            }
        }
    }

    //CRUD - Create
    public void addDevice() {
        System.out.println("\n============== Add new device  ===============");
        System.out.println("Select the device type: ");
        System.out.println("1. Smart Light");
        System.out.println("2. Smart Thermostat");
        System.out.println("3. Smart CCTV");
        System.out.println("Enter Choice (1 -3)");

        int choice = inputScanner.nextInt();
        inputScanner.nextLine();  // to clear the cache

        System.out.println("Enter the uniqe device ID (such as L01, T02, or C03)");
        String deviceID = inputScanner.nextLine();

        System.out.println("Enter Room Name (such as Living Room, Study Room)");
        String roomType = inputScanner.nextLine();

        System.out.println("Turn on the power? (1: turn on ; 0: turn off)");
        int powerOn = inputScanner.nextInt();
        inputScanner.nextLine();
        boolean isPowered = (powerOn == 1);

        if (choice == 1) {
            System.out.println("Enter initial brightness level (integer 1 - 100)");
            int brightnessLevel = inputScanner.nextInt();
            inputScanner.nextLine();

            SmartLight light = new SmartLight(deviceID, isPowered, roomType, brightnessLevel);
            deviceRegistry.add(light);
            System.out.println("The Smart Light is added to registry.");

        } else if (choice == 2) {
            System.out.println("Enter initial Target Temperature (°C)");
            double temperature = inputScanner.nextDouble();
            inputScanner.nextLine();

            SmartThermostat thermostat = new SmartThermostat(deviceID, isPowered, roomType, temperature);
            deviceRegistry.add(thermostat);
            System.out.println("The Smart Thermostat is added to registry.");

        } else if (choice == 3) {
            System.out.println("Enter CCTV camera resolution (e.g. 4k, 8k)");
            String resolution = inputScanner.nextLine();
            
            System.out.println("Power on the CCTV? (1 = On; 0 = off)");
            boolean isRecording = inputScanner.nextLine().equals("1");

            SmartCCTV CCTV = new SmartCCTV(deviceID, isPowered, roomType, resolution, isRecording);
            deviceRegistry.add(CCTV);
            System.out.println("The Smart CCTV is added to registry.\n");

        } else {
            System.out.println("Error: Invalid device type selected.  Back to main menu.\n");
        }
        System.out.println("\n");
    }

    // CRUD - Read
    public void showDevice() {
        System.out.println("\n============= Show Device ===============");
        for (SmartDevice device : deviceRegistry) {
            device.displayStatus();
        }
        System.out.println("------------- End of List ---------------\n");
    }

    // CRUD - delete
    public void deleteDevice() {
        System.out.println("\n============= Device Deletion ===============");
        System.out.println("Enter the device ID for deletion: ");
        String deviceID = inputScanner.nextLine();

        for (int i = 0; i < deviceRegistry.size(); i++) {
            SmartDevice device = deviceRegistry.get(i);

            if (device.getDeviceID().equals(deviceID)) {
                deviceRegistry.remove(i);
                System.out.println();
                return;
            }
        }

        System.out.println("Error: Device ID" + deviceID + " not found \n");
    }

    // CRUD - update
    public void updateDevice() {
        System.out.println("\n============ Update Device Setting ===============");
        System.out.println("Enter the device ID for setting update: ");
        String deviceID = inputScanner.nextLine();

        for (int i = 0; i < deviceRegistry.size(); i++) {
            SmartDevice device = deviceRegistry.get(i);

            if (device.getDeviceID().equals(deviceID)) {
                String powerOn = device.isIsPowered() ? "on" : "off";
                System.out.println("Toggle the power (1:Toggle; 2:No Toggle)? Current the power is " + powerOn );
                int powerConfig  = inputScanner.nextInt();
                inputScanner.nextLine();
                boolean convertedPowerConfig = powerConfig == 1;
                if (convertedPowerConfig) {
                    device.togglePower();
                }

                if (device instanceof SmartLight) {
                    System.out.println("Enter the new brightness level (1 - 100): ");
                    int newValue = inputScanner.nextInt();
                    inputScanner.nextLine();
                    ((SmartLight) device).changeSetting(newValue);
                } else if (device instanceof SmartThermostat) {
                    System.out.println("Enter the new target temperature (°C): ");
                    double newValue = inputScanner.nextDouble();
                    inputScanner.nextLine();
                    ((SmartThermostat) device).changeSetting(newValue);
                } else if (device instanceof SmartCCTV) {
                    System.out.println("Turn on/off Smart CCTV (1 = on, 0 = off) ");
                    int newValue = inputScanner.nextInt();
                    inputScanner.nextLine();
                    ((SmartCCTV) device).changeSetting(newValue);
                }
                System.out.println();
                return;
            }
        }

        System.out.println("Error: Device ID " + deviceID + " not found\n");
    }
}
