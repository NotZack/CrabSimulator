package entities.players;

import entities.EntityHandler;
import metaControl.CameraControl;
import splitScreen.SplitScreenHandler;
import worldModel.World;

import java.util.ArrayList;
import java.util.Random;

/**
 * Handles the creation, initialization, destruction of players.
 */
public class PlayerHandler {

    private static Random random = new Random();

    private static ArrayList<Player> playersList = new ArrayList<>();
    public static int numberOfPlayers;

    /**
     * Initializes all created players. Called when the sim starts.
     */
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

    /**
     * Adds the given new Player to the player and entity list.
     * @param newPlayer The new player
     */
    public static void createNewPlayer(Player newPlayer) {
        playersList.add(newPlayer);
        newPlayer.playerId = playersList.size();
        EntityHandler.addEntity(newPlayer);
    }

    /**
     * Finds and returns a player whose playerId is given. Returns null if that player does not exist.
     * @param playerNumber The player id to find a player from
     * @return The player whose id matches the given playerNumber
     */
    public static Player getPlayer(int playerNumber) {
        for (Player playerToFind : playersList) {
            if (playerToFind.playerId == playerNumber)
                return playerToFind;
        }
        return null;
    }

    /**
     * Clears the playerList of all created players. Used to refresh playerList during player and controls selection.
     */
    public static void clearPlayers() {
        playersList.clear();
    }

    /**
     * Sets the number of players that are playing during this game.
     * @param i The number of players given
     */
    public static void setNumberOfPlayers(int i) {
        numberOfPlayers = i;
    }

    /**
     * @return The player list
     */
    public static ArrayList<Player> getPlayersList() {
        return playersList;
    }

    /**
     * Marks the given player as dead, to be removed within the next mainLoop update.
     * @param playerId The id of the player to be killed.
     */
    static void killPlayer(int playerId) {
        EntityHandler.markEntityAsDead(getPlayer(playerId));

        playersList.remove(getPlayer(playerId));
    }
}
