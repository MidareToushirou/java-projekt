import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage car, level1;

    public static void init(){

        car = ImageLoader.loadImage("/textures/testCar.png");
        level1 = ImageLoader.loadImage("textures/level1.png");
    }
}
