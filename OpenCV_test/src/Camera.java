import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

import java.awt.*;

public class Camera {
    VideoCapture video = new VideoCapture(0);
    Mat image = new Mat();

    public Component startCamera() {
        while (true) {
            video.read(image);
        }
    }
}
