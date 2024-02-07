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
    Integer moves = 0;

    private WinnerPage winnerPage;

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
        lbScroll.setBounds(20, 360, 400, 300);

        lbScroll2 = new JLabel();
        lbScroll2.setIcon(scrollImage);
        lbScroll2.setBounds(1500, 360, 400, 300);
        lbScroll2.setVisible(false);

        darkPegPlayer = new JLabel();
        darkPegPlayer.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        darkPegPlayer.setFont(new Font("Dogica Pixel", Font.BOLD, 24));
        darkPegPlayer.setForeground(Color.BLACK);
        darkPegPlayer.setHorizontalAlignment(JLabel.CENTER);
        darkPegPlayer.setBounds(30, 450, 390, 70);

        lightPegPlayer = new JLabel();
        lightPegPlayer.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lightPegPlayer.setFont(new Font("Dogica Pixel", Font.BOLD, 24));
        lightPegPlayer.setForeground(Color.BLACK);
        lightPegPlayer.setHorizontalAlignment(JLabel.CENTER);
        lightPegPlayer.setBounds(1520, 450, 380, 70);
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
                                    if (finalJ-placeholderValid[0] == -1) {
                                        break;
                                    } else if (gameBoardArray[finalI][finalJ - placeholderValid[0]] == 2) {
                                        placeholderValid[0]++;
                                    } else if (placeholderValid[0] == 1) {
                                        break;
                                    } else if (gameBoardArray[finalI][finalJ - placeholderValid[0]] == 1) {
                                        placeholderValid[0] = 1;
                                        isScannedValid[0] = true;
                                        isValid = true;
                                    } else if (gameBoardArray[finalI][finalJ - placeholderValid[0]] == 0) {
                                        break;
                                    } else {
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
                                    if (finalJ+placeholderValid[1] == 8) {
                                        break;
                                    } else if (gameBoardArray[finalI][finalJ + placeholderValid[1]] == 2) {
                                        placeholderValid[1]++;
                                    } else if (placeholderValid[1] == 1) {
                                        break;
                                    } else if (gameBoardArray[finalI][finalJ + placeholderValid[1]] == 1) {
                                        placeholderValid[1] = 1;
                                        isScannedValid[1] = true;
                                        isValid = true;
                                    } else if (gameBoardArray[finalI][finalJ + placeholderValid[1]] == 0) {
                                        break;
                                    } else {
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
                                    if (finalI+placeholderValid[2] == 8) {
                                        break;
                                    } else if (gameBoardArray[finalI + placeholderValid[2]][finalJ] == 2) {
                                        placeholderValid[2]++;
                                    } else if (placeholderValid[2] == 1) {
                                        break;
                                    } else if (gameBoardArray[finalI + placeholderValid[2]][finalJ] == 1) {
                                        placeholderValid[2] = 1;
                                        isScannedValid[2] = true;
                                        isValid = true;
                                    } else if (gameBoardArray[finalI + placeholderValid[2]][finalJ] == 0) {
                                        break;
                                    } else {
                                        JOptionPane.showMessageDialog(null, "NOT VALID!");
                                        break;
                                    }

                                } catch (Exception a) {
                                    System.out.println("Error in: is from above. Might be out of bounds.");
                                    break;
                                }

                            }
                            while (!isScannedValid[3]) {
                                // is from below
                                try {

                                    if (finalI-placeholderValid[3] == -1) {
                                        break;
                                    } else if (gameBoardArray[finalI - placeholderValid[3]][finalJ] == 2) {
                                        placeholderValid[3]++;
                                    } else if (placeholderValid[3] == 1) {
                                        break;
                                    } else if (gameBoardArray[finalI - placeholderValid[3]][finalJ] == 1) {
                                        placeholderValid[3] = 1;
                                        isScannedValid[3] = true;
                                        isValid = true;
                                    } else if (gameBoardArray[finalI - placeholderValid[3]][finalJ] == 0) {
                                        break;
                                    } else {
                                        JOptionPane.showMessageDialog(null, "NOT VALID!");
                                        break;
                                    }

                                } catch (Exception a) {
                                    System.out.println("Error in: is from below. Might be out of bounds.");
                                    break;
                                }

                            }
                            while (!isScannedValid[4]) {
                                // if point going right down
                                try {
                                    if (finalI + placeholderValid[4] == 8 && finalJ + placeholderValid[4] == 8) {
                                        break;
                                    } else if (gameBoardArray[finalI + placeholderValid[4]][finalJ + placeholderValid[4]] == 2) {
                                        placeholderValid[4]++;
                                    } else if (placeholderValid[4] == 1) {
                                        break;
                                    } else if (gameBoardArray[finalI + placeholderValid[4]][finalJ + placeholderValid[4]] == 1) {
                                        placeholderValid[4] = 1;
                                        isScannedValid[4] = true;
                                        isValid = true;
                                    } else if (gameBoardArray[finalI + placeholderValid[4]][finalJ + placeholderValid[4]] == 0) {
                                        break;
                                    } else {
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
                                    if (finalI - placeholderValid[5] == -1 && finalJ - placeholderValid[5] == -1) {
                                        break;
                                    } else if (gameBoardArray[finalI - placeholderValid[5]][finalJ - placeholderValid[5]] == 2) {
                                        placeholderValid[5]++;
                                    } else if (placeholderValid[5] == 1) {
                                        break;
                                    } else if (gameBoardArray[finalI - placeholderValid[5]][finalJ - placeholderValid[5]] == 1) {
                                        placeholderValid[5] = 1;
                                        isScannedValid[5] = true;
                                        isValid = true;
                                    } else if (gameBoardArray[finalI - placeholderValid[5]][finalJ - placeholderValid[5]] == 0) {
                                        break;
                                    } else {
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
                                    if (finalI + placeholderValid[6] == 8 && finalJ - placeholderValid[6] == -1) {
                                        break;
                                    } else if (gameBoardArray[finalI + placeholderValid[6]][finalJ - placeholderValid[6]] == 2) {
                                        placeholderValid[6]++;
                                    } else if (placeholderValid[6] == 1) {
                                        break;
                                    } else if (gameBoardArray[finalI + placeholderValid[6]][finalJ - placeholderValid[6]] == 1) {
                                        placeholderValid[6] = 1;
                                        isScannedValid[6] = true;
                                        isValid = true;
                                    } else if (gameBoardArray[finalI + placeholderValid[6]][finalJ - placeholderValid[6]] == 0) {
                                        break;
                                    } else {
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
                                    if (finalI - placeholderValid[7] == -1 && finalJ + placeholderValid[7] == 8) {
                                        break;
                                    } else if (gameBoardArray[finalI - placeholderValid[7]][finalJ + placeholderValid[7]] == 2) {
                                        placeholderValid[7]++;
                                    } else if (placeholderValid[7] == 1) {
                                        break;
                                    } else if (gameBoardArray[finalI - placeholderValid[7]][finalJ + placeholderValid[7]] == 1) {
                                        placeholderValid[7] = 1;
                                        isScannedValid[7] = true;
                                        isValid = true;
                                    } else if (gameBoardArray[finalI - placeholderValid[7]][finalJ + placeholderValid[7]] == 0) {
                                        break;
                                    } else {
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
                                player1Turn = false;
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

                                            if (finalJ+placeholder[0] == 8) {
                                                break;
                                            }


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

                                            if (finalJ-placeholder[1] == -1) {
                                                break;
                                            }

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
                                    // is from below
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
                                        System.out.println("Scan is out bounds when placed below going up. Override.");
                                        break;
                                    }
                                }
                                while (!isScanned[3]) {
                                    // is from above
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
                                        System.out.println("Scan is out of bounds when placed above. Override.");
                                        break;
                                    }
                                }
                                while (!isScanned[4]) {
                                    // is from point to bottom right
                                    try {
                                        if (gameBoardArray[finalI][finalJ] == 1 && gameBoardArray[finalI + placeholder[4]][finalJ + placeholder[4]] == 2) {
                                            placeholder[4]++;

                                            if (finalI+placeholder[4] == 8 || finalJ+placeholder[4] == 8) {
                                                break;
                                            }



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

                                            if (finalI-placeholder[5] == -1 || finalJ+placeholder[5] == 8) {
                                                break;
                                            }

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

                                            if (finalI+placeholder[6] == 8 || finalJ-placeholder[5] == -1) {
                                                break;
                                            }

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

                                            if (finalI-placeholder[5] == -1 || finalJ-placeholder[5] == -1) {
                                                break;
                                            }

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

                                printGameBoardToConsole();
                                moves++;
                                System.out.println(moves);
                                lbScroll.setVisible(false);
                                darkPegPlayer.setVisible(false);
                                lbScroll2.setVisible(true);
                                lightPegPlayer.setVisible(true);
                            }
                            else {
                                player1Turn = false;
                            }


                        } else {

                            int[] placeholderValid = {1, 1, 1, 1, 1, 1, 1, 1};
                            boolean[] isScannedValid = {false, false, false, false, false, false, false, false};
                            boolean isValid = false;

                            while (!isScannedValid[0]) {
                                // is from right
                                try {
                                    if (gameBoardArray[finalI][finalJ - placeholderValid[0]] == 1) {
                                        placeholderValid[0]++;

                                        if (finalJ - placeholderValid[0] == -1) {
                                            isScannedValid[0] = true;
                                        }

                                    } else if (placeholderValid[0] == 1) {
                                        break;
                                    } else if (gameBoardArray[finalI][finalJ - placeholderValid[0]] == 2) {
                                        placeholderValid[0] = 1;
                                        isScannedValid[0] = true;
                                        isValid = true;
                                    } else if (gameBoardArray[finalI][finalJ - placeholderValid[0]] == 0) {
                                        break;
                                    } else {
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
                                    if (gameBoardArray[finalI][finalJ + placeholderValid[1]] == 1) {
                                        placeholderValid[1]++;
                                    } else if (placeholderValid[1] == 1) {
                                        break;
                                    } else if (gameBoardArray[finalI][finalJ + placeholderValid[1]] == 2) {
                                        placeholderValid[1] = 1;
                                        isScannedValid[1] = true;
                                        isValid = true;
                                    } else if (gameBoardArray[finalI][finalJ + placeholderValid[1]] == 0) {
                                        break;
                                    } else {
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
                                    if (gameBoardArray[finalI + placeholderValid[2]][finalJ] == 1) {
                                        placeholderValid[2]++;
                                    } else if (placeholderValid[2] == 1) {
                                        break;
                                    } else if (gameBoardArray[finalI + placeholderValid[2]][finalJ] == 2) {
                                        placeholderValid[2] = 1;
                                        isScannedValid[2] = true;
                                        isValid = true;
                                    } else if (gameBoardArray[finalI + placeholderValid[2]][finalJ] == 0) {
                                        break;
                                    } else {
                                        JOptionPane.showMessageDialog(null, "NOT VALID!");
                                        break;
                                    }

                                } catch (Exception a) {
                                    System.out.println("Error in: is from above. Might be out of bounds.");
                                    break;
                                }

                            }
                            while (!isScannedValid[3]) {
                                // is from below
                                try {
                                    if (gameBoardArray[finalI - placeholderValid[3]][finalJ] == 1) {
                                        placeholderValid[3]++;
                                    } else if (placeholderValid[3] == 1) {
                                        break;
                                    } else if (gameBoardArray[finalI - placeholderValid[3]][finalJ] == 2) {
                                        placeholderValid[3] = 1;
                                        isScannedValid[3] = true;
                                        isValid = true;
                                    } else if (gameBoardArray[finalI - placeholderValid[3]][finalJ] == 0) {
                                        break;
                                    } else {
                                        JOptionPane.showMessageDialog(null, "NOT VALID!");
                                        break;
                                    }

                                } catch (Exception a) {
                                    System.out.println("Error in: is from below. Might be out of bounds.");
                                    break;
                                }

                            }
                            while (!isScannedValid[4]) {
                                // if point going right down
                                try {
                                    if (gameBoardArray[finalI + placeholderValid[4]][finalJ + placeholderValid[4]] == 1) {
                                        placeholderValid[4]++;
                                    } else if (placeholderValid[4] == 1) {
                                        break;
                                    } else if (gameBoardArray[finalI + placeholderValid[4]][finalJ + placeholderValid[4]] == 2) {
                                        placeholderValid[4] = 1;
                                        isScannedValid[4] = true;
                                        isValid = true;
                                    } else if (gameBoardArray[finalI + placeholderValid[4]][finalJ + placeholderValid[4]] == 0) {
                                        break;
                                    } else {
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
                                    if (gameBoardArray[finalI - placeholderValid[5]][finalJ - placeholderValid[5]] == 1) {
                                        placeholderValid[5]++;
                                    } else if (placeholderValid[5] == 1) {
                                        break;
                                    } else if (gameBoardArray[finalI - placeholderValid[5]][finalJ - placeholderValid[5]] == 2) {
                                        placeholderValid[5] = 1;
                                        isScannedValid[5] = true;
                                        isValid = true;
                                    } else if (gameBoardArray[finalI - placeholderValid[5]][finalJ - placeholderValid[5]] == 0) {
                                        break;
                                    } else {
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
                                    if (gameBoardArray[finalI + placeholderValid[6]][finalJ - placeholderValid[6]] == 1) {
                                        placeholderValid[6]++;
                                    } else if (placeholderValid[6] == 1) {
                                        break;
                                    } else if (gameBoardArray[finalI + placeholderValid[6]][finalJ - placeholderValid[6]] == 2) {
                                        placeholderValid[6] = 1;
                                        isScannedValid[6] = true;
                                        isValid = true;
                                    } else if (gameBoardArray[finalI + placeholderValid[6]][finalJ - placeholderValid[6]] == 0) {
                                        break;
                                    } else {
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
                                    if (gameBoardArray[finalI - placeholderValid[7]][finalJ + placeholderValid[7]] == 1) {
                                        placeholderValid[7]++;
                                    } else if (placeholderValid[7] == 1) {
                                        break;
                                    } else if (gameBoardArray[finalI - placeholderValid[7]][finalJ + placeholderValid[7]] == 2) {
                                        placeholderValid[7] = 1;
                                        isScannedValid[7] = true;
                                        isValid = true;
                                    } else if (gameBoardArray[finalI - placeholderValid[7]][finalJ + placeholderValid[7]] == 0) {
                                        break;
                                    } else {
                                        JOptionPane.showMessageDialog(null, "NOT VALID!");
                                        break;
                                    }

                                } catch (Exception a) {
                                    System.out.println("Error in: point going right up. Might be out of bounds.");
                                    break;
                                }

                            }

                            if (isValid) {
                                slot[finalI][finalJ].setIcon(lightPeg);
                                player1Turn = true;
                                gameBoardArray[finalI][finalJ] = 2;
                                slot[finalI][finalJ].removeMouseListener(this);
                                System.out.println("\nPLAYER2: I clicked slot " + finalI + " and " + finalJ + "\n");

                                int[] placeholder = {1, 1, 1, 1, 1, 1, 1, 1};
                                boolean[] isScanned = {false, false, false, false, false, false, false, false};

                                // scan slots that can be flipped
                                while (!isScanned[0]) {
                                    // is from left
                                    try {
                                        if (gameBoardArray[finalI][finalJ] == 2 && gameBoardArray[finalI][finalJ + placeholder[0]] == 1) {
                                            placeholder[0]++;
                                        } else if (gameBoardArray[finalI][finalJ] == 2 && gameBoardArray[finalI][finalJ + placeholder[0]] == 2) {
                                            placeholder[0] -= 1;

                                            for (int a = placeholder[0]; a > 0; a--) {
                                                gameBoardArray[finalI][finalJ + a] = 2;
                                                slot[finalI][finalJ + a].setIcon(lightPeg);
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
                                        if (gameBoardArray[finalI][finalJ] == 2 && gameBoardArray[finalI][finalJ - placeholder[1]] == 1) {
                                            placeholder[1]++;
                                        } else if (gameBoardArray[finalI][finalJ] == 2 && gameBoardArray[finalI][finalJ - placeholder[1]] == 2) {
                                            placeholder[1] -= 1;

                                            for (int a = placeholder[1]; a > 0; a--) {
                                                gameBoardArray[finalI][finalJ - a] = 2;
                                                slot[finalI][finalJ - a].setIcon(lightPeg);
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
                                        if (gameBoardArray[finalI][finalJ] == 2 && gameBoardArray[finalI - placeholder[2]][finalJ] == 1) {
                                            placeholder[2]++;
                                        } else if (gameBoardArray[finalI][finalJ] == 2 && gameBoardArray[finalI - placeholder[2]][finalJ] == 2) {
                                            placeholder[2] -= 1;

                                            for (int a = placeholder[2]; a > 0; a--) {
                                                gameBoardArray[finalI - a][finalJ] = 2;
                                                slot[finalI - a][finalJ].setIcon(lightPeg);
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
                                        if (gameBoardArray[finalI][finalJ] == 2 && gameBoardArray[finalI + placeholder[3]][finalJ] == 1) {
                                            placeholder[3]++;
                                        } else if (gameBoardArray[finalI][finalJ] == 2 && gameBoardArray[finalI + placeholder[3]][finalJ] == 2) {
                                            placeholder[3] -= 1;

                                            for (int a = placeholder[3]; a > 0; a--) {
                                                gameBoardArray[finalI + a][finalJ] = 2;
                                                slot[finalI + a][finalJ].setIcon(lightPeg);
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
                                        if (gameBoardArray[finalI][finalJ] == 2 && gameBoardArray[finalI + placeholder[4]][finalJ + placeholder[4]] == 1) {
                                            placeholder[4]++;
                                        } else if (gameBoardArray[finalI][finalJ] == 2 && gameBoardArray[finalI + placeholder[4]][finalJ + placeholder[4]] == 2) {
                                            placeholder[4] -= 1;

                                            for (int a = placeholder[4]; a > 0; a--) {
                                                gameBoardArray[finalI + a][finalJ + a] = 2;
                                                slot[finalI + a][finalJ + a].setIcon(lightPeg);
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
                                        if (gameBoardArray[finalI][finalJ] == 2 && gameBoardArray[finalI - placeholder[5]][finalJ + placeholder[5]] == 1) {
                                            placeholder[5]++;
                                        } else if (gameBoardArray[finalI][finalJ] == 2 && gameBoardArray[finalI - placeholder[5]][finalJ + placeholder[5]] == 2) {
                                            placeholder[5] -= 1;

                                            for (int a = placeholder[5]; a > 0; a--) {
                                                gameBoardArray[finalI - a][finalJ + a] = 2;
                                                slot[finalI - a][finalJ + a].setIcon(lightPeg);
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
                                        if (gameBoardArray[finalI][finalJ] == 2 && gameBoardArray[finalI + placeholder[6]][finalJ - placeholder[6]] == 1) {
                                            placeholder[6]++;
                                        } else if (gameBoardArray[finalI][finalJ] == 2 && gameBoardArray[finalI + placeholder[6]][finalJ - placeholder[6]] == 2) {
                                            placeholder[6] -= 1;

                                            for (int a = placeholder[6]; a > 0; a--) {
                                                gameBoardArray[finalI + a][finalJ - a] = 2;
                                                slot[finalI + a][finalJ - a].setIcon(lightPeg);
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
                                        if (gameBoardArray[finalI][finalJ] == 2 && gameBoardArray[finalI - placeholder[7]][finalJ - placeholder[7]] == 1) {
                                            placeholder[7]++;
                                        } else if (gameBoardArray[finalI][finalJ] == 2 && gameBoardArray[finalI - placeholder[7]][finalJ - placeholder[7]] == 2) {
                                            placeholder[7] -= 1;

                                            for (int a = placeholder[7]; a > 0; a--) {
                                                gameBoardArray[finalI - a][finalJ - a] = 2;
                                                slot[finalI - a][finalJ - a].setIcon(lightPeg);
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

                                printGameBoardToConsole();
                                moves++;
                                System.out.println(moves);
                                lbScroll.setVisible(true);
                                darkPegPlayer.setVisible(true);
                                lbScroll2.setVisible(false);
                                lightPegPlayer.setVisible(false);
                            } else {
                                player1Turn = true;
                            }
                        }

                        checkWinner();

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

        for (int i = 0; i < 8; i++) { // the reason why the possible positions are moved here because some are not still instantiated on the first loop
            for (int j = 0; j < 8; j++) {

                int[] placeholderPos = {1, 1, 1, 1, 1, 1, 1, 1};
                boolean[] isScannedPos = {false, false, false, false, false, false, false, false};

                while (!isScannedPos[0]) {
                    // is from right
                    try {
                        if (gameBoardArray[i][j] == 1 && gameBoardArray[i][j - placeholderPos[0]] == 2) {
                            placeholderPos[0]++;
                        } else if (placeholderPos[0] == 1) {
                            break;

                        } else if (gameBoardArray[i][j] == 1 && gameBoardArray[i][j - placeholderPos[0]] == 0) {
                            slot[i][j - placeholderPos[0]].setIcon(pegBleach);
                            isScannedPos[0] = true;
                        } else {
                            break;
                        }

                    } catch (Exception a) {
                        System.out.println("Error in: is from right. Might be out of bounds.");
                        break;
                    }
                }
                while (!isScannedPos[1]) {
                    // is from left

                    if (gameBoardArray[i][j] == 1 && gameBoardArray[i][j + placeholderPos[1]] == 2) {
                        placeholderPos[1]++;
                        System.out.println("add " + placeholderPos[1]);
                    } else if (placeholderPos[1] == 1) {
                        break;
                    }

                    if (gameBoardArray[i][j] == 1 && gameBoardArray[i][j + placeholderPos[1]] == 0) {
                        slot[i][j + placeholderPos[1]].setIcon(pegBleach);
                        isScannedPos[1] = true;
                    } else {
                        break;
                    }


                }
                while (!isScannedPos[2]) {
                    // is from above going down
                    try {
                        if (gameBoardArray[i][j] == 1 && gameBoardArray[i + placeholderPos[2]][j] == 2) {
                            placeholderPos[2]++;
                        } else if (placeholderPos[2] == 1) {
                            break;

                        } else if (gameBoardArray[i + placeholderPos[2]][j] == 0) {
                            slot[i + placeholderPos[2]][j].setIcon(pegBleach);
                            isScannedPos[2] = true;
                        } else {
                            break;
                        }

                    } catch (Exception a) {
                        System.out.println("Error in: is from above going down. Might be out of bounds.");
                        break;
                    }
                }
                while (!isScannedPos[3]) {
                    // is from below going up
                    try {
                        if (gameBoardArray[i][j] == 1 && gameBoardArray[i - placeholderPos[3]][j] == 2) {
                            placeholderPos[3]++;
                        } else if (placeholderPos[3] == 1) {
                            break;
                        } else if (gameBoardArray[i - placeholderPos[3]][j] == 0) {
                            slot[i - placeholderPos[3]][j].setIcon(pegBleach);
                            isScannedPos[3] = true;
                        } else {
                            break;
                        }

                    } catch (Exception a) {
                        System.out.println("Error in: is from above going down. Might be out of bounds.");
                        break;
                    }
                }
                while (!isScannedPos[4]) {
                    // is from point going right down
                    try {
                        if (gameBoardArray[i][j] == 1 && gameBoardArray[i + placeholderPos[4]][j + placeholderPos[4]] == 2) {
                            placeholderPos[4]++;
                        } else if (placeholderPos[4] == 1) {
                            break;
                        } else if (gameBoardArray[i + placeholderPos[4]][j + placeholderPos[4]] == 0) {
                            slot[i + placeholderPos[4]][j + placeholderPos[4]].setIcon(pegBleach);

                            isScannedPos[4] = true;
                        } else {
                            break;
                        }

                    } catch (Exception a) {
                        System.out.println("Error in: is from point going down. Might be out of bounds.");
                        break;
                    }
                }
                while (!isScannedPos[5]) {
                    // is from point going left up
                    try {
                        if (gameBoardArray[i][j] == 1 && gameBoardArray[i - placeholderPos[5]][j - placeholderPos[5]] == 2) {
                            placeholderPos[5]++;
                        } else if (placeholderPos[5] == 1) {
                            break;
                        } else if (gameBoardArray[i - placeholderPos[5]][j - placeholderPos[5]] == 0) {
                            slot[i - placeholderPos[5]][j - placeholderPos[5]].setIcon(pegBleach);
                            isScannedPos[5] = true;
                        } else {
                            break;
                        }

                    } catch (Exception a) {
                        System.out.println("Error in: is from point left up Might be out of bounds.");
                        break;
                    }
                }
                while (!isScannedPos[6]) {
                    // is from point going left down
                    try {
                        if (gameBoardArray[i][j] == 1 && gameBoardArray[i + placeholderPos[6]][j - placeholderPos[6]] == 2) {
                            placeholderPos[6]++;
                        } else if (placeholderPos[6] == 1) {
                            break;
                        } else if (gameBoardArray[i + placeholderPos[6]][j - placeholderPos[6]] == 0) {
                            slot[i + placeholderPos[6]][j - placeholderPos[6]].setIcon(pegBleach);

                            isScannedPos[6] = true;
                        } else {
                            break;
                        }

                    } catch (Exception a) {
                        System.out.println("Error in: is from point going down. Might be out of bounds.");
                        break;
                    }
                }
                while (!isScannedPos[7]) {
                    // is from point going right up
                    try {
                        if (gameBoardArray[i][j] == 1 && gameBoardArray[i - placeholderPos[7]][j + placeholderPos[7]] == 2) {
                            placeholderPos[7]++;
                        } else if (placeholderPos[7] == 1) {
                            break;
                        } else if (gameBoardArray[i - placeholderPos[7]][j + placeholderPos[7]] == 0) {
                            slot[i - placeholderPos[7]][j + placeholderPos[7]].setIcon(pegBleach);
                            isScannedPos[7] = true;
                        } else {
                            break;
                        }

                    } catch (Exception a) {
                        System.out.println("Error in: is from going right up. Might be out of bounds.");
                        break;
                    }
                }

                if (!player1Turn) {
                    slot[i][j + placeholderPos[0]].setIcon(null);
                    slot[i][j - placeholderPos[1]].setIcon(null);
                    slot[i + placeholderPos[2]][j].setIcon(null);
                    slot[i - placeholderPos[3]][j].setIcon(null);
                    slot[i + placeholderPos[4]][j + placeholderPos[4]].setIcon(null);
                    slot[i - placeholderPos[5]][j - placeholderPos[5]].setIcon(null);
                    slot[i + placeholderPos[6]][j - placeholderPos[6]].setIcon(null);
                    slot[i - placeholderPos[7]][j + placeholderPos[7]].setIcon(null);
                }
            }

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

        public void checkWinner() {
            if (moves == 2) {
                winnerPage.winnerFrame.setVisible(true);
            }
        }

}