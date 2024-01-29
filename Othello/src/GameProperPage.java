import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameProperPage {
    JPanel panelGameProper = new JPanel();
    ImageIcon gameBoard, darkPeg, lightPeg;
    JLabel lbGameBoard, lbDarkPeg, lbLightPeg;
    JButton[][] slot = new JButton[8][8];
    boolean player1Turn = true;
    boolean gameRunning = true;

    public GameProperPage() {


        panelGameProper.setLayout(null);
        panelGameProper.setOpaque(false);

        gameBoard = new ImageIcon("Othello/Images/GameProperPage/gameBoard.png");
        lbGameBoard = new JLabel();
        Image dabGameBoard = gameBoard.getImage();
        Image modifiedGameBoard = dabGameBoard.getScaledInstance(950, 950, Image.SCALE_REPLICATE);
        gameBoard = new ImageIcon(modifiedGameBoard);
        lbGameBoard.setIcon(gameBoard);
        lbGameBoard.setBounds(500, 20, 950, 950);

        lbDarkPeg = new JLabel();
        darkPeg = new ImageIcon("Othello/Images/GameProperPage/Pegs/darkPeg.png");
        Image dabDarkPeg = darkPeg.getImage();
        Image modifiedDarkPeg = dabDarkPeg.getScaledInstance(90, 90, Image.SCALE_REPLICATE);
        darkPeg = new ImageIcon(modifiedDarkPeg);
        lbDarkPeg.setIcon(darkPeg);

        lbLightPeg = new JLabel();
        lightPeg = new ImageIcon("Othello/Images/GameProperPage/Pegs/lightPeg.png");
        Image dabLightPeg = lightPeg.getImage();
        Image modifiedLightPeg = dabLightPeg.getScaledInstance(90, 90, Image.SCALE_REPLICATE);
        lightPeg = new ImageIcon(modifiedLightPeg);
        lbLightPeg.setIcon(lightPeg);

        Integer[][] gameBoardArray = {
                {0, 2, 1, 0, 0, 0, 0, 0},
                {0, 2, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}};

        Integer x_value = 550;
        Integer y_value = 40;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if (gameBoardArray[i][j] == 1) {
                    slot[i][j] = new JButton();
                    slot[i][j].setBounds(x_value, y_value, 100, 100);
                    slot[i][j].setOpaque(false);
                    slot[i][j].setContentAreaFilled(false);
                    slot[i][j].setBorderPainted(false);
                    slot[i][j].setIcon(darkPeg);
                    panelGameProper.add(slot[i][j]);

                } else if (gameBoardArray[i][j] == 2) {
                    slot[i][j] = new JButton();
                    slot[i][j].setBounds(x_value, y_value, 100, 100);
                    slot[i][j].setOpaque(false);
                    slot[i][j].setContentAreaFilled(false);
                    slot[i][j].setIcon(lightPeg);
                    panelGameProper.add(slot[i][j]);
                    slot[i][j].setBorderPainted(false);

                } else {
                    slot[i][j] = new JButton();
                    slot[i][j].setBounds(x_value, y_value, 100, 100);
                    slot[i][j].setOpaque(false);
                    slot[i][j].setContentAreaFilled(false);
                    panelGameProper.add(slot[i][j]);
                    slot[i][j].setBorderPainted(false);
                    panelGameProper.add(slot[i][j]);
                }

                x_value += 109; // add x values to each button

                int finalI = i;
                int finalJ = j;

                slot[i][j].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                        if (player1Turn) {
                            System.out.println("I clicked slot " + finalI + " and " + finalJ);
                            slot[finalI][finalJ].setIcon(darkPeg);
                            player1Turn = false;
                            gameBoardArray[finalI][finalJ] = 1;
                            slot[finalI][finalJ].removeMouseListener(this);
                        } else {
                            System.out.println("I clicked slot " + finalI + " and " + finalJ);
                            slot[finalI][finalJ].setIcon(lightPeg);
                            player1Turn = true;
                            gameBoardArray[finalI][finalJ] = 2;
                            slot[finalI][finalJ].removeMouseListener(this);
                        }

                        for (int outer = 0; outer < 8; outer++) {
                            for (int inner = 0; inner < 6; inner++) {

                                /*if ((gameBoardArray[outer][inner-2] == 1 && gameBoardArray[outer][inner] == 2) &&
                                        gameBoardArray[outer][inner+1] == 1)  {

                                    System.out.println("changing!");

                                }*/

                                if ((gameBoardArray[0][0] == 1 && gameBoardArray[outer][inner + 1] == 2) && gameBoardArray[outer][inner + 2] == 1) {
                                    gameBoardArray[outer][inner + 1] = 1;
                                    System.out.println(gameBoardArray[0][1]);

                                    updateBoard(gameBoardArray);


                                }

                            }
                        }

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                });


            }

            x_value = 550; //reset x value
            y_value += 114; // add y value

        }

        panelGameProper.add(lbGameBoard);

    }

    public void updateBoard(Integer[][] gameBoardArray) {

        Integer x_value = 550;
        Integer y_value = 40;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if (gameBoardArray[i][j] == 1) {
                    slot[i][j] = new JButton();
                    slot[i][j].setBounds(x_value, y_value, 100, 100);
                    slot[i][j].setOpaque(false);
                    slot[i][j].setContentAreaFilled(false);
                    slot[i][j].setBorderPainted(false);
                    slot[i][j].setIcon(darkPeg);
                    panelGameProper.add(slot[i][j]);

                } else if (gameBoardArray[i][j] == 2) {
                    slot[i][j] = new JButton();
                    slot[i][j].setBounds(x_value, y_value, 100, 100);
                    slot[i][j].setOpaque(false);
                    slot[i][j].setContentAreaFilled(false);
                    slot[i][j].setIcon(lightPeg);
                    panelGameProper.add(slot[i][j]);
                    slot[i][j].setBorderPainted(false);

                } else {
                    slot[i][j] = new JButton();
                    slot[i][j].setBounds(x_value, y_value, 100, 100);
                    slot[i][j].setOpaque(false);
                    slot[i][j].setContentAreaFilled(false);
                    panelGameProper.add(slot[i][j]);
                    slot[i][j].setBorderPainted(false);
                    panelGameProper.add(slot[i][j]);
                }

                x_value += 109; // add x values to each button


            }


        }

    }

}


