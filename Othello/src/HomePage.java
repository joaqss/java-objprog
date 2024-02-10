import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventListener;

public class HomePage {

    JPanel panelLandingPage = new JPanel();
    JLabel lbMainTitle, lbStartButton, lbExitButton, lbHTPButton;
    ImageIcon startButton, mainTitle, exitButton, htpButton;

    public HomePage() {
        panelLandingPage.setLayout(null);

        mainTitle = new ImageIcon("Othello/Images/HomePage/mainTitle.png");
        lbMainTitle = new JLabel(mainTitle);
        lbMainTitle.setBounds(0, 100, 1000, 500);

        startButton = new ImageIcon("Othello/Images/HomePage/startButton.png");
        Image dabStartButton = startButton.getImage();
        Image modifiedStartButton = dabStartButton.getScaledInstance(300, 100, Image.SCALE_REPLICATE);
        startButton = new ImageIcon(modifiedStartButton);
        lbStartButton = new JLabel(startButton);
        lbStartButton.setBounds(370, 550, 300, 100);

        htpButton = new ImageIcon("Othello/Images/HomePage/htpButton.png");
        Image dabHTPButton = htpButton.getImage();
        Image modifiedHTPButton = dabHTPButton.getScaledInstance(300, 80, Image.SCALE_REPLICATE);
        htpButton = new ImageIcon(modifiedHTPButton);
        lbHTPButton = new JLabel(htpButton);
        lbHTPButton.setBounds(375, 665, 300, 80);

        exitButton = new ImageIcon("Othello/Images/HomePage/exitButton.png");
        Image dabExitButton = exitButton.getImage();
        Image modifiedExitButton = dabExitButton.getScaledInstance(250, 80, Image.SCALE_REPLICATE);
        exitButton = new ImageIcon(modifiedExitButton);
        lbExitButton = new JLabel(exitButton);
        lbExitButton.setBounds(400, 760, 250, 80);

        panelLandingPage.setOpaque(false);
        panelLandingPage.add(lbMainTitle);
        panelLandingPage.add(lbStartButton);
        panelLandingPage.add(lbHTPButton);
        panelLandingPage.add(lbExitButton);

        ///////////////////////////////////////////////////////////


    }

}
