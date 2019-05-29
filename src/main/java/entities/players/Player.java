package entities.players;

import entities.Being;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Circle;
import splitScreen.SplitScreen;

/**
 * Defines and distinguishes a player from a plain being.
 */
public abstract class Player extends Being {

    /**
     * This player's portion of the screen
     */
    public SplitScreen screen;

    int playerId;

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

    /**
     * Deals the given damageAmount to this player's health.
     * @param damageAmount The damage amount to be dealt
     */
    public abstract void takeDamage(int damageAmount);

    /**
     * Toggles the state of this player's vulnerability to make the player either vulnerable or invulnerable.
     */
    abstract void toggleVulnerability();

    /**
     * Sets the player to be rotating left, to be acted upon within the player's rotateLeft()
     */
    public abstract void setRotateLeft();

    /**
     * Sets the player to be rotating right, to be acted upon within the player's rotateRight().
     */
    public abstract void setRotateRight();

    /**
     * Sets the player to be shooting, to be acted upon within the player's shoot().
     */
    public abstract void setShoot();

    /**
     * -(delta) Decreases the player's angle.
     */
    public abstract void rotateLeft();

    /**
     * +(delta) Increases the player's angle.
     */
    public abstract void rotateRight();

    /**
     * Sets rotatingLeft to false.
     */
    public abstract void stopLeftRotate();

    /**
     * Sets rotatingRight to false.
     */
    public abstract void stopRightRotate();

    /**
     * Moves this player forward in the direction that this player is facing.
     */
    abstract void moveForward();

    /**
     * Stops forward movement of this player.
     */
    public abstract void stopMovement();

    /**
     * Fires a projectile from this player.
     */
    public abstract void shoot();

    /**
     * Sets shooting to false.
     */
    public abstract void stopShoot();
}
