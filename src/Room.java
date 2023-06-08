public class Room {

    private String roomId;
    private int size;
    private double cost;

    public Room(String roomId, int size, double cost) {
        this.roomId = roomId;
        this.size = size;
        this.cost = cost;
    }

    public Room(String roomId, int size, int cost) {
        this.roomId = roomId;
        this.size = size;
        this.cost = cost;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
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
}
