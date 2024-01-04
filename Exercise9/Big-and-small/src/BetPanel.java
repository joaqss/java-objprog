import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class BetPanel {
    //DecimalFormat df = new DecimalFormat("0.00");
    JPanel panel = new JPanel();
    double userAmount = 0.0;
    JTextField enterBet;

    public BetPanel() {
        panel.setLayout(new GridLayout(1,1));
        panel.setBorder(BorderFactory.createTitledBorder("Your Bet"));
        enterBet = new JTextField(Double.toString(userAmount));

        panel.add(enterBet);

    }
}
