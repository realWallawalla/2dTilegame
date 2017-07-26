package entities.creatures;

import entities.creatures.Creature;
import game.Game;
import gfx.Assets;

import java.awt.*;

public class Player extends Creature {
    private Game game;

    public Player(Game game, float x, float y) {
        super(x, y); // pass to the extented class
        this.game = game;
    }

    @Override
    public void tick() {
        if(game.getKeyManager().up){
            y-=10;
        }
        if(game.getKeyManager().down){
            y+=10;
        }
        if(game.getKeyManager().left){
            x-=10;
        }
        if(game.getKeyManager().right){
            x+=10;
        }

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player,(int)x,(int)y,null);

    }

}
