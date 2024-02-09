import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class VolumeSettingsPage {

    JPanel panelVolumeSettings = new JPanel();
    JButton volumeUp, volumeDown;
    KeyListener volumeBindListener;

    public VolumeSettingsPage() {

        panelVolumeSettings.setLayout(new GridLayout(1,3));
        panelVolumeSettings.setSize(1000,500);
        panelVolumeSettings.setBackground(Color.GREEN);

        volumeUp = new JButton("Volume Up");
        volumeUp.setSize(50,100);

        volumeDown = new JButton("Volume Down");
        volumeDown.setSize(50,100);

        panelVolumeSettings.add(volumeUp);
        panelVolumeSettings.add(volumeDown);

       volumeBindListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_V && e.getKeyCode() == KeyEvent.VK_U) {
                    panelVolumeSettings.setVisible(true);
                    System.out.println("Pressed  and U");
                }

                if (e.getKeyCode() == KeyEvent.VK_V && e.getKeyCode() == KeyEvent.VK_Y) {
                    panelVolumeSettings.setVisible(true);
                    System.out.println("Pressed  and Y");
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };



    }



}
