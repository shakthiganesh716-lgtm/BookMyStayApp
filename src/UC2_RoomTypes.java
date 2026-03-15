/**
 * UC2 - Basic Room Types & Static Availability
 * Demonstrates abstraction and inheritance
 *
 * Author: Shakthi
 * Version: 1.0
 */

abstract class Room {

    protected int beds;
    protected double size;
    protected double price;

    public Room(int beds, double size, double price) {
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

    public void displayRoomDetails() {
        System.out.println("Beds: " + beds);
        System.out.println("Room Size: " + size + " sq ft");
        System.out.println("Price per night: ₹" + price);
    }
}

class SingleRoom extends Room {

    public SingleRoom() {
        super(1, 200, 2000);
    }

    public void showType() {
        System.out.println("Room Type: Single Room");
    }
}

class DoubleRoom extends Room {

    public DoubleRoom() {
        super(2, 350, 3500);
    }

    public void showType() {
        System.out.println("Room Type: Double Room");
    }
}

class SuiteRoom extends Room {

    public SuiteRoom() {
        super(3, 600, 7000);
    }

    public void showType() {
        System.out.println("Room Type: Suite Room");
    }
}

public class UC2_RoomTypes {

    public static void main(String[] args) {

        System.out.println("========== Book My Stay ==========");
        System.out.println("Room Availability");
        System.out.println("==================================");

        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        System.out.println("\nSingle Room Details");
        ((SingleRoom) single).showType();
        single.displayRoomDetails();
        System.out.println("Available Rooms: " + singleAvailable);

        System.out.println("\nDouble Room Details");
        ((DoubleRoom) doubleRoom).showType();
        doubleRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + doubleAvailable);

        System.out.println("\nSuite Room Details");
        ((SuiteRoom) suite).showType();
        suite.displayRoomDetails();
        System.out.println("Available Rooms: " + suiteAvailable);

        System.out.println("\nApplication Terminated.");
    }
}