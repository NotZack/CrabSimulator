package entities;

import entities.enemies.Enemy;
import entities.players.Player;
import javafx.scene.shape.Shape;

public class Collision {
    public static boolean checkCollision(Being being, Being otherBeing) {
        Shape intersect = Shape.intersect(being.getBoundingBox(), otherBeing.getBoundingBox());
        return intersect.getBoundsInLocal().getWidth() != -1;
    }

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

    private static void handleCollision(Player player1, Player player2) {

    }

    private static void handleCollision(Player player, Enemy enemy) {
        if (player.isVulnerable()) {
            player.takeDamage(enemy.getDamageAmount());
        }

    }

    private static void handleCollision(Enemy enemy1, Enemy enemy2) {

    }
}
