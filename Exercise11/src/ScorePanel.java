import javax.swing.*;
import java.awt.*;

public class ScorePanel {

    JPanel panel = new JPanel();
    JTextField playerTextField, computerTextField;
    JLabel player, computer;
    int playerScore, computerScore;

    public ScorePanel() {

        panel.setLayout(new GridLayout(2,2));

        playerScore = 0;
        computerScore = 0;

        player = new JLabel("Player");
        playerTextField = new JTextField(String.valueOf(playerScore));
        computer = new JLabel("Computer");
        computerTextField = new JTextField(String.valueOf(computerScore));

        playerTextField.setEnabled(false);
        computerTextField.setEnabled(false);

        panel.add(player);
        panel.add(computer);
        panel.add(playerTextField);
        panel.add(computerTextField);

    }



}
