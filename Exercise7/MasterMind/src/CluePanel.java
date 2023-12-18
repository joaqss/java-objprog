import javax.swing.*;
import java.awt.*;

public class CluePanel {
    JPanel cpPanel;
    JLabel B1, B2, B3, B4;

    public CluePanel() {

        cpPanel = new JPanel();
        cpPanel.setLayout(null);

        B1 = new JLabel("■");
        B1.setForeground(Color.GRAY);
        B1.setBounds(9,5,20,20);

        B2 = new JLabel("■");
        B2.setForeground(Color.GRAY);
        B2.setBounds(21,5,20,20);

        B3 = new JLabel("■");
        B3.setForeground(Color.GRAY);
        B3.setBounds(9,17,20,20);

        B4 = new JLabel("■");
        B4.setForeground(Color.GRAY);
        B4.setBounds(21,17,20,20);

        cpPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        cpPanel.add(B1);
        cpPanel.add(B2);
        cpPanel.add(B3);
        cpPanel.add(B4);





    }

}
