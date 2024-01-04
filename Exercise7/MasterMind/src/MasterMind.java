import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MasterMind {

    JFrame mainFrame = new JFrame("MasterMind");
    AnswerPanel [] MAP; int y_axis = 10;
    CluePanel[] Clue; int y_axis2 = 10;
    ComboBoxPanel CBP;
    ButtonPanel BP;
    SecretPanel SP;
    MyRandom randomColor;

    public MasterMind() {
        mainFrame.setLayout(null);
        mainFrame.setLocation(400, 0);
        mainFrame.setSize(350, 700);

        // Answer Panel
        MAP = new AnswerPanel[10];
        for (int j = 0; j != 10; j++) {
            MAP[j] = new AnswerPanel();
            MAP[j].AnsPanel.setBounds(20, y_axis, 220, 40);
            mainFrame.add(MAP[j].AnsPanel);
            y_axis = y_axis + 45;
        }

        // Clue Panel
        Clue = new CluePanel[10];
        for (int c = 0; c != 10; c++) {
            Clue[c] = new CluePanel();
            Clue[c].cpPanel.setBounds(250, y_axis2, 40, 40);
            mainFrame.add(Clue[c].cpPanel);
            y_axis2 = y_axis2 + 45;
        }

        // Combo Box
        CBP = new ComboBoxPanel();
        CBP.comboBPanel.setBounds(20, 470, 300, 50);
        mainFrame.add(CBP.comboBPanel);

        // Button Panel
        BP = new ButtonPanel();
        BP.buttonPanel.setBounds(20, 520, 300, 40);
        mainFrame.add(BP.buttonPanel);

        // Secret Panel
        SP = new SecretPanel();
        SP.secretPanel.setBounds(20, 580, 220, 40);
        mainFrame.add(SP.secretPanel);

        // Random Color
        randomColor = new MyRandom();

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);

        CBP.C1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (CBP.C1.getSelectedIndex()) {
                    case 1:
                        MAP[BP.trialNumber].L1.setForeground(Color.BLUE);
                        break;
                    case 2:
                        MAP[BP.trialNumber].L1.setForeground(Color.GREEN);
                        break;
                    case 3:
                        MAP[BP.trialNumber].L1.setForeground(Color.RED);
                        break;
                    case 4:
                        MAP[BP.trialNumber].L1.setForeground(Color.yellow);
                        break;
                    case 5:
                        MAP[BP.trialNumber].L1.setForeground(Color.PINK);
                        break;
                    case 6:
                        MAP[BP.trialNumber].L1.setForeground(Color.ORANGE);
                        break;
                    default:
                        MAP[BP.trialNumber].L1.setForeground(Color.GRAY);
                }
            }
        });
        CBP.C2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (CBP.C2.getSelectedIndex()) {
                    case 1:
                        MAP[BP.trialNumber].L2.setForeground(Color.BLUE);
                        break;
                    case 2:
                        MAP[BP.trialNumber].L2.setForeground(Color.GREEN);
                        break;
                    case 3:
                        MAP[BP.trialNumber].L2.setForeground(Color.RED);
                        break;
                    case 4:
                        MAP[BP.trialNumber].L2.setForeground(Color.YELLOW);
                        break;
                    case 5:
                        MAP[BP.trialNumber].L2.setForeground(Color.PINK);
                        break;
                    case 6:
                        MAP[BP.trialNumber].L2.setForeground(Color.ORANGE);
                        break;
                    default:
                        MAP[BP.trialNumber].L2.setForeground(Color.GRAY);
                        break;
                }
            }
        });
        CBP.C3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (CBP.C3.getSelectedIndex()) {
                    case 1:
                        MAP[BP.trialNumber].L3.setForeground(Color.BLUE);
                        break;
                    case 2:
                        MAP[BP.trialNumber].L3.setForeground(Color.GREEN);
                        break;
                    case 3:
                        MAP[BP.trialNumber].L3.setForeground(Color.RED);
                        break;
                    case 4:
                        MAP[BP.trialNumber].L3.setForeground(Color.YELLOW);
                        break;
                    case 5:
                        MAP[BP.trialNumber].L3.setForeground(Color.PINK);
                        break;
                    case 6:
                        MAP[BP.trialNumber].L3.setForeground(Color.ORANGE);
                        break;
                    default:
                        MAP[BP.trialNumber].L3.setForeground(Color.GRAY);
                        break;
                }
            }
        });
        CBP.C4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (CBP.C4.getSelectedIndex()) {
                    case 1:
                        MAP[BP.trialNumber].L4.setForeground(Color.BLUE);
                        break;
                    case 2:
                        MAP[BP.trialNumber].L4.setForeground(Color.GREEN);
                        break;
                    case 3:
                        MAP[BP.trialNumber].L4.setForeground(Color.RED);
                        break;
                    case 4:
                        MAP[BP.trialNumber].L4.setForeground(Color.YELLOW);
                        break;
                    case 5:
                        MAP[BP.trialNumber].L4.setForeground(Color.PINK);
                        break;
                    case 6:
                        MAP[BP.trialNumber].L4.setForeground(Color.ORANGE);
                        break;
                    default:
                        MAP[BP.trialNumber].L4.setForeground(Color.GRAY);
                        break;
                }
            }
        });
        BP.submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int[] answerArray = {0,0,0,0};
                int[] secretArray = {0,0,0,0};

                int countBlack = 0;
                int countWhite = 0;
                answerArray[0] = CBP.C1.getSelectedIndex();
                answerArray[1] = CBP.C2.getSelectedIndex();
                answerArray[2] = CBP.C3.getSelectedIndex();
                answerArray[3] = CBP.C4.getSelectedIndex();

                secretArray[0] = randomColor.rand1;
                secretArray[1] = randomColor.rand2;
                secretArray[2] = randomColor.rand3;
                secretArray[3] = randomColor.rand4;

                for (int i=0; i!=4; i++) {
                    if (answerArray[i] == secretArray[i]) {
                        countBlack++;
                        answerArray[i] = 10;
                        secretArray[i] = 10;
                    }
                }

                System.out.println("Black: " + countBlack);



                for (int i = 0; i!=4; i++) {
                    for (int j = 0; j!=4; j++) {
                        if ((answerArray[i] != 10) && (secretArray[j] != 10)) {
                            if ((answerArray[i] == secretArray[j])) {
                                countWhite++;
                                answerArray[i] = 10;
                                secretArray[i] = 10;
                            }
                        }
                    }
                }

                System.out.println("White: " + countWhite);

                if (countBlack == 0) {
                    if (countWhite == 1) {
                        Clue[BP.trialNumber].B1.setForeground(Color.WHITE);
                    } else if (countWhite == 2) {
                        Clue[BP.trialNumber].B1.setForeground(Color.WHITE);
                        Clue[BP.trialNumber].B2.setForeground(Color.WHITE);
                    } else if (countWhite == 3) {
                        Clue[BP.trialNumber].B1.setForeground(Color.WHITE);
                        Clue[BP.trialNumber].B2.setForeground(Color.WHITE);
                        Clue[BP.trialNumber].B3.setForeground(Color.WHITE);
                    } else if (countWhite == 4) {
                        Clue[BP.trialNumber].B1.setForeground(Color.WHITE);
                        Clue[BP.trialNumber].B2.setForeground(Color.WHITE);
                        Clue[BP.trialNumber].B3.setForeground(Color.WHITE);
                        Clue[BP.trialNumber].B4.setForeground(Color.WHITE);
                    }
                }

                if (countBlack == 1) {
                    Clue[BP.trialNumber].B1.setForeground(Color.BLACK);

                    if (countWhite == 1) {
                        Clue[BP.trialNumber].B2.setForeground(Color.WHITE);
                    } else if (countWhite == 2) {
                        Clue[BP.trialNumber].B2.setForeground(Color.WHITE);
                        Clue[BP.trialNumber].B3.setForeground(Color.WHITE);
                    } else if (countWhite == 3) {
                        Clue[BP.trialNumber].B2.setForeground(Color.WHITE);
                        Clue[BP.trialNumber].B3.setForeground(Color.WHITE);
                        Clue[BP.trialNumber].B4.setForeground(Color.WHITE);
                    }
                }

                if (countBlack == 2) {
                    Clue[BP.trialNumber].B1.setForeground(Color.BLACK);
                    Clue[BP.trialNumber].B2.setForeground(Color.BLACK);

                    if (countWhite == 1) {
                        Clue[BP.trialNumber].B3.setForeground(Color.WHITE);
                    } else if (countWhite == 2) {
                        Clue[BP.trialNumber].B3.setForeground(Color.WHITE);
                        Clue[BP.trialNumber].B4.setForeground(Color.WHITE);
                    }
                }

                if (countBlack == 3) {
                    Clue[BP.trialNumber].B1.setForeground(Color.BLACK);
                    Clue[BP.trialNumber].B2.setForeground(Color.BLACK);
                    Clue[BP.trialNumber].B3.setForeground(Color.BLACK);

                    if (countWhite == 1) {
                        Clue[BP.trialNumber].B4.setForeground(Color.WHITE);
                    }
                }

                if (countBlack == 4) {
                    Clue[BP.trialNumber].B1.setForeground(Color.BLACK);
                    Clue[BP.trialNumber].B2.setForeground(Color.BLACK);
                    Clue[BP.trialNumber].B3.setForeground(Color.BLACK);
                    Clue[BP.trialNumber].B4.setForeground(Color.BLACK);

                    if (randomColor.rand1 == 1) {
                        SP.S1.setForeground(Color.BLUE);
                    } else if (randomColor.rand1 == 2) {
                        SP.S1.setForeground(Color.GREEN);
                    } else if (randomColor.rand1 == 3) {
                        SP.S1.setForeground(Color.RED);
                    } else if (randomColor.rand1 == 4) {
                        SP.S1.setForeground(Color.YELLOW);
                    } else if (randomColor.rand1 == 5) {
                        SP.S1.setForeground(Color.PINK);
                    } else if (randomColor.rand1 == 6) {
                        SP.S1.setForeground(Color.ORANGE);
                    } else if (randomColor.rand1 == 7) {
                        SP.S1.setForeground(Color.GRAY);
                    }

                    if (randomColor.rand2 == 1) {
                        SP.S2.setForeground(Color.BLUE);
                    } else if (randomColor.rand2 == 2) {
                        SP.S2.setForeground(Color.GREEN);
                    } else if (randomColor.rand2 == 3) {
                        SP.S2.setForeground(Color.RED);
                    } else if (randomColor.rand2 == 4) {
                        SP.S2.setForeground(Color.YELLOW);
                    } else if (randomColor.rand2 == 5) {
                        SP.S2.setForeground(Color.PINK);
                    } else if (randomColor.rand2 == 6) {
                        SP.S2.setForeground(Color.ORANGE);
                    } else if (randomColor.rand2 == 7) {
                        SP.S2.setForeground(Color.GRAY);
                    }

                    if (randomColor.rand3 == 1) {
                        SP.S3.setForeground(Color.BLUE);
                    } else if (randomColor.rand3 == 2) {
                        SP.S3.setForeground(Color.GREEN);
                    } else if (randomColor.rand3 == 3) {
                        SP.S3.setForeground(Color.RED);
                    } else if (randomColor.rand3 == 4) {
                        SP.S3.setForeground(Color.YELLOW);
                    } else if (randomColor.rand3 == 5) {
                        SP.S3.setForeground(Color.PINK);
                    } else if (randomColor.rand3 == 6) {
                        SP.S3.setForeground(Color.ORANGE);
                    } else if (randomColor.rand3 == 7) {
                        SP.S3.setForeground(Color.GRAY);
                    }

                    if (randomColor.rand4 == 1) {
                        SP.S4.setForeground(Color.BLUE);
                    } else if (randomColor.rand4 == 2) {
                        SP.S4.setForeground(Color.GREEN);
                    } else if (randomColor.rand4 == 3) {
                        SP.S4.setForeground(Color.RED);
                    } else if (randomColor.rand4 == 4) {
                        SP.S4.setForeground(Color.YELLOW);
                    } else if (randomColor.rand4 == 5) {
                        SP.S4.setForeground(Color.PINK);
                    } else if (randomColor.rand4 == 6) {
                        SP.S4.setForeground(Color.ORANGE);
                    } else if (randomColor.rand4 == 7) {
                        SP.S4.setForeground(Color.GRAY);
                    }

                    JOptionPane.showMessageDialog(null,"You win!");

                    BP.trialNumber = -1;
                    for (int i=0; i!=10; i++) {
                        MAP[i].resetValue();
                        Clue[i].resetValue();
                    }
                    randomColor.resetValue();

                    SP.resetValue(); // make it gray again
                }

                if (BP.trialNumber < 9) {
                    BP.trialNumber++;
                    CBP.resetValue();

                } else {

                    if (randomColor.rand1 == 1) {
                        SP.S1.setForeground(Color.BLUE);
                    } else if (randomColor.rand1 == 2) {
                        SP.S1.setForeground(Color.GREEN);
                    } else if (randomColor.rand1 == 3) {
                        SP.S1.setForeground(Color.RED);
                    } else if (randomColor.rand1 == 4) {
                        SP.S1.setForeground(Color.YELLOW);
                    } else if (randomColor.rand1 == 5) {
                        SP.S1.setForeground(Color.PINK);
                    } else if (randomColor.rand1 == 6) {
                        SP.S1.setForeground(Color.ORANGE);
                    } else if (randomColor.rand1 == 7) {
                        SP.S1.setForeground(Color.GRAY);
                    }

                    if (randomColor.rand2 == 1) {
                        SP.S2.setForeground(Color.BLUE);
                    } else if (randomColor.rand2 == 2) {
                        SP.S2.setForeground(Color.GREEN);
                    } else if (randomColor.rand2 == 3) {
                        SP.S2.setForeground(Color.RED);
                    } else if (randomColor.rand2 == 4) {
                        SP.S2.setForeground(Color.YELLOW);
                    } else if (randomColor.rand2 == 5) {
                        SP.S2.setForeground(Color.PINK);
                    } else if (randomColor.rand2 == 6) {
                        SP.S2.setForeground(Color.ORANGE);
                    } else if (randomColor.rand2 == 7) {
                        SP.S2.setForeground(Color.GRAY);
                    }

                    if (randomColor.rand3 == 1) {
                        SP.S3.setForeground(Color.BLUE);
                    } else if (randomColor.rand3 == 2) {
                        SP.S3.setForeground(Color.GREEN);
                    } else if (randomColor.rand3 == 3) {
                        SP.S3.setForeground(Color.RED);
                    } else if (randomColor.rand3 == 4) {
                        SP.S3.setForeground(Color.YELLOW);
                    } else if (randomColor.rand3 == 5) {
                        SP.S3.setForeground(Color.PINK);
                    } else if (randomColor.rand3 == 6) {
                        SP.S3.setForeground(Color.ORANGE);
                    } else if (randomColor.rand3 == 7) {
                        SP.S3.setForeground(Color.GRAY);
                    }

                    if (randomColor.rand4 == 1) {
                        SP.S4.setForeground(Color.BLUE);
                    } else if (randomColor.rand4 == 2) {
                        SP.S4.setForeground(Color.GREEN);
                    } else if (randomColor.rand4 == 3) {
                        SP.S4.setForeground(Color.RED);
                    } else if (randomColor.rand4 == 4) {
                        SP.S4.setForeground(Color.YELLOW);
                    } else if (randomColor.rand4 == 5) {
                        SP.S4.setForeground(Color.PINK);
                    } else if (randomColor.rand4 == 6) {
                        SP.S4.setForeground(Color.ORANGE);
                    } else if (randomColor.rand4 == 7) {
                        SP.S4.setForeground(Color.GRAY);
                    }

                    JOptionPane.showMessageDialog(null, "You lose!");

                    BP.trialNumber = 0;
                    for (int i=0; i!=10; i++) {
                        MAP[i].resetValue();
                        Clue[i].resetValue();
                    }
                    randomColor.resetValue();
                    SP.resetValue(); // make it gray again
                }

            }
        });
        BP.exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }



    public static void main(String[] args) {
        MasterMind runProgram = new MasterMind();
    }
}