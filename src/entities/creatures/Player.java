package entities.creatures;

import entities.creatures.Creature;
import game.Game;
import gfx.Assets;

import java.awt.*;

public class Player extends Creature {

    public Player(Game game, float x, float y) {
        super(game, x, y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT); // pass to the extented class
    }

    @Override
    public void tick() {
        getInput();
        move();
        game.getGameCamera().centerOnEntity(this); //center on this player

    }

    private void getInput(){
        xMove = 0;
        yMove = 0;

        if(game.getKeyManager().up){
            yMove = -speed;
        }
        if(game.getKeyManager().down){
            yMove = speed;
        }
        if(game.getKeyManager().left){
            xMove = -speed;
        }
        if(game.getKeyManager().right){
            xMove = speed;
        }

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player,(int)(x - game.getGameCamera().getxOffset()),
                (int)(y - game.getGameCamera().getyOffset()), width, height, null);

    }

}
