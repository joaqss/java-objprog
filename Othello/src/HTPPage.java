import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HTPPage {

    JLabel htpTitle, rulesTitle, description1, description2, description3,
            description4, lbScroll, lbNextButton, lbBackButton, lbHomeButton;
    ImageIcon scrollImage, nextButton, backButton, homeButton;
    JPanel panelHTPPage = new JPanel();
    SoundClass soundClass;

    private HomePage homePage; // create private class to call HomePage panel

    public HTPPage(HomePage homePage) {
        soundClass = new SoundClass();
        this.homePage = homePage;

        panelHTPPage.setLayout(null);
        panelHTPPage.setOpaque(false);

        lbScroll = new JLabel();
        scrollImage = new ImageIcon("./Images/HTPPage/scrollImage.png");
        Image dabScroll = scrollImage.getImage();
        Image modifiedScroll = dabScroll.getScaledInstance(1500, 1000, Image.SCALE_REPLICATE);
        scrollImage = new ImageIcon(modifiedScroll);
        lbScroll.setIcon(scrollImage);
        lbScroll.setBounds(0,30,1500,1000);

        htpTitle = new JLabel("Othello: How to Play?");
        htpTitle.setFont(new Font("Dogica Pixel", Font.BOLD, 40));
        htpTitle.setForeground(Color.BLACK);
        htpTitle.setBounds(200,130,800,100);

        rulesTitle = new JLabel("Rules of Othello");
        rulesTitle.setFont(new Font("Dogica Pixel", Font.BOLD, 40));
        rulesTitle.setForeground(Color.BLACK);
        rulesTitle.setBounds(200,130,800,100);
        rulesTitle.setVisible(false);

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
        nextButton = new ImageIcon("./Images/HTPPage/nextButton.png");
        Image dabNextButton = nextButton.getImage();
        Image modifiedNextButton = dabNextButton.getScaledInstance(80, 80, Image.SCALE_REPLICATE);
        nextButton = new ImageIcon(modifiedNextButton);
        lbNextButton.setIcon(nextButton);
        lbNextButton.setBounds(1250,800,100,90);

        lbBackButton = new JLabel();
        backButton = new ImageIcon("./Images/HTPPage/backButton.png");
        Image dabBackButton = backButton.getImage();
        Image modifiedBackButton = dabBackButton.getScaledInstance(80, 80, Image.SCALE_REPLICATE);
        backButton = new ImageIcon(modifiedBackButton);
        lbBackButton.setIcon(backButton);
        lbBackButton.setBounds(200,800,100,90);
        lbBackButton.setVisible(false);

        lbHomeButton = new JLabel();
        homeButton = new ImageIcon("./Images/HTPPage/homeButton.png");
        Image dabHomeButton = homeButton.getImage();
        Image modifiedHomeButton = dabHomeButton.getScaledInstance(220, 80, Image.SCALE_REPLICATE);
        homeButton = new ImageIcon(modifiedHomeButton);
        lbHomeButton.setIcon(homeButton);
        lbHomeButton.setBounds(650,800,250,90);
        lbHomeButton.setVisible(true);

        description2 = new JLabel();
        description2.setFont(new Font("Dogica", Font.PLAIN,23));
        description2.setForeground(Color.BLACK);
        description2.setText("<html><div style='line-height: 10px;'> Each player takes 32 discs and " +
                "chooses one colour<br><br> to use throughout the game. A move consists of <br><br>\"outflanking\" " +
                "your opponent's disc(s), then<br><br> flipping the outflanked disc(s)to your colour. \n" +
                "To<br><br> outflank means to place a disc on the board so that<br><br> your opponent's row " +
                "(or rows) of disc(s) is<br><br> bordered at each\n end by a disc of your colour.<br><br> " +
                "(A \"row\" may be made up of one or more discs). Thus <br><br>here are rules to " +
                "take note of: <br><br>" +
                "1. Black always moves first. <br><br> </div> </html>");
        description2.setBounds(200,230,1200,500);
        description2.setVisible(false);

        description3 = new JLabel();
        description3.setFont(new Font("Dogica", Font.PLAIN, 23));
        description3.setForeground(Color.BLACK);
        description3.setText("<html> 2. If on your turn you cannot outflank and flip at <br><br> least " +
                "one opposing disc, your turn is forfeited <br><br>and your opponent moves <br><br>" +
                "3. Players may not skip over their own colour <br><br> disc(s) to outflank an opposing disc. <br><br> " +
                "4. Disc(s) may only be outflanked as a direct <br><br>result of a move and must fall in the " +
                "direct line<br><br> of the disc placed down. <br><br>" +
                "5. All discs outflanked in any one move must be <br><br>flipped, even if it is to the player's " +
                "advantage<br><br> not to flip them at all. <br><br> </html>");

        description3.setBounds(200,230,1200,520);
        description3.setVisible(false);

        description4 = new JLabel();
        description4.setFont(new Font("Dogica", Font.PLAIN, 23));
        description4.setForeground(Color.BLACK);
        description4.setText("<html> 6. Once a disc is placed on a square, it can never <br><br>" +
                "be moved to another square later in the game. <br><br>" +
                "7. When it is no longer possible for either player<br><br>" +
                " to move, the game is over. Discs are counted and<br><br>" +
                " the player with the majority of their colour<br><br> showing is the winner." +
                "<br><br> <br>" +
                "Source: <br><br> https://www.worldothello.org/about/about-./<br><br>" +
                "othello-rules/official-rules/english</html>");

        description4.setBounds(200,230,1200,520);
        description4.setVisible(false);


        panelHTPPage.add(htpTitle);
        panelHTPPage.add(rulesTitle);
        panelHTPPage.add(description1);
        panelHTPPage.add(description2);
        panelHTPPage.add(description3);
        panelHTPPage.add(description4);
        panelHTPPage.add(lbNextButton);
        panelHTPPage.add(lbBackButton);
        panelHTPPage.add(lbHomeButton);
        panelHTPPage.add(lbScroll);


        lbNextButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                soundClass.sound("./Music/next_backButton.wav");
                if (htpTitle.isVisible() && description1.isVisible()) {
                    htpTitle.setVisible(false);
                    description1.setVisible(false);
                    rulesTitle.setVisible(true);
                    description2.setVisible(true);
                    lbBackButton.setVisible(true);
                }
                else if (description2.isVisible() && lbBackButton.isVisible())  {
                    description2.setVisible(false);
                    description3.setVisible(true);
                }
                else if (description3.isVisible()) {
                    description3.setVisible(false);
                    description4.setVisible(true);
                    lbNextButton.setVisible(false);
                }

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                nextButton = new ImageIcon("./Images/HTPPage/nextButton-Selected.png");
                Image dabNextButton = nextButton.getImage();
                Image modifiedNextButton = dabNextButton.getScaledInstance(90, 90, Image.SCALE_REPLICATE);
                nextButton = new ImageIcon(modifiedNextButton);
                lbNextButton.setIcon(nextButton);
                lbNextButton.setBounds(1250,800,90,90);
                panelHTPPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                nextButton = new ImageIcon("./Images/HTPPage/nextButton.png");
                Image dabNextButton = nextButton.getImage();
                Image modifiedNextButton = dabNextButton.getScaledInstance(80, 80, Image.SCALE_REPLICATE);
                nextButton = new ImageIcon(modifiedNextButton);
                lbNextButton.setIcon(nextButton);
                lbNextButton.setBounds(1250,800,80,80);
                panelHTPPage.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

            }
        });

        lbBackButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {


            }

            @Override
            public void mousePressed(MouseEvent e) {
                soundClass.sound("./Music/next_backButton.wav");
                if (rulesTitle.isVisible() && description2.isVisible()) {
                    rulesTitle.setVisible(false);
                    description2.setVisible(false);
                    htpTitle.setVisible(true);
                    description1.setVisible(true);
                    lbBackButton.setVisible(false);
                }

                if (lbNextButton.isVisible() && description3.isVisible()) {
                    description2.setVisible(true);
                    description3.setVisible(false);
                    lbNextButton.setVisible(true);
                }

                if (!lbNextButton.isVisible() && description4.isVisible()) {
                    description4.setVisible(false);
                    description3.setVisible(true);
                    lbNextButton.setVisible(true);
                }


            }

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                backButton = new ImageIcon("./Images/HTPPage/backButton-Selected.png");
                Image dabBackButton = backButton.getImage();
                Image modifiedBackButton = dabBackButton.getScaledInstance(90, 90, Image.SCALE_REPLICATE);
                backButton = new ImageIcon(modifiedBackButton);
                lbBackButton.setIcon(backButton);
                lbBackButton.setBounds(200,800,90,90);
                panelHTPPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                backButton = new ImageIcon("./Images/HTPPage/backButton.png");
                Image dabBackButton = backButton.getImage();
                Image modifiedBackButton = dabBackButton.getScaledInstance(80, 80, Image.SCALE_REPLICATE);
                backButton = new ImageIcon(modifiedBackButton);
                lbBackButton.setIcon(backButton);
                lbBackButton.setBounds(200,800,80,80);
                panelHTPPage.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

            }
        });

        lbHomeButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                soundClass.sound("./Music/buttonPressed-Reversed.wav");
                delayClick();
                panelHTPPage.setVisible(false);
                homePage.panelLandingPage.setVisible(true);

            }

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                homeButton = new ImageIcon("./Images/HTPPage/homeButton-Selected.png");
                Image dabHomeButton = homeButton.getImage();
                Image modifiedHomeButton = dabHomeButton.getScaledInstance(240, 90, Image.SCALE_REPLICATE);
                homeButton = new ImageIcon(modifiedHomeButton);
                lbHomeButton.setIcon(homeButton);
                lbHomeButton.setBounds(645,800,250,90);
                panelHTPPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                homeButton = new ImageIcon("./Images/HTPPage/homeButton.png");
                Image dabHomeButton = homeButton.getImage();
                Image modifiedHomeButton = dabHomeButton.getScaledInstance(220, 80, Image.SCALE_REPLICATE);
                homeButton = new ImageIcon(modifiedHomeButton);
                lbHomeButton.setIcon(homeButton);
                lbHomeButton.setBounds(650,800,250,90);
                panelHTPPage.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

            }
        });
    }

    public void delayClick() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

}
