package assignments.building;

public class Conference extends Room{

    public Conference() {
    }

    public Conference(int furniture){
        super(furniture);
    }

    @Override
    public RoomType getRoomType() {
        return RoomType.CONFERENCE;
    }

    @Override
    public String toString() {
        String furniture = getFurniture() > 1 ? "seats" : "seat";

        return super.toString().replace("furniture",furniture);
    }


}
