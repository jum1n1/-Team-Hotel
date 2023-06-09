

import java.util.*;
import java.time.ZonedDateTime;
import java.time.ZoneOffset;
import java.util.regex.Pattern;

public class Main {
    static Hotel hotel;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        hotel = new Hotel();

        //메인메뉴 실행.
        while (true) {
            greeting();
            printMainMenu(); //메뉴 리스트 프린트
            //메인메뉴 입력 및 실행
            switch (scanner.nextInt()) {
                case 1:
                    // 방 예약 기능
                    greeting();
                    makeReservation();
                    break;

                case 2:
                    // 방 목록 보기 기능
                    greeting();
                    showRoomList();
                    break;

                case 3:
                    // 예약 정보 검색 기능
                    greeting();
                    findReservation();
                    break;

                case 4:
                    // 예약 취소하기
                    greeting();
                    cancleReservation();
                    break;

                case 5:
                    //관리자 모드
                    enterAdminMode();
                    break;

                case 6:
                    exitProgram();
                    break;

                default:
                    System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
            }
        }
    }

    //메인메뉴 출력 메소드//
    public static void greeting() { //todo 옮기기
        System.out.println("☆.｡･:*:･ﾟ`☆､｡･:*:･ﾟ`★.｡･:*:･ﾟ`☆.｡･:☆♪");
        System.out.println("<HOTEL Number Six 에 오신 것을 환영합니다!>");
    }

    static void printMainMenu(){
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
    }

    //1. 예약하기
    public static void makeReservation(){
        Scanner scanner = new Scanner(System.in);

        System.out.println(" [ 객실 예약하기 ] ");
        System.out.println("성함을 입력해 주세요.");
        String name = scanner.nextLine();
        System.out.println("연락 가능한 휴대전화 번호를 입력해 주세요.");
        String phoneNumber = takePhoneNumber();
        System.out.println("지출 가능한 예산을 입력해 주세요.");
        double money = scanner.nextDouble();
        Customer customer = new Customer(name, phoneNumber, money);
        System.out.println("원하시는 예약 날짜를 선택해 주세요 (YYYY-MM-DD):");
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
        if (t){
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
        }
    }

    //1-1정규표현식으로 데이터 받기
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
        return returnDate;
    }


    //2. 모든 객실보기
    private static void showRoomList(){
        System.out.println(" [ 객실 목록 조회하기 ] ");
        hotel.getAllRooms(); // todo 모든 방 보여주기 구현하기
    }

    //3. 예약 조회하기
    private static void findReservation(){
        Scanner scanner = new Scanner(System.in);

        System.out.println(" [ 예약 정보 확인하기 ] " +
                "\n예약번호를 입력해주세요.");
        String ans= scanner.nextLine();
        Reservation targetReservation = hotel.getReservationsByCustomer(ans);
        if (targetReservation==null){
            System.out.println("해당 예약이 없습니다.");
        } else {
            System.out.println("예약 번호 \'"+ans+"\'의 예약조회 결과입니다.\n 방 이름 : " + targetReservation.getRoom() +"\n예약 일시"+targetReservation.getDate()); //todo 포맷다듬기
        }
    }

    private static void cancleReservation(){
        Scanner scanner = new Scanner(System.in);

        System.out.println(" [ 예약 취소하기 ] ");
        System.out.println("예약 번호를 입력해 주세요.");
        String cancelInput = scanner.nextLine();
        hotel.cancelReservation(cancelInput);
    }

    private static void enterAdminMode(){
        Scanner scanner = new Scanner(System.in);

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
    }

    private static void exitProgram(){
        Scanner scanner = new Scanner(System.in);

        System.out.println(" [ 프로그램을 종료합니다. ] ");
        System.out.println("☆.｡･:*:･ﾟ`☆､｡･:*:･ﾟ`★.｡･:*:･ﾟ`☆.｡･:☆♪");
        System.out.println("HAVE A NICE DAY!");
        System.out.println("☆.｡･:*:･ﾟ`☆､｡･:*:･ﾟ`★.｡･:*:･ﾟ`☆.｡･:☆♪");
        scanner.close();
        System.exit(0);
    }
}