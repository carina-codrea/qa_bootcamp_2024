package assignments.building;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class Floor {
    private int floorNumber;
    private List<Room> rooms;

    public Floor(int floorNumber) {
        this.rooms = new ArrayList<>();
        this.floorNumber = floorNumber;
    }

    public void addRoom(Room room) {
        if (room instanceof Conference conference) {

            if (this.floorNumber == 3) {
                conference.addAppliance("telepresence");
            }
        }
        rooms.add(room);
    }

    private HashMap<RoomType, Integer> getRoomCount() {
        HashMap<RoomType, Integer> roomCount = new HashMap<>();

        for (Room room : rooms) {
            RoomType roomType = room.getRoomType();

            if (roomCount.containsKey(roomType)) {
                roomCount.put(roomType, roomCount.get(roomType) + 1);
            } else {
                roomCount.put(roomType, 1);
            }
        }

        return roomCount;
    }

    @Override
    public String toString() {
        StringBuilder floorDetails = new StringBuilder();
        HashMap<RoomType, Integer> roomCount = getRoomCount();
        Set<RoomType> roomTypeKeys = roomCount.keySet();

        for (RoomType roomType : roomTypeKeys) {
            int count = roomCount.get(roomType);
            floorDetails.append(count)
                    .append(" ")
                    .append(roomType.getName())
                    .append(count > 1 ? "s:\n" : ":\n");

            int roomIndex = 1;
            for (Room room : rooms) {
                if (room.getRoomType() == roomType) {
                    floorDetails.append("\t")
                            .append(roomType.getName())
                            .append(" ")
                            .append(roomIndex)
                            .append("\n\t\t\t");

                    if (!room.toString().isBlank()){
                        floorDetails.append(room);

                    }

                    floorDetails.append("\n");

                    roomIndex++;
                }
            }
        }

        return floorDetails.toString();
    }
}
