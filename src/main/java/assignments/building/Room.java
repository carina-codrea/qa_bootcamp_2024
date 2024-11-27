package assignments.building;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public abstract class Room {
    @Getter
    private int furniture;

    @Getter
    @Setter
    private List<String> appliances;

    public abstract RoomType getRoomType();
    public Room() {
        this.appliances = new ArrayList<>();
    }
    public Room(int furniture){
        setFurniture(furniture);
        this.appliances = new ArrayList<>();
    }


    public void setFurniture(int furniture) {
        if (furniture < 0){
            throw new IllegalArgumentException("Furniture count cannot be less than 0. ");
        }

        this.furniture = furniture;
    }


    public void addAppliance(String appliance){
        appliances.add(appliance);
    }

    @Override
    public String toString() {
        StringBuilder roomDetails = new StringBuilder();

        if (furniture > 0){
            roomDetails
                    .append(getFurniture())
                    .append(" furniture");
        }


        if (!appliances.isEmpty()) {
            if (roomDetails.length() > 0){
                roomDetails.append(",");
            }

            roomDetails.append(String.join(", ", appliances));
        }

        return roomDetails.toString();
    }

}
