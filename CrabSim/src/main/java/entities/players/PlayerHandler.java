package entities.players;

import entities.EntityHandler;
import javafx.scene.image.Image;
import main.AssetLoading;
import main.Main;
import menus.PlayerChoices;
import world.World;

import java.util.ArrayList;
import java.util.Random;

public class PlayerHandler {

    private static Random random = new Random();

    private static ArrayList<Player> playersList = new ArrayList<>();

    public static void init() {

        ArrayList<Image> chosenSprites = PlayerChoices.getChosenSprites();

        for (int i = 0; i < PlayerChoices.getNumberOfPlayers(); i++) {
            if (chosenSprites.get(i) == AssetLoading.crabSprite)
                createNewPlayer(new Crab(AssetLoading.crabSprite));
            else if (chosenSprites.get(i) == AssetLoading.shrimpSprite)
                createNewPlayer(new Shrimp(AssetLoading.shrimpSprite));
        }
    }

    private static void createNewPlayer(Player newPlayer) {
        playersList.add(newPlayer);
        EntityHandler.addEntity(newPlayer);

        World.getWorld().getChildren().add(newPlayer);
        newPlayer.relocate(random.nextInt((int) Main.initialScene.getWidth()), random.nextInt((int) Main.initialScene.getHeight()));
    }

    public static Player getPlayer(int playerNumber) {
        return playersList.get(playerNumber - 1);
    }
}
