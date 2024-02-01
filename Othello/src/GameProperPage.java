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
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 2, 0, 0, 0, 2, 0},
                {0, 0, 0, 2, 1, 0, 2, 0},
                {0, 0, 0, 1, 2, 0, 1, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}};

        Integer x_value = 550;
        Integer y_value = 40;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < gameBoardArray.length; j++) {

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
                            if ((gameBoardArray[finalI][finalJ] == 0 && gameBoardArray[finalI][finalJ+1] == 2) ||
                                (gameBoardArray[finalI][finalJ] == 0 && gameBoardArray[finalI+1][finalJ] == 2) ||
                                (gameBoardArray[finalI][finalJ] == 0 && gameBoardArray[finalI][finalJ-1] == 2) ||
                                (gameBoardArray[finalI][finalJ] == 0 && gameBoardArray[finalI-1][finalJ] == 2) ||
                                (gameBoardArray[finalI][finalJ] == 0 && gameBoardArray[finalI+1][finalJ+1] == 2))
                            {
                                System.out.println("I clicked slot " + finalI + " and " + finalJ);
                                slot[finalI][finalJ].setIcon(darkPeg);
                                player1Turn = false;
                                gameBoardArray[finalI][finalJ] = 1;
                                slot[finalI][finalJ].removeMouseListener(this);

                                int[] placeholder = {1,1,1,1,1,1};
                                boolean isOppositeColor = true;

                                while (isOppositeColor) {
                                    // scan if peg is from right
                                    if (gameBoardArray[finalI][finalJ] == 1 && gameBoardArray[finalI][finalJ-placeholder[0]] == 2) {
                                        placeholder[0]++;

                                        if (gameBoardArray[finalI][finalJ] == 1 && gameBoardArray[finalI][finalJ-placeholder[0]] == 1) {
                                            placeholder[0] -= 1;
                                            System.out.println("FLIPPING! " + placeholder[0]);
                                            for (int i=placeholder[0];i>0;i--) {
                                                slot[finalI][finalJ-i].setIcon(darkPeg);
                                            }
                                            isOppositeColor = false;
                                        }
                                    }

                                    // scan if peg is from left
                                    if (gameBoardArray[finalI][finalJ] == 1 && gameBoardArray[finalI][finalJ+placeholder[1]] == 2) {
                                        placeholder[1]++;

                                        if (gameBoardArray[finalI][finalJ] == 1 && gameBoardArray[finalI][finalJ+placeholder[1]] == 1) {
                                            placeholder[1] -= 1;
                                            System.out.println("FLIPPING RIGHT! " + placeholder[1]);
                                            for (int i=placeholder[1];i>0;i--) {
                                                slot[finalI][finalJ+i].setIcon(darkPeg);
                                            }
                                            isOppositeColor = false;
                                        }

                                        else {
                                            continue;
                                        }
                                    }

                                    // scan if peg is placed above
                                    if (gameBoardArray[finalI][finalJ] == 1 && gameBoardArray[finalI+placeholder[2]][finalJ] == 2) {
                                        placeholder[2]++;

                                        if(gameBoardArray[finalI][finalJ] == 1 && gameBoardArray[finalI+placeholder[2]][finalJ] == 1) {
                                            placeholder[2] -= 1;
                                            System.out.println("FLIPPING RIGHT! " + placeholder[2]);
                                            for (int i=placeholder[2];i>0;i--) {
                                                slot[finalI+i][finalJ].setIcon(darkPeg);
                                            }
                                            isOppositeColor = false;
                                        }
                                    }

                                    // scan if peg is placed below
                                    if (gameBoardArray[finalI][finalJ] == 1 && gameBoardArray[finalI-placeholder[3]][finalJ] == 2) {
                                        placeholder[3]++;

                                        if(gameBoardArray[finalI][finalJ] == 1 && gameBoardArray[finalI-placeholder[3]][finalJ] == 1) {
                                            placeholder[3] -= 1;
                                            System.out.println("FLIPPING RIGHT! " + placeholder[3]);
                                            for (int i=placeholder[3];i>0;i--) {
                                                slot[finalI-i][finalJ].setIcon(darkPeg);
                                            }
                                            isOppositeColor = false;
                                        }
                                    }

                                    // scan if peg is placed diagonally from left to right
                                    if (gameBoardArray[finalI][finalJ] == 1 && gameBoardArray[finalI+placeholder[4]][finalJ+placeholder[4]+1] == 2) {
                                        placeholder[4]++;

                                        if(gameBoardArray[finalI][finalJ] == 1 && gameBoardArray[finalI+placeholder[4]][finalJ+placeholder[4]+1] == 1) {
                                            placeholder[4] -= 1;
                                            System.out.println("FLIPPING DIAG TO RIGHT! " + placeholder[4]);
                                            for (int i=placeholder[4];i>0;i--) {
                                                slot[finalI+i][finalJ].setIcon(darkPeg);
                                            }
                                            isOppositeColor = false;
                                        }

                                    }





                                }

                            }


                        } else {
                            if ((gameBoardArray[finalI][finalJ] == 0 && gameBoardArray[finalI][finalJ+1] == 1) ||
                                (gameBoardArray[finalI][finalJ] == 0 & gameBoardArray[finalI+1][finalJ] == 1) ||
                                (gameBoardArray[finalI][finalJ] == 0 && gameBoardArray[finalI][finalJ-1] == 1) ||
                                (gameBoardArray[finalI][finalJ] == 0 && gameBoardArray[finalI-1][finalJ] == 1))
                            {
                                System.out.println("I clicked slot " + finalI + " and " + finalJ);
                                slot[finalI][finalJ].setIcon(lightPeg);
                                player1Turn = true;
                                gameBoardArray[finalI][finalJ] = 2;
                                slot[finalI][finalJ].removeMouseListener(this);
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

}


