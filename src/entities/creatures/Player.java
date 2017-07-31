package entities.creatures;

import com.sun.org.apache.regexp.internal.RE;
import entities.Entity;
import game.Game;
import game.Handler;
import gfx.Animation;
import gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature {

    //Animations
    private Animation animDown;
    private Animation animUp;
    private Animation animLeft;
    private Animation animRight;

    //Attack timer
    private long lastAttackTimer,
                 attackColldown = 500,
                 attackTimer = attackColldown;

    public Player(Handler handler, float x, float y) {
        super(handler, x, y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT); // pass to the extented class

        bounds.x =0;
        bounds.y =0;
        bounds.width =50;
        bounds.height =50; // size of hit box, customize depending on pic that you use. x&y starting posioton from referens point of player (0, 0). width & height size of rectangle.

        //Animation
        animDown = new Animation(200, Assets.player_down);
        animUp = new Animation(200, Assets.player_up);
        animLeft = new Animation(200, Assets.player_left);
        animRight = new Animation(200, Assets.player_right);
    }

    @Override
    public void tick() {
        //Animations
        animDown.tick();
        animUp.tick();
        animLeft.tick();
        animRight.tick();
        //Movement
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this); //center on this player
        //Attack
        checkAttacks();

    }

    private void checkAttacks(){ //create a rectangle depending on arrowkey pressed. check attackRectangel bounds for collision with other entity
        attackTimer +=System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if (attackTimer<attackColldown)
            return; // if attack timer is not 800 yet. return and dont eun code below. if greater code in method will continue.
        Rectangle cb = getCollisionBounds(0, 0);
        Rectangle attRec = new Rectangle();
        int attRecSize = 20;
             attRec.width = attRecSize;
             attRec.height = attRecSize;

        if (handler.getKeyManager().aUp){
            attRec.x =cb.x +cb.width/2 - attRecSize/2;
            attRec.y =cb.y - attRecSize;
        }else if (handler.getKeyManager().aDown) {
            attRec.x = cb.x + cb.width / 2 - attRecSize / 2;
            attRec.y = cb.y + cb.height;
        } else if (handler.getKeyManager().aLeft) {
            attRec.x = cb.x - attRecSize;
            attRec.y = cb.y + cb.height/2 - attRecSize/2;
        } else if (handler.getKeyManager().aRight) {
            attRec.x = cb.x + cb.width;
            attRec.y = cb.y + cb.height/2 - attRecSize/2;
        } else
            return;

        attackTimer = 0;

        for(Entity e : handler.getWorld().getEntityManager().getEntities()){
            if (e.equals(this))
                continue;
            if (e.getCollisionBounds(0, 0).intersects(attRec)) {
                e.hurt(1);
                return;
            }
        }
    }


    @Override
    public void die() {
        System.out.println("you died!");
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
        g.drawImage(getCurrentAnimationFrame(),(int)(x - handler.getGameCamera().getxOffset()),
                (int)(y - handler.getGameCamera().getyOffset()), width, height, null);


        //SHOWS HIT BOX PLAYER
        g.setColor(Color.red);
        g.fillRect((int) (x - bounds.x - handler.getGameCamera().getxOffset()),
                (int) (y - bounds.y - handler.getGameCamera().getyOffset()),
                bounds.width, bounds.height);



    }

    private BufferedImage getCurrentAnimationFrame(){
        if (xMove<0){
            return animLeft.getCurrentFrame();
        }else if (xMove>0){
            return animRight.getCurrentFrame();
        }else if (yMove < 0){
            return animUp.getCurrentFrame();
        }else{
            return animDown.getCurrentFrame();
        }

    }

}
