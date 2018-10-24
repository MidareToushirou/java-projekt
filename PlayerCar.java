import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class PlayerCar extends Car {


    private float speed = 0.0f;
    private int maxSpeed = 20;
    private int maxReverseSpeed = -5;
    private float turn = 0.0f;
    private int turnMax = 2;
    private float xVel = 0.0f;
    private float yVel = 0.0f;
    private double friction = 0.9;
    private float rotation = 0.0f;


    public PlayerCar(Handler handler, float x, float y){
        super(handler, x, y);
    }

    @Override
    public void tick() {
        //listen to Key inputs on every frame and center the camera on this object
        getInput();
        handler.getCamera().centerOnPlayer(this);
    }

    //listens to keyboard input
    public void getInput(){

        if(handler.getKeyManager().up){
            //if not fully accelerated yet, speed up
            if(speed < maxSpeed) {
                speed += 2;
            }else if(speed > maxSpeed){
                speed = maxSpeed;
            }
        }

        if(handler.getKeyManager().down){
            //same thing for reverse
            if(speed > maxReverseSpeed){
                speed -= 2;
            }else if(speed < maxReverseSpeed){
                speed = maxReverseSpeed;
            }
        }
        //turn slightly and smoothly left and right
        if(handler.getKeyManager().left){
            turn += 0.1;
            if (turn > turnMax){
                turn = turnMax;
            }
        }
        if(handler.getKeyManager().right){
            turn -= 0.1;
            if (turn < -turnMax){
                turn = -turnMax;
            }
        }

        //apply friction
        speed *= friction;

        //nullify speed if it gets too low
        if(speed > 0 && speed < 0.05){
            speed = 0;
        }

        //move along each axis based on sin and cos of direction
        xVel = (float) (speed * Math.sin(rotation * Math.PI / 180));
        yVel = (float) (speed * Math.cos(rotation * Math.PI / 180));

        //increment position by velocity
        x += xVel;
        y += yVel;

        //nullify turning if it gets low enough
        if(turn > 0 && turn < 0.05){
            turn = 0;
        }
        if(turn < 0 && turn > -0.05){
            turn = 0;
        }

        //apply friction and update direction of rotation
        turn *= friction;
        turn -= turn * 0.1;
        rotation += turn * speed;
    }

    //rotates the image of the car based on its direction
    public BufferedImage rotate(double degrees){
        AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(degrees), Assets.car.getWidth() / 2, Assets.car.getHeight() / 2);
        BufferedImage rotatedImage = new BufferedImage(Assets.car.getHeight(), Assets.car.getHeight(), Assets.car.getType());
        Graphics2D g2d = (Graphics2D) rotatedImage.getGraphics();
        g2d.setTransform(at);
        g2d.drawImage(Assets.car, 0, 0, null);
        return rotatedImage;
    }

    //the player's car's render method
    @Override
    public void render(Graphics g) {
        g.drawImage(rotate(-rotation), (int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), null);
    }

}
