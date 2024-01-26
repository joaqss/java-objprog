import javax.swing.*;
import java.awt.*;

public class GameProperPage {
    JPanel panelGameProper = new JPanel();
    ImageIcon gameBoard;
    JLabel lbGameBoard;

    public GameProperPage() {

        panelGameProper.setLayout(null);
        panelGameProper.setOpaque(false);

        gameBoard = new ImageIcon("Othello/Images/GameProperPage/gameBoard.png");
        lbGameBoard = new JLabel();
        Image dabGameBoard = gameBoard.getImage();
        Image modifiedGameBoard = dabGameBoard.getScaledInstance(950, 950, Image.SCALE_REPLICATE);
        gameBoard = new ImageIcon(modifiedGameBoard);
        lbGameBoard.setIcon(gameBoard);
        lbGameBoard.setBounds(0,0,950,950);

        panelGameProper.add(lbGameBoard);
    }


}
