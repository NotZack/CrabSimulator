package entities.players;

import entities.EntityHandler;
import javafx.animation.*;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import main.AssetLoading;

/**
 * The Shrimp player moves at a fast rate of 15 and shoots at a fast rate of 15, but does low damage and doesn't turn as
 * much as other players.
 */
public class Shrimp extends Player {

    public Shrimp() {
        this.setImage(AssetLoading.shrimpSprite);
        this.setEffect(statusEffect);
        this.health = 100;
        this.reticule = new Circle(5, Color.RED);

        this.translateXProperty().addListener(o -> {
            Point2D end = this.localToParent(50, -100);
            reticule.setCenterX(end.getX());
            reticule.setCenterY(end.getY());
        });
    }

    /**
     * @inheritDoc
     */
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
        } else {
            this.statusEffect.setHue(50);
            PlayerHandler.killPlayer(this.playerId);
        }
    }

    /**
     * @inheritDoc
     */
    @Override
    void toggleVulnerability() {
        vulnerable = !vulnerable;
    }

    /**
     * @inheritDoc
     */
    @Override
    public void setRotateLeft() {
        rotatingLeft = true;
        rotateLeft();
    }

    /**
     * @inheritDoc
     */
    @Override
    public void setRotateRight() {
        rotatingRight = true;
        rotateRight();
    }

    /**
     * @inheritDoc
     */
    @Override
    public void setShoot() {
        shooting = true;
    }

    /**
     * @inheritDoc
     */
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

    /**
     * @inheritDoc
     */
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

    /**
     * @inheritDoc
     */
    @Override
    public void stopLeftRotate() {

    }

    /**
     * @inheritDoc
     */
    @Override
    public void stopRightRotate() {

    }


    /**
     * @inheritDoc
     */
    @Override
    void moveForward() {

    }


    /**
     * @inheritDoc
     */
    @Override
    public void shoot() {

    }

    /**
     * @inheritDoc
     */
    @Override
    public void stopShoot() {

    }

    /**
     * @inheritDoc
     */
    @Override
    protected Rectangle getBoundingBox() {
        return new Rectangle(this.getLayoutX() + this.getTranslateX(), this.getLayoutY() + this.getTranslateY(), 100, 50);
    }

    /**
     * @inheritDoc
     */
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

    /**
     * @inheritDoc
     */
    @Override
    protected boolean isVulnerable() {
        return vulnerable;
    }

    /**
     * @inheritDoc
     */
    @Override
    public int getCollisionDamageAmount() {
        return 0;
    }

    /**
     * @inheritDoc
     */
    @Override
    public void kill() {
        EntityHandler.getEntities().remove(this);
        stopShoot();
        stopMovement();
    }

    /**
     * @inheritDoc
     */
    @Override
    public void stopMovement() {
        if (movementAnimation != null)
            movementAnimation.stop();
    }
}