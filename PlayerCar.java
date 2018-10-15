import java.awt.*;

public class PlayerCar extends GameObject{

    public PlayerCar(int x, int y){
        super(x, y);
        //temp v
        velX = 1;
        //temp ^
    }

    public void tick(){
        x += velX;
        y += velY;
    }

    public void render(Graphics g){
        g.setColor(Color.black);
        g.fillRect(x, y, 32, 32);
    }

    public Rectangle getBounds(){
        return null;
    }
}
