package assignments.building;

public class Office extends Room {

    public Office(int furniture) {
        super(furniture);
    }

    @Override
    public RoomType getRoomType() {
        return RoomType.OFFICE;
    }

    @Override
    public String toString() {
        String furniture = getFurniture() > 1 ? "desks" : "desk";

        return super.toString().replace("furniture",furniture);
    }
}
