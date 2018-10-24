public class Camera {

    private Handler handler;
    private float xOffset, yOffset;

    public Camera(Handler handler, float xOffset, float yOffset){
        this.handler = handler;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public void checkMapBorder(){
        if(xOffset < 0){
            xOffset = 0;
        }else if(xOffset > Assets.level1.getWidth() - handler.getWidth()){
            xOffset = Assets.level1.getWidth() - handler.getWidth();
        }
        if(yOffset < 0){
            yOffset = 0;
        }else if(yOffset > Assets.level1.getHeight() - handler.getHeight()){
            yOffset = Assets.level1.getHeight() - handler.getHeight();
        }
    }

    public void centerOnPlayer(Car c){
        xOffset = c.getX() - handler.getWidth() / 2 + 50;
        yOffset = c.getY() - handler.getHeight() / 2 + 50;
        checkMapBorder();
    }

    public void move(float xAmt, float yAmt){
        xOffset += xAmt;
        yOffset += yAmt;
        checkMapBorder();
    }

    //getters and setter
    public float getxOffset() {
        return xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }
}
