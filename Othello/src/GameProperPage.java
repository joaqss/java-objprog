import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameProperPage {
    JPanel panelGameProper = new JPanel();
    ImageIcon gameBoard, darkPeg, lightPeg, scrollImage;
    JLabel lbGameBoard, lbDarkPeg, lbLightPeg, lbScroll, lbScroll2, darkPegPlayer, lightPegPlayer;
    JButton[][] slot = new JButton[8][8];
    boolean player1Turn = true;
    boolean[] isOppositeColor = {true, true};
    Integer[][] gameBoardArray = {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 2, 1, 0, 0, 0},
            {0, 0, 0, 1, 2, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}};
    Integer x_value = 550;
    Integer y_value = 40;

    public GameProperPage() {

        System.out.println(darkPegPlayer);
        System.out.println(lightPegPlayer);

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

        lbScroll = new JLabel();
        scrollImage = new ImageIcon("Othello/Images/GameProperPage/scrollImage.png");
        Image dabScroll = scrollImage.getImage();
        Image modifiedScroll = dabScroll.getScaledInstance(400, 200, Image.SCALE_REPLICATE);
        scrollImage = new ImageIcon(modifiedScroll);
        lbScroll.setIcon(scrollImage);
        lbScroll.setBounds(20,360,400,300);

        lbScroll2 = new JLabel();
        lbScroll2.setIcon(scrollImage);
        lbScroll2.setBounds(1500,360,400,300);
        lbScroll2.setVisible(false);

        darkPegPlayer = new JLabel();
        darkPegPlayer.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        darkPegPlayer.setFont(new Font("Dogica Pixel", Font.BOLD, 24));
        darkPegPlayer.setForeground(Color.BLACK);
        darkPegPlayer.setHorizontalAlignment(JLabel.CENTER);
        darkPegPlayer.setBounds(30,450,390,70);

        lightPegPlayer = new JLabel();
        lightPegPlayer.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lightPegPlayer.setFont(new Font("Dogica Pixel", Font.BOLD, 24));
        lightPegPlayer.setForeground(Color.BLACK);
        lightPegPlayer.setHorizontalAlignment(JLabel.CENTER);
        lightPegPlayer.setBounds(1520,450,380,70);
        lightPegPlayer.setVisible(false);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if (gameBoardArray[i][j] == 1) {
                    slot[i][j] = new JButton();
                    slot[i][j].setBounds(x_value, y_value, 100, 100);
                    slot[i][j].setOpaque(false);
                    slot[i][j].setContentAreaFilled(false);
                    //slot[i][j].setBorderPainted(false);
                    slot[i][j].setIcon(darkPeg);
                    panelGameProper.add(slot[i][j]);

                } else if (gameBoardArray[i][j] == 2) {
                    slot[i][j] = new JButton();
                    slot[i][j].setBounds(x_value, y_value, 100, 100);
                    slot[i][j].setOpaque(false);
                    slot[i][j].setContentAreaFilled(false);
                    slot[i][j].setIcon(lightPeg);
                    panelGameProper.add(slot[i][j]);
                    //slot[i][j].setBorderPainted(false);

                } else {
                    slot[i][j] = new JButton();
                    slot[i][j].setBounds(x_value, y_value, 100, 100);
                    slot[i][j].setOpaque(false);
                    slot[i][j].setContentAreaFilled(false);
                    panelGameProper.add(slot[i][j]);
                    //slot[i][j].setBorderPainted(false);
                    panelGameProper.add(slot[i][j]);
                }

                x_value += 109; // add x values to each button

                final int finalI = i;
                final int finalJ = j;

                slot[i][j].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                        if (player1Turn) {

                            printGameBoardToConsole();
                            int placeholderOut = 1;

                            /*if (finalJ+placeholderOut != 8) {*/

                                    slot[finalI][finalJ].setIcon(darkPeg);
                                    player1Turn = false;
                                    gameBoardArray[finalI][finalJ] = 1;
                                    slot[finalI][finalJ].removeMouseListener(this);
                                    System.out.println("PLAYER1: I clicked slot " + finalI + " and " + finalJ + "\n Player1Turn set to False");

                                    int[] placeholder = {1, 1, 1, 1, 1, 1, 1, 1};
                                    boolean[] isScanned = {false, false, false, false, false, false, false, false};
                                    isOppositeColor[0] = true;

                                    /*System.out.println(placeholder[0] + " " + placeholder[1] + " " + placeholder[2] + " " + placeholder[3]
                                        + " " + placeholder[4] + " " + placeholder[5] + " " + placeholder[6] + " " + placeholder[7]);*/

                                    while (isOppositeColor[0]) {

                                        // scan if peg is from right
                                        try {
                                            if (finalJ - placeholder[0] != -1 || finalJ + placeholder[0] != 8) {

                                                if (gameBoardArray[finalI][finalJ] == 1 && gameBoardArray[finalI][finalJ - placeholder[0]] == 2) {
                                                    placeholder[0]++;
                                                    System.out.println(placeholder[0]);

                                                    if (gameBoardArray[finalI][finalJ] == 1 && gameBoardArray[finalI][finalJ - placeholder[0]] == 1) {
                                                        placeholder[0] -= 1;
                                                        System.out.println("FLIPPING! " + placeholder[0]);
                                                        for (int i = placeholder[0]; i > 0; i--) {
                                                            slot[finalI][finalJ - i].setIcon(darkPeg);
                                                            gameBoardArray[finalI][finalJ - i] = 1;
                                                        }
                                                        isScanned[0] = true;

                                                    }
                                                }
                                            } else {
                                                placeholder[0] = 0;
                                            }
                                        } catch (Exception a) {
                                            System.out.println("Out of bounds");
                                        }

                                        try {
                                            // scan if peg is from left
                                            if (finalJ + placeholder[1] != 8) {
                                                if (gameBoardArray[finalI][finalJ] == 1 && gameBoardArray[finalI][finalJ + placeholder[1]] == 2) {
                                                    placeholder[1]++;

                                                    if (gameBoardArray[finalI][finalJ] == 1 && gameBoardArray[finalI][finalJ + placeholder[1]] == 1) {
                                                        placeholder[1] -= 1;
                                                        System.out.println("FLIPPING RIGHT! " + placeholder[1]);
                                                        for (int i = placeholder[1]; i >= 0; i--) {
                                                            slot[finalI][finalJ + i].setIcon(darkPeg);
                                                            gameBoardArray[finalI][finalJ + i] = 1;
                                                        }
                                                        isScanned[1] = true;

                                                    }
                                                }
                                            } else {
                                                placeholder[1] = 0;
                                            }
                                        } catch (Exception a) {
                                            System.out.println("Out of bounds");
                                        }

                                        try {
                                            if (finalI + placeholder[2] != 8) {
                                                // scan if peg is placed above
                                                if (gameBoardArray[finalI][finalJ] == 1 && gameBoardArray[finalI + placeholder[2]][finalJ] == 2) {
                                                    placeholder[2]++;

                                                    if (gameBoardArray[finalI][finalJ] == 1 && gameBoardArray[finalI + placeholder[2]][finalJ] == 1) {
                                                        placeholder[2] -= 1;
                                                        System.out.println("FLIPPING RIGHT! " + placeholder[2]);
                                                        for (int i = placeholder[2]; i > 0; i--) {
                                                            slot[finalI + i][finalJ].setIcon(darkPeg);
                                                            gameBoardArray[finalI + i][finalJ] = 1;
                                                        }
                                                        isScanned[2] = true;

                                                    }
                                                }
                                            } else {
                                                placeholder[2] = 0;
                                            }
                                        } catch (Exception a) {
                                            System.out.println("Out of bounds");
                                        }

                                        try {
                                            if (finalI - placeholder[3] != -1) {
                                                // scan if peg is placed below
                                                if (gameBoardArray[finalI][finalJ] == 1 && gameBoardArray[finalI - placeholder[3]][finalJ] == 2) {
                                                    placeholder[3]++;

                                                    if (gameBoardArray[finalI][finalJ] == 1 && gameBoardArray[finalI - placeholder[3]][finalJ] == 1) {
                                                        placeholder[3] -= 1;
                                                        System.out.println("FLIPPING TO TOP " + placeholder[3]);
                                                        for (int i = placeholder[3]; i > 0; i--) {
                                                            slot[finalI - i][finalJ].setIcon(darkPeg);
                                                            gameBoardArray[finalI - i][finalJ] = 1;
                                                        }
                                                        isScanned[3] = true;

                                                    }
                                                }
                                            } else {
                                                placeholder[3] = 0;
                                            }
                                        } catch (Exception a) {
                                            System.out.println("Out of bounds");
                                        }


                                        // scan if peg is placed diagonally from left to right pababa

                                        try {
                                            if (finalI + placeholder[4] != 8 || finalJ + placeholder[4] != 8) {
                                                if (gameBoardArray[finalI][finalJ] == 1 && gameBoardArray[finalI + placeholder[4]][finalJ + placeholder[4]] == 2) {
                                                    placeholder[4]++;

                                                    if (gameBoardArray[finalI][finalJ] == 1 && gameBoardArray[finalI + placeholder[4]][finalJ + placeholder[4]] == 1) {
                                                        placeholder[4] -= 1;
                                                        System.out.println("FLIPPING DIAG TO RIGHT! " + placeholder[4]);
                                                        for (int i = placeholder[4]; i > 0; i--) {
                                                            slot[finalI + i][finalJ + i].setIcon(darkPeg);
                                                            gameBoardArray[finalI + i][finalJ + i] = 1;
                                                        }
                                                        isScanned[4] = true;

                                                    }

                                                }
                                            } else {
                                                placeholder[4] = 0;
                                            }
                                        } catch (Exception a) {
                                            System.out.println("out of bounds");

                                        }

                                        try {
                                            if (finalI-placeholder[5] != -1 || finalJ+placeholder[5] != 8) {
                                                // scan if peg is placed diagonally from left to right pataas
                                                if (gameBoardArray[finalI][finalJ] == 1 && gameBoardArray[finalI - placeholder[5]][finalJ + placeholder[5]] == 2) {
                                                    placeholder[5]++;

                                                    if (gameBoardArray[finalI][finalJ] == 1 && gameBoardArray[finalI - placeholder[5]][finalJ + placeholder[5]] == 1) {
                                                        placeholder[5] -= 1;
                                                        System.out.println("FLIPPING DIAG TO RIGHT! " + placeholder[5]);
                                                        for (int i = placeholder[5]; i > 0; i--) {
                                                            slot[finalI - i][finalJ + i].setIcon(darkPeg);
                                                            gameBoardArray[finalI - i][finalJ + i] = 1;
                                                        }
                                                        isScanned[5] = true;

                                                    }

                                                }
                                            } else {
                                                placeholder[5] = 0;
                                            }
                                        } catch (Exception a) {
                                            System.out.println("Out of bounds");
                                        }


                                        try {
                                            if (finalI - placeholder[6] != -1 && finalJ - placeholder[6] != -1) {
                                                // scan if peg is placed diagonally from right to left pababa
                                                if (gameBoardArray[finalI][finalJ] == 1 && gameBoardArray[finalI - placeholder[6]][finalJ - placeholder[6]] == 2) {
                                                    placeholder[6]++;

                                                    if (gameBoardArray[finalI][finalJ] == 1 && gameBoardArray[finalI - placeholder[6]][finalJ - placeholder[6]] == 1) {
                                                        placeholder[6] -= 1;
                                                        System.out.println("FLIPPING DIAG TO leFt! " + placeholder[6]);
                                                        for (int i = placeholder[6]; i > 0; i--) {
                                                            slot[finalI - i][finalJ - i].setIcon(darkPeg);
                                                            gameBoardArray[finalI - i][finalJ - i] = 1;
                                                        }
                                                        isScanned[6] = true;

                                                    }
                                                }
                                            } else {
                                                placeholder[6] = 0;
                                            }
                                        } catch (Exception a) {
                                            System.out.println("Out of bounds");
                                        }

                                        try {
                                            if (finalJ - placeholder[7] != -1 || finalI+placeholder[7] != 8) {
                                                // scan if peg is placed diagonally from right to left pataas
                                                if (gameBoardArray[finalI][finalJ] == 1 && gameBoardArray[finalI + placeholder[7]][finalJ - placeholder[7]] == 2) {
                                                    placeholder[7]++;

                                                    if (gameBoardArray[finalI][finalJ] == 1 && gameBoardArray[finalI + placeholder[7]][finalJ - placeholder[7]] == 1) {
                                                        placeholder[7] -= 1;
                                                        System.out.println("FLIPPING DIAG TO leFt! " + placeholder[7]);
                                                        for (int i = placeholder[7]; i > 0; i--) {
                                                            slot[finalI + i][finalJ - i].setIcon(darkPeg);
                                                            gameBoardArray[finalI + i][finalJ - i] = 1;
                                                        }
                                                        isScanned[7] = true;

                                                    }
                                                }
                                            } else {
                                                placeholder[7] = 0;
                                            }
                                        } catch (Exception a) {
                                            System.out.println("Out of bounds");
                                        }

                                        if (isScanned[0] || isScanned[1] || isScanned[2] || isScanned[3] || isScanned[4] || isScanned[5] || isScanned[6] ||
                                                isScanned[7]) {
                                            System.out.println(isScanned[0] + "" + isScanned[1] + isScanned[3] + isScanned[4] + isScanned[5] + isScanned[6] +
                                                    isScanned[7]);
                                            isOppositeColor[0] = false;
                                        }

                                        printGameBoardToConsole();
                                        lbScroll.setVisible(false);
                                        darkPegPlayer.setVisible(false);
                                        lbScroll2.setVisible(true);
                                        lightPegPlayer.setVisible(true);
                                        //isOppositeColor[0] = false;

                                    }

                           /* } else {
                                placeholderOut = 0;
                                System.out.println("Invalid!");
                            }*/

                        } else {

                                slot[finalI][finalJ].setIcon(lightPeg);
                                player1Turn = true;
                                gameBoardArray[finalI][finalJ] = 2;
                                slot[finalI][finalJ].removeMouseListener(this);
                                System.out.println("PLAYER2: I clicked slot " + finalI + " and " + finalJ + "\n Player1Turn set to True");

                                int[] placeholder = {1, 1, 1, 1, 1, 1, 1, 1};
                                boolean[] isScanned = {false, false, false, false, false, false, false, false};
                                /*System.out.println(placeholder[0] + " " + placeholder[1] + " " + placeholder[2] + " " + placeholder[3]
                                        + " " + placeholder[4] + " " + placeholder[5] + " " + placeholder[6] + " " + placeholder[7]);*/
                                isOppositeColor[1] = true;

                            while (isOppositeColor[1]) {
                                // scan if peg is from right
                                try {
                                    if (finalJ - placeholder[0] != -1) {

                                        if (gameBoardArray[finalI][finalJ] == 2 && gameBoardArray[finalI][finalJ - placeholder[0]] == 1) {
                                            placeholder[0]++;
                                            System.out.println(placeholder[0]);

                                            if (gameBoardArray[finalI][finalJ] == 2 && gameBoardArray[finalI][finalJ - placeholder[0]] == 2) {
                                                placeholder[0] -= 1;
                                                System.out.println("FLIPPING! " + placeholder[0]);
                                                for (int i = placeholder[0]; i > 0; i--) {
                                                    slot[finalI][finalJ - i].setIcon(lightPeg);
                                                    gameBoardArray[finalI][finalJ - i] = 2;
                                                }
                                                isScanned[0] = true;

                                            }
                                        }
                                    } else {
                                        placeholder[0] = 0;
                                    }
                                } catch (Exception a) {
                                    System.out.println("Out of bounds");
                                }

                                try {
                                    // scan if peg is from left
                                    if (finalJ + placeholder[1] != 8) {
                                        if (gameBoardArray[finalI][finalJ] == 2 && gameBoardArray[finalI][finalJ + placeholder[1]] == 1) {
                                            placeholder[1]++;

                                            if (gameBoardArray[finalI][finalJ] == 2 && gameBoardArray[finalI][finalJ + placeholder[1]] == 2) {
                                                placeholder[1] -= 1;
                                                System.out.println("FLIPPING RIGHT! " + placeholder[1]);
                                                for (int i = placeholder[1]; i >= 0; i--) {
                                                    slot[finalI][finalJ + i].setIcon(lightPeg);
                                                    gameBoardArray[finalI][finalJ + i] = 2;
                                                }
                                                isScanned[1] = true;

                                            }
                                        }
                                    } else {
                                        placeholder[1] = 0;
                                    }
                                } catch (Exception a) {
                                    System.out.println("Out of bounds");
                                }

                                try {
                                    if (finalI + placeholder[2] != 8) {
                                        // scan if peg is placed above
                                        if (gameBoardArray[finalI][finalJ] == 2 && gameBoardArray[finalI + placeholder[2]][finalJ] == 1) {
                                            placeholder[2]++;

                                            if (gameBoardArray[finalI][finalJ] == 2 && gameBoardArray[finalI + placeholder[2]][finalJ] == 2) {
                                                placeholder[2] -= 1;
                                                System.out.println("FLIPPING RIGHT! " + placeholder[2]);
                                                for (int i = placeholder[2]; i > 0; i--) {
                                                    slot[finalI + i][finalJ].setIcon(lightPeg);
                                                    gameBoardArray[finalI + i][finalJ] = 2;
                                                }
                                                isScanned[2] = true;

                                            }
                                        }
                                    } else {
                                        placeholder[2] = 0;
                                    }
                                } catch (Exception a) {
                                    System.out.println("Out of bounds");
                                }

                                try {
                                    if (finalI - placeholder[3] != -1) {
                                        // scan if peg is placed below
                                        if (gameBoardArray[finalI][finalJ] == 2 && gameBoardArray[finalI - placeholder[3]][finalJ] == 1) {
                                            placeholder[3]++;

                                            if (gameBoardArray[finalI][finalJ] == 2 && gameBoardArray[finalI - placeholder[3]][finalJ] == 2) {
                                                placeholder[3] -= 1;
                                                System.out.println("FLIPPING TO TOP " + placeholder[3]);
                                                for (int i = placeholder[3]; i > 0; i--) {
                                                    slot[finalI - i][finalJ].setIcon(lightPeg);
                                                    gameBoardArray[finalI - i][finalJ] = 2;
                                                }
                                                isScanned[3] = true;

                                            }
                                        }
                                    } else {
                                        placeholder[3] = 0;
                                    }
                                } catch (Exception a) {
                                    System.out.println("Out of bounds");
                                }


                                // scan if peg is placed diagonally from left to right pababa
                                try {
                                    if (finalI + placeholder[4] != 8 || finalJ + placeholder[4] != 8) {
                                        if (gameBoardArray[finalI][finalJ] == 2 && gameBoardArray[finalI + placeholder[4]][finalJ + placeholder[4]] == 1) {
                                            placeholder[4]++;

                                            if (gameBoardArray[finalI][finalJ] == 2 && gameBoardArray[finalI + placeholder[4]][finalJ + placeholder[4]] == 2) {
                                                placeholder[4] -= 1;
                                                System.out.println("FLIPPING DIAG TO RIGHT! " + placeholder[4]);
                                                for (int i = placeholder[4]; i > 0; i--) {
                                                    slot[finalI + i][finalJ + i].setIcon(lightPeg);
                                                    gameBoardArray[finalI + i][finalJ + i] = 2;
                                                }
                                                isScanned[4] = true;

                                            }

                                        }
                                    } else {
                                        placeholder[4] = 0;
                                    }
                                } catch (Exception a) {
                                    System.out.println("out of bounds");

                                }

                                try {
                                    // scan if peg is placed diagonally from left to right pataas
                                    if (finalI-placeholder[5] != -1 || finalJ+placeholder[5] != 8) {
                                        if (gameBoardArray[finalI][finalJ] == 2 && gameBoardArray[finalI - placeholder[5]][finalJ + placeholder[5]] == 1) {
                                            placeholder[5]++;

                                            if (gameBoardArray[finalI][finalJ] == 2 && gameBoardArray[finalI - placeholder[5]][finalJ + placeholder[5]] == 2) {
                                                placeholder[5] -= 1;
                                                System.out.println("FLIPPING DIAG TO RIGHT! " + placeholder[5]);
                                                for (int i = placeholder[5]; i > 0; i--) {
                                                    slot[finalI - i][finalJ + i].setIcon(lightPeg);
                                                    gameBoardArray[finalI - i][finalJ + i] = 2;
                                                }
                                                isScanned[5] = true;

                                            }

                                        }
                                    } else {
                                        placeholder[5] = 0;
                                    }
                                } catch (Exception a) {
                                    System.out.println("Out of bounds");
                                }

                                try {
                                    if (finalI - placeholder[6] != -1 && finalJ - placeholder[6] != -1) {
                                        // scan if peg is placed diagonally from right to left pababa
                                        if (gameBoardArray[finalI][finalJ] == 2 && gameBoardArray[finalI - placeholder[6]][finalJ - placeholder[6]] == 1) {
                                            placeholder[6]++;

                                            if (gameBoardArray[finalI][finalJ] == 2 && gameBoardArray[finalI - placeholder[6]][finalJ - placeholder[6]] == 2) {
                                                placeholder[6] -= 1;
                                                System.out.println("FLIPPING DIAG TO leFt! " + placeholder[6]);
                                                for (int i = placeholder[6]; i > 0; i--) {
                                                    slot[finalI - i][finalJ - i].setIcon(lightPeg);
                                                    gameBoardArray[finalI - i][finalJ - i] = 2;
                                                }
                                                isScanned[6] = true;

                                            }
                                        }
                                    } else {
                                        placeholder[6] = 0;
                                    }
                                } catch (Exception a) {
                                    System.out.println("Out of bounds");
                                }

                                try {
                                    if (finalJ - placeholder[7] != -1 || finalI+placeholder[7] == 8) {
                                        // scan if peg is placed diagonally from right to left pataas
                                        if (gameBoardArray[finalI][finalJ] == 2 && gameBoardArray[finalI + placeholder[7]][finalJ - placeholder[7]] == 1) {
                                            placeholder[7]++;

                                            if (gameBoardArray[finalI][finalJ] == 2 && gameBoardArray[finalI + placeholder[7]][finalJ - placeholder[7]] == 2) {
                                                placeholder[7] -= 1;
                                                System.out.println("FLIPPING DIAG TO leFt! " + placeholder[7]);
                                                for (int i = placeholder[7]; i > 0; i--) {
                                                    slot[finalI + i][finalJ - i].setIcon(lightPeg);
                                                    gameBoardArray[finalI + i][finalJ - i] = 2;
                                                }
                                                isScanned[7] = true;

                                            }
                                        }
                                    } else {
                                        placeholder[7] = 0;
                                    }
                                } catch (Exception a) {
                                    System.out.println("Out of bounds");
                                }

                                if (isScanned[0] || isScanned[1] || isScanned[2] || isScanned[3] || isScanned[4] || isScanned[5] || isScanned[6] ||
                                        isScanned[7]) {
                                    System.out.println(isScanned[0] + "" + isScanned[1] + isScanned[3] + isScanned[4] + isScanned[5] + isScanned[6] +
                                            isScanned[7]);
                                    isOppositeColor[1] = false;
                                }

                                printGameBoardToConsole();
                                //isOppositeColor[0] = false;
                                lbScroll.setVisible(true);
                                darkPegPlayer.setVisible(true);
                                lbScroll2.setVisible(false);
                                lightPegPlayer.setVisible(false);

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
            System.out.println();

        }
        panelGameProper.add(lbGameBoard);
        panelGameProper.add(darkPegPlayer);
        panelGameProper.add(lightPegPlayer);
        panelGameProper.add(lbScroll);
        panelGameProper.add(lbScroll2);
    }

    public void printGameBoardToConsole() {
        System.out.println("Current Game Board:");

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(gameBoardArray[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}