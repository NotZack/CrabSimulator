package entities.players;

import entities.EntityHandler;
import javafx.animation.*;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import main.AssetLoading;
import main.Main;
import world.World;

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
        this.setRotate((Math.abs((int) this.getRotate()) % 360 <= 1) ? -(Main.deltaTime * CRAB_SPEED) : this.getRotate() - (Main.deltaTime * CRAB_SPEED));
    }

    @Override
    public void rotateRight() {
        this.setRotate((Math.abs((int) this.getRotate()) % 360 <= 1) ? (Main.deltaTime * CRAB_SPEED) : this.getRotate() + (Main.deltaTime * CRAB_SPEED));
    }

    @Override
    public void stopRightRotate() {
        rotatingRight = false;
    }

    @Override
    public void stopLeftRotate() {
        rotatingLeft = false;
    }

    @Override
    void moveForward() {
        this.setTranslateX(this.getTranslateX() + ( ( ((CRAB_SPEED * 5) * Main.deltaTime) * Math.sin(Math.toRadians(-(this.getRotate() - 90))) ) ) );
        this.setTranslateY(this.getTranslateY() + ( ( ((CRAB_SPEED * 5) * Main.deltaTime) * Math.cos(Math.toRadians(-(this.getRotate() - 90))) ) ) );
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
        if (moving)
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
        stopRightRotate();
        stopLeftRotate();
        stopShoot();
        stopMovement();
        World.getWorld().getChildren().remove(this);
    }

    @Override
    public void stopMovement() {
        moving = false;
    }
}
