import java.util.*;

public class Hotel {
    private List<Room> rooms = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();

    // 방 예약 ( 성수님)
    public String reserveRoom(Customer customer, Room room, String date) {
        // 구현 해야 할 부분
        Reservation reservationInput = new Reservation(room, customer, date);
        reservations.add(reservationInput);
        return reservationInput.getReservationId();
    }

    // 예약 취소 ( 현우님)
    public void cancelReservation(String reservationId) {
        // 구현 해야 할 부분
    }

    // 모든 예약 목록 조회 ( 디스플레이 되는 곳에서 사용할 수 있게 은영님 )
    public List<Reservation> getAllReservations() {
        return reservations;
    }

    // 특정 고객의 예약 목록 조회 (주민님)
    public List<Reservation> getReservationsByCustomer(Customer customer) {
        // 구현 해야 할 부분
        return null;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
