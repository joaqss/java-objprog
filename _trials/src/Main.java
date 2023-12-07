import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;

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
    static JButton button1, button2;

    private static void Jframetest() {
        mainWindow = new JFrame("Four in a Row");

        // JFRAME is a subclass of Container. With JFRAME, you can resize,
        Container pane = mainWindow.getContentPane();
        pane.setLayout(new FlowLayout());
        pane.setBackground(Color.GREEN);

        JLabel title = new JLabel("Test title");

        button1 = new JButton("Button1");
        button2 = new JButton("Button2");

        // add panel to frame

        pane.add(title);
        pane.add(button1);
        pane.add(button2);

        // FRAME SETTINGS
        mainWindow.setSize(1000, 800);
        mainWindow.setLocation(500,300);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setVisible(true);

        // LABEL SETTINGS
        button1.setBounds(250, 200, 100, 100);
        button1.setSize(200, 50);
        button1.setBackground(Color.CYAN);

        button2.setBounds(450, 200, 100, 100);
        button2.setSize(200, 50);
        button2.setBackground(Color.GREEN);



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