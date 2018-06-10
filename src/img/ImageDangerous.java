package img;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class ImageDangerous
{
    private static final double DELAY = 0.5;
    private ImageView image;
    private Timeline timer;
    private boolean flag = true;

    public ImageDangerous(ImageView image)
    {
        this.image = image;
        timer = new Timeline((new KeyFrame((Duration.seconds(DELAY)), ev ->
        {
            image.setVisible(flag);
            flag = !flag;
        })));
        timer.setCycleCount(Animation.INDEFINITE);
    }

    public void startError()
    {
        timer.play();
    }
    public void stopError()
    {
        timer.stop();
        image.setVisible(false);
    }
}
