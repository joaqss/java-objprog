import javax.swing.*;
import java.awt.*;

public class AnswerPanel {
    JPanel AnsPanel;
    JLabel L1, L2, L3, L4;

    public AnswerPanel() {
        AnsPanel = new JPanel();

        L1 = new JLabel("■");
        L1.setForeground(Color.GRAY);
        L1.setBounds(25,10,20,20);

        L2 = new JLabel("■");
        L2.setBounds(80,10,20,20);
        L2.setForeground(Color.GRAY);

        L3 = new JLabel("■");
        L3.setForeground(Color.GRAY);
        L3.setBounds(135,10,20,20);

        L4 = new JLabel("■");
        L4.setForeground(Color.GRAY);
        L4.setBounds(190,10,20,20);

        AnsPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        AnsPanel.setLayout(null);
        AnsPanel.add(L1);
        AnsPanel.add(L2);
        AnsPanel.add(L3);
        AnsPanel.add(L4);
    }

    public void resetValue() {
        this.L1.setForeground(Color.GRAY);
        this.L2.setForeground(Color.GRAY);
        this.L3.setForeground(Color.GRAY);
        this.L4.setForeground(Color.GRAY);


    }
}
