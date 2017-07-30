package gfx;

import entities.Entity;
import game.Game;
import game.Handler;
import tiles.Tile;

public class GameCamera {
    private Handler handler;
    private float xOffset;
    private float yOffset;


    public GameCamera(Handler handler, float xOffset, float yOffset){
        this.handler = handler;
        this.xOffset = xOffset;
        this.yOffset = yOffset;

    }

    public void checkCameraBlankSpace(){
        if (xOffset < 0){
            xOffset = 0;
        }else if(xOffset > handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth()){
            xOffset = handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth(); // width of world in pixels - widht of window.
        }

        if (yOffset < 0){
            yOffset = 0;
        }else if(yOffset > handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight()){
            yOffset = handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight(); // height of world in pixels - height of window.
        }
    }

    public void centerOnEntity(Entity e){
        xOffset = e.getX() - handler.getWidth()/2 + e.getWidth()/2;
        yOffset = e.getY() - handler.getHeight()/2 + e.getHeight()/2;
        checkCameraBlankSpace();
    }

    public void move(float xAmt, float yAmt){
        xOffset +=xAmt;
        yOffset +=yAmt;
        checkCameraBlankSpace();
    }

    public float getxOffset() {
        return xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }

}


