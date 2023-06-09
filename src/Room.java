public class Room {

    private int roomNum;
    private int size;
    private double cost;

    public Room(int roomNum, int size, double cost) {
        this.roomNum = roomNum;
        this.size = size;
        this.cost = cost;
    }

    public Room(int roomNum, int size, int cost) {
        this.roomNum = roomNum;
        this.size = size;
        this.cost = cost;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String toString(){
        return "방번호 : "+ roomNum +"    방 가격 : "+cost+"    방 크기 : "+size;
    }
}
