import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public Main() {
        JFrame mainWindow = new JFrame("GridLayout Test");
        mainWindow.setSize(300, 100);
        mainWindow.setLayout(new GridLayout(2,3));

        JButton red, green, blue, yellow, pink, magenta;

        red = new JButton("Red");
        green = new JButton("Green");
        blue = new JButton("Blue");
        yellow = new JButton("Yellow");
        pink = new JButton("Pink");
        magenta = new JButton("Purple");

        mainWindow.add(red);
        mainWindow.add(green);
        mainWindow.add(blue);
        mainWindow.add(yellow);
        mainWindow.add(pink);
        mainWindow.add(magenta);

        changeColor(red, green, blue, yellow, pink, magenta);

        mainWindow.setVisible(true);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void changeColor(JButton red, JButton green, JButton blue, JButton yellow,
                            JButton pink, JButton magenta)
    {
        red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                red.setBackground(Color.red);
            }
        });

        green.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                green.setBackground(Color.green);
            }
        });

        blue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                blue.setBackground(Color.BLUE);
            }
        });

        yellow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                yellow.setBackground(Color.YELLOW);
            }
        });

        pink.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pink.setBackground(Color.pink);
            }
        });

        magenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                magenta.setBackground(Color.magenta);
            }
        });
    }

    public static void main(String[] args) {
        Main startProgram = new Main();

    }
}