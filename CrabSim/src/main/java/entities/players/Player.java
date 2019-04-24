package entities.players;

import entities.Being;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Circle;
import splitScreen.SplitScreen;

public abstract class Player extends Being {

    public SplitScreen screen;

    public int playerId;

    int health;

    Circle reticule;

    ColorAdjust statusEffect = new ColorAdjust();

    RotateTransition rotateAnimation = null;
    TranslateTransition movementAnimation = null;
    PauseTransition vulnerbilityTimer = null;

    int invulnerableSeconds = 1;
    boolean vulnerable = true;

    public KeyCode rotateLeftKey;
    public KeyCode shootKey;
    public KeyCode rotateRightKey;

    boolean rotatingLeft = false;
    boolean shooting = false;
    boolean rotatingRight = false;
    boolean moving = true;

    public abstract void takeDamage(int damageAmount);

    abstract void toggleVulnerability();

    public abstract void setRotateLeft();

    public abstract void setRotateRight();

    public abstract void setShoot();

    public abstract void rotateLeft();

    public abstract void rotateRight();

    public abstract void stopLeftRotate();

    public abstract void stopRightRotate();

    abstract void moveForward();

    public abstract void stopMovement();

    public abstract void shoot();

    public abstract void stopShoot();
}
