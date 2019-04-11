package main;

import org.ini4j.Ini;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class LoadConfiguration {

    //[Meta]
    private static boolean isFullscreen;
    private static int binRegionSize;

    //[Tiles]
    private static boolean worldSquare;
    private static int worldVRegions;
    private static int worldHRegions;
    private static String basicWorldTile;

    static void loadConfigurationFile() {
        Ini ini = null;
        try {
            ini = new Ini(new File("crabSim/src/main/configuration.ini"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setConfiguration(Objects.requireNonNull(ini));
    }

    private static void setConfiguration(@NotNull Ini ini) {
        isFullscreen = Boolean.parseBoolean(ini.get("Meta", "fullscreen"));
        binRegionSize = Integer.parseInt(ini.get("Meta", "binRegionSize"));

        worldSquare = Boolean.parseBoolean(ini.get("Overworld", "squareRegionSet"));
        worldHRegions = Integer.parseInt(ini.get("Overworld", "horizontalRegions"));
        worldVRegions = Integer.parseInt(ini.get("Overworld", "verticalRegions"));
        basicWorldTile = ini.get("Overworld", "basictile");
    }

    static boolean isFullscreen() {
        return isFullscreen;
    }

    public static int getWorldHRegions() {
        return worldHRegions;
    }

    public static boolean isWorldSquare() {
        return worldSquare;
    }

    public static int getWorldVRegions() {
        return worldVRegions;
    }

    public static int getBinRegionSize() {
        return binRegionSize;
    }

    public static String getBasicWorldTile() {
        return basicWorldTile;
    }
}
