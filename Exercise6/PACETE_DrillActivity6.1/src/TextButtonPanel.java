import javax.swing.*;
import java.awt.*;

public class TextButtonPanel {
    JPanel mainTBP, panel, panel2;
    JLabel mainTitle, convertToTitle;

    JButton inch, meter;
    public TextButtonPanel() {
        // main panel for TBP
        mainTBP = new JPanel();
        mainTBP.setLayout(new GridLayout(2,1,1,1));
        mainTBP.setBackground(Color.white);

        // PANEL 1
        panel = new JPanel();
        panel.setLayout(new GridLayout(2,1));
        panel.setBackground(Color.white);

        mainTitle = new JLabel("Unit Converter");
        convertToTitle = new JLabel("convert to");
        mainTitle.setHorizontalAlignment(JLabel.CENTER);
        convertToTitle.setHorizontalAlignment(JLabel.CENTER);

        // presets
        mainTitle.setFont(new Font("Arial", Font.BOLD, 25));
        mainTitle.setForeground(new java.awt.Color(252,189,117));
        convertToTitle.setFont(new Font("Arial", Font.BOLD, 17));
        convertToTitle.setForeground(new java.awt.Color(252,189,117));

        panel.add(mainTitle);
        panel.add(convertToTitle);


        // PANEL 2
        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1,2));
        panel2.setBackground(Color.white);
        inch = new JButton("inch");
        meter = new JButton("meter");

        // presets
        inch.setOpaque(false);
        inch.setContentAreaFilled(false);
        inch.setBorderPainted(false);
        inch.setFont(new Font("Arial", Font.PLAIN, 14));
        meter.setOpaque(false);
        meter.setContentAreaFilled(false);
        meter.setBorderPainted(false);
        meter.setFont(new Font("Arial", Font.PLAIN, 14));

        panel2.add(inch);
        panel2.add(meter);


        // To end
        mainTBP.setBorder(javax.swing.BorderFactory.createEmptyBorder(20,0,0,0));
        mainTBP.add(panel);
        mainTBP.add(panel2);

    }

}
