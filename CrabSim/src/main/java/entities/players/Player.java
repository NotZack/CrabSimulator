package entities.players;

import entities.Being;

public abstract class Player  extends Being {

    int health;

    int vulnerableFrames = 300;
    boolean vulnerable = true;

    public abstract void init();

    public abstract void takeDamage(int damageAmount);
}
