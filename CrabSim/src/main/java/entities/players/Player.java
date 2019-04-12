package entities.players;

import entities.Being;
import javafx.scene.input.KeyCode;

public abstract class Player  extends Being {

    int health;

    int vulnerableFrames = 300;
    boolean vulnerable = true;

    public KeyCode rotateLeftKey;
    public KeyCode shootKey;
    public KeyCode rotateRightKey;

    public boolean rotatingLeft = false;
    public boolean shooting = false;
    public boolean rotatingRight = false;

    public abstract void takeDamage(int damageAmount);

    public abstract void setRotateLeft();

    public abstract void setRotateRight();

    public abstract void setShoot();

    public abstract void rotateLeft();

    public abstract void rotateRight();

    public abstract void stopLeftRotate();

    public abstract void stopRightRotate();

    public abstract void shoot();

    public abstract void stopShoot();
}
