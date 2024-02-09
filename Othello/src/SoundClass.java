import javax.sound.sampled.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SoundClass {

    Float volume = -10.0f;
    KeyListener volumeBindListener;
    Clip clip;

    public SoundClass() {
        volumeBindListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
            @Override
            public void keyPressed(KeyEvent e) {



                if (e.getKeyCode() == KeyEvent.VK_U) {
                    VolumeUp();
                }

                else if (e.getKeyCode() == KeyEvent.VK_Y) {
                    System.out.println("Pressed Y");
                    VolumeDown();
                }


            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
    }
    public void sound(String filepath) {
        try {

            Path path = Paths.get(filepath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(path.toFile());

            clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            // Set volume
            FloatControl setVolume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            setVolume.setValue(-8.0f);

            clip.start();

            // Adjust the volume while the clip is playing

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("Error in playing sound/music.");
        }
    }
    public void bgMusic(String filepath) {
        try {

            Path path = Paths.get(filepath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(path.toFile());

            clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            // Set volume
            FloatControl setVolume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            setVolume.setValue(volume);

            clip.start();

            // Adjust the volume while the clip is playing
            while (clip.isActive()) {
                setVolume.setValue(volume);
            }

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("Error in playing sound/music.");
        }
    }

    // update float control
    private void adjustVolume() {
        if (clip != null) {
            FloatControl setVolume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            setVolume.setValue(volume);
        }
    }
    public void VolumeUp() {
        if (volume == 10.0f) {
            volume = 10.0f;
            System.out.println("no added vol");
        } else if (volume <= 10.0f) {
            volume += 4.0f;
            adjustVolume();
            System.out.println("add volume");
        }
    }

    public void VolumeDown() {

        if (volume >= -20.0f) {
            volume -= 4.0f;
            adjustVolume();
            System.out.println("minus volume");
        } else {
            volume = -20.0f;
            System.out.println("no subtr vol");
        }


    }
}
