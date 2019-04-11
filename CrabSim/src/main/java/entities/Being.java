package entities;

import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public abstract class Being extends ImageView {

    protected abstract Rectangle getBoundingBox();

    public abstract void update();

    protected abstract boolean isVulnerable();

    public abstract int getDamageAmount();
}
