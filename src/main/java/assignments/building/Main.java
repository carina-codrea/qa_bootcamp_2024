package assignments.building;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
     Floor firstFloor = new Floor(1);
     firstFloor.addRoom(new Office(20));
     firstFloor.addRoom(new Toilet());
     firstFloor.addRoom(new Toilet());
     firstFloor.addRoom(new Kitchen());

     for (int i = 0; i < 2 ; i++) {
            firstFloor.addRoom(new Conference(10));
        }

     Floor secondFloor = new Floor(2);
     secondFloor.addRoom(new Kitchen());

     for (int i = 0; i < 2 ; i++) {
            secondFloor.addRoom(new Office(10));
            secondFloor.addRoom(new Toilet());
        }

     for (int i = 0; i < 4 ; i++) {
            secondFloor.addRoom(new Conference(8));

        }

     Floor thirdFloor = new Floor(3);
     thirdFloor.addRoom(new Toilet());
     thirdFloor.addRoom(new Toilet());
     thirdFloor.addRoom(new Conference(30));
     thirdFloor.addRoom(new Conference(20));

        for (int i = 0; i < 4; i++) {
            thirdFloor.addRoom(new Conference(10));

        }

     List<Floor> floors = new ArrayList<>();
     floors.add(firstFloor);
     floors.add(secondFloor);
     floors.add(thirdFloor);

     Building building = new Building();
     building.setFloors(floors);

     building.assignConferenceRoomEquipment();

     System.out.println(building);





    }
}
