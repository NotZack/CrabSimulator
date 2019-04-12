package entities.players;

import javafx.scene.shape.Rectangle;
import main.AssetLoading;

public class Crab extends Player {

    public Crab() {
        this.setImage(AssetLoading.crabSprite);
        this.setX(0);
        this.setY(0);
    }

    @Override
    public void takeDamage(int damageAmount) {
        vulnerable = false;
        health -= damageAmount;
    }

    @Override
    public void setRotateLeft() {
        rotatingLeft = true;
    }

    @Override
    public void setRotateRight() {
        rotatingRight = true;
    }

    @Override
    public void setShoot() {
        shooting = true;
    }

    @Override
    public void rotateLeft() {
        this.setRotate(this.getRotate() - 10);
    }

    @Override
    public void rotateRight() {
        this.setRotate(this.getRotate() + 10);
    }

    @Override
    public void stopLeftRotate() {
        rotatingLeft = false;
    }

    @Override
    public void stopRightRotate() {
        rotatingRight = false;
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

        this.setTranslateX(this.getTranslateX() + (5 * Math.sin(this.getRotate())));
        this.setTranslateY(this.getTranslateY() + (5 * Math.cos(this.getRotate())));

        if (rotatingLeft)
            rotateLeft();
        else if (rotatingRight)
            rotateRight();
        else if (shooting)
            shoot();
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
