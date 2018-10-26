import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable{

    private Display display;
    private int width = 0;
    private int height = 0;
    public String title;

    private Thread thread;
    private boolean running = false;

    private BufferStrategy bs;
    private Graphics g;

    //input
    private KeyManager keyManager;
    //camera
    private Camera camera;
    //game state
    private State gameState;
    //handler
    private Handler handler;

    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
    }

    private void init(){
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        Assets.init();
        handler = new Handler(this);
        camera = new Camera(handler,0,0);
        gameState = new GameState(handler);
        State.setState(gameState);
    }

    private void tick(){
        keyManager.tick();

        if(State.getState() != null){
            State.getState().tick();
        }
    }

    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0,0, width, height);
        //////////////////////////all objects to be drawn here///////////////////

        if(State.getState() != null) {
            State.getState().render(g);
        }

        /////////////////////////////////////////////////////////////////////////
        bs.show();
        g.dispose();
    }

    public void run(){

        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while(running){
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }
            if(timer >= 1000000000){
                ticks = 0;
                timer = 0;
            }
        }
        stop();
    }

    //getters
    public KeyManager getKeyManager(){return keyManager;}
    public Camera getCamera() {return camera;}
    public int getWidth(){return width;}
    public int getHeight(){return height;}


    //thread start and stop functions
    public synchronized void start(){
        if(running){
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        if(!running){
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
