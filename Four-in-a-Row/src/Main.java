
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Main {

    Font mainFont;
    JFrame mainFrame = new JFrame("Four in a Row - Java Edition");
    ImageIcon gameLogo, mainBg;
    JLabel lbMainBg;
    HomePage mainHomePage;

    public Main() {


        mainFrame.setSize(1000,800);

        // logo
        gameLogo = new ImageIcon("Four-in-a-Row/Images/mainlogo.png");
        mainFrame.setIconImage(gameLogo.getImage());
        // bg
        mainBg = new ImageIcon("Four-in-a-Row/Images/mainBg.png");
        lbMainBg = new JLabel(mainBg);
        mainFrame.setContentPane(lbMainBg);

        mainHomePage = new HomePage();
        mainFrame.add(mainHomePage.panelLandingPage);
        mainHomePage.panelLandingPage.setBounds(0,100,1000,100);



        mainFrame.setLocationRelativeTo(null); // center the window
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }


    public static void main(String[] args) {
        Main runGame = new Main();
    }
}