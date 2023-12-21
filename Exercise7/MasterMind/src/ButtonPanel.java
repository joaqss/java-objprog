import javax.swing.*;
import java.awt.*;

public class ButtonPanel {

    JPanel buttonPanel;
    JButton exitButton, submitButton;
    int trialNumber = 0;

    public ButtonPanel() {
        // BUTTON PANEL
        buttonPanel = new JPanel();
        buttonPanel.setLayout(null);

        submitButton = new JButton("Submit");
        exitButton = new JButton("Exit");

        submitButton.setBounds(0,10,80,30);
        buttonPanel.add(submitButton);

        exitButton.setBounds(100,10,80,30);
        buttonPanel.add(exitButton);
    }
}
