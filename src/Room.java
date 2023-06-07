public class Room {
    public int roomNumber;
    public String roomType;
    public int roomPrice;
    public int getroomNumber() {
        return roomNumber;
    }
    public String getroomType() {
        return roomType;
    }
    public int getroomPrice() {
        return roomPrice;
    }

    Room(int number, String type, int price) {
        this.roomNumber = number;
        this.roomType = type;
        this.roomPrice = price;
    }

    public Room() {
    }


}



