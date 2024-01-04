import javax.swing.*;
import java.awt.*;

public class RadioButtonPanel {

    JPanel panel = new JPanel();
    JRadioButton highRB, lowRB;

    public RadioButtonPanel() {
        panel.setLayout(new FlowLayout());
        highRB = new JRadioButton("HIGH");
        lowRB = new JRadioButton("LOW");

        panel.add(highRB);
        panel.add(lowRB);
    }
}
