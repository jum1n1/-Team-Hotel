import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.UUID;

public class Reservation {
    private final String reservationId;
    private Room room;
    private Customer customer;
    private String checkInDate;
//    private ZonedDateTime reservationTime;
    private String reservationTime;
    private LocalDateTime ldt;

    public Reservation(Room room, Customer customer, String checkInDate) {
        this.reservationId = UUID.randomUUID().toString();
        this.room = room;
        this.customer = customer;
        this.checkInDate = checkInDate;

        DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
        this.reservationTime = OffsetDateTime.now().withNano(0).format(formatter);
/*
        this.reservationTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        this.reservationTime = ZonedDateTime.now(ZoneOffset.UTC);
*/
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

    public String getReservationTime() {
        return reservationTime;
    }
    public void setReservationTime(String reservationTime) {
        this.reservationTime = reservationTime;
    }
}