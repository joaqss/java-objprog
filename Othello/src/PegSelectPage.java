import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PegSelectPage {
    JPanel panelChoosePick = new JPanel();
    ImageIcon playerPickColor, darkPeg, lightPeg, darkPeg2, lightPeg2;
    JLabel lbPlayerPickColor, lbDarkPeg, lbLightPeg, lbDarkPeg2, lbLightPeg2,
            playerPickTitle, player1Title, player2Title;

    public PegSelectPage() {

        panelChoosePick.setLayout(null);
        panelChoosePick.setOpaque(false);

        lbPlayerPickColor = new JLabel();
        playerPickColor = new ImageIcon("Othello/Images/PegSelectPage/playerPickColor.png");
        Image dabPlayerPickColor = playerPickColor.getImage();
        Image modifiedPlayerPickColor = dabPlayerPickColor.getScaledInstance(1300, 600, Image.SCALE_REPLICATE);
        playerPickColor = new ImageIcon(modifiedPlayerPickColor);
        lbPlayerPickColor.setIcon(playerPickColor);
        lbPlayerPickColor.setBounds(320,200,1300,600);

        playerPickTitle = new JLabel("Choose your Peg!");
        playerPickTitle.setFont(new Font("Dogica Pixel", Font.BOLD, 35));
        playerPickTitle.setForeground(Color.BLACK);
        playerPickTitle.setBounds(720,250,700,100);

        player1Title = new JLabel("Player 1");
        player1Title.setFont(new Font("Dogica Pixel", Font.BOLD, 28));
        player1Title.setForeground(Color.BLACK);
        player1Title.setBounds(870,300,700,100);

        player2Title = new JLabel("Player 2");
        player2Title.setFont(new Font("Dogica Pixel", Font.BOLD, 28));
        player2Title.setForeground(Color.BLACK);
        player2Title.setBounds(870,500,700,100);

        lbDarkPeg = new JLabel();
        darkPeg = new ImageIcon("Othello/Images/PegSelectPage/Pegs/darkPeg.png");
        Image dabDarkPeg = darkPeg.getImage();
        Image modifiedDarkPeg = dabDarkPeg.getScaledInstance(90, 90, Image.SCALE_REPLICATE);
        darkPeg = new ImageIcon(modifiedDarkPeg);
        lbDarkPeg.setIcon(darkPeg);
        lbDarkPeg.setBounds(850,400,90,90);

        lbLightPeg = new JLabel();
        lightPeg = new ImageIcon("Othello/Images/PegSelectPage/Pegs/lightPeg.png");
        Image dabLightPeg = lightPeg.getImage();
        Image modifiedLightPeg = dabLightPeg.getScaledInstance(90, 90, Image.SCALE_REPLICATE);
        lightPeg = new ImageIcon(modifiedLightPeg);
        lbLightPeg.setIcon(lightPeg);
        lbLightPeg.setBounds(1000,400,90,90);

        lbDarkPeg2 = new JLabel();
        darkPeg2 = new ImageIcon("Othello/Images/PegSelectPage/Pegs/darkPeg.png");
        Image dabDarkPeg2 = darkPeg.getImage();
        Image modifiedDarkPeg2 = dabDarkPeg2.getScaledInstance(90, 90, Image.SCALE_REPLICATE);
        darkPeg2 = new ImageIcon(modifiedDarkPeg2);
        lbDarkPeg2.setIcon(darkPeg);
        lbDarkPeg2.setBounds(850,600,90,90);

        lbLightPeg2 = new JLabel();
        lightPeg2 = new ImageIcon("Othello/Images/PegSelectPage/Pegs/lightPeg.png");
        Image dabLightPeg2 = lightPeg2.getImage();
        Image modifiedLightPeg2 = dabLightPeg2.getScaledInstance(90, 90, Image.SCALE_REPLICATE);
        lightPeg2 = new ImageIcon(modifiedLightPeg2);
        lbLightPeg2.setIcon(lightPeg);
        lbLightPeg2.setBounds(1000,600,90,90);

        panelChoosePick.add(playerPickTitle);
        panelChoosePick.add(player1Title);
        panelChoosePick.add(player2Title);
        panelChoosePick.add(lbDarkPeg);
        panelChoosePick.add(lbLightPeg);
        panelChoosePick.add(lbDarkPeg2);
        panelChoosePick.add(lbLightPeg2);
        panelChoosePick.add(lbPlayerPickColor);


        final boolean[] isPickedDark = {false};
        final boolean[] isPickedLight = {false};

        lbDarkPeg.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!isPickedDark[0]) {
                    lbDarkPeg2.setEnabled(false);
                    lbLightPeg.setEnabled(false);
                    darkPeg = new ImageIcon("Othello/Images/PegSelectPage/Pegs/darkPeg-Selected.png");
                    Image dabDarkPeg = darkPeg.getImage();
                    Image modifiedDarkPeg = dabDarkPeg.getScaledInstance(100, 100, Image.SCALE_REPLICATE);
                    darkPeg = new ImageIcon(modifiedDarkPeg);
                    lbDarkPeg.setIcon(darkPeg);
                    lbDarkPeg.setBounds(845,395,100,100);
                    panelChoosePick.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    isPickedDark[0] = true;
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (!isPickedDark[0]) {
                    lbDarkPeg2.setEnabled(false);
                    lbLightPeg.setEnabled(false);
                    darkPeg = new ImageIcon("Othello/Images/PegSelectPage/Pegs/darkPeg-Selected.png");
                    Image dabDarkPeg = darkPeg.getImage();
                    Image modifiedDarkPeg = dabDarkPeg.getScaledInstance(100, 100, Image.SCALE_REPLICATE);
                    darkPeg = new ImageIcon(modifiedDarkPeg);
                    lbDarkPeg.setIcon(darkPeg);
                    lbDarkPeg.setBounds(845,395,100,100);
                    panelChoosePick.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    isPickedDark[0] = true;
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                panelChoosePick.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panelChoosePick.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });

        lbDarkPeg2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!isPickedDark[0]) {
                    lbDarkPeg.setEnabled(false);
                    lbLightPeg2.setEnabled(false);
                    darkPeg2 = new ImageIcon("Othello/Images/PegSelectPage/Pegs/darkPeg-Selected.png");
                    Image dabDarkPeg2 = darkPeg2.getImage();
                    Image modifiedDarkPeg2 = dabDarkPeg2.getScaledInstance(100, 100, Image.SCALE_REPLICATE);
                    darkPeg2 = new ImageIcon(modifiedDarkPeg2);
                    lbDarkPeg2.setIcon(darkPeg2);
                    lbDarkPeg2.setBounds(845,595,100,100);
                    panelChoosePick.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    isPickedDark[0] = true;
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (!isPickedDark[0]) {
                    lbDarkPeg.setEnabled(false);
                    lbLightPeg2.setEnabled(false);
                    darkPeg2 = new ImageIcon("Othello/Images/PegSelectPage/Pegs/darkPeg-Selected.png");
                    Image dabDarkPeg2 = darkPeg2.getImage();
                    Image modifiedDarkPeg2 = dabDarkPeg2.getScaledInstance(100, 100, Image.SCALE_REPLICATE);
                    darkPeg2 = new ImageIcon(modifiedDarkPeg2);
                    lbDarkPeg2.setIcon(darkPeg2);
                    lbDarkPeg2.setBounds(845,595,100,100);
                    panelChoosePick.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    isPickedDark[0] = true;
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                panelChoosePick.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panelChoosePick.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });

        lbLightPeg.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!isPickedLight[0]) {
                    lbLightPeg2.setEnabled(false);
                    lbDarkPeg.setEnabled(false);
                    lightPeg = new ImageIcon("Othello/Images/PegSelectPage/Pegs/lightPeg-Selected.png");
                    Image dabLightPeg = lightPeg.getImage();
                    Image modifiedLightPeg = dabLightPeg.getScaledInstance(100, 100, Image.SCALE_REPLICATE);
                    lightPeg = new ImageIcon(modifiedLightPeg);
                    lbLightPeg.setIcon(lightPeg);
                    lbLightPeg.setBounds(995,995,100,100);
                    panelChoosePick.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    isPickedLight[0] = true;
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (!isPickedLight[0]) {
                    lbLightPeg2.setEnabled(false);
                    lbDarkPeg.setEnabled(false);
                    lightPeg = new ImageIcon("Othello/Images/PegSelectPage/Pegs/lightPeg-Selected.png");
                    Image dabLightPeg = lightPeg.getImage();
                    Image modifiedLightPeg = dabLightPeg.getScaledInstance(100, 100, Image.SCALE_REPLICATE);
                    lightPeg = new ImageIcon(modifiedLightPeg);
                    lbLightPeg.setIcon(lightPeg);
                    lbLightPeg.setBounds(995,395,100,100);
                    panelChoosePick.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    isPickedLight[0] = true;
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                panelChoosePick.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panelChoosePick.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });

        lbLightPeg2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!isPickedLight[0]) {
                    lbLightPeg.setEnabled(false);
                    lbDarkPeg2.setEnabled(false);
                    lightPeg2 = new ImageIcon("Othello/Images/PegSelectPage/Pegs/lightPeg-Selected.png");
                    Image dabLightPeg2 = lightPeg2.getImage();
                    Image modifiedLightPeg2 = dabLightPeg2.getScaledInstance(100, 100, Image.SCALE_REPLICATE);
                    lightPeg2 = new ImageIcon(modifiedLightPeg2);
                    lbLightPeg2.setIcon(lightPeg2);
                    lbLightPeg2.setBounds(995,595,100,100);
                    panelChoosePick.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    isPickedLight[0] = true;
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (!isPickedLight[0]) {
                    lbLightPeg.setEnabled(false);
                    lbDarkPeg2.setEnabled(false);
                    lightPeg2 = new ImageIcon("Othello/Images/PegSelectPage/Pegs/lightPeg-Selected.png");
                    Image dabLightPeg2 = lightPeg2.getImage();
                    Image modifiedLightPeg2 = dabLightPeg2.getScaledInstance(100, 100, Image.SCALE_REPLICATE);
                    lightPeg2 = new ImageIcon(modifiedLightPeg2);
                    lbLightPeg2.setIcon(lightPeg2);
                    lbLightPeg2.setBounds(995,595,100,100);
                    panelChoosePick.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    isPickedLight[0] = true;
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                panelChoosePick.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panelChoosePick.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });




    }




}
