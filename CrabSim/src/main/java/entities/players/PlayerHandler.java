package entities.players;

import entities.EntityHandler;
import metaControl.CameraControl;
import splitScreen.SplitScreenHandler;
import worldModel.World;

import java.util.ArrayList;
import java.util.Random;

public class PlayerHandler {

    private static Random random = new Random();

    private static ArrayList<Player> playersList = new ArrayList<>();
    public static int numberOfPlayers;

    public static void init() {
        for (Player player : playersList) {
            World.getWorld().getChildren().addAll(player, player.reticule);

            new CameraControl(player);

            player.setTranslateX(100);
            player.setTranslateY(100);
        }
        for (Player player : playersList) {
            SplitScreenHandler.initPlayerScreen(player);
        }
    }

    public static void createNewPlayer(Player newPlayer) {
        playersList.add(newPlayer);
        newPlayer.playerId = playersList.size();
        EntityHandler.addEntity(newPlayer);
    }

    public static Player getPlayer(int playerNumber) {
        for (Player playerToFind : playersList) {
            if (playerToFind.playerId == playerNumber)
                return playerToFind;
        }
        return null;
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

    static void killPlayer(int playerId) {
        EntityHandler.markEntityAsDead(getPlayer(playerId));

        playersList.remove(getPlayer(playerId));
    }
}
