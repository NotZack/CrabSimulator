package entities.players;

import entities.Being;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.input.KeyCode;

public abstract class Player  extends Being {

    public int playerId;

    int health;

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

    public abstract void takeDamage(int damageAmount);

    abstract void toggleVulnerability();

    public abstract void setRotateLeft();

    public abstract void setRotateRight();

    public abstract void setShoot();

    public abstract void rotateLeft();

    public abstract void rotateRight();

    public abstract void stopLeftRotate();

    abstract void moveForward();

    abstract void createMoveForwardAnimation();

    public abstract void stopRightRotate();

    public abstract void stopMovement();

    public abstract void shoot();

    public abstract void stopShoot();
}
