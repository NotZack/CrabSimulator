package entities;

import entities.enemies.Enemy;
import entities.players.Player;
import javafx.scene.shape.Shape;

/**
 * Handles and acts upon any collision between entities.
 */
public class Collision {

    /**
     * Checks two beings for possible collision using that being's bounding box.
     * @param being A being that is being checked for collision
     * @param otherBeing The other being that is being checked for collision.
     * @return Whether or not the being's bounding boxes intersect each another
     */
    public static boolean checkCollision(Being being, Being otherBeing) {
        Shape intersect = Shape.intersect(being.getBoundingBox(), otherBeing.getBoundingBox());
        return intersect.getBoundsInLocal().getWidth() != -1;
    }

    /**
     * Calls for the correct handleCollision based off what type of entity the being is (player or enemy).
     * @param being A being having a collision
     * @param otherBeing The other being having a collision.
     */
    public static void handleCollision(Being being, Being otherBeing) {
        if (being instanceof Player) {
            if (otherBeing instanceof Player)
                handleCollision((Player) being, (Player) otherBeing);
            else
                handleCollision((Player) being, (Enemy) otherBeing);
        }
        else if (otherBeing instanceof Player) {
            handleCollision((Player) otherBeing, (Enemy) being);
        }
        else
            handleCollision((Enemy) being, (Enemy) otherBeing);
    }

    /**
     * Handles a collision between two Player entities.
     * @param player1 The player colliding with the other player
     * @param player2 The other player colliding with the other player
     */
    private static void handleCollision(Player player1, Player player2) {

    }

    /**
     * Handles a collision between an Enemy entity and a Player entity.
     * @param player The Player colliding with the enemy
     * @param enemy The Enemy colliding with the player
     */
    private static void handleCollision(Player player, Enemy enemy) {
        if (player.isVulnerable()) {
            player.takeDamage(enemy.getCollisionDamageAmount());
        }

    }

    /**
     * Handles a collision between two Enemy entities.
     * @param enemy1 The Enemy colliding with the other Enemy
     * @param enemy2 The other Enemy colliding with the other Enemy
     */
    private static void handleCollision(Enemy enemy1, Enemy enemy2) {

    }
}
