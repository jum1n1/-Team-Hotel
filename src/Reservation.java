public class Reservation {

    public String clientName;
    public int clientPhoneNumber;
    public int roomNumber;
    public int createdAt;
    public int reservationNumber;


    Reservation(String name, int roomNumber, int phoneNumber, int createdAt, int reservationNnumber) {
        this.clientName = name;
        this.clientPhoneNumber = phoneNumber;
        this.roomNumber = roomNumber;
        this.createdAt = createdAt;
        this.reservationNumber = reservationNumber;

    }

}
