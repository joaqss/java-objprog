public class BuildingFloor {

    double totalFloorArea;
    int numberOfRooms;
    double floorHeight;
    String wallColor;

    public BuildingFloor(double inputTotalFloorArea, int inputNumberOfRooms,
                         double inputFloorHeight, String inputWallColor) {
        this.totalFloorArea = inputTotalFloorArea;
        this.numberOfRooms = inputNumberOfRooms;
        this.floorHeight = inputFloorHeight;
        this.wallColor = inputWallColor;
    }
    // change 2 attributes in one method
    public void change2Methods(int newNumberOfRooms, String newWallColor) {
        this.numberOfRooms = newNumberOfRooms;
        this.wallColor = newWallColor;
    }
    // change 1 attribute (rooms)
    public void changeNumberOfRooms(int newNumberOfRooms) {
        this.numberOfRooms = newNumberOfRooms;
    }
    // change 1 attribute (wall color)
    public void changeWallColor(String newWallColor) {
        this.wallColor = newWallColor;
    }
}
