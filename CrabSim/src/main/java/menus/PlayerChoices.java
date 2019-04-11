package menus;

import javafx.scene.image.Image;
import main.Main;

import java.util.ArrayList;

public class PlayerChoices {

    private static ArrayList<Image> playerChosenSprites = new ArrayList<>();

    private static int numberOfPlayers = 1;

    public static void setPlayerChosenSprite(Image selection) {
        playerChosenSprites.add(selection);

        if (numberOfPlayers == playerChosenSprites.size()) {
            MenuHandler.getMenuPane().getChildren().clear();
            Main.simInit();
        }
    }

    public static void setNumberOfPlayers(int numOfPlayers) {
        numberOfPlayers = numOfPlayers;
    }

    public static void clearChosenSprites() {
        playerChosenSprites.clear();
    }

    public static ArrayList<Image> getChosenSprites() {
        return playerChosenSprites;
    }

    public static int getNumberOfPlayers() {
        return numberOfPlayers;
    }
}
