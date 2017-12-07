package entities.statics;

import game.Handler;
import gfx.Assets;
import items.Item;
import tiles.Tile;

import java.awt.*;

public class Tree extends StaticEntity {

    public Tree(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);

//        bounds.x = 10;
//        bounds.y = (int)(height/1.5f);
        bounds.x = 0;
        bounds.y = 0;
        bounds.width = width - 20;
        bounds.height = (int)(height - height/2f);
    }

    @Override
    public void tick() {

    }

    @Override
    public void die() {
        handler.getWorld().getItemManager().addItem(Item.swordItem.createNew((int)x, (int)y));
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.tree, (int)(x - handler.getGameCamera().getxOffset()),
                (int)(y - handler.getGameCamera().getyOffset()), width, height, null);

        g.setColor(Color.red);
        g.fillRect((int) (x+ - bounds.x - handler.getGameCamera().getxOffset()),
                (int) (y - bounds.y - handler.getGameCamera().getyOffset()),
                bounds.width, bounds.height);

    }
}
