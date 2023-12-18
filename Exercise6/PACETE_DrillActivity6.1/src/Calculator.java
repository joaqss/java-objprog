import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Calculator {

    TextButtonPanel TBP;

    TextFieldPanel TFP;

    JButton convert, clear;
    public Calculator() {
        // Main Frame
        JFrame mainWindow = new JFrame("Unit Converter");
        mainWindow.setSize(300,500);
        mainWindow.setLayout(new FlowLayout());
        mainWindow.setResizable(false);
        mainWindow.getContentPane().setBackground(Color.white);

        // Add Text Button Panel
        TBP = new TextButtonPanel();
        mainWindow.add(TBP.mainTBP);

        // Add Text Field Panel
        TFP = new TextFieldPanel();
        mainWindow.add(TFP.mainTFP);

        // Button to Convert
        convert = new JButton("Convert");
        convert.setHorizontalAlignment(JButton.CENTER);
        clear = new JButton("Clear");

            // presets for convert and clear button
            convert.setBackground(new java.awt.Color(252,189,117));
            convert.setForeground(Color.WHITE);
            convert.setFont(new Font("Arial", Font.BOLD, 14));
            convert.setBorderPainted(false);
            //convert.set(new Insets(20,20,20,20));
            clear.setBackground(new java.awt.Color(252,189,117));
            clear.setForeground(Color.WHITE);
            clear.setFont(new Font("Arial", Font.BOLD, 14));
            clear.setBorderPainted(false);

        mainWindow.add(convert);
        mainWindow.add(clear);




        actionListeners(TBP, TFP, convert, clear);
        mainWindow.setVisible(true);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionListeners(TextButtonPanel TBP, TextFieldPanel TFP, JButton convert, JButton clear) {

        final boolean[] convertToInch = {false};
        final boolean[] convertToMeter = {false};

        TBP.inch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TBP.inch.setFont(TBP.inch.getFont().deriveFont(Font.BOLD));
                TBP.meter.setFont(TBP.meter.getFont().deriveFont(Font.PLAIN));
                convertToMeter[0] = false;
                convertToInch[0] = true;
                TFP.disableMeter();

            }
        });

        TBP.meter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TBP.meter.setFont(TBP.meter.getFont().deriveFont(Font.BOLD));
                TBP.inch.setFont(TBP.inch.getFont().deriveFont(Font.PLAIN));
                convertToInch[0] = false;
                convertToMeter[0] = true;
                TFP.disableInch();
            }
        });

        DecimalFormat df = new DecimalFormat("0.00");

        convert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (convertToInch[0]) {
                    double meter = Double.parseDouble(TFP.meterTextField.getText());
                    double in = (meter / 0.0254);
                    TFP.inchTextField.setText(df.format(in));
                    System.out.println("Working!");
                }

                if (convertToMeter[0]) {
                    double in = Double.parseDouble(TFP.inchTextField.getText());
                    double meter = (in * 0.0254);
                    TFP.meterTextField.setText(df.format(meter));
                }
            }
        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TFP.inchTextField.setText(df.format(0));
                TFP.meterTextField.setText(df.format(0));
            }
        });


    }

    public static void main(String[] args) {

        Calculator startProgram = new Calculator();

    }
}