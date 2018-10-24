import java.awt.*;

public abstract class Car {

    protected Handler handler;
    protected float x = 0.0f;
    protected float y = 0.0f;
    public Car(Handler handler, float x, float y){
        this.handler = handler;
        this.x = x;
        this.y = y;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
