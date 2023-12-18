import javax.swing.*;
import java.awt.*;

public class TextPanel {
    JPanel panel;
    JLabel celsiusLabel;
    JLabel fahrenheitLabel;
    JTextField celsiusTextField;
    JTextField fahrenheitTextField;

    public TextPanel() {
        panel = new JPanel();
        celsiusLabel = new JLabel("Celsius: ");
        fahrenheitLabel = new JLabel("Fahrenheit: ");
        celsiusTextField = new JTextField("0");
        fahrenheitTextField = new JTextField("0");

        this.TextEnableF();

        panel.setLayout(new GridLayout(2, 2));
        panel.add(celsiusLabel);
        panel.add(celsiusTextField);
        panel.add(fahrenheitLabel);
        panel.add(fahrenheitTextField);
    }

    public void TextEnableC() {
        fahrenheitTextField.setEnabled(false);
        celsiusTextField.setEnabled(true);

    }

    public void TextEnableF() {
        celsiusTextField.setEnabled(false);
        fahrenheitTextField.setEnabled(true);

    }
}
