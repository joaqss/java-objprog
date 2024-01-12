import javax.swing.*;
import java.awt.*;

public class HomePage {

    JPanel panelLandingPage = new JPanel();
    JPanel panelHomePage = new JPanel();
    JLabel mainTitle;

    public HomePage() {
        mainTitle = new JLabel("Four in a Row");
        mainTitle.setFont(new Font("pixelmix", Font.BOLD, 70));

        panelLandingPage.setOpaque(false);
        panelLandingPage.add(mainTitle);


    }
}
