public class Main {

    public static void displayAttributes(BuildingFloor floor8, BuildingFloor floor3) {
        System.out.println("3rd Floor Details: ");
        System.out.println("\t Total Floor Area: " + floor3.totalFloorArea);
        System.out.println("\t Number of Rooms: " + floor3.numberOfRooms);
        System.out.println("\t Height of Floor: " + floor3.floorHeight);
        System.out.println("\t Wall Color: " + floor3.wallColor);

        System.out.println("\n8th Floor Details: ");
        System.out.println("\t Total Floor Area: " + floor8.totalFloorArea);
        System.out.println("\t Number of Rooms: " + floor8.numberOfRooms);
        System.out.println("\t Height of Floor: " + floor8.floorHeight);
        System.out.println("\t Wall Color: " + floor8.wallColor);
    }

    public static void main(String[] args) {

        // length = 66
        // width = 22

        BuildingFloor floor8 = new BuildingFloor(1452, 14, 2.5, "Orange");
        BuildingFloor floor3 = new BuildingFloor(1452, 16, 2.5, "Green");

        // print current attributes
        System.out.println("\n!Default Attributes!");
        displayAttributes(floor3, floor8);

        // Change attributes
        floor3.change2Methods(14, "Light Brown");
        floor8.change2Methods(16, "Dark Orange");

        System.out.println("\n\n! New Changes in the Attributes ! (Wall Color and No. of Rooms)");
        displayAttributes(floor3, floor8);

        // Change attributes (2nd time)
        floor8.changeWallColor("Light Orange");
        floor3.changeNumberOfRooms(19);

        System.out.println("\n\n! New Changes in the Attributes ! (Floor 3 No. of Rooms & Floor 8 Wall Color)");
        displayAttributes(floor3, floor8);

    }
}
