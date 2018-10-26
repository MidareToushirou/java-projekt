import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage car, level1, level1Thumb, icon, level2;

    public static void init(){

        car = ImageLoader.loadImage("textures/testCar.png");
        //car = ImageLoader.loadImage("textures/car2.png");
        //level1 = ImageLoader.loadImage("textures/level1.png");
        level1 = ImageLoader.loadImage("textures/level2.png");
        level1Thumb = ImageLoader.loadImage("textures/level1_thumbnail.png");
        icon = ImageLoader.loadImage("textures/AvatarElemente.png");
        level2 = ImageLoader.loadImage("textures/level2.png");
    }
}
