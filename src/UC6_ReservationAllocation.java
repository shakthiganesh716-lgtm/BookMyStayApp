import java.util.*;

/**
 * UC6 - Reservation Confirmation & Room Allocation
 * Demonstrates FIFO booking processing, unique room allocation,
 * and inventory synchronization.
 *
 * Author: Shakthi
 * Version: 1.0
 */

/* Reservation request */
class Reservation {

    String guestName;
    String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
}

/* Inventory Service */
class InventoryService {

    private HashMap<String, Integer> inventory;

    public InventoryService() {

        inventory = new HashMap<>();

        inventory.put("Single Room", 2);
        inventory.put("Double Room", 2);
        inventory.put("Suite Room", 1);
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    public void decreaseRoom(String roomType) {
        inventory.put(roomType, inventory.get(roomType) - 1);
    }
}

/* Booking Service */
class BookingService {

    private Queue<Reservation> requestQueue;
    private HashMap<String, Set<String>> allocatedRooms;
    private InventoryService inventory;

    public BookingService(InventoryService inventory) {

        this.inventory = inventory;

        requestQueue = new LinkedList<>();

        allocatedRooms = new HashMap<>();
    }

    public void addRequest(Reservation r) {
        requestQueue.add(r);
    }

    public void processBookings() {

        while (!requestQueue.isEmpty()) {

            Reservation r = requestQueue.poll();

            if (inventory.getAvailability(r.roomType) > 0) {

                String roomId = generateRoomId(r.roomType);

                allocatedRooms
                        .computeIfAbsent(r.roomType, k -> new HashSet<>())
                        .add(roomId);

                inventory.decreaseRoom(r.roomType);

                System.out.println(
                        "Reservation Confirmed → "
                                + r.guestName
                                + " | "
                                + r.roomType
                                + " | Room ID: "
                                + roomId
                );

            } else {

                System.out.println(
                        "Reservation Failed → "
                                + r.guestName
                                + " | No rooms available for "
                                + r.roomType
                );
            }
        }
    }

    private String generateRoomId(String roomType) {

        String prefix = roomType.replace(" ", "").substring(0, 3).toUpperCase();

        int id = new Random().nextInt(900) + 100;

        return prefix + id;
    }
}

/* Main UC6 Program */
public class UC6_ReservationAllocation {

    public static void main(String[] args) {

        System.out.println("====== Book My Stay ======");
        System.out.println("Reservation Confirmation");
        System.out.println("==========================");

        InventoryService inventory = new InventoryService();

        BookingService booking = new BookingService(inventory);

        booking.addRequest(new Reservation("Alice", "Single Room"));
        booking.addRequest(new Reservation("Bob", "Double Room"));
        booking.addRequest(new Reservation("Charlie", "Single Room"));
        booking.addRequest(new Reservation("David", "Suite Room"));
        booking.addRequest(new Reservation("Emma", "Suite Room"));

        booking.processBookings();

        System.out.println("\nAll requests processed safely.");
    }
}
