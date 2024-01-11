import javax.swing.*;

public class Main {

    JFrame mainFrame = new JFrame("Label Button");
    ImageIcon mainBg;
    JLabel lbMainBg;
    DiceButtonPanel mainDiceButtonPanel;

    public Main() {
        mainFrame.setSize(960,540);
        mainFrame.setResizable(false);


        mainBg = new ImageIcon("Exercise10/Images/bg.png");
        lbMainBg = new JLabel(mainBg);
        mainFrame.setContentPane(lbMainBg);

        mainDiceButtonPanel = new DiceButtonPanel();
        mainDiceButtonPanel.panel.setBounds(0,0,940,300);
        mainFrame.add(mainDiceButtonPanel.panel);



        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);


    }


    public static void main(String[] args) {
        Main startProgram = new Main();
    }
}