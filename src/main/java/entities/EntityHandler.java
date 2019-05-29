package entities;

import java.util.ArrayList;

/**
 * Keeps track of all entities in the world.
 */
public class EntityHandler {

    private static ArrayList<Being> allEntities = new ArrayList<>();

    /**
     * @return The master entity list
     */
    public static ArrayList<Being> getEntities() {
        return allEntities;
    }

    /**
     * Adds a given entity to the master entity list.
     * @param newEntity The new entity to add
     */
    public static void addEntity(Being newEntity) {
        allEntities.add(newEntity);
    }

    /**
     * Marks a given being as dead, to be removed in the next main loop update.
     * @param entityToRemove The entity to be marked as dead
     */
    public static void markEntityAsDead(Being entityToRemove) {
        entityToRemove.markedAsDead = true;
    }
}