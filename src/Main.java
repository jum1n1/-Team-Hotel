import java.util.*;

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
}