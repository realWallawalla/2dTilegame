package items;

import game.Handler;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ItemManager {
    private Handler handler;
    private ArrayList<Item> items;

    public ItemManager(Handler handler){
        this.handler = handler;
        items = new ArrayList<>();
    }

    public void tick(){
        Iterator<Item> it = items.iterator();
        while (it.hasNext()){
            Item item = it.next();
            item.tick();
            if (item.isPickedUp())
                it.remove();
        }

    }

    public void render(Graphics g){
        for(Item item : items){
            item.render(g);
        }
    }

    public void addItem(Item item){
        item.setHandler(handler);
        items.add(item);
    }


        //GETTER AND SETTERS
    public Handler getHandler() {
        return handler;
    }
}
