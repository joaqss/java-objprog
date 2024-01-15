import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoamPanel implements ActionListener {

    JPanel panel = new JPanel();
    ImageIcon circle = new ImageIcon("Exercise12/Images/circle.png");
    JLabel lbCircle, lbMovingArea, lbCircle2;
    JButton up, down, left, right, stop;
    Timer myTimer;
    int x = 0;
    int y = 0;
    char direction;
    boolean initial = false;
    ImageIcon black30, black60, black80, white30, white60, white80, white;

    public RoamPanel() {
        panel.setLayout(null);
        lbCircle = new JLabel();
        lbMovingArea = new JLabel();
        up = new JButton("Move Up");
        down = new JButton("Move Down");
        left = new JButton("Move Left");
        right = new JButton("Move Right");
        stop = new JButton("Stop");

        lbCircle2 = new JLabel();
        black30 = new ImageIcon("Exercise12/Images/black30png.png");
        black60 = new ImageIcon("Exercise12/Images/black60png.png");
        black80 = new ImageIcon("Exercise12/Images/black80png.png");
        white30 = new ImageIcon("Exercise12/Images/white30png.png");
        white60 = new ImageIcon("Exercise12/Images/white60png.png");
        white80 = new ImageIcon("Exercise12/Images/white80png.png");
        white = new ImageIcon("Exercise12/Images/whitepng.png");

        lbCircle2.setBounds(400,520,40,40);
        panel.add(lbCircle2);


        lbMovingArea.setBounds(0,0,1200,500);
        lbMovingArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        up.setBounds(80,520,100,40);
        left.setBounds(40,560,100,40);
        right.setBounds(140,560,100,40);
        down.setBounds(80,600,100,40);
        stop.setBounds(800,520,100,40);
        lbCircle.setIcon(circle);
        lbCircle.setBounds(x,y,40,40);

        panel.add(lbMovingArea);
        panel.add(up);
        panel.add(down);
        panel.add(left);
        panel.add(right);
        panel.add(stop);
        panel.add(lbCircle);
    }



    public void move(char direction) {

        if (!this.initial) {
            myTimer = new Timer(1, this); // this means dito daw siya sa class na to nakikinig
        }

        this.initial = true;
        this.direction = direction;
        myTimer.start();
    }

    public void actionPerformed(ActionEvent e) {

        if (((x > 1160) ||  x < 0) || ((y > 460 || y < 0))) {
            myTimer.stop();

            this.initial = false;

            if (x < 0){
                x = 0;
            }
            if (x>1160) {
                x=1160;
            }

            if(y<0) {
                y = 0;
            }

            if (y>460) {
                y = 460;
            }

        } else {
            if (this.direction == 'R') {
                x++;
                int z = (x%8);
                switch (z) {
                    case 0:
                        lbCircle2.setIcon(black30);
                        break;
                    case 1:
                        lbCircle2.setIcon(black60);
                        break;
                    case 2:
                        lbCircle2.setIcon(black80);
                        break;
                    case 3:
                        lbCircle2.setIcon(white80);
                        break;
                    case 4:
                        lbCircle2.setIcon(white60);
                        break;
                    case 5:
                        lbCircle2.setIcon(white30);
                        break;
                    case 6:
                        lbCircle2.setIcon(white);
                        break;
                }
            }

            else if (this.direction == 'L') {
                x--;
                int z = (x%8);
                switch (z) {
                    case 0:
                        lbCircle2.setIcon(black30);
                        break;
                    case 1:
                        lbCircle2.setIcon(black60);
                        break;
                    case 2:
                        lbCircle2.setIcon(black80);
                        break;
                    case 3:
                        lbCircle2.setIcon(white80);
                        break;
                    case 4:
                        lbCircle2.setIcon(white60);
                        break;
                    case 5:
                        lbCircle2.setIcon(white30);
                        break;
                    case 6:
                        lbCircle2.setIcon(white);
                        break;
                }
            }

            else if (this.direction == 'U') {
                y--;
                int z = (y%8);
                switch (z) {
                    case 0:
                        lbCircle2.setIcon(black30);
                        break;
                    case 1:
                        lbCircle2.setIcon(black60);
                        break;
                    case 2:
                        lbCircle2.setIcon(black80);
                        break;
                    case 3:
                        lbCircle2.setIcon(white80);
                        break;
                    case 4:
                        lbCircle2.setIcon(white60);
                        break;
                    case 5:
                        lbCircle2.setIcon(white30);
                        break;
                    case 6:
                        lbCircle2.setIcon(white);
                        break;
                }
            }

            else if (this.direction == 'D') {
                y++;
                int z = (y%8);
                switch (z) {
                    case 0:
                        lbCircle2.setIcon(black30);
                        break;
                    case 1:
                        lbCircle2.setIcon(black60);
                        break;
                    case 2:
                        lbCircle2.setIcon(black80);
                        break;
                    case 3:
                        lbCircle2.setIcon(white80);
                        break;
                    case 4:
                        lbCircle2.setIcon(white60);
                        break;
                    case 5:
                        lbCircle2.setIcon(white30);
                        break;
                    case 6:
                        lbCircle2.setIcon(white);
                        break;
                }
            }

            else if (this.direction == 'S') {
                myTimer.stop();
            }
        }

        lbCircle.setBounds(x,y,40,40);

    }
}
