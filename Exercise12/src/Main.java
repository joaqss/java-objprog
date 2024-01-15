import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    JFrame mainFrame = new JFrame("TimeSample");
    RoamPanel mainRoamPanel = new RoamPanel();

    public Main() {

        mainFrame.setSize(1280,720);
        mainFrame.setResizable(false);
        mainFrame.setLayout(null);

        mainRoamPanel.panel.setBounds(30,0,1280,710);
        mainFrame.add(mainRoamPanel.panel);

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);

        mainRoamPanel.right.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainRoamPanel.move('R');
            }
        });

        mainRoamPanel.left.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainRoamPanel.move('L');
            }
        });

        mainRoamPanel.up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainRoamPanel.move('U');
            }
        });

        mainRoamPanel.down.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainRoamPanel.move('D');
            }
        });
        mainRoamPanel.stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainRoamPanel.move('S');
            }
        });




    }
    public static void main(String[] args) {

        Main runProgram = new Main();
    }
}