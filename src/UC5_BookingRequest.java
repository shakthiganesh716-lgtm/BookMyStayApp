import java.util.LinkedList;
import java.util.Queue;

/**
 * UC5 - Booking Request Queue
 * Demonstrates FIFO booking request handling
 *
 * Author: Shakthi
 * Version: 1.0
 */

/* Reservation represents a guest booking request */
class Reservation {

    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void displayRequest() {
        System.out.println("Guest: " + guestName + " requested " + roomType);
    }
}

/* Booking queue to store incoming requests */
class BookingRequestQueue {

    private Queue<Reservation> requestQueue;

    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }

    /* Add booking request */
    public void addRequest(Reservation reservation) {
        requestQueue.add(reservation);
        System.out.println("Request Added → " + reservation.getGuestName());
    }

    /* Display queue */
    public void displayRequests() {

        System.out.println("\nCurrent Booking Queue:");

        for (Reservation r : requestQueue) {
            r.displayRequest();
        }
    }
}

/* Main UC5 Program */
public class UC5_BookingRequest {

    public static void main(String[] args) {

        System.out.println("====== Book My Stay ======");
        System.out.println("Booking Request Queue");
        System.out.println("==========================");

        BookingRequestQueue queue = new BookingRequestQueue();

        Reservation r1 = new Reservation("Alice", "Single Room");
        Reservation r2 = new Reservation("Bob", "Double Room");
        Reservation r3 = new Reservation("Charlie", "Suite Room");

        queue.addRequest(r1);
        queue.addRequest(r2);
        queue.addRequest(r3);

        queue.displayRequests();

        System.out.println("\nRequests stored in FIFO order. No inventory updated.");
    }
}
