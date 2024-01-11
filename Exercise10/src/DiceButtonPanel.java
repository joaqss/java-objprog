import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DiceButtonPanel {
    JPanel panel;
    DiceLabel diceOne, diceTwo, diceThree, diceFour, diceFive, diceSix;
    JLabel diceInfo;

    public DiceButtonPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setOpaque(false);

        diceOne = new DiceLabel(1);
        diceTwo = new DiceLabel(2);
        diceThree = new DiceLabel(3);
        diceFour = new DiceLabel(4);
        diceFive = new DiceLabel(5);
        diceSix = new DiceLabel(6);

        diceInfo = new JLabel("The button clicked will be displayed here...", JLabel.CENTER);
        diceInfo.setForeground(Color.WHITE);

        diceOne.lbDice.setBounds(0,0,150,150);
        diceTwo.lbDice.setBounds(160,0,150,150);
        diceThree.lbDice.setBounds(320,0,150,150);
        diceFour.lbDice.setBounds(480,0,150,150);
        diceFive.lbDice.setBounds(640,0,150,150);
        diceSix.lbDice.setBounds(800,0,150,150);

        diceInfo.setBounds(0, 150, 920,20);

        panel.add(diceOne.lbDice);
        panel.add(diceTwo.lbDice);
        panel.add(diceThree.lbDice);
        panel.add(diceFour.lbDice);
        panel.add(diceFive.lbDice);
        panel.add(diceSix.lbDice);
        panel.add(diceInfo);


        diceOne.lbDice.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getButton() == MouseEvent.BUTTON1) {
                    diceInfo.setText("Left Button  is clicked!");
                }

                else if (e.getButton() == MouseEvent.BUTTON3) {
                    diceInfo.setText("Right Button  is clicked!");
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {
                diceOne.lbDice.setBounds(0,150,150,150);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                diceOne.lbDice.setBounds(0,0,150,150);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                diceInfo.setText("Mouse is on button 1");

            }

            @Override
            public void mouseExited(MouseEvent e) {
                diceInfo.setText("The mouse exited from button 1");

            }
        });

        diceTwo.lbDice.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getButton() == MouseEvent.BUTTON1) {
                    diceInfo.setText("Left Button  is clicked!");
                }

                else if (e.getButton() == MouseEvent.BUTTON3) {
                    diceInfo.setText("Right Button  is clicked!");
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {
                diceTwo.lbDice.setBounds(160,150,150,150);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                diceTwo.lbDice.setBounds(160,0,150,150);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                diceInfo.setText("Mouse is on button 2");

            }

            @Override
            public void mouseExited(MouseEvent e) {
                diceInfo.setText("The mouse exited from button 2");

            }
        });

        diceThree.lbDice.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getButton() == MouseEvent.BUTTON1) {
                    diceInfo.setText("Left Button  is clicked!");
                }

                else if (e.getButton() == MouseEvent.BUTTON3) {
                    diceInfo.setText("Right Button  is clicked!");
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {
                diceThree.lbDice.setBounds(320,150,150,150);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                diceThree.lbDice.setBounds(320,0,150,150);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                diceInfo.setText("Mouse is on button 3");

            }

            @Override
            public void mouseExited(MouseEvent e) {
                diceInfo.setText("The mouse exited from button 3");

            }
        });

        diceFour.lbDice.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getButton() == MouseEvent.BUTTON1) {
                    diceInfo.setText("Left Button  is clicked!");
                }

                else if (e.getButton() == MouseEvent.BUTTON3) {
                    diceInfo.setText("Right Button  is clicked!");
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {
                diceFour.lbDice.setBounds(480,150,150,150);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                diceFour.lbDice.setBounds(480,0,150,150);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                diceInfo.setText("Mouse is on button 4");

            }

            @Override
            public void mouseExited(MouseEvent e) {
                diceInfo.setText("The mouse exited from button 4");

            }
        });

        diceFive.lbDice.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getButton() == MouseEvent.BUTTON1) {
                    diceInfo.setText("Left Button  is clicked!");
                }

                else if (e.getButton() == MouseEvent.BUTTON3) {
                    diceInfo.setText("Right Button  is clicked!");
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {
                diceFive.lbDice.setBounds(640,150,150,150);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                diceFive.lbDice.setBounds(640,0,150,150);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                diceInfo.setText("Mouse is on button 5");

            }

            @Override
            public void mouseExited(MouseEvent e) {
                diceInfo.setText("The mouse exited from button 5");

            }
        });

        diceSix.lbDice.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getButton() == MouseEvent.BUTTON1) {
                    diceInfo.setText("Left Button  is clicked!");
                }

                else if (e.getButton() == MouseEvent.BUTTON3) {
                    diceInfo.setText("Right Button  is clicked!");
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {
                diceSix.lbDice.setBounds(800,150,150,150);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                diceSix.lbDice.setBounds(800,0,150,150);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                diceInfo.setText("Mouse is on button 6");

            }

            @Override
            public void mouseExited(MouseEvent e) {
                diceInfo.setText("The mouse exited from button 6");

            }
        });

    }


}
