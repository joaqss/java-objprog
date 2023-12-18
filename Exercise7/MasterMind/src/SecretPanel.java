import javax.swing.*;
import java.awt.*;

public class SecretPanel {
    JPanel secretPanel;
    JLabel S1, S2, S3, S4;

    public SecretPanel() {
        secretPanel = new JPanel();
        secretPanel.setLayout(null);

        S1 = new JLabel("?");
        S1.setForeground(Color.GRAY);
        S1.setBounds(25,10,20,20);

        S2 = new JLabel("?");
        S2.setBounds(80,10,20,20);
        S2.setForeground(Color.GRAY);

        S3 = new JLabel("?");
        S3.setForeground(Color.GRAY);
        S3.setBounds(135,10,20,20);

        S4 = new JLabel("?");
        S4.setForeground(Color.GRAY);
        S4.setBounds(190,10,20,20);

        secretPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        secretPanel.add(S1);
        secretPanel.add(S2);
        secretPanel.add(S3);
        secretPanel.add(S4);

    }
}
