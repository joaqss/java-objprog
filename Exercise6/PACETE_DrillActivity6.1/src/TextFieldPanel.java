import javax.swing.*;
import java.awt.*;
public class TextFieldPanel {
    JPanel mainTFP;
    JTextField inchTextField, meterTextField;

    JLabel inchLabel, meterLabel;

    public TextFieldPanel() {
        mainTFP = new JPanel();
        mainTFP.setLayout(new GridLayout(4,1,0,0));
        mainTFP.setBackground(Color.white);

        inchLabel = new JLabel("Inch");
        inchTextField = new JTextField("0.00");
        inchTextField.setPreferredSize(new Dimension(200,50));
        inchTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        inchTextField.setBackground(new java.awt.Color(244, 244, 243));

        meterLabel = new JLabel("Meter");
        meterTextField = new JTextField("0.00");
        meterTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        meterTextField.setBackground(new java.awt.Color(244, 244, 243));

        mainTFP.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,20,0));
        mainTFP.add(inchLabel);
        mainTFP.add(inchTextField);
        mainTFP.add(meterLabel);
        mainTFP.add(meterTextField);


        this.disableMeter();

    }

    public void disableMeter() {
        inchTextField.setEnabled(false);
        meterTextField.setEnabled(true);

    }

    public void disableInch() {
        meterTextField.setEnabled(false);
        inchTextField.setEnabled(true);

    }

}
