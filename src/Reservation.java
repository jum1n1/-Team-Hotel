import HOTEL_numbersix2.Customer;
import HOTEL_numbersix2.Room;

import java.util.UUID;

public class Reservation {
    private String reservationId;
    private Room room;
    private Customer customer;
    private String date;

    public Reservation(Room room, Customer customer, String date) {
        this.reservationId = UUID.randomUUID().toString();
        this.room = room;
        this.customer = customer;
        this.date = date;
    }

    public String getReservationId() {
        return reservationId;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Customer getCustomer() {
        return customer;
    }