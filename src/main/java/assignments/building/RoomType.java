package assignments.building;

public enum RoomType {
    KITCHEN("Kitchen"),
    TOILET("Toilet"),
    OFFICE("Office space"),
    CONFERENCE("Conference room");

    private final String name;

    RoomType(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
