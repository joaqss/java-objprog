import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DiceLabel {

    ImageIcon[] dices = new ImageIcon[6];
    JLabel lbDice;

    public DiceLabel(int diceNumber) {

        lbDice = new JLabel();

        int a=1;
        for(int i=0; i<6; i++) {
            dices[i] = new ImageIcon("Exercise10/Images/dice" + a + ".png");
            a++;
        }

        switch (diceNumber) {
            case 1:
                lbDice.setIcon(dices[0]);
                break;
            case 2:
                lbDice.setIcon(dices[1]);
                break;
            case 3:
                lbDice.setIcon(dices[2]);
                break;
            case 4:
                lbDice.setIcon(dices[3]);
                break;
            case 5:
                lbDice.setIcon(dices[4]);
                break;
            case 6:
                lbDice.setIcon(dices[5]);
                break;
            default:
                break;
        }


    }
}
