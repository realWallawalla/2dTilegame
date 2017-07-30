package entities;

import game.Handler;

import java.awt.*;

public abstract class Entity {
   protected float x;
   protected float y;
   protected int width;
   protected int height;
   protected Handler handler;
   protected Rectangle bounds;

    public Entity(Handler handler, float x, float y, int width, int height) {
        this.handler = handler;
        this.width=width;
        this.height=height;
        this.x = x;
        this.y = y;

        bounds = new Rectangle(0, 0, width, height);
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
