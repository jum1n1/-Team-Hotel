import java.util.*;

public class Hotel {
    private List<Room> rooms = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();

    // 방 예약 ( 성수님)
    public String reserveRoom(Customer customer, Room room, String date) {
        Reservation reservationInput = new Reservation(room, customer, date);
        reservations.add(reservationInput);
        return reservationInput.getReservationId();
    }

    // 예약 취소 ( 현우님)
    public void cancelReservation(String reservationId) {
        Reservation tempReservation = findReservation(reservationId); // 아래 메소드에서 해당 Reservation 리턴 받아오기.
        if (tempReservation == null) { //반환값이 null이면 예약번호가 없다고 출력
            System.out.println("해당 번호의 예약이 존재하지 않습니다.");
        } else {
            reservations.remove(tempReservation);
            System.out.println("예약 번호 : " + tempReservation.getReservationId() + "\n해당 예약이 취소되었습니다.");
        }
    }

    public Reservation findReservation(String reservationId) { //id값 받아서 예약 찾아서 반환해주는 메소드
        Reservation targetReservation = null; // null로 선언 및 초기화.
        for (Reservation reservations : reservations) {  //받은 Id값이랑 같은 값이 나올때까지 반복문.
            if (!reservations.getReservationId().equals(reservationId)) {
                continue;
            } else {
                targetReservation = reservations; // 맞는게 나오면 targetReservation에 할당.
                break;
            }
        }
        return targetReservation; // 해당 id가 없으면 초기화된 null로 리턴.
    }

    // 모든 예약 목록 조회 ( 디스플레이 되는 곳에서 사용할 수 있게 은영님 )
    public void getAllReservations() {
        if(reservations.isEmpty()){
            System.out.println("예약이 없습니다.");
        } else {
            Iterator<Reservation> it = reservations.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
        }
    }   // 특정 고객의 예약 목록 조회 (주민님)
    // 예약번호를 reservationId으로 받고
    // 반복문 돌려서 배열 인덱스가 맞는 것이 나오면 출력
    public Reservation getReservationsByCustomer(String reservationId){
        Reservation reservationConfirm = null;
        for (int i = 0; i < reservations.size(); i++) {
            if (Objects.equals(reservationId, reservations.get(i).getReservationId())) {
                reservationConfirm = reservations.get(i);
            }
        }
        return reservationConfirm;
    }


    // 모든 객실 조회 구현하기 todo
    public void getAllRooms() {
        Iterator itr = rooms.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
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