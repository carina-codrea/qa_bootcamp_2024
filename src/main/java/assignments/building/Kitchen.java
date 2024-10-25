package assignments.building;

public class Kitchen extends Room{
    public Kitchen() {
        super();
        addAppliance("coffee machine");
        addAppliance("water dispenser");
        addAppliance("fridge");
    }

    @Override
    public RoomType getRoomType() {
        return RoomType.KITCHEN;
    }


}
