package entities.enemies;

import entities.EntityHandler;
import main.AssetLoading;
import main.LoadConfiguration;
import worldModel.World;

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

        newLobster.setTranslateX(random.nextInt(5000));
        newLobster.setTranslateY(random.nextInt(5000));
        EntityHandler.addEntity(newLobster);
        World.getWorld().getChildren().add(newLobster);
    }
}
