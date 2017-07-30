package entities.creatures;

import game.Game;
import game.Handler;
import gfx.Assets;

import java.awt.*;

public class Player extends Creature {

    public Player(Handler handler, float x, float y) {
        super(handler, x, y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT); // pass to the extented class

        bounds.x = 0;
        bounds.y = 0;
        bounds.width =50;
        bounds.height =50; // size of hit box, customize depending on pic that you use. x&y starting posioton from referens point of player (0, 0). width & height size of rectangle.
    }

    @Override
    public void tick() {
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this); //center on this player

    }

    private void getInput(){
        xMove = 0;
        yMove = 0;

        if(handler.getKeyManager().up){
            yMove = -speed;
        }
        if(handler.getKeyManager().down){
            yMove = speed;
        }
        if(handler.getKeyManager().left){
            xMove = -speed;
        }
        if(handler.getKeyManager().right){
            xMove = speed;
        }

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player,(int)(x - handler.getGameCamera().getxOffset()),
                (int)(y - handler.getGameCamera().getyOffset()), width, height, null);


        //SHOWS HIT BOX PLAYER
        /* g.setColor(Color.red);
        g.fillRect((int) (x - bounds.x - handler.getGameCamera().getxOffset()),
                (int) (y - bounds.y - handler.getGameCamera().getyOffset()),
                bounds.width, bounds.height);

                */

    }

}
