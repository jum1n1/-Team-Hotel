import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.UUID;

public class Reservation {
    private final String reservationId;
    private Room room;
    private Customer customer;
    private String checkInDate;
    private ZonedDateTime reservationTime;

    public Reservation(Room room, Customer customer, String checkInDate) {
        this.reservationId = UUID.randomUUID().toString();
        this.room = room;
        this.customer = customer;
        this.checkInDate = checkInDate;
        this.reservationTime = ZonedDateTime.now(ZoneOffset.UTC);
    }

    public String getReservationId() {
        return reservationId;
    }

    public Room getRoom() {
        return room;
    }

    public String getCheckInDate(){
        return checkInDate;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ZonedDateTime getReservationTime() {
        return reservationTime;
    }
    public void setReservationTime(ZonedDateTime reservationTime) {
        this.reservationTime = reservationTime;
    }
}