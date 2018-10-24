import java.awt.*;

public class GameState extends State {

    private PlayerCar playerCar;

    public GameState(Handler handler){
        super(handler);
        playerCar = new PlayerCar(handler,600, 500);
    }

    @Override
    public void tick() {
        playerCar.tick();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.level1, (int) (0 - handler.getCamera().getxOffset()), (int) (0 - handler.getCamera().getyOffset()), null);
        playerCar.render(g);
    }
}
