import java.util.HashMap;

/**
 * UC3 - Centralized Room Inventory Management
 * Demonstrates use of HashMap for centralized availability management
 *
 * Author: Shakthi
 * Version: 1.0
 */

class RoomInventory {

    private HashMap<String, Integer> inventory;

    // Constructor initializes room availability
    public RoomInventory() {
        inventory = new HashMap<>();

        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);
    }

    // Retrieve availability
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    // Update availability
    public void updateAvailability(String roomType, int newCount) {
        inventory.put(roomType, newCount);
    }

    // Display inventory
    public void displayInventory() {

        System.out.println("\nCurrent Room Inventory");

        for (String room : inventory.keySet()) {
            System.out.println(room + " → " + inventory.get(room));
        }
    }
}

public class UC3_RoomInventory {

    public static void main(String[] args) {

        System.out.println("====== Book My Stay ======");
        System.out.println("Centralized Room Inventory");
        System.out.println("===========================");

        RoomInventory inventory = new RoomInventory();

        // Display initial inventory
        inventory.displayInventory();

        // Example update
        System.out.println("\nUpdating availability...");

        inventory.updateAvailability("Single Room", 4);

        // Display updated inventory
        inventory.displayInventory();

        System.out.println("\nApplication Terminated");
    }
}