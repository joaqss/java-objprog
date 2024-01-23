
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

public class Main {

    Font mainFont;
    JFrame mainFrame = new JFrame("Othello - Java Edition");
    ImageIcon gameLogo, mainBg;
    JLabel lbMainBg;
    HomePage mainHomePage;
    HTPPage mainHTPPage;

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

        mainHTPPage = new HTPPage(mainHomePage); // pass mainHomePage to HTPPage
        mainFrame.add(mainHTPPage.panelHTPPage);
        mainHTPPage.panelHTPPage.setBounds(200,0,1600,1080);
        mainHTPPage.panelHTPPage.setVisible(false);

        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setLocationRelativeTo(null); // center the window
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        mainHomePage.lbStartButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainHomePage.panelLandingPage.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                mainHomePage.panelLandingPage.setVisible(false);
            }

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                mainHomePage.startButton = new ImageIcon("Othello/Images/HomePage/startButton-Selected.png");
                Image dabStartButton = mainHomePage.startButton.getImage();
                Image modifiedStartButton = dabStartButton.getScaledInstance(310, 110, Image.SCALE_REPLICATE);
                mainHomePage.startButton = new ImageIcon(modifiedStartButton);
                mainHomePage.lbStartButton.setIcon(mainHomePage.startButton);
                mainHomePage.lbStartButton.setBounds(370, 545, 310, 110);
                mainHomePage.panelLandingPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mainHomePage.startButton = new ImageIcon("Othello/Images/HomePage/startButton.png");
                Image dabStartButton = mainHomePage.startButton.getImage();
                Image modifiedStartButton = dabStartButton.getScaledInstance(300, 100, Image.SCALE_REPLICATE);
                mainHomePage.startButton = new ImageIcon(modifiedStartButton);
                mainHomePage.lbStartButton.setIcon(mainHomePage.startButton);
                mainHomePage.lbStartButton.setBounds(378, 550, 300, 100);
                mainHomePage.panelLandingPage.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });

        mainHomePage.lbHTPButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainHomePage.panelLandingPage.setVisible(false);
                mainHTPPage.panelHTPPage.setVisible(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                mainHomePage.panelLandingPage.setVisible(false);
                mainHTPPage.panelHTPPage.setVisible(true);
            }

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                mainHomePage.htpButton = new ImageIcon("Othello/Images/HomePage/htpButton-Selected.png");
                Image dabHTPButton = mainHomePage.htpButton.getImage();
                Image modifiedHTPButton = dabHTPButton.getScaledInstance(310, 90, Image.SCALE_REPLICATE);
                mainHomePage.htpButton = new ImageIcon(modifiedHTPButton);
                mainHomePage.lbHTPButton.setIcon(mainHomePage.htpButton);
                mainHomePage.lbHTPButton.setBounds(375, 665, 310, 90);
                mainHomePage.panelLandingPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mainHomePage.htpButton = new ImageIcon("Othello/Images/HomePage/htpButton.png");
                Image dabHTPButton = mainHomePage.htpButton.getImage();
                Image modifiedHTPButton = dabHTPButton.getScaledInstance(300, 80, Image.SCALE_REPLICATE);
                mainHomePage.htpButton = new ImageIcon(modifiedHTPButton);
                mainHomePage.lbHTPButton.setIcon(mainHomePage.htpButton);
                mainHomePage.lbHTPButton.setBounds(375, 665, 300, 80);
                mainHomePage.panelLandingPage.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

            }
        });

        mainHomePage.lbExitButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?",
                        "Exit Game?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (option == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?",
                        "Exit Game?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (option == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                mainHomePage.exitButton = new ImageIcon("Othello/Images/HomePage/exitButton-Selected.png");
                Image dabExitButton = mainHomePage.exitButton.getImage();
                Image modifiedExitButton = dabExitButton.getScaledInstance(260, 90, Image.SCALE_REPLICATE);
                mainHomePage.exitButton = new ImageIcon(modifiedExitButton);
                mainHomePage.lbExitButton.setIcon(mainHomePage.exitButton);
                mainHomePage.lbExitButton.setBounds(400, 760, 260, 90);
                mainHomePage.panelLandingPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mainHomePage.exitButton = new ImageIcon("Othello/Images/HomePage/exitButton.png");
                Image dabExitButton = mainHomePage.exitButton.getImage();
                Image modifiedExitButton = dabExitButton.getScaledInstance(250, 80, Image.SCALE_REPLICATE);
                mainHomePage.exitButton = new ImageIcon(modifiedExitButton);
                mainHomePage.lbExitButton.setIcon(mainHomePage.exitButton);
                mainHomePage.lbExitButton.setBounds(400, 760, 250, 80);
                mainHomePage.panelLandingPage.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });
    }


    public static void main(String[] args) {
        Main runGame = new Main();
    }






}