package entities.enemies;

import javafx.scene.shape.Rectangle;

public class Lobster extends Enemy {
    @Override
    protected Rectangle getBoundingBox() {
        return new Rectangle(this.getLayoutX(), this.getLayoutY(),100, 50);
    }

    @Override
    public void update() {

    }

    @Override
    protected boolean isVulnerable() {
        return false;
    }

    @Override
    public int getDamageAmount() {
        return 0;
    }
}
