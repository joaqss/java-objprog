import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameProperPage {
    JPanel panelGameProper = new JPanel();
    ImageIcon gameBoard, darkPeg, pegBleach, lightPeg, scrollImage;
    JLabel lbGameBoard, lbDarkPeg, lbPegBleach, lbLightPeg, lbScroll, lbScroll2, darkPegPlayer, lightPegPlayer;
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

        lbPegBleach = new JLabel();
        pegBleach = new ImageIcon("Othello/Images/GameProperPage/Pegs/peg-Bleach.png");
        Image dabPegBleach = pegBleach.getImage();
        Image modifiedPegBleach = dabPegBleach.getScaledInstance(90, 90, Image.SCALE_REPLICATE);
        pegBleach = new ImageIcon(modifiedPegBleach);
        lbPegBleach.setIcon(pegBleach);

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
                slot[i][j] = new JButton();
                slot[i][j].setBounds(x_value, y_value, 100, 100);
                slot[i][j].setOpaque(false);
                slot[i][j].setContentAreaFilled(false);
                //slot[i][j].setBorderPainted(false);

                if (gameBoardArray[i][j] == 1) {
                    slot[i][j].setIcon(darkPeg);

                } else if (gameBoardArray[i][j] == 2) {
                    slot[i][j].setIcon(lightPeg);
                }

                panelGameProper.add(slot[i][j]);

                x_value += 109; // add x values to each button

                int[] placeholderPos = {1, 1, 1, 1, 1, 1, 1, 1};
                boolean[] isScannedPos = {false, false, false, false, false, false, false, false};

                while (!isScannedPos[0]) {
                    // is from right
                    try {
                        if (gameBoardArray[i][j] == 1 && gameBoardArray[i][j-placeholderPos[0]] == 2) {
                            placeholderPos[0]++;
                        } else if (placeholderPos[0] == 1) {
                            break;

                        } else if (gameBoardArray[i][j - placeholderPos[0]] == 0) {
                            slot[i][j-placeholderPos[0]].setIcon(pegBleach);
                            placeholderPos[0] = 1;
                            isScannedPos[0] = true;
                        }
                        else {
                            break;
                        }

                    } catch (Exception a) {
                        System.out.println("Error in: is from right. Might be out of bounds.");
                        break;
                    }
                }
                while (!isScannedPos[1]) {
                    // is from left
                    try {
                        if (gameBoardArray[i][j] == 1 && gameBoardArray[i][j+placeholderPos[1]] == 2) {
                            placeholderPos[1]++;
                            System.out.println("add " + placeholderPos[1]);
                        } else if (placeholderPos[1] == 1) {
                            break;

                        } else if (gameBoardArray[i][j] == 1 && gameBoardArray[i][j + placeholderPos[1]] == 0) {
                            slot[i][j+placeholderPos[1]].setIcon(pegBleach);
                            placeholderPos[1] = 1;
                            isScannedPos[1] = true;
                        }
                        else {
                            break;
                        }

                    } catch (Exception a) {
                        System.out.println("Error in: is from left. Might be out of bounds.");
                        break;
                    }
                } // not fix
                while (!isScannedPos[2]) {
                    // is from down to up
                    try {
                        if (gameBoardArray[i][j] == 1 && gameBoardArray[i+placeholderPos[2]][j] == 2) {
                            placeholderPos[2]++;
                        } else if (placeholderPos[2] == 1) {
                            break;

                        } else if (gameBoardArray[i + placeholderPos[2]][j] == 0) {
                            slot[i+placeholderPos[2]][j].setIcon(pegBleach);
                            placeholderPos[2] = 1;
                            isScannedPos[2] = true;
                        }
                        else {
                            break;
                        }

                    } catch (Exception a) {
                        System.out.println("Error in: is from above to down. Might be out of bounds.");
                        break;
                    }
                }




                final int finalI = i;
                final int finalJ = j;

                slot[i][j].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                        if (player1Turn) {
                            // to check if chosen slot is valid
                            int[] placeholderValid = {1, 1, 1, 1, 1, 1, 1, 1};
                            boolean[] isScannedValid = {false, false, false, false, false, false, false, false};
                            boolean isValid = false;

                            while (!isScannedValid[0]) {
                                // is from right
                                try {
                                    if (gameBoardArray[finalI][finalJ-placeholderValid[0]] == 2) {
                                        placeholderValid[0]++;

                                        if (finalJ-placeholderValid[0] == -1) {
                                            isScannedValid[0] = true;
                                        }

                                    } else if (placeholderValid[0] == 1) {
                                        break;
                                    } else if (gameBoardArray[finalI][finalJ - placeholderValid[0]] == 1) {
                                        placeholderValid[0] = 1;
                                        isScannedValid[0] = true;
                                        isValid = true;
                                    } else if (gameBoardArray[finalI][finalJ - placeholderValid[0]] == 0) {
                                        break;
                                    }
                                    else {
                                        JOptionPane.showMessageDialog(null, "NOT VALID!");
                                        break;
                                    }

                                } catch (Exception a) {
                                    System.out.println("Error in: is from right. Might be out of bounds.");
                                    break;
                                }
                            }
                            while (!isScannedValid[1]) {
                                // is from left
                                try {
                                    if (gameBoardArray[finalI][finalJ+placeholderValid[1]] == 2) {
                                        placeholderValid[1]++;
                                    } else if (placeholderValid[1] == 1) {
                                        break;
                                    } else if (gameBoardArray[finalI][finalJ + placeholderValid[1]] == 1) {
                                        placeholderValid[1] = 1;
                                        isScannedValid[1] = true;
                                        isValid = true;
                                    } else if (gameBoardArray[finalI][finalJ + placeholderValid[1]] == 0) {
                                        break;
                                    }
                                    else {
                                        JOptionPane.showMessageDialog(null, "NOT VALID!");
                                        break;
                                    }

                                } catch (Exception a) {
                                    System.out.println("Error in: is from left. Might be out of bounds.");
                                    break;
                                }
                            }
                            while (!isScannedValid[2]) {
                                // is from above
                                try {
                                    if (gameBoardArray[finalI + placeholderValid[2]][finalJ] == 2) {
                                        placeholderValid[2]++;
                                    } else if (placeholderValid[2] == 1) {
                                        break;
                                    } else if (gameBoardArray[finalI + placeholderValid[2]][finalJ] == 1) {
                                        placeholderValid[2] = 1;
                                        isScannedValid[2] = true;
                                        isValid = true;
                                    } else if (gameBoardArray[finalI + placeholderValid[2]][finalJ] == 0) {
                                        break;
                                    }
                                    else {
                                        JOptionPane.showMessageDialog(null, "NOT VALID!");
                                        break;
                                    }

                                } catch (Exception a) {
                                    System.out.println("Error in: is from above. Might be out of bounds.");
                                    break;
                                }

                            }
                            while (!isScannedValid[3]) {
                                // is from above
                                try {
                                    if (gameBoardArray[finalI - placeholderValid[3]][finalJ] == 2) {
                                        placeholderValid[3]++;
                                    } else if (placeholderValid[3] == 1) {
                                        break;
                                    } else if (gameBoardArray[finalI - placeholderValid[3]][finalJ] == 1) {
                                        placeholderValid[3] = 1;
                                        isScannedValid[3] = true;
                                        isValid = true;
                                    } else if (gameBoardArray[finalI - placeholderValid[3]][finalJ] == 0) {
                                        break;
                                    }
                                    else {
                                        JOptionPane.showMessageDialog(null, "NOT VALID!");
                                        break;
                                    }

                                } catch (Exception a) {
                                    System.out.println("Error in: is from above. Might be out of bounds.");
                                    break;
                                }

                            }
                            while (!isScannedValid[4]) {
                                // if point going right down
                                try {
                                    if (gameBoardArray[finalI + placeholderValid[4]][finalJ + placeholderValid[4]] == 2) {
                                        placeholderValid[4]++;
                                    } else if (placeholderValid[4] == 1) {
                                        break;
                                    } else if (gameBoardArray[finalI + placeholderValid[4]][finalJ + placeholderValid[4]] == 1) {
                                        placeholderValid[4] = 1;
                                        isScannedValid[4] = true;
                                        isValid = true;
                                    } else if (gameBoardArray[finalI + placeholderValid[4]][finalJ + placeholderValid[4]] == 0) {
                                        break;
                                    }
                                    else {
                                        JOptionPane.showMessageDialog(null, "NOT VALID!");
                                        break;
                                    }

                                } catch (Exception a) {
                                    System.out.println("Error in: if point going right down. Might be out of bounds.");
                                    break;
                                }

                            }
                            while (!isScannedValid[5]) {
                                // point going left up
                                try {
                                    if (gameBoardArray[finalI - placeholderValid[5]][finalJ - placeholderValid[5]] == 2) {
                                        placeholderValid[5]++;
                                    } else if (placeholderValid[5] == 1) {
                                        break;
                                    } else if (gameBoardArray[finalI - placeholderValid[5]][finalJ - placeholderValid[5]] == 1) {
                                        placeholderValid[5] = 1;
                                        isScannedValid[5] = true;
                                        isValid = true;
                                    } else if (gameBoardArray[finalI - placeholderValid[5]][finalJ - placeholderValid[5]] == 0) {
                                        break;
                                    }
                                    else {
                                        JOptionPane.showMessageDialog(null, "NOT VALID!");
                                        break;
                                    }

                                } catch (Exception a) {
                                    System.out.println("Error in: point going left up. Might be out of bounds.");
                                    break;
                                }

                            }
                            while (!isScannedValid[6]) {
                                // if point going left down
                                try {
                                    if (gameBoardArray[finalI + placeholderValid[6]][finalJ - placeholderValid[6]] == 2) {
                                        placeholderValid[6]++;
                                    } else if (placeholderValid[6] == 1) {
                                        break;
                                    } else if (gameBoardArray[finalI + placeholderValid[6]][finalJ - placeholderValid[6]] == 1) {
                                        placeholderValid[6] = 1;
                                        isScannedValid[6] = true;
                                        isValid = true;
                                    } else if (gameBoardArray[finalI + placeholderValid[6]][finalJ - placeholderValid[6]] == 0) {
                                        break;
                                    }
                                    else {
                                        JOptionPane.showMessageDialog(null, "NOT VALID!");
                                        break;
                                    }

                                } catch (Exception a) {
                                    System.out.println("Error in: if point is going left down. Might be out of bounds.");
                                    break;
                                }

                            }
                            while (!isScannedValid[7]) {
                                // point going right up
                                try {
                                    if (gameBoardArray[finalI - placeholderValid[7]][finalJ + placeholderValid[7]] == 2) {
                                        placeholderValid[7]++;
                                    } else if (placeholderValid[7] == 1) {
                                        break;
                                    } else if (gameBoardArray[finalI - placeholderValid[7]][finalJ + placeholderValid[7]] == 1) {
                                        placeholderValid[7] = 1;
                                        isScannedValid[7] = true;
                                        isValid = true;
                                    } else if (gameBoardArray[finalI - placeholderValid[7]][finalJ + placeholderValid[7]] == 0) {
                                        break;
                                    }
                                    else {
                                        JOptionPane.showMessageDialog(null, "NOT VALID!");
                                        break;
                                    }

                                } catch (Exception a) {
                                    System.out.println("Error in: point going right up. Might be out of bounds.");
                                    break;
                                }

                            }

                            if (isValid) {
                                slot[finalI][finalJ].setIcon(darkPeg);
                                //player1Turn = false;
                                gameBoardArray[finalI][finalJ] = 1;
                                slot[finalI][finalJ].removeMouseListener(this);
                                System.out.println("\nPLAYER1: I clicked slot " + finalI + " and " + finalJ + "\n");

                                int[] placeholder = {1, 1, 1, 1, 1, 1, 1, 1};
                                boolean[] isScanned = {false, false, false, false, false, false, false, false};

                                // scan slots that can be flipped
                                while (!isScanned[0]) {
                                    // is from left
                                    try {
                                        if (gameBoardArray[finalI][finalJ] == 1 && gameBoardArray[finalI][finalJ + placeholder[0]] == 2) {
                                            placeholder[0]++;
                                        } else if (gameBoardArray[finalI][finalJ] == 1 && gameBoardArray[finalI][finalJ + placeholder[0]] == 1) {
                                            placeholder[0] -= 1;

                                            for (int a = placeholder[0]; a > 0; a--) {
                                                gameBoardArray[finalI][finalJ + a] = 1;
                                                slot[finalI][finalJ + a].setIcon(darkPeg);
                                            }
                                            isScanned[0] = true;
                                        } else {
                                            isScanned[0] = true;
                                        }

                                    } catch (Exception a) {
                                        System.out.println("Scan is out of bounds when placed left going to right. Override.");
                                        break;
                                    }

                                }
                                while (!isScanned[1]) {
                                    // is from right
                                    try {
                                        if (gameBoardArray[finalI][finalJ] == 1 && gameBoardArray[finalI][finalJ - placeholder[1]] == 2) {
                                            placeholder[1]++;
                                        } else if (gameBoardArray[finalI][finalJ] == 1 && gameBoardArray[finalI][finalJ - placeholder[1]] == 1) {
                                            placeholder[1] -= 1;

                                            for (int a = placeholder[1]; a > 0; a--) {
                                                gameBoardArray[finalI][finalJ - a] = 1;
                                                slot[finalI][finalJ - a].setIcon(darkPeg);
                                            }
                                            isScanned[1] = true;
                                        } else {
                                            isScanned[1] = true;
                                        }

                                    } catch (Exception a) {
                                        System.out.println("Scan is out of bounds when placed right to left. Override.");
                                        break;
                                    }
                                }
                                while (!isScanned[2]) {
                                    // is from above
                                    try {
                                        if (gameBoardArray[finalI][finalJ] == 1 && gameBoardArray[finalI - placeholder[2]][finalJ] == 2) {
                                            placeholder[2]++;
                                        } else if (gameBoardArray[finalI][finalJ] == 1 && gameBoardArray[finalI - placeholder[2]][finalJ] == 1) {
                                            placeholder[2] -= 1;

                                            for (int a = placeholder[2]; a > 0; a--) {
                                                gameBoardArray[finalI - a][finalJ] = 1;
                                                slot[finalI - a][finalJ].setIcon(darkPeg);
                                            }
                                            isScanned[2] = true;
                                        } else {
                                            isScanned[2] = true;
                                        }

                                    } catch (Exception a) {
                                        System.out.println("Scan is out bounds when placed above going down. Override.");
                                        break;
                                    }
                                }
                                while (!isScanned[3]) {
                                    // is from below
                                    try {
                                        if (gameBoardArray[finalI][finalJ] == 1 && gameBoardArray[finalI + placeholder[3]][finalJ] == 2) {
                                            placeholder[3]++;
                                        } else if (gameBoardArray[finalI][finalJ] == 1 && gameBoardArray[finalI + placeholder[3]][finalJ] == 1) {
                                            placeholder[3] -= 1;

                                            for (int a = placeholder[3]; a > 0; a--) {
                                                gameBoardArray[finalI + a][finalJ] = 1;
                                                slot[finalI + a][finalJ].setIcon(darkPeg);
                                            }
                                            isScanned[3] = true;
                                        } else {
                                            isScanned[3] = true;
                                        }

                                    } catch (Exception a) {
                                        System.out.println("Scan is out of bounds when placed below going up. Override.");
                                        break;
                                    }
                                }
                                while (!isScanned[4]) {
                                    // is from point to bottom right
                                    try {
                                        if (gameBoardArray[finalI][finalJ] == 1 && gameBoardArray[finalI + placeholder[4]][finalJ + placeholder[4]] == 2) {
                                            placeholder[4]++;
                                        } else if (gameBoardArray[finalI][finalJ] == 1 && gameBoardArray[finalI + placeholder[4]][finalJ + placeholder[4]] == 1) {
                                            placeholder[4] -= 1;

                                            for (int a = placeholder[4]; a > 0; a--) {
                                                gameBoardArray[finalI + a][finalJ + a] = 1;
                                                slot[finalI + a][finalJ + a].setIcon(darkPeg);
                                            }
                                            isScanned[4] = true;
                                        } else {
                                            isScanned[4] = true;
                                        }

                                    } catch (Exception a) {
                                        System.out.println("Scan is out of bounds when placed point to bottom right. Override.");
                                        break;
                                    }
                                }
                                while (!isScanned[5]) {
                                    // is from point to right above
                                    try {
                                        if (gameBoardArray[finalI][finalJ] == 1 && gameBoardArray[finalI - placeholder[5]][finalJ + placeholder[5]] == 2) {
                                            placeholder[5]++;
                                        } else if (gameBoardArray[finalI][finalJ] == 1 && gameBoardArray[finalI - placeholder[5]][finalJ + placeholder[5]] == 1) {
                                            placeholder[5] -= 1;

                                            for (int a = placeholder[5]; a > 0; a--) {
                                                gameBoardArray[finalI - a][finalJ + a] = 1;
                                                slot[finalI - a][finalJ + a].setIcon(darkPeg);
                                            }
                                            isScanned[5] = true;
                                        } else {
                                            isScanned[5] = true;
                                        }

                                    } catch (Exception a) {
                                        System.out.println("Scan is out of bounds when placed point to right above. Override.");
                                        break;
                                    }
                                }
                                while (!isScanned[6]) {
                                    // is from point to left below
                                    try {
                                        if (gameBoardArray[finalI][finalJ] == 1 && gameBoardArray[finalI + placeholder[6]][finalJ - placeholder[6]] == 2) {
                                            placeholder[6]++;
                                        } else if (gameBoardArray[finalI][finalJ] == 1 && gameBoardArray[finalI + placeholder[6]][finalJ - placeholder[6]] == 1) {
                                            placeholder[6] -= 1;

                                            for (int a = placeholder[6]; a > 0; a--) {
                                                gameBoardArray[finalI + a][finalJ - a] = 1;
                                                slot[finalI + a][finalJ - a].setIcon(darkPeg);
                                            }
                                            isScanned[6] = true;
                                        } else {
                                            isScanned[6] = true;
                                        }

                                    } catch (Exception a) {
                                        System.out.println("Scan is out of bounds when placed point to left below. Override.");
                                        break;
                                    }
                                }
                                while (!isScanned[7]) {
                                    // is from point to left above
                                    try {
                                        if (gameBoardArray[finalI][finalJ] == 1 && gameBoardArray[finalI - placeholder[7]][finalJ - placeholder[7]] == 2) {
                                            placeholder[7]++;
                                        } else if (gameBoardArray[finalI][finalJ] == 1 && gameBoardArray[finalI - placeholder[7]][finalJ - placeholder[7]] == 1) {
                                            placeholder[7] -= 1;

                                            for (int a = placeholder[7]; a > 0; a--) {
                                                gameBoardArray[finalI - a][finalJ - a] = 1;
                                                slot[finalI - a][finalJ - a].setIcon(darkPeg);
                                            }
                                            isScanned[7] = true;
                                        } else {
                                            isScanned[7] = true;
                                        }

                                    } catch (Exception a) {
                                        System.out.println("Scan is out of bounds when placed point to left above. Override.");
                                        break;
                                    }
                                }
                            }

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