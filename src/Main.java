

import java.util.*;
import java.time.ZonedDateTime;
import java.time.ZoneOffset;
import java.util.regex.Pattern;

public class Main {
    public static void greeting() {
        System.out.println("☆.｡･:*:･ﾟ`☆､｡･:*:･ﾟ`★.｡･:*:･ﾟ`☆.｡･:☆♪");
        System.out.println("<HOTEL Number Six 에 오신 것을 환영합니다!>");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();

        // Room 객체 생성
        Room room1 = new Room("101", 12, 100000);  // 방 번호, 크기, 비용
        Room room2 = new Room("102", 12, 100000);
        Room room3 = new Room("103", 12, 100000);
        Room room4 = new Room("201", 20, 150000);
        Room room5 = new Room("202", 20, 150000);
        Room room6 = new Room("203", 20, 150000);
        Room room7 = new Room("301", 30, 200000);
        Room room8 = new Room("302", 30, 200000);
        Room room9 = new Room("303", 30, 200000);
        Room room10 = new Room("401", 50, 400000);

        // Hotel 객체 안에 Room 객체를 추가
        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotel.addRoom(room3);
        hotel.addRoom(room4);
        hotel.addRoom(room5);
        hotel.addRoom(room6);
        hotel.addRoom(room7);
        hotel.addRoom(room8);
        hotel.addRoom(room9);
        hotel.addRoom(room10);

        while (true) { // 은영님
            greeting();
            System.out.println("원하시는 서비스를 선택해 주세요:");
            System.out.println("1. 객실 예약하기");
            System.out.println("2. 객실 목록 조회하기");
            System.out.println("3. 예약 정보 확인하기");
            System.out.println("4. 예약 취소하기");
            System.out.println("5. 관리자 모드");
            System.out.println("6. 종료");
            System.out.println("☆.｡･:*:･ﾟ`☆､｡･:*:･ﾟ`★.｡･:*:･ﾟ`☆.｡･:☆♪");
            System.out.println("HAVE A NICE DAY!");
            System.out.println("☆.｡･:*:･ﾟ`☆､｡･:*:･ﾟ`★.｡･:*:･ﾟ`☆.｡･:☆♪");
            System.out.println("");
            System.out.println(">>");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    // 방 예약 기능
                    greeting();
                    System.out.println(" [ 객실 예약하기 ] ");
                    System.out.println("성함을 입력해 주세요.");
                    String name = scanner.nextLine();
                    System.out.println("연락 가능한 휴대전화 번호를 입력해 주세요.");
                    String phoneNumber = takePhoneNumber();
                    System.out.println("지출 가능한 예산을 입력해 주세요.");
                    double money = scanner.nextDouble();
                    Customer customer = new Customer(name, phoneNumber, money);
                    System.out.println("원하시는 예약 날짜를 선택해 주세요:");
                    String inputDate = takeDate();  // 호텔 체크인 일시
                    scanner.nextLine();
                    for (Room rooms : hotel.getRooms()) {
                        System.out.println("호수 : " + rooms.getRoomId() + " | 객실 크기 : " + rooms.getSize() + " | 가격 : " + rooms.getCost());
                    }
                    System.out.println("원하시는 객실을 선택해 주세요:");
                    String inputRoomId = scanner.nextLine();
                    boolean t = true;
                    // 호텔 이름 && 예약일 == 예약내역 과 겹치면 x
                    for (Reservation rv : hotel.getReservations()) {
                        if (inputRoomId.equals(rv.getRoom().getRoomId()) && inputDate.equals(rv.getDate())) {
                            System.out.println("[예약 불가] 이미 예약이 있습니다.");
                            System.out.println("메인으로 돌아갑니다.");
                            t = false;
                        }
                    }
                    if (t == false){
                        break;
                    }
                    Room roomPicked = null;
                    for (Room r : hotel.getRooms()) {
                        if (inputRoomId.equals(r.getRoomId())) {
                            roomPicked = r;
                            if (money < roomPicked.getCost()) { // 돈 모자르면 back
                                System.out.println("예산부족!");
                            } else {
                                ZonedDateTime completedReservationT = ZonedDateTime.now(ZoneOffset.UTC);  // 예약일시
                                System.out.println("예약완료! 예약번호는 " + hotel.reserveRoom(customer, roomPicked, inputDate) + " 입니다.");
                            }
                        }
                    }
                    break;

                case "2":
                    // 방 목록 보기 기능
                    greeting();
                    System.out.println(" [ 객실 목록 조회하기 ] ");
                    hotel.getAllRooms(); // todo 모든 방 보여주기 구현하기
                    break;

                case "3":
                    // 예약 정보 검색 기능
                    greeting();
                    System.out.println(" [ 예약 정보 확인하기 ] " +
                            "\n예약번호를 입력해주세요.");
                    String ans= scanner.nextLine();
                    Reservation targetReservation = hotel.getReservationsByCustomer(ans);
                    if (targetReservation==null){
                        System.out.println("해당 예약이 없습니다.");
                    } else {
                        System.out.println("예약 정보는 : \n" + targetReservation.getRoom() + targetReservation.getDate()); //todo 포맷다듬기
                        break;
                    }

                case "4":
                    //
                    // 예약 취소하기
                    greeting();
                    System.out.println(" [ 예약 취소하기 ] ");
                    System.out.println("예약 번호를 입력해 주세요.");
                    String cancelInput = scanner.nextLine();
                    hotel.cancelReservation(cancelInput);
                    break;

                case "5":
                    //관리자 모드
                    System.out.println(" [ 관리자 모드 ] ");
                    System.out.println("1. 예약 목록 조회하기");
                    System.out.println("2. 종료하기");
                    System.out.println(">>");
                    int managerInput = scanner.nextInt();
                    if (managerInput == 1) {
                        hotel.getAllReservations();// 모든 예약 조회 메소드. todo 모든 예약조회 관리자모드
                    } else {
                        System.out.println(" [ 프로그램을 종료합니다. ] ");
                        scanner.close();
                        System.exit(0);
                    }
                    break;

                case "6":
                    System.out.println("프로그램을 종료합니다.");
                    greeting();
                    System.out.println(" [ 프로그램을 종료합니다. ] ");
                    System.out.println("☆.｡･:*:･ﾟ`☆､｡･:*:･ﾟ`★.｡･:*:･ﾟ`☆.｡･:☆♪");
                    System.out.println("HAVE A NICE DAY!");
                    System.out.println("☆.｡･:*:･ﾟ`☆､｡･:*:･ﾟ`★.｡･:*:･ﾟ`☆.｡･:☆♪");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
            }

        }

    }


    //정규표현식으로
    public static String takePhoneNumber() {
        String returnNumber = "";
        Scanner scanner = new Scanner(System.in);
        String ans = scanner.nextLine();
        boolean checkPhoneNum1 = Pattern.matches("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$", ans);
        boolean checkPhoneNum2 = Pattern.matches("^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}$", ans);

        if (!checkPhoneNum1 && !checkPhoneNum2) {
            System.out.println("올바르지 않은 형식입니다." +
                    "다시 입력해주세요.");
            takePhoneNumber();
        } else if (checkPhoneNum2 && ans.length() == 11) {
            returnNumber += ans.substring(0, 3) + "-" + ans.substring(3, 7) + "-" + ans.substring(7, 11);
        } else if (checkPhoneNum2 && ans.length() == 10) {
            returnNumber += ans.substring(0, 3) + "-" + ans.substring(3, 6) + "-" + ans.substring(6, 10);
        } else if (checkPhoneNum1) {
            returnNumber = ans;
        }
        System.out.println(returnNumber); // 확인용
        return returnNumber;
    }
    public static String takeDate() {
        String returnDate = "";
        Scanner scanner = new Scanner(System.in);
        String date = scanner.nextLine();
        boolean checkDate1 = Pattern.matches("^\\d{4}\\-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$", date);
        boolean checkDate2 = Pattern.matches("^\\d{4}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])$", date);
        if (!checkDate1 && !checkDate2) {
            System.out.println("올바르지 않은 형식입니다." +
                    "다시 입력해주세요.");
        } else if (checkDate2) {
            returnDate += date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6, 8);
        } else if (checkDate1) {
            returnDate = date;
        }
//        System.out.println(returnDate); // 확인용
        return returnDate;
    }



}