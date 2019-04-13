package entities.players;

import entities.EntityHandler;
import javafx.animation.*;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import main.AssetLoading;
import world.World;

public class Crab extends Player {

    public Crab() {
        this.setImage(AssetLoading.crabSprite);
        this.setEffect(statusEffect);
        this.health = 100;
    }

    @Override
    public void takeDamage(int damageAmount) {
        health -= damageAmount;
        toggleVulnerability();

        if (health > 0) {
            if (vulnerbilityTimer == null) {
                vulnerbilityTimer = new PauseTransition(Duration.seconds(invulnerableSeconds));
                vulnerbilityTimer.setOnFinished(event -> {
                    toggleVulnerability();
                    vulnerbilityTimer = null;
                });

                FadeTransition fadeTransition = new FadeTransition(Duration.millis((invulnerableSeconds * 1000) / 5), this);
                fadeTransition.setFromValue(0.1);
                fadeTransition.setToValue(1);
                fadeTransition.setCycleCount(invulnerableSeconds * 5);

                fadeTransition.play();
                vulnerbilityTimer.play();
            }
        }
        else {
            if (!this.markedAsDead) {
                this.statusEffect.setHue(50);
                PlayerHandler.killPlayer(this.playerId);
            }
        }
    }

    @Override
    void toggleVulnerability() {
        vulnerable = !vulnerable;
    }

    @Override
    public void setRotateLeft() {
        rotatingLeft = true;
        rotateLeft();
    }

    @Override
    public void setRotateRight() {
        rotatingRight = true;
        rotateRight();
    }

    @Override
    public void setShoot() {
        shooting = true;
    }

    @Override
    public void rotateLeft() {
        if (rotateAnimation == null) {
            rotateAnimation = new RotateTransition(Duration.millis(1000), this);
            rotateAnimation.setByAngle(-360);
            rotateAnimation.setCycleCount(Animation.INDEFINITE);
            rotateAnimation.setInterpolator(Interpolator.LINEAR);
            rotateAnimation.play();
        }
    }

    @Override
    public void rotateRight() {
        if (rotateAnimation == null) {
            rotateAnimation = new RotateTransition(Duration.millis(1000), this);
            rotateAnimation.setByAngle(360);
            rotateAnimation.setCycleCount(Animation.INDEFINITE);
            rotateAnimation.setInterpolator(Interpolator.LINEAR);
            rotateAnimation.play();
        }
    }

    @Override
    public void stopLeftRotate() {
        rotatingLeft = false;
        if (rotateAnimation != null) {
            rotateAnimation.stop();
            rotateAnimation = null;
        }
    }

    @Override
    public void stopRightRotate() {
        rotatingRight = false;
        if (rotateAnimation != null) {
            rotateAnimation.stop();
            rotateAnimation = null;
        }
    }

    @Override
    void moveForward() {
        if (movementAnimation == null)
            createMoveForwardAnimation();
    }

    @Override
    void createMoveForwardAnimation() {
        movementAnimation = new TranslateTransition(Duration.millis(1000), this);
        movementAnimation.setToX(this.getTranslateX() + (500 * Math.cos(this.getRotate())));
        movementAnimation.setToY(this.getTranslateY() + (500 * Math.sin(this.getRotate())));
        movementAnimation.setInterpolator(Interpolator.LINEAR);
        movementAnimation.play();
        movementAnimation.setOnFinished(event -> createMoveForwardAnimation());
    }

    @Override
    public void shoot() {

    }

    @Override
    public void stopShoot() {

    }

    @Override
    protected Rectangle getBoundingBox() {
        return new Rectangle(this.getLayoutX() + this.getTranslateX(), this.getLayoutY() + this.getTranslateY(),100, 50);
    }

    @Override
    public void update() {

        if (rotatingLeft)
            rotateLeft();
        if (rotatingRight)
            rotateRight();
        if (shooting)
            shoot();

        moveForward();
    }

    @Override
    protected boolean isVulnerable() {
        return vulnerable;
    }

    @Override
    public int getDamageAmount() {
        return 0;
    }

    @Override
    public void kill() {
        EntityHandler.getEntities().remove(this);
        stopLeftRotate();
        stopRightRotate();
        stopShoot();
        stopMovement();
        World.getWorld().getChildren().remove(this);
    }

    @Override
    public void stopMovement() {
        if (movementAnimation != null)
            movementAnimation.stop();
    }
}
