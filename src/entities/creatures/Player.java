package entities.creatures;

import entities.creatures.Creature;
import gfx.Assets;

import java.awt.*;

public class Player extends Creature {

    public Player(float x, float y) {
        super(x, y); // pass to the extented class
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player,(int)x,(int)y,null);

    }

}
