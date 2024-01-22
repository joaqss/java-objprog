import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HTPPage {

    JLabel htpTitle, description1, lbScroll, lbNextButton, lbBackButton;
    ImageIcon scrollImage, nextButton, backButton;
    JPanel panelHTPPage = new JPanel();

    public HTPPage() {

        panelHTPPage.setLayout(null);
        panelHTPPage.setOpaque(false);
        panelHTPPage.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        lbScroll = new JLabel();
        scrollImage = new ImageIcon("Othello/Images/HTPPage/scrollImage.png");
        Image dabScroll = scrollImage.getImage();
        Image modifiedScroll = dabScroll.getScaledInstance(1500, 1000, Image.SCALE_REPLICATE);
        scrollImage = new ImageIcon(modifiedScroll);
        lbScroll.setIcon(scrollImage);
        lbScroll.setBounds(0,30,1500,1000);

        htpTitle = new JLabel("Othello: How to Play?");
        htpTitle.setFont(new Font("Dogica Pixel", Font.BOLD, 40));
        htpTitle.setForeground(Color.BLACK);
        htpTitle.setBounds(200,130,800,100);

        description1 = new JLabel();
        description1.setFont(new Font("Dogica", Font.PLAIN,23));
        description1.setForeground(Color.BLACK);
        description1.setText("<html><div style='line-height: 10px;'>" +
                "Othello is an abstract strategy game played by two <br><br> players " +
                "on a board with 8 rows and 8 columns and a <br><br> set of 64 identical pieces. " +
                "The pieces are <br><br>typically discs with a light and a dark face, each<br><br> " +
                "colour assigned to one of the players. Players take<br><br> turns making a " +
                "\"move\" which consists in placing one<br><br> disc on the board with their " +
                "assigned colour facing<br><br> up and then flipping over all the opponent's<br><br> " +
                "discs that are \"outflanked\" by the disc that was <br><br>just placed.  The " +
                "objective of the game is to have a<br><br> majority of one's own coloured " +
                "pieces showing at<br><br> the end of the game.</div> </html>");

        description1.setBounds(200,230,1200,500);

        lbNextButton = new JLabel();
        nextButton = new ImageIcon("Othello/Images/HTPPage/nextButton.png");
        Image dabNextButton = nextButton.getImage();
        Image modifiedNextButton = dabNextButton.getScaledInstance(100, 90, Image.SCALE_REPLICATE);
        nextButton = new ImageIcon(modifiedNextButton);
        lbNextButton.setIcon(nextButton);
        lbNextButton.setBounds(1250,800,100,90);


        panelHTPPage.add(htpTitle);
        panelHTPPage.add(description1);
        panelHTPPage.add(lbNextButton);
        panelHTPPage.add(lbScroll);


        lbNextButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                htpTitle.setVisible(false);
                description1.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                htpTitle.setVisible(false);
                description1.setVisible(false);

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                nextButton = new ImageIcon("Othello/Images/HTPPage/nextButton-Selected.png");
                Image dabNextButton = nextButton.getImage();
                Image modifiedNextButton = dabNextButton.getScaledInstance(110, 100, Image.SCALE_REPLICATE);
                nextButton = new ImageIcon(modifiedNextButton);
                lbNextButton.setIcon(nextButton);
                lbNextButton.setBounds(1250,800,110,100);
                panelHTPPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                nextButton = new ImageIcon("Othello/Images/HTPPage/nextButton.png");
                Image dabNextButton = nextButton.getImage();
                Image modifiedNextButton = dabNextButton.getScaledInstance(100, 90, Image.SCALE_REPLICATE);
                nextButton = new ImageIcon(modifiedNextButton);
                lbNextButton.setIcon(nextButton);
                lbNextButton.setBounds(1250,800,400,100);
                panelHTPPage.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

            }
        });
    }
}
