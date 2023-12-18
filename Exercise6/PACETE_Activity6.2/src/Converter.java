import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Converter {
    JFrame mainWindow;
    TextPanel MTP;
    RadioButtonPanel MRBP;
    ButtonPanel MBP;
    public Converter() {

        mainWindow = new JFrame("Temperature Converter");
        MTP = new TextPanel(); // main text panel
        MRBP = new RadioButtonPanel(); // main radio button panel
        MBP = new ButtonPanel(); // main button panel

        // default layout
        mainWindow.setLayout(new FlowLayout());
        mainWindow.setSize(300, 300);
        mainWindow.setResizable(false);

        // add panels
        mainWindow.add(MTP.panel);
        mainWindow.add(MRBP.panel);
        mainWindow.add(MBP.panel);

        MRBP.RB1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MTP.TextEnableF();
            }
        });

        MRBP.RB2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MTP.TextEnableC();
            }
        });

        DecimalFormat df = new DecimalFormat("0.00"); // 2 decimal places only

        MBP.convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (MRBP.RB1.isSelected()) {
                    double F = Double.parseDouble(MTP.fahrenheitTextField.getText()); // convert string to double
                    Double C = (F-32) / 1.8;
                    MTP.celsiusTextField.setText(df.format(C));
                }

                if (MRBP.RB2.isSelected()) {
                    double C = Double.parseDouble(MTP.celsiusTextField.getText()); // convert string to double
                    double F = C * 1.8 + 32;
                    MTP.fahrenheitTextField.setText(df.format(F));


                }
            }
        });

        MBP.exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // indicates successful termination
            }
        });

        // as a close-off
        mainWindow.setVisible(true);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        // run method
        Converter startConverter = new Converter();


    }
}