import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{

    String LevelName = "TestLevel";
    private boolean isRunning = false;
    private Thread thread;
    private Handler handler;

    //starts up the game and activates the thread
    private void start(){
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    //starts a new game, opening the window for the level
    public Game(){
        new LoadLevel(1200, 700, LevelName, this);
        start();
        handler = new Handler();

        handler.addObject(new PlayerCar(100,100));
    }

    //stops the game and the thread
    private void stop(){
        isRunning = false;
        try {
            thread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void run(){
        //copy pasted code that basically makes frames and updates per frame work
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(isRunning){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >=1){
                tick();
                delta--;
            }
            render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                frames = 0;
            }
        }
        stop();
    }

    //tells the handler to tick all objects
    public void tick(){
        handler.tick();
    }


    public void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        //all objects to be drawn in here///////////////////
        g.setColor(Color.pink);
        g.drawRect(10,10, 100,100);

        handler.render(g);

        //objects to be drawn end here//////////////////////
        g.dispose();
        bs.show();
    }

    public static void main(String args[]){
        new Game();
    }
}
