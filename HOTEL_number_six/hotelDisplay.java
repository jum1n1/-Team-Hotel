package HOTEL_number_six;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static HOTEL_number_six.hotelOperation.*;

public class hotelDisplay {

    static Scanner sc = new Scanner(System.in);

    public static void greeting() {
        System.out.println("☆.｡･:*:･ﾟ`☆､｡･:*:･ﾟ`★.｡･:*:･ﾟ`☆.｡･:☆♪");
        System.out.println("<HOTEL Number Six 에 오신 것을 환영합니다!>");
    }

    public static void hotelMainScreen() {
        greeting();
        System.out.println("아래 메뉴 중 원하시는 서비스의 번호를 입력해 주세요.");
        System.out.println("");
        System.out.println("1. 예약하기");
        System.out.println("2. 예약 조회하기");
        System.out.println("3. 예약 취소하기");
        System.out.println("4. 관리자 메뉴"); //1.전체예약 조회 2.보유 자산 조회
        System.out.println("☆.｡･:*:･ﾟ`☆､｡･:*:･ﾟ`★.｡･:*:･ﾟ`☆.｡･:☆♪");
        System.out.println("HAVE A NICE DAY!");
        System.out.println("☆.｡･:*:･ﾟ`☆､｡･:*:･ﾟ`★.｡･:*:･ﾟ`☆.｡･:☆♪");
        System.out.println("");
        System.out.println(">>");

        int clientInput0 = sc.nextInt();
        switch (clientInput0) {
            case 1:
                makeReservationScreen();
                break;
            case 2:
                showMyReservationScreen();
                break;
            case 3:
                cancelReservationScreen();
                break;
            case 4:
                managerModeScreen();
                break;
            default:
                System.out.println("잘못된 입력입니다.");
                hotelMainScreen();
        }
    }

    public static void makeReservationScreen() {
        greeting();
        System.out.println("예약을 원하시는 날짜를 선택해 주세요.");
        System.out.println("");
        System.out.println(">>");
        System.out.println("예약을 원하시는 객실 호수를 선택해 주세요.");
        System.out.println("");
        System.out.println(">>");

        int // 예약 날짜
        int clientInput = sc.nextInt();


        List<Reservation> reservationList = new ArrayList<>();
        List<Room> roomList = new ArrayList<>();
        for (int i = 0; i < roomList.size(); i++) {
            System.out.println("<ROOM LIST>");
            System.out.println("[+" + roomList.get(i).roomNumber + "] " + roomList.get(i).roomType + " ㅣ " + "$" + roomList.get(i).roomPrice);
        }

        if (reservationList.contains(clientInput)) {
            greeting();
            System.out.println("[Room " + clientInput + "]" + "는 해당 날짜에 예약이 불가합니다. 다른 객실을 선택해 주세요.");
            makeReservationScreen();
        } else {
            greeting();
            System.out.println("[Room " + clientInput + "]" + "을 예약하시겠습니까?");
            System.out.println("1. 예       2. 아니오");
            System.out.println("");
            System.out.println(">>");

            int clientInput2 = sc.nextInt();

            if (clientInput2 == 2) {
                makeReservationScreen();
            } else {
                greeting();
                System.out.println("예약자 성함을 입력해 주세요. (예: 홍길동)");
                System.out.println(">>");
                String clientName = sc.nextLine();
                System.out.println("연락 가능한 휴대전화 번호를 입력해 주세요. (예: XXX-XXXX-XXXX)");
                System.out.println(">>");
                String clientPhoneNumber = sc.nextLine();
                System.out.println("지출 가능한 예산(소지금, $)을 입력해 주세요. (예: 100)");
                System.out.println(">>");
                int clientBudget = sc.nextInt();

                if (clientBudget < roomList.get(i).roomPrice) // 예산이 객실 가격보다 적으면
                {
                    System.out.println("예산이 초과되었습니다. 다른 객실을 선택해 주세요.");
                    greeting();
                    makeReservationScreen();
                } else {
                    System.out.println("예약을 진행 중입니다.");
                    try {
                        Thread.sleep(3000); // 3초 대기
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    makeReservation();
                    confirmReservationScreen();

                }
            }
        }
    }

    public static void confirmReservationScreen() {
        greeting();
        System.out.println("예약이 확정되셨습니다.");
        System.out.println("");
        System.out.println("==" + " 예약정보 " + "==");
        System.out.println("예약자: " + reservationList.peek().clientName);
        System.out.println("예약 객실: [Room " + reservationList.peek().roomNumber + "]");
        System.out.println("예약 번호: "); //createdAt+roomNumber //uuid
        System.out.println("☆.｡･:*:･ﾟ`☆､｡･:*:･ﾟ`★.｡･:*:･ﾟ`☆.｡･:☆♪");
        System.out.println("HAVE A NICE DAY!");
        System.out.println("☆.｡･:*:･ﾟ`☆､｡･:*:･ﾟ`★.｡･:*:･ﾟ`☆.｡･:☆♪");

        List<Client> clientList = new ArrayList<>();

    }

    public static void showMyReservationScreen() {
        greeting();
        System.out.println("예약자 성함을 입력해 주세요.");

    }

    public static void cancelReservationScreen() {
        greeting();
        System.out.println("예약자 성함을 입력해 주세요.");
    }

    public static void managerModeScreen() {
        System.out.println("["+" 관리자 메뉴 "+"]");
        System.out.println("1. 전체 예약 조회하기");
        System.out.println("2. 보유 자산 조회하기");
        int managerInput = sc.nextInt();

        if (managerInput==1) {
            showAllReservation();
        } else {
            // 보유 자산 조회하기()
        }

    }
}