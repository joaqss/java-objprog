import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class CashPanel {
    //DecimalFormat df = new DecimalFormat("0.00");
    JPanel panel = new JPanel();
    double yourCash = 5000.0;
    JLabel cash;

    public CashPanel() {
        panel.setLayout(new GridLayout(1,1));
        panel.setBorder(BorderFactory.createTitledBorder("Your cash"));
        cash = new JLabel(Double.toString(yourCash));

        panel.add(cash);


    }
}
