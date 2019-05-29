package main;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Loads in image assets from the local file system.
 */
public class AssetLoading {

    public static Image crabSprite;
    public static Image shrimpSprite;

    public static Image lobsterSprite;

    public static Image defaultWorldTile;

    static void init() {
        loadTiles();
        loadEnemies();
        loadPlayers();
    }

    private static void loadPlayers() {
        try {
            crabSprite = new Image(new FileInputStream("src/main/resources/Players/Crab.png"),0, 0, true, false);
            shrimpSprite = new Image(new FileInputStream("src/main/resources/Players/Shrimp.png"),0, 0, true, false);
        }
        catch (FileNotFoundException error) {
            error.printStackTrace();
        }
    }

    private static void loadEnemies() {
        try {
            lobsterSprite = new Image(new FileInputStream("src/main/resources/Enemies/Lobster.png"),0, 0, true, false);
        }
        catch (FileNotFoundException error) {
            error.printStackTrace();
        }
    }

    private static void loadTiles() {
        try {
            defaultWorldTile = new Image(new FileInputStream("src/main/resources/Tiles/"
                    + LoadConfiguration.getBasicWorldTile() + ".png"),0, 0, true, false);
        }
        catch (FileNotFoundException error) {
            error.printStackTrace();
        }
    }
}
