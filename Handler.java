import java.awt.*;
import java.util.LinkedList;

//Class tht handles the updates of every possible object in the game
public class Handler {

    //creating the list of all objects to update
    LinkedList<GameObject> object = new LinkedList<GameObject>();

    //Handler's tick function triggers each object's own tick, updating it
    public void tick(){
       for(int i = 0; i < object.size(); i++){
           GameObject tempObject = object.get(i);
           tempObject.tick();
        }
    }

    //Same  as above, rendering the object's graphics
    public void render(Graphics g){
        for(int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);
            tempObject.render(g);
        }
    }

    //adds objects to list
    public void addObject(GameObject tempObject){
        object.add(tempObject);
    }

    //removes objects from list
    public void removeObject(GameObject tempObject){
        object.remove(tempObject);
    }
}