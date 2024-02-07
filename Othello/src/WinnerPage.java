import javax.swing.*;
import java.awt.*;

public class WinnerPage {
    JFrame winnerFrame = new JFrame("Winner!");
    JPanel panelWinnerFrame = new JPanel();
    ImageIcon playerPickColor, goButton, backButton, gameLogo;
    JLabel lbPlayerPickColor, playerPickTitle, player1Title, player2Title, lbGoButton, lbBackButton;
    GameProperPage subGameProperPage;
    WinnerPage mainWinnerPage = new WinnerPage(subGameProperPage);

    public WinnerPage(GameProperPage subGameProperPage) {


        // logo
        gameLogo = new ImageIcon("Othello/Images/mainlogo.png");

        winnerFrame.setSize(720, 640);
        winnerFrame.setIconImage(gameLogo.getImage());
        winnerFrame.setResizable(false);
        winnerFrame.setVisible(false);
        winnerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        winnerFrame.setLocationRelativeTo(null); // center the window

        ////////////////////////////////////////////////////////

        panelWinnerFrame.setLayout(null);
        panelWinnerFrame.setOpaque(false);

        lbPlayerPickColor = new JLabel();
        playerPickColor = new ImageIcon("Othello/Images/PegSelectPage/playerPickColor.png");
        Image dabPlayerPickColor = playerPickColor.getImage();
        Image modifiedPlayerPickColor = dabPlayerPickColor.getScaledInstance(1300, 700, Image.SCALE_REPLICATE);
        playerPickColor = new ImageIcon(modifiedPlayerPickColor);
        lbPlayerPickColor.setIcon(playerPickColor);
        lbPlayerPickColor.setBounds(320,200,1300,700);

        playerPickTitle = new JLabel("Choose your Peg!");
        playerPickTitle.setFont(new Font("Dogica Pixel", Font.BOLD, 35));
        playerPickTitle.setForeground(Color.BLACK);
        playerPickTitle.setBounds(720,250,700,100);

        player1Title = new JLabel();
        player1Title.setFont(new Font("Dogica Pixel", Font.BOLD, 28));
        player1Title.setForeground(Color.BLACK);
        player1Title.setHorizontalAlignment(JLabel.CENTER);
        player1Title.setBounds(620,320,700,70);

        player2Title = new JLabel();
        player2Title.setFont(new Font("Dogica Pixel", Font.BOLD, 28));
        player2Title.setForeground(Color.BLACK);
        player2Title.setHorizontalAlignment(JLabel.CENTER);
        player2Title.setBounds(620,520,700,70);

        lbGoButton = new JLabel();
        goButton = new ImageIcon("Othello/Images/PegSelectPage/goButton.png");
        Image dabGoButton = goButton.getImage();
        Image modifiedGoButton = dabGoButton.getScaledInstance(220, 80, Image.SCALE_REPLICATE);
        goButton = new ImageIcon(modifiedGoButton);
        lbGoButton.setIcon(goButton);
        lbGoButton.setBounds(870,730,250,90);

        lbBackButton = new JLabel();
        backButton = new ImageIcon("Othello/Images/PegSelectPage/backButton.png");
        Image dabBackButton = backButton.getImage();
        Image modifiedBackButton = dabBackButton.getScaledInstance(210, 70, Image.SCALE_REPLICATE);
        backButton = new ImageIcon(modifiedBackButton);
        lbBackButton.setIcon(backButton);
        lbBackButton.setBounds(620, 740, 210, 70);

        panelWinnerFrame.add(playerPickTitle);
        panelWinnerFrame.add(player1Title);
        panelWinnerFrame.add(player2Title);
        panelWinnerFrame.add(lbGoButton);
        panelWinnerFrame.add(lbBackButton);

        winnerFrame.add(panelWinnerFrame);


    }




}
