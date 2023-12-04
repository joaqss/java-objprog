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

    public void changeMethods(int newNumberOfRooms, String newWallColor) {
        this.numberOfRooms = newNumberOfRooms;
        this.wallColor = newWallColor;
    }
}
