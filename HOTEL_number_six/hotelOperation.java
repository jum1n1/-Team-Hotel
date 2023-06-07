package HOTEL_number_six;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class hotelOperation {
    public void addRooms(Room room) {
        List<Room> roomList = new ArrayList<>();
        roomList.add(new Room(101, "Single Room", 100));
        roomList.add(new Room(102, "Single Room", 100));
        roomList.add(new Room(103, "Single Room", 100));
        roomList.add(new Room(201, "Twin Room", 130));
        roomList.add(new Room(202, "Twin Room", 130));
        roomList.add(new Room(203, "Twin Room", 130));
        roomList.add(new Room(301, "Deluxe Room", 160));
        roomList.add(new Room(302, "Deluxe Room", 160));
        roomList.add(new Room(303, "Deluxe Room", 160));
        roomList.add(new Room(401, "Suite Room", 300));
    }


    public static Stack<Reservation> reservationList = new Stack<>();
    public Reservation peek() {
        return reservationList.peek(); }

    // [예약 하기]
    public static void makeReservation() {
        reservationList.push(new Reservation(String clientName, int roomNumber, int phoneNumber, int createdAt, int reservationNnumber));
        }


        // [전체 예약 조회: 호텔]
    public static void showAllReservation(Reservation reservation){
        Iterator it = reservationList.iterator();
            while(it.hasNext()) {
                System.out.println(it.next());
            }
        }

        // [특정 예약 조회: 고객]
    public void showMyReservation(Reservation reservation) {
        Reservation reservation1 = reservationList.get(i).toString();

    }

    // [예약 취소]
    public void cancelReservation(Reservation reservation) {
            reservationList.remove()
        }

    }


}