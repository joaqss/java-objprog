import javax.swing.*;
import java.awt.*;

public class ImagePanel {
    JPanel panel = new JPanel();
    JLabel lbComputerImages = new JLabel();
    JLabel lbPlayerImages = new JLabel();
    ImageIcon[] images = new ImageIcon[4];

    public ImagePanel() {

        images[0] = new ImageIcon("Exercise11/Images/Rock.png");
        images[1] = new ImageIcon("Exercise11/Images/paper.png");
        images[2] = new ImageIcon("Exercise11/Images/scissors.png");
        images[3] = new ImageIcon("Exercise11/Images/none.png");

        lbPlayerImages.setIcon(images[0]);
        lbComputerImages.setIcon(images[3]);

        panel.add(lbPlayerImages);
        panel.add(lbComputerImages);


    }

}
