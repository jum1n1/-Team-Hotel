import java.util.*;
import java.time.ZonedDateTime;
import java.time.ZoneOffset;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();

        // Room 객체 생성
        Room room1 = new Room("101", 12, 100000);  // 방 번호, 크기, 비용
        Room room2 = new Room("102", 12, 120000);
        Room room3 = new Room("103", 20, 150000);

        // Hotel 객체 안에 Room 객체를 추가
        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotel.addRoom(room3);

        while (true) { // 은영님
            System.out.println("원하시는 기능을 선택해주세요:");
            System.out.println("1: 방 예약");
            System.out.println("2: 방 목록 보기");
            System.out.println("3: 예약 정보 검색");

            System.out.println("6: 종료");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    // 방 예약 기능
                    System.out.println("이름입력");
                    String name = scanner.nextLine();

                    System.out.println("폰번호입력");
                    String phoneNumber = takePhoneNumber();

                    System.out.println("소지금입력");
                    double money = scanner.nextDouble();

                    Customer customer = new Customer(name, phoneNumber, money);

                    for (int i = 0; i < hotel.getRooms().size(); i++) {
                        System.out.println("호수 : " + hotel.getRooms().get(i).getRoomId() + " | 방사이즈 : " + hotel.getRooms().get(i).getSize() + " | 가격 : " + hotel.getRooms().get(i).getCost());
                    }

                    System.out.println("원하시는 방을 선택해주세요:");
                    String inputRoomNum = scanner.nextLine();

                    System.out.println("원하시는 예약날짜를 선택해주세요:");
                    String inputDate = scanner.nextLine();

                    for (int i = 0; i < hotel.getReservations().size(); i++) {
                        if (inputRoomNum.equals(hotel.getReservations().get(i).getRoom().getRoomId()) && inputDate.equals(hotel.getReservations().get(i).getDate())) {
                            System.out.println("예약불가 이미 예약이 있습니다.");
                        } else if (inputRoomNum.equals("101")) {
                            ZonedDateTime now = ZonedDateTime.now(ZoneOffset.UTC);
                            System.out.println("예약완료! 예약번호는 " + hotel.reserveRoom(customer, room1, inputDate) + " 입니다.");
                        } else if (inputRoomNum.equals("102")) {
                            ZonedDateTime now = ZonedDateTime.now(ZoneOffset.UTC);
                            System.out.println("예약완료! 예약번호는 " + hotel.reserveRoom(customer, room2, inputDate) + " 입니다.");
                        } else if (inputRoomNum.equals("103")) {
                            ZonedDateTime now = ZonedDateTime.now(ZoneOffset.UTC);
                            System.out.println("예약완료! 예약번호는 " + hotel.reserveRoom(customer, room3, inputDate) + " 입니다.");
                        }
                    }
                    break;

                case "2":
                    // 방 목록 보기 기능
                    break;

                case "3":
                    // 예약 정보 검색 기능
                    break;

                case "4":
                    //
                    break;

                case "5":
                    break;

                case "6":
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
            }
        }
    }

    //정규표현식으로
    public static String takePhoneNumber(){
        String returnNumber="";
        Scanner scanner = new Scanner(System.in);
        String ans = scanner.nextLine();
        boolean checkPhoneNum1 = Pattern.matches("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$", ans);
        boolean checkPhoneNum2 = Pattern.matches("^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}$", ans);

        if(!checkPhoneNum1 && !checkPhoneNum2){
            System.out.println("올바르지 않은 형식입니다." +
                    "다시 입력해주세요.");
            takePhoneNumber();
        } else if(checkPhoneNum2 && ans.length()==11){
            returnNumber += ans.substring(0,3)+"-"+ans.substring(3,7)+"-"+ans.substring(7,10);
        } else if(checkPhoneNum2 && ans.length()==10){
            returnNumber += ans.substring(0,3)+"-"+ans.substring(3,6)+"-"+ans.substring(6,9);
        } else if(checkPhoneNum1){
            returnNumber = ans;
        }
        return returnNumber;
    }

}
