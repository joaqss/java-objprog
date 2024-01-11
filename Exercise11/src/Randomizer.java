import java.util.Random;

public class Randomizer {

    Random rand;
    int x;

    public Randomizer() {

        rand = new Random();
        x = rand.nextInt(3);

    }

}
