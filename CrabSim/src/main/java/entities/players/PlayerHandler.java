package entities.players;

import entities.EntityHandler;
import javafx.scene.image.Image;
import main.AssetLoading;
import main.Main;
import world.World;

import java.util.ArrayList;
import java.util.Random;

public class PlayerHandler {

    private static Random random = new Random();

    private static ArrayList<Player> playersList = new ArrayList<>();
    public static int numberOfPlayers;

    public static void init() {
        for (Player player : playersList) {
            player.setLayoutX(random.nextInt((int) Main.initialScene.getWidth()));
            player.setLayoutY(random.nextInt((int) Main.initialScene.getHeight()));
            World.getWorld().getChildren().add(player);
        }
    }

    public static void createNewPlayer(Player newPlayer) {
        playersList.add(newPlayer);
        EntityHandler.addEntity(newPlayer);
    }

    public static Player getPlayer(int playerNumber) {
        return playersList.get(playerNumber - 1);
    }

    public static void clearPlayers() {
        playersList.clear();
    }

    public static void setNumberOfPlayers(int i) {
        numberOfPlayers = i;
    }

    public static ArrayList<Player> getPlayersList() {
        return playersList;
    }
}
