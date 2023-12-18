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

    public MasterMind() {
        mainFrame.setLayout(null);
        mainFrame.setLocation(400,0);
        mainFrame.setSize(350,700);

        // Answer Panel
        MAP = new AnswerPanel[10];
        for (int j=0; j!=10; j++) {
            MAP[j] = new AnswerPanel();
            MAP[j].AnsPanel.setBounds(20, y_axis, 220,40);
            mainFrame.add(MAP[j].AnsPanel);
            y_axis = y_axis+45;
        }

        // Clue Panel
        Clue = new CluePanel[10];
        for (int c=0; c!=10; c++) {
            Clue[c] = new CluePanel();
            Clue[c].cpPanel.setBounds(250, y_axis2, 40,40);
            mainFrame.add(Clue[c].cpPanel);
            y_axis2 = y_axis2+45;
        }

        // Combo Box
        CBP = new ComboBoxPanel();
        CBP.comboBPanel.setBounds(20,470,300,50);
        mainFrame.add(CBP.comboBPanel);

        // Button Panel
        BP = new ButtonPanel();
        BP.buttonPanel.setBounds(20,520,300,40);
        mainFrame.add(BP.buttonPanel);

        // Secret Panel
        SP = new SecretPanel();
        SP.secretPanel.setBounds(20,580,220,40);
        mainFrame.add(SP.secretPanel);

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
    public static void main(String[] args) {
        MasterMind runProgram = new MasterMind();
    }
}