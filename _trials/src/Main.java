import javax.swing.JOptionPane;

// class
public class Main {

    // method of class
    public static void main(String[] args) {
        System.out.println("Hello.");
        System.out.println("Running the program\n");
        run();

    }

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
}