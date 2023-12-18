import javax.swing.*;
import java.awt.*;

public class ButtonPanel {
    JPanel panel;
    JButton convertButton, exitButton;

    public ButtonPanel() {
        panel = new JPanel();
        convertButton = new JButton("Convert");
        exitButton = new JButton("Exit");

        panel.setLayout(new FlowLayout());
        panel.add(convertButton);
        panel.add(exitButton);


    }


}
