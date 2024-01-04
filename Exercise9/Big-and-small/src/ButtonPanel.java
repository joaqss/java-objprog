import javax.swing.*;
import java.awt.*;

public class ButtonPanel {

    JPanel panel = new JPanel();
    JButton rollButton, exitButton;

    public ButtonPanel() {
        panel.setLayout(new FlowLayout());
        rollButton = new JButton("Roll");
        exitButton = new JButton("Exit");

        panel.add(rollButton);
        panel.add(exitButton);
    }
}
