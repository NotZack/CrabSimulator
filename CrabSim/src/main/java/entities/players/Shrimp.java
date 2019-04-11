package entities.players;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

class Shrimp extends Player {

    Shrimp(Image shrimpSprite) {
        this.setImage(shrimpSprite);
    }

    @Override
    public void init() {

    }

    @Override
    public void takeDamage(int damageAmount) {

    }

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
