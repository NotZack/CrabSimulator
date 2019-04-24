package entities;

import javafx.scene.shape.Rectangle;
import worldModel.EntityModel;

public abstract class Being extends EntityModel {

    public boolean markedAsDead = false;

    protected abstract Rectangle getBoundingBox();

    public abstract void update();

    protected abstract boolean isVulnerable();

    public abstract int getDamageAmount();

    public abstract void kill();
}
