import java.util.HashMap;

/**
 * UC4 - Room Search & Availability Check
 * Demonstrates read-only search using centralized inventory
 *
 * Author: Shakthi
 * Version: 1.0
 */

class Room {

    private String type;
    private double price;

    public Room(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public void displayDetails() {
        System.out.println("Room Type: " + type);
        System.out.println("Price per night: ₹" + price);
    }
}

class RoomInventory {

    private HashMap<String, Integer> inventory;

    public RoomInventory() {

        inventory = new HashMap<>();

        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 0); // Example unavailable room
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    public HashMap<String, Integer> getAllAvailability() {
        return inventory;
    }
}

class RoomSearchService {

    public void searchAvailableRooms(RoomInventory inventory, Room[] rooms) {

        System.out.println("\nAvailable Rooms:");

        for (Room room : rooms) {

            int available = inventory.getAvailability(room.getType());

            if (available > 0) {

                room.displayDetails();
                System.out.println("Available Rooms: " + available);
                System.out.println("----------------------------");

            }
        }
    }
}

public class UC4_RoomSearch {

    public static void main(String[] args) {

        System.out.println("====== Book My Stay ======");
        System.out.println("Room Search");
        System.out.println("==========================");

        RoomInventory inventory = new RoomInventory();

        Room single = new Room("Single Room", 2000);
        Room doubleRoom = new Room("Double Room", 3500);
        Room suite = new Room("Suite Room", 7000);

        Room[] rooms = {single, doubleRoom, suite};

        RoomSearchService searchService = new RoomSearchService();

        searchService.searchAvailableRooms(inventory, rooms);

        System.out.println("\nSearch Completed (Inventory Not Modified)");
    }
}
