import javax.swing.*;
import java.awt.*;

public class RadioButtonPanel {

    JPanel panel;
    JRadioButton RB1, RB2;

    public RadioButtonPanel() {

        panel = new JPanel();
        RB1 = new JRadioButton("Celsius"); RB1.doClick(); // sets it as default
        RB2 = new JRadioButton("Fahrenheit");
        ButtonGroup RadioGroup = new ButtonGroup(); // so that only one button can be selected at a time.

        RadioGroup.add(RB1);
        RadioGroup.add(RB2);

        panel.setPreferredSize(new Dimension(200,60));
        panel.setLayout(new GridLayout(2,1));

        // layout
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Convert to"));
        panel.add(RB1);
        panel.add(RB2);


    }




}
