package entities;

import game.Game;

import java.awt.*;

public abstract class Entity {
   protected float x;
   protected float y;
   protected int width;
   protected int height;
   protected Game game;

    public Entity(Game game, float x, float y, int width, int height) {
        this.game = game;
        this.width=width;
        this.height=height;
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    public abstract void tick();

    public abstract void render(Graphics g);

}
