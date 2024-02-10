
import org.opencv.core.Core;

import javax.swing.*;

public class Main {
    public Main() {

        JFrame mainFrame = new JFrame("Camera");
        Camera mainCameraClass = new Camera();

        mainFrame.add(mainCameraClass.startCamera());

        mainFrame.setSize(640, 560);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);


    }

    public static void main(String[] args) {
        new Main();
    }
}