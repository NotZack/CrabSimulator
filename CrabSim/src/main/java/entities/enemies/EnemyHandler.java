package entities.enemies;

import entities.EntityHandler;
import main.AssetLoading;
import main.LoadConfiguration;
import world.World;
import world.regions.BinRegion;
import world.regions.BinRegionHandler;

import java.util.Random;

public class EnemyHandler {

    private static Random random = new Random();

    public static void init() {
        for (int i = 0; i < LoadConfiguration.getNumberOfLobsters(); i++) {
            createLobster();
        }
    }

    private static void createLobster() {
        Lobster newLobster = new Lobster();
        newLobster.setImage(AssetLoading.lobsterSprite);

        World.getWorld().getChildren().add(newLobster);

        BinRegion randRegion = BinRegionHandler.getRandomRegion();
        newLobster.setTranslateX(random.nextInt(randRegion.getMaxX()) + randRegion.getLayoutX());
        newLobster.setTranslateY(random.nextInt(randRegion.getMaxY()) + randRegion.getLayoutY());
        EntityHandler.addEntity(newLobster);
    }
}
