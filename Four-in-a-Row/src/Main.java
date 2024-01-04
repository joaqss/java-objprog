import javax.swing.*;

public class Main {

    JFrame mainFrame = new JFrame("Four in a Row - Java Edition");

    public Main() {

        mainFrame.setSize(1000,800);

        // logo
        ImageIcon gameLogo = new ImageIcon("Four-in-a-Row/Images/mainlogo.png");
        mainFrame.setIconImage(gameLogo.getImage());

        mainFrame.setLocationRelativeTo(null); // center the window
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }


    public static void main(String[] args) {
        Main runGame = new Main();
    }
}