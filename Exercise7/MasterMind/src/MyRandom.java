import java.util.Random;

public class MyRandom {
    Random randomNumber;
    int rand1, rand2, rand3, rand4;

    public MyRandom() {
        rand1 = this.createRandomNo();
        rand2 = this.createRandomNo();
        rand3 = this.createRandomNo();
        rand4 = this.createRandomNo();
    }

    public int createRandomNo() {
        randomNumber = new Random();
        return (randomNumber.nextInt(6) + 1);
    }

    public void resetValue() {
        this.rand1 = this.createRandomNo();
        this.rand2 = this.createRandomNo();
        this.rand3 = this.createRandomNo();
        this.rand4 = this.createRandomNo();

    }

}
