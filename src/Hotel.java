import java.util.*;


public class Hotel {
    private List<Room> roomList = new ArrayList<>();
    private List<Reservation> reservationList = new ArrayList<>();

    //기본 생성자
    Hotel(){
        roomInit(); //기본 생성자 실행시 바로 Room객체 생성
    }

    // Room 객체 생성 및 리스트 추가 메소드
    private void roomInit (){
        Room room1 = new Room(101, 12, 100000);  // 방 번호, 크기, 비용
        Room room2 = new Room(102, 12, 100000);
        Room room3 = new Room(103, 12, 100000);
        Room room4 = new Room(201, 20, 150000);
        Room room5 = new Room(202, 20, 150000);
        Room room6 = new Room(203, 20, 150000);
        Room room7 = new Room(301, 30, 200000);
        Room room8 = new Room(302, 30, 200000);
        Room room9 = new Room(303, 30, 200000);
        Room room10 = new Room(401, 50, 400000);

        // Hotel 객체 안에 Room 객체를 추가
        addRoom(room1);
        addRoom(room2);
        addRoom(room3);
        addRoom(room4);
        addRoom(room5);
        addRoom(room6);
        addRoom(room7);
        addRoom(room8);
        addRoom(room9);
        addRoom(room10); //안에 변수명 굳이 안만들고 바로 생성자로 넣는게 낫나..? 변수명을 쓸 일을 대비하는 게 좋을까?
    }


    // 1. 방 예약 ( 성수님)
    public void addReservation(Reservation reservationInput) { //메소드명은 reserveRoom인데 반환값이 Id라서 헷갈림.
        reservationList.add(reservationInput);
    }

    // 예약 취소 (현우님)
    public void cancelReservation(String reservationId) {
        Reservation tempReservation = findReservation(reservationId); // 아래 메소드에서 해당 Reservation 리턴 받아오기.
        if (tempReservation == null) { //반환값이 null이면 예약번호가 없다고 출력
            System.out.println("해당 번호의 예약이 존재하지 않습니다.");
        } else {
            reservationList.remove(tempReservation);
            System.out.println("예약 번호 : " + tempReservation.getReservationId() + "\n해당 예약이 취소되었습니다.");
        }
    }

    public Reservation findReservation(String reservationId) { //id값 받아서 예약 찾아서 반환해주는 메소드
        Reservation targetReservation = null; // null로 선언 및 초기화.
        for (Reservation reservations : reservationList) {  //받은 Id값이랑 같은 값이 나올때까지 반복문.
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
        if(reservationList.isEmpty()){
            System.out.println("예약이 없습니다.");
        } else {
            Iterator<Reservation> it = reservationList.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
        }
    }   // 특정 고객의 예약 목록 조회 (주민님)
    // 예약번호를 reservationId으로 받고
    // 반복문 돌려서 배열 인덱스가 맞는 것이 나오면 출력
    public Reservation getReservationsByCustomer(String reservationId){
        Reservation reservationConfirm = null;
        for (int i = 0; i < reservationList.size(); i++) {
            if (reservationList.get(i).getReservationId().equals(reservationId)) {
                reservationConfirm = reservationList.get(i);
            }
        }
        return reservationConfirm;
    }


    // 모든 객실 조회 구현하기 todo
    public void getAllRooms() {
        Iterator itr = roomList.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    public void addRoom (Room room){
        roomList.add(room);
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public List<Reservation> getReservationList() {
        return reservationList; //값 받아서 해당 reservation 리턴
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }


}