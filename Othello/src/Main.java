
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main {

    JFrame mainFrame = new JFrame("Othello");
    JFrame nicknameFrame = new JFrame("Othello: Set Nickname");
    JFrame winnerFrame = new JFrame("Winner!");
    ImageIcon gameLogo, mainBg, nicknameBg;
    JLabel lbMainBg;
    NicknameGetPage mainNicknameGetPage;
    HomePage mainHomePage;
    HTPPage mainHTPPage;
    PegSelectPage mainPegSelectPage;
    GameProperPage mainGameProperPage;

    public Main() {

        // logo
        gameLogo = new ImageIcon("Othello/Images/mainlogo.png");

        //bg
        mainBg = new ImageIcon("Othello/Images/mainBg.png");
        lbMainBg = new JLabel(mainBg);

        nicknameFrame.setSize(720, 640);
        nicknameFrame.setIconImage(gameLogo.getImage());
        nicknameFrame.setResizable(false);

        mainNicknameGetPage = new NicknameGetPage();
        nicknameFrame.add(mainNicknameGetPage.panelNicknameGet);

        nicknameFrame.setVisible(true);
        nicknameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nicknameFrame.setLocationRelativeTo(null); // center the window
        mainNicknameGetPage.lbGoButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                nicknameFrame.dispose();
                mainFrame.setVisible(true);
                mainNicknameGetPage.player1Nickname = mainNicknameGetPage.player1Input.getText();
                mainNicknameGetPage.player2Nickname = mainNicknameGetPage.player2Input.getText();
                mainGameProperPage.darkPegPlayer.setText(mainNicknameGetPage.player1Nickname);
                mainGameProperPage.lightPegPlayer.setText(mainNicknameGetPage.player2Nickname);
                /*mainPegSelectPage.player1Nickname = mainNicknameGetPage.player1Input.getText();
                mainPegSelectPage.player2Nickname = mainNicknameGetPage.player2Input.getText();
                mainPegSelectPage.player1Title.setText(mainNicknameGetPage.player1Nickname);
                mainPegSelectPage.player2Title.setText(mainNicknameGetPage.player2Nickname);*/
            }

            @Override
            public void mousePressed(MouseEvent e) {
                nicknameFrame.dispose();
                mainFrame.setVisible(true);
                mainNicknameGetPage.player1Nickname = mainNicknameGetPage.player1Input.getText();
                mainNicknameGetPage.player2Nickname = mainNicknameGetPage.player2Input.getText();
                mainGameProperPage.darkPegPlayer.setText(mainNicknameGetPage.player1Nickname + "'s Turn!");
                mainGameProperPage.lightPegPlayer.setText(mainNicknameGetPage.player2Nickname + "'s Turn!");
               /*mainNicknameGetPage.player1Nickname = mainNicknameGetPage.player1Input.getText();
                mainNicknameGetPage.player2Nickname = mainNicknameGetPage.player2Input.getText();
                mainPegSelectPage.player1Nickname = mainNicknameGetPage.player1Input.getText();
                mainPegSelectPage.player2Nickname = mainNicknameGetPage.player2Input.getText();
                mainPegSelectPage.player1Title.setText(mainNicknameGetPage.player1Nickname);
                mainPegSelectPage.player2Title.setText(mainNicknameGetPage.player2Nickname);*/ ;


            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                mainNicknameGetPage.goButton = new ImageIcon("Othello/Images/NicknameGetPage/goButton-Selected.png");
                Image dabGoButton = mainNicknameGetPage.goButton.getImage();
                Image modifiedGoButton = dabGoButton.getScaledInstance(230, 90, Image.SCALE_REPLICATE);
                mainNicknameGetPage.goButton = new ImageIcon(modifiedGoButton);
                mainNicknameGetPage.lbGoButton.setIcon(mainNicknameGetPage.goButton);
                mainNicknameGetPage.lbGoButton.setBounds(250,440,230,90);
                mainNicknameGetPage.panelNicknameGet.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mainNicknameGetPage.goButton = new ImageIcon("Othello/Images/NicknameGetPage/goButton.png");
                Image dabGoButton = mainNicknameGetPage.goButton.getImage();
                Image modifiedGoButton = dabGoButton.getScaledInstance(220, 80, Image.SCALE_REPLICATE);
                mainNicknameGetPage.goButton = new ImageIcon(modifiedGoButton);
                mainNicknameGetPage.lbGoButton.setIcon(mainNicknameGetPage.goButton);
                mainNicknameGetPage.lbGoButton.setBounds(250,440,250,90);
                mainNicknameGetPage.panelNicknameGet.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

            }
        });

        ///////////////////////////////////////////////////////////////

        mainFrame.setSize(1920,1080);
        mainFrame.setIconImage(gameLogo.getImage());

        // bg
        mainFrame.setContentPane(lbMainBg);

        mainHomePage = new HomePage();
        mainFrame.add(mainHomePage.panelLandingPage);
        mainHomePage.panelLandingPage.setBounds(480,0,1000,1080);

        mainHTPPage = new HTPPage(mainHomePage); // pass mainHomePage to HTPPage
        mainFrame.add(mainHTPPage.panelHTPPage);
        mainHTPPage.panelHTPPage.setBounds(200,0,1600,1080);
        mainHTPPage.panelHTPPage.setVisible(false);

        mainGameProperPage = new GameProperPage();
        mainFrame.add(mainGameProperPage.panelGameProper);
        mainGameProperPage.panelGameProper.setBounds(0,0,1920,1080);
        mainGameProperPage.panelGameProper.setVisible(false);

        mainPegSelectPage = new PegSelectPage(mainHomePage, mainGameProperPage);
        mainFrame.add(mainPegSelectPage.panelChoosePick);
        mainPegSelectPage.panelChoosePick.setBounds(0,0,1920,1080);
        mainPegSelectPage.panelChoosePick.setVisible(false);


        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setLocationRelativeTo(null); // center the window
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        mainHomePage.lbStartButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainHomePage.panelLandingPage.setVisible(false);
                mainGameProperPage.panelGameProper.setVisible(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                mainHomePage.panelLandingPage.setVisible(false);
                mainGameProperPage.panelGameProper.setVisible(true);
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
        new Main();
    }






}