import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DicePanel {

    JPanel panel;
    ImageIcon[] dices = new ImageIcon[6];
    JLabel lbDice;

    public DicePanel() {

        panel = new JPanel();
        panel.setLayout(null);
        lbDice = new JLabel();

        int a=1;
        for(int i=0; i<6; i++) {
            dices[i] = new ImageIcon("Exercise9/Big-and-small/Images/dice" + a + ".png");
            a++;
        }

        lbDice.setIcon(dices[0]);

        lbDice.setBounds(0,0,150,150);
        panel.add(lbDice);

    }

    public void changeIcon(int x) {

        if (x==1) {
            lbDice.setIcon(dices[0]);
        }
        else if (x==2) {
            lbDice.setIcon(dices[1]);
        }
        else if (x==3) {
            lbDice.setIcon(dices[2]);
        }
        else if (x==4) {
            lbDice.setIcon(dices[3]);
        }
        else if (x==5) {
            lbDice.setIcon(dices[4]);
        }
        else if (x==6) {
            lbDice.setIcon(dices[5]);
        }

    }
}
