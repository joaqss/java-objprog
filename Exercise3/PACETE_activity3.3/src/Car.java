public class Car {
    //attributes
    String licensePlateNo;
    String carType;
    float aveMPG;
    String carColor;
    boolean tailLightWorking;

    // constructor method
    public Car(String inputLicensePlateNo,
               String inputCarType,
               float inputAveMPG,
               String inputCarColor,
               boolean inputTailLightWorking) {
        // lahat na nanggaling na input, ilalagay sa mga attributes.
        // Yung "this", iniindicate na dito sa class nanggaling ito.
        this.licensePlateNo = inputLicensePlateNo;
        this.carType = inputCarType;
        this.aveMPG = inputAveMPG;
        this.carColor = inputCarColor;
        this.tailLightWorking = inputTailLightWorking;
    }

    public void changePaintColor(String newCarColor) {
        this.carColor = newCarColor;
    }

    public void changeTailLightWorking(boolean newTailLightWorking) {
        this.tailLightWorking = newTailLightWorking;
    }
}
