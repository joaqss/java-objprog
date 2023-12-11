import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// class
public class Main {

    // method of class
    public static void main(String[] args) {
        System.out.println("Hello.");
        System.out.println("Running the program\n");
        // run();
        Jframetest();

    }

    static JFrame mainWindow;
    static JPanel panel1;
    static JButton button1, button2, button3;

    private static void Jframetest() {
        mainWindow = new JFrame("Four in a Row");
        mainWindow.getContentPane().setBackground(Color.YELLOW);
        JLabel title = new JLabel("Test title");
        button1 = new JButton("Button1");
        button2 = new JButton("Button2");
        button3 = new JButton("Button2");


        // FRAME SETTINGS
        mainWindow.setLayout(new GridLayout(2,5));
        mainWindow.setBounds(100,100,1000,600);
        mainWindow.setLocation(500,100);


        // add
        mainWindow.add(title, "Center");
        mainWindow.add(button1,"North");
        mainWindow.add(button2, "East");
        mainWindow.add(button3, "West");

        button1.setBackground(Color.BLUE);
        button2.setBackground(Color.GREEN);
        button3.setBackground(Color.RED);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button1.setBackground(Color.MAGENTA);
            }
        });


        mainWindow.setVisible(true);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
/*
    private static void run(){
        boolean bool = true;

        do {
            Object[] options = {"Yes", "No"};
            int number1 = Integer.parseInt(JOptionPane.showInputDialog("Enter number 1: ", "###"));
            int number2 = Integer.parseInt(JOptionPane.showInputDialog("Enter number 2: ", "###"));
            int calculate = number1 + number2;
            System.out.println("Calculated number: " + calculate);

            JOptionPane.showMessageDialog(null, "Your added numbers are: " + calculate);
            System.out.println("Print the dialog for added numbers.");

            int choice2 = JOptionPane.showOptionDialog(null, "Do you still want to add?", "Choose an Option", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
            System.out.println("Show message dialog for options to continue or not.");

            if (choice2 == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Thank you! Good bye.");
                System.out.println("Ending the program.\n");
                bool = false;
            }

            else {
                System.out.println("Program will be continued.\n\n");
            }

        } while (bool == true);

    }

 */
}