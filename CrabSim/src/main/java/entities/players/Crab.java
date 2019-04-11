package entities.players;

import javafx.scene.shape.Rectangle;

public class Crab extends Player {

    @Override
    public void init() {
        health = 150;
    }

    @Override
    public void takeDamage(int damageAmount) {
        vulnerable = false;
        health -= damageAmount;
    }

    @Override
    protected Rectangle getBoundingBox() {
        return null;
    }

    @Override
    public void update() {

    }

    @Override
    protected boolean isVulnerable() {
        return vulnerable;
    }

    @Override
    public int getDamageAmount() {
        return 0;
    }
}
