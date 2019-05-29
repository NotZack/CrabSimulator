package entities.enemies;

import javafx.scene.shape.Rectangle;

/**
 * The lobster moves at a slow speed of 5 and shoots at a slow speed of UNDEFINED.
 */
public class Lobster extends Enemy {

    /**
     * @inheritDoc
     */
    @Override
    protected Rectangle getBoundingBox() {
        return new Rectangle(this.getTranslateX(), this.getTranslateY(),100, 50);
    }

    /**
     * @inheritDoc
     */
    @Override
    public void update() {
    }

    /**
     * @inheritDoc
     */
    @Override
    protected boolean isVulnerable() {
        return false;
    }

    /**
     * @inheritDoc
     */
    @Override
    public int getCollisionDamageAmount() {
        return 100;
    }

    /**
     * @inheritDoc
     */
    @Override
    public void kill() {

    }
}
