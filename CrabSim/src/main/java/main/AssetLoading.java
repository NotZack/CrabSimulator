package main;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class AssetLoading {

    public static Image crabSprite;

    public static Image localPlayer;
    public static Image defaultWorldTile;

    static void init() {
        loadTiles();
        loadEnemies();
        loadPlayers();
    }

    private static void loadPlayers() {
        try {
            crabSprite = new Image(new FileInputStream("CrabSim/src/main/resources/Players/Crab.png"),0, 0, true, false);
        }
        catch (FileNotFoundException error) {
            error.printStackTrace();
        }
    }

    private static void loadEnemies() {

    }

    private static void loadTiles() {
        try {
            defaultWorldTile = new Image(new FileInputStream("CrabSim/src/main/resources/Tiles/"
                    + LoadConfiguration.getBasicWorldTile() + ".png"),0, 0, true, false);
        }
        catch (FileNotFoundException error) {
            error.printStackTrace();
        }
    }
}
