
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Main {

    Font mainFont;
    JFrame mainFrame = new JFrame("Othello - Java Edition");
    ImageIcon gameLogo, mainBg;
    JLabel lbMainBg;
    HomePage mainHomePage;

    public Main() {


        mainFrame.setSize(1920,1080);

        // logo
        gameLogo = new ImageIcon("Othello/Images/mainlogo.png");
        mainFrame.setIconImage(gameLogo.getImage());
        // bg
        mainBg = new ImageIcon("Othello/Images/mainBg.png");
        lbMainBg = new JLabel(mainBg);
        mainFrame.setContentPane(lbMainBg);

        mainHomePage = new HomePage();
        mainFrame.add(mainHomePage.panelLandingPage);
        mainHomePage.panelLandingPage.setBounds(480,0,1000,1080);

        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setLocationRelativeTo(null); // center the window
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }


    public static void main(String[] args) {
        Main runGame = new Main();
    }
}