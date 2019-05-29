package entities.enemies;

import entities.EntityHandler;
import main.AssetLoading;
import main.LoadConfiguration;
import worldModel.World;

import java.util.Random;

/**
 * Handles the creation and destruction of all enemies
 */
public class EnemyHandler {

    private static Random random = new Random();

    /**
     * Calls for creation of a number of enemies to be created defined by the loadConfiguration.
     */
    public static void init() {
        for (int i = 0; i < LoadConfiguration.getNumberOfLobsters(); i++) {
            createLobster();
        }
    }

    /**
     * Creates and adds a Lobster enemy to the world.
     */
    private static void createLobster() {
        Lobster newLobster = new Lobster();
        newLobster.setImage(AssetLoading.lobsterSprite);

        newLobster.setTranslateX(random.nextInt(5000));
        newLobster.setTranslateY(random.nextInt(5000));
        EntityHandler.addEntity(newLobster);
        World.getWorld().getChildren().add(newLobster);
    }
}
