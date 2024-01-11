import javax.swing.*;

public class ButtonPanel {

    JPanel panel = new JPanel();
    JButton goButton, resetButton, exitButton;

    public ButtonPanel() {

        goButton = new JButton("Go");
        resetButton = new JButton("Reset");
        exitButton = new JButton("Exit");

        panel.add(goButton);
        panel.add(resetButton);
        panel.add(exitButton);

    }

}
