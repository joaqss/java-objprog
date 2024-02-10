import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class SoundClass {

    Float volume = -20.0f;
    KeyListener volumeBindListener;
    Clip clipFX, clipBGM;
    int gameBoardMusic;

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

            clipFX = AudioSystem.getClip();
            clipFX.open(audioInputStream);

            // Set volume
            FloatControl setVolume = (FloatControl) clipFX.getControl(FloatControl.Type.MASTER_GAIN);
            setVolume.setValue(-8.0f);

            clipFX.start();

            // Adjust the volume while the clip is playing

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("Error in playing sound/music.");
        }
    }
    public void bgMusic(String filepath) {
        try {


            Path path = Paths.get(filepath);

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(path.toFile());
            System.out.println(path);

            clipBGM = AudioSystem.getClip();
            clipBGM.open(audioInputStream);

            // Set volume
            adjustVolume();

            clipBGM.start();
            clipBGM.loop(Clip.LOOP_CONTINUOUSLY);


        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("Error in playing sound/music.");
        }
    }
    // update float control
    private void adjustVolume() {
        if (clipBGM != null) {
            FloatControl setVolume = (FloatControl) clipBGM.getControl(FloatControl.Type.MASTER_GAIN);
            setVolume.setValue(volume);
        } else {
            System.out.println("null yung clipbgm");
        }
    }
    public void VolumeUp() {
        if (volume == 10.0f) {
            volume = 10.0f;
            System.out.println("no added vol");
        } else if (volume < 10.0f) {
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
    public void stopMusic() {

        if (clipBGM != null) {
            clipBGM.stop();
            clipBGM.close();

        } else {
            System.out.println("clipBGM is null. Unable to stop and close.");
        }
    }
    public int randomMusicGen() {
        Random rand = new Random();
        gameBoardMusic = rand.nextInt(6);

        return gameBoardMusic;
    }
}
