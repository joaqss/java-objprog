import javax.swing.*;
import java.awt.*;

public class WinningBanner {

    JPanel panel = new JPanel();
    JLabel labelStatus;

    public WinningBanner() {

        labelStatus = new JLabel("Place your bet!");
        panel.add(labelStatus);

    }
}
