
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    JFrame mainFrame = new JFrame("Big and small");
    CashPanel mainCashPanel = new CashPanel();
    RadioButtonPanel mainRadioButtonPanel = new RadioButtonPanel();
    BetPanel mainBetPanel = new BetPanel();
    WinningBanner mainWinningBanner = new WinningBanner();
    ButtonPanel mainButtonPanel = new ButtonPanel();
    DicePanel DicePanel1 = new DicePanel();
    DicePanel DicePanel2 = new DicePanel();
    DicePanel DicePanel3 = new DicePanel();
    Randomizer rand1, rand2, rand3;

    public Main() {

        mainFrame.setLayout(null);
        mainFrame.setLocation(400,20);
        mainFrame.setSize(510,420);
        mainFrame.setResizable(false);

        mainCashPanel.panel.setBounds(20,20,450,40);
        mainFrame.add(mainCashPanel.panel);

        mainRadioButtonPanel.panel.setBounds(10,70,100,100);
        mainFrame.add(mainRadioButtonPanel.panel);

        mainBetPanel.panel.setBounds(130,70,340,60);
        mainFrame.add(mainBetPanel.panel);

        mainWinningBanner.panel.setBounds(10,130,480,40);
        mainFrame.add(mainWinningBanner.panel);

        mainButtonPanel.panel.setBounds(0,170,500,40);
        mainFrame.add(mainButtonPanel.panel);

        DicePanel1.panel.setBounds(10,210,150,150);
        mainFrame.add(DicePanel1.panel);

        DicePanel2.panel.setBounds(170,210,150,150);
        mainFrame.add(DicePanel2.panel);

        DicePanel3.panel.setBounds(330,210,150,150);
        mainFrame.add(DicePanel3.panel);

        // "Roll" Button clicked
        mainButtonPanel.rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (mainRadioButtonPanel.highRB.isSelected() && mainRadioButtonPanel.lowRB.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Select one button only!");
                    mainRadioButtonPanel.highRB.setSelected(false);
                    mainRadioButtonPanel.lowRB.setSelected(false);
                }

                else if (!mainRadioButtonPanel.highRB.isSelected() && !mainRadioButtonPanel.lowRB.isSelected()) {
                    JOptionPane.showMessageDialog(null, "No button has been selected!");
                    mainRadioButtonPanel.highRB.setSelected(false);
                    mainRadioButtonPanel.lowRB.setSelected(false);
                }

                else {
                    // instantiate randomizer
                    rand1 = new Randomizer();
                    rand2 = new Randomizer();
                    rand3 = new Randomizer();

                    // call out changeIcon void from DicePanel.java
                    DicePanel1.changeIcon(rand1.x);
                    DicePanel2.changeIcon(rand2.x);
                    DicePanel3.changeIcon(rand3.x);

                    // check selected.
                    int totalDice = rand1.x + rand2.x + rand3.x;

                    if ((mainRadioButtonPanel.highRB.isSelected()) && (totalDice >= 11 && totalDice <= 18)) {
                        mainWinningBanner.labelStatus.setText("Total Dice is " + totalDice + ". HIGH. You win!!!");
                        mainCashPanel.yourCash += Double.parseDouble(mainBetPanel.enterBet.getText());
                        mainCashPanel.cash.setText(Double.toString(mainCashPanel.yourCash));
                    }

                    if ((mainRadioButtonPanel.lowRB.isSelected()) && (totalDice >= 11 && totalDice <= 18)) {
                        mainWinningBanner.labelStatus.setText("Total Dice is " + totalDice + ". LOW. You lose!!!");
                        mainCashPanel.yourCash -= Double.parseDouble(mainBetPanel.enterBet.getText());
                        mainCashPanel.cash.setText(Double.toString(mainCashPanel.yourCash));
                    }

                    if ((mainRadioButtonPanel.lowRB.isSelected()) && (totalDice >= 3 && totalDice <= 10)) {
                        mainWinningBanner.labelStatus.setText("Total Dice is " + totalDice + ". LOW. You win!!!");
                        mainCashPanel.yourCash += Double.parseDouble(mainBetPanel.enterBet.getText());
                        mainCashPanel.cash.setText(Double.toString(mainCashPanel.yourCash));
                    }
                    if ((mainRadioButtonPanel.highRB.isSelected()) && (totalDice >= 3 && totalDice <= 10)) {
                        mainWinningBanner.labelStatus.setText("Total Dice is " + totalDice + ". LOW. You lose!!!");
                        mainCashPanel.yourCash -= Double.parseDouble(mainBetPanel.enterBet.getText());
                        mainCashPanel.cash.setText(Double.toString(mainCashPanel.yourCash));
                    }
                }
                // check cash
                if (mainCashPanel.yourCash == 0) {
                    JOptionPane.showMessageDialog(null,"Game over! You have no cash left.");
                    System.exit(0);
                }

            }
        });

        mainButtonPanel.exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Main runProgram = new Main();
    }
}