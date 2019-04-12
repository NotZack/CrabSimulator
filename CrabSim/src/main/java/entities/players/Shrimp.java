package entities.players;

import javafx.scene.shape.Rectangle;
import main.AssetLoading;

public class Shrimp extends Player {

    public Shrimp() {
        this.setImage(AssetLoading.shrimpSprite);
        this.setX(0);
        this.setY(0);
    }

    @Override
    public void takeDamage(int damageAmount) {

    }

    @Override
    public void setRotateLeft() {

    }

    @Override
    public void setRotateRight() {

    }

    @Override
    public void setShoot() {

    }

    @Override
    public void rotateLeft() {

    }

    @Override
    public void rotateRight() {

    }

    @Override
    public void stopLeftRotate() {

    }

    @Override
    public void stopRightRotate() {

    }

    @Override
    public void shoot() {

    }

    @Override
    public void stopShoot() {

    }

    @Override
    protected Rectangle getBoundingBox() {
        return new Rectangle(this.getTranslateX(), this.getTranslateY(),100, 50);
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
