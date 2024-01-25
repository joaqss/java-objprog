import javax.swing.*;
import java.awt.*;

public class NicknameGetPage {

    JPanel panelNicknameGet = new JPanel();
    ImageIcon goButton, nicknameBg;
    JLabel lbNicknameBg, lbGoButton, player1Title, player2Title;
    JTextField player1Input, player2Input;
    String player1Nickname, player2Nickname;

    public NicknameGetPage() {
        panelNicknameGet.setLayout(null);

        nicknameBg = new ImageIcon("Othello/Images/nicknameGetBackground.png");
        lbNicknameBg = new JLabel();
        Image dabNicknameBg = nicknameBg.getImage();
        Image modifiedNicknameBg = dabNicknameBg.getScaledInstance(720, 640, Image.SCALE_REPLICATE);
        nicknameBg = new ImageIcon(modifiedNicknameBg);
        lbNicknameBg.setIcon(nicknameBg);
        lbNicknameBg.setBounds(0,0,720,640);

        player1Title = new JLabel("Player 1 Nickname");
        player1Title.setFont(new Font("Dogica Pixel", Font.BOLD, 20));
        player1Title.setBounds(210,80,400,100);

        player1Input = new JTextField();
        player1Input.setFont(new Font("Dogica Pixel", Font.PLAIN, 20));
        player1Input.setBounds(160,150,400,50);
        player1Input.setHorizontalAlignment(JTextField.CENTER);

        player2Title = new JLabel("Player 2 Nickname");
        player2Title.setFont(new Font("Dogica Pixel", Font.BOLD, 20));
        player2Title.setBounds(210,200,400,100);

        player2Input = new JTextField();
        player2Input.setFont(new Font("Dogica Pixel", Font.PLAIN, 20));
        player2Input.setBounds(160,270,400,50);
        player2Input.setHorizontalAlignment(JTextField.CENTER);

        lbGoButton = new JLabel();
        goButton = new ImageIcon("Othello/Images/NicknameGetPage/goButton.png");
        Image dabGoButton = goButton.getImage();
        Image modifiedGoButton = dabGoButton.getScaledInstance(220, 80, Image.SCALE_REPLICATE);
        goButton = new ImageIcon(modifiedGoButton);
        lbGoButton.setIcon(goButton);
        lbGoButton.setBounds(250,440,250,90);


        panelNicknameGet.add(player1Title);
        panelNicknameGet.add(player1Input);
        panelNicknameGet.add(player2Title);
        panelNicknameGet.add(player2Input);
        panelNicknameGet.add(lbGoButton);
        panelNicknameGet.add(lbNicknameBg);
    }
}
