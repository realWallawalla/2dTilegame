package inventory;

import game.Handler;
import items.Item;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class Inventory {
    private Handler handler;
    private boolean active = false;
    private ArrayList<Item> inventoryItems;

    public Inventory(Handler handler) {
        this.handler = handler;
        inventoryItems = new ArrayList<>();
    }

    public void tick () {
        if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_E))
            active = !active;
        if(!active)
            return;

        System.out.println("INVENTORY");
        for (Item i : inventoryItems) {
            System.out.println(i.getName() + " " + i.getCount());
        }

    }

    public void render (Graphics g) {

    }

    //INVENTORY METHODS

    public void addItem(Item item) {
        for (Item itemInArray : inventoryItems) {
            if(itemInArray.getId() == item.getId()) {
                itemInArray.setCount(itemInArray.getCount() + item.getCount());
                return;
            }
        }
        inventoryItems.add(item);
    }

    //GETTERS AMD SETTER


    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
