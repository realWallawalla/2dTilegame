package entities;

import entities.creatures.Player;
import game.Handler;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class EntityManager {

    private Handler handler;
    private Player player;
    private ArrayList<Entity> entities;
    /*comparator sorts list. Want to sort list y asceding (lowest y cordinate ffirts so all entiteis renders in right order).
    example when player is infront of tree player should be rendered on top of the tree. if behind viceversa. */
    private Comparator<Entity> renderSorter = new Comparator<Entity>(){
        @Override
        public int compare(Entity a, Entity b) {
            if((a.getY() + a.getHeight()) < (b.getY() + b.getHeight()))
                return -1; // a has a lesser y coordinate and should be rendered first
            return 1; // b has lesser y and will be remdered first
        }
    };


    public EntityManager(Handler handler, Player player) {
        this.handler = handler;
        this.player = player;
        entities = new ArrayList<>();
        entities.add(player);
    }

    public void tick(){
        for (int i = 0; i<entities.size(); i++){
            Entity e =entities.get(i);
            e.tick();
            if(!e.isActive())
                entities.remove(e);
        }
        entities.sort(renderSorter);
    }

    public void render(Graphics g){
        for (Entity e : entities){
            e.render(g);
        }
    }

    public void addEntity(Entity e){
        entities.add(e);
    }

    //GETTERS AND SETTER

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }
}
