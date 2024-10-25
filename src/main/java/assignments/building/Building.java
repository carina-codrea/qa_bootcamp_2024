package assignments.building;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Building {
    private List<Floor> floors;
    public void assignConferenceRoomEquipment() {
        Conference largestConferenceRoom = null;

        //find the largest conference room from the building
        for (Floor floor : floors) {
            for (Room room : floor.getRooms()) {
                if (room instanceof Conference conferenceRoom) {
                    // Check if this conference room is larger than the current largest
                    if (largestConferenceRoom == null || conferenceRoom.getFurniture() > largestConferenceRoom.getFurniture()) {
                        largestConferenceRoom = conferenceRoom;
                    }
                }
            }
        }
        // add video projector as appliance to the largest conference room
        if (largestConferenceRoom != null){
            largestConferenceRoom.addAppliance("video projector");
        }


        // add tv as appliance to the rest of the conference rooms
        for (Floor floor : floors) {
            for (Room room : floor.getRooms()) {
                if (room instanceof Conference conferenceRoom && conferenceRoom != largestConferenceRoom) {
                    conferenceRoom.addAppliance("TV");
                }
            }
        }
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("Building has ")
                .append(floors.size())
                .append(" floors")
                .append("\n");

        for (Floor floor : floors) {
            stringBuilder
                    .append("Floor ")
                    .append(floor.getFloorNumber())
                    .append(":")
                    .append("\n")
                    .append(floor);
        }

        return stringBuilder.toString();
    }
}
