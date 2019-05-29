package entities.players;

import entities.EntityHandler;
import javafx.animation.*;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import main.AssetLoading;
import main.Main;

/**
 * The Crab player moves at an average speed of 10 and shoots at an average rate of UNDEFINED.
 */
public class Crab extends Player {

    private final static int CRAB_SPEED = 10;

    public Crab() {
        this.setImage(AssetLoading.crabSprite);
        this.setEffect(statusEffect);
        this.health = 100000;
        this.reticule = new Circle(5, Color.RED);

        this.translateXProperty().addListener(o -> {
            Point2D end = this.localToParent(50, -100);
            reticule.setCenterX(end.getX());
            reticule.setCenterY(end.getY());
        });
    }

    /**
     * @inheritDoc
     * @param damageAmount The damage amount to be dealt
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
        }
        else {
            if (!this.markedAsDead) {
                this.statusEffect.setHue(50);
                PlayerHandler.killPlayer(this.playerId);
            }
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
        this.setRotate((Math.abs((int) this.getRotate()) % 360 <= 1) ? -(Main.deltaTime * CRAB_SPEED) : this.getRotate() - (Main.deltaTime * CRAB_SPEED));
    }

    /**
     * @inheritDoc
     */
    @Override
    public void rotateRight() {
        this.setRotate((Math.abs((int) this.getRotate()) % 360 <= 1) ? (Main.deltaTime * CRAB_SPEED) : this.getRotate() + (Main.deltaTime * CRAB_SPEED));
    }

    /**
     * @inheritDoc
     */
    @Override
    public void stopRightRotate() {
        rotatingRight = false;
    }

    /**
     * @inheritDoc
     */
    @Override
    public void stopLeftRotate() {
        rotatingLeft = false;
    }

    /**
     * @inheritDoc
     */
    @Override
    void moveForward() {
        this.setTranslateX(this.getTranslateX() + ( ( ((CRAB_SPEED * 5) * Main.deltaTime) * Math.sin(Math.toRadians(-(this.getRotate() - 90))) ) ) );
        this.setTranslateY(this.getTranslateY() + ( ( ((CRAB_SPEED * 5) * Main.deltaTime) * Math.cos(Math.toRadians(-(this.getRotate() - 90))) ) ) );
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
        return new Rectangle(this.getLayoutX() + this.getTranslateX(), this.getLayoutY() + this.getTranslateY(),100, 50);
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
        if (moving)
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
        stopRightRotate();
        stopLeftRotate();
        stopShoot();
        stopMovement();
    }

    /**
     * @inheritDoc
     */
    @Override
    public void stopMovement() {
        moving = false;
    }
}
