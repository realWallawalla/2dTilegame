package entities.creatures;

import entities.Entity;

public abstract class Creature extends Entity {
    protected int health;

    public Creature(float x, float y) {
        super(x, y);// pass along x and y to super class
        health = 10;
    }

}
