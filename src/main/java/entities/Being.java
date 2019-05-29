package entities;

import javafx.scene.shape.Rectangle;
import worldModel.EntityModel;

/**
 * Defines an entity that is part of the world, that can be updated, collided with, and killed.
 */
public abstract class Being extends EntityModel {

    /**
     * Whether or not this being is going to be removed from the world in the next mainLoop update.
     */
    public boolean markedAsDead = false;

    /**
     * Creates the collision box for this entity.
     * @return The collision box for this entity
     */
    protected abstract Rectangle getBoundingBox();

    /**
     * Moves this entity. Called every time that this entity is in the world and is not colliding.
     */
    public abstract void update();

    /**
     * Whether or not this entity is vulnerable to damage or not.
     * @return The isVulnerable state
     */
    protected abstract boolean isVulnerable();

    /**
     * Called whenever this entity collides with a vulnerable foe.
     * @return The damage amount that this entity does if colliding with a foe.
     */
    public abstract int getCollisionDamageAmount();

    /**
     * De-initializes this being to eventually be removed from the world based on markedAsDead.
     */
    public abstract void kill();
}
