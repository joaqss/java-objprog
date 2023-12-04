public class Main {
    public static void main(String[] args) {

        Car carA = new Car("PQZ978", "Sedan",
                12.2f, "Red", true);

        System.out.println("CarA's license plate: " + carA.licensePlateNo);
        System.out.println("CarA's car type: " + carA.carType);
        System.out.println("CarA's average MPG: " + carA.aveMPG);
        System.out.println("CarA's car color: " + carA.carColor);
        System.out.println("CarA's tail light is working: " + carA.tailLightWorking);

        Car carB = new Car("NQZ988", "SUV",
                20.6f, "Black", false);

        System.out.println("\nCarB's license plate: " + carB.licensePlateNo);
        System.out.println("CarB's car type: " + carB.carType);
        System.out.println("CarB's average MPG: " + carB.aveMPG);
        System.out.println("CarB's car color: " + carB.carColor);
        System.out.println("CarB's tail light is working: " + carB.tailLightWorking);


    }
}