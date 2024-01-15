import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventListener;

public class HomePage {

    JPanel panelLandingPage = new JPanel();
    JPanel panelHomePage = new JPanel();
    JLabel lbMainTitle, lbStartButton, lbExitButton, lbHTPButton;
    ImageIcon startButton, mainTitle, exitButton, htpButton;

    public HomePage() {
        panelLandingPage.setLayout(null);

        mainTitle = new ImageIcon("Othello/Images/HomePage/mainTitle.png");
        lbMainTitle = new JLabel(mainTitle);
        lbMainTitle.setBounds(0, 100, 1000, 500);

        startButton = new ImageIcon("Othello/Images/HomePage/startButton.png");
        lbStartButton = new JLabel();
        lbStartButton.setIcon(startButton);
        lbStartButton.setBounds(340, 500, 600, 300);

        htpButton = new ImageIcon("Othello/Images/HomePage/htpButton.png");
        Image dabHTPButton = htpButton.getImage();
        Image modifiedHTPButton = dabHTPButton.getScaledInstance(350, 170, Image.SCALE_REPLICATE);
        htpButton = new ImageIcon(modifiedHTPButton);
        lbHTPButton = new JLabel(htpButton);
        lbHTPButton.setBounds(370, 700, 300, 100);


        exitButton = new ImageIcon("Othello/Images/HomePage/exitButton.png");
        Image dabExitButton = exitButton.getImage();
        Image modifiedExitButton = dabExitButton.getScaledInstance(350, 150, Image.SCALE_REPLICATE);
        exitButton = new ImageIcon(modifiedExitButton);
        lbExitButton = new JLabel(exitButton);
        lbExitButton.setBounds(370, 790, 300, 100);

        panelLandingPage.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelLandingPage.setOpaque(false);
        panelLandingPage.add(lbMainTitle);
        panelLandingPage.add(lbStartButton);
        panelLandingPage.add(lbHTPButton);
        panelLandingPage.add(lbExitButton);

        lbStartButton.addMouseListener(new SeparateMouseListener());

        //////////////////////////////////////////////////////////////////////////
    }

    private class SeparateMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

            if (e.getSource() == lbStartButton) {

            } else if (e.getSource() == lbHTPButton) {

            } else if (e.getSource() == lbExitButton) {

            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            // Handle mouse press event
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // Handle mouse release event
        }

        @Override
        public void mouseEntered(MouseEvent e) {

            if (e.getSource() == lbStartButton) {



            }

            else if (e.getSource() == lbHTPButton) {

                Image dabHTPButton = htpButton.getImage();
                Image modifiedHTPButton = dabHTPButton.getScaledInstance(370, 190, Image.SCALE_REPLICATE);
                htpButton = new ImageIcon(modifiedHTPButton);
                lbHTPButton.setIcon(htpButton);

            }

            else if (e.getSource() == lbExitButton) {

            }

        }

        @Override
        public void mouseExited(MouseEvent e) {
            // Handle mouse exit event
        }




    }




}
