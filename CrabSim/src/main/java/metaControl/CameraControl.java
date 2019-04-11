package metaControl;

import javafx.geometry.Bounds;
import main.Main;
import world.World;
import world.regions.WorldRegion;

/**
 * Handles all of the camera movements sent by Input.java. Translates and scales the corresponding scene accordingly.
 */
public class CameraControl {

    private static final double MOVEMENTOFFSET = 20;

    private static boolean
            north = false,
            south = false,
            east = false,
            west = false,
            zoomIn = false,
            zoomOut = false;

    /**
     * Updates the camera movement based off of the direction set to true.
     */
    public static void updateCamera() {
        WorldRegion world = World.getWorld();

        //ActionHandler
        if (north) world.setLayoutY(world.getLayoutY() + MOVEMENTOFFSET);
        if (east)  world.setLayoutX(world.getLayoutX() - MOVEMENTOFFSET);
        if (south)  world.setLayoutY(world.getLayoutY() - MOVEMENTOFFSET);
        if (west)  world.setLayoutX(world.getLayoutX() + MOVEMENTOFFSET);

        //Zooming
        if (zoomIn) zoomCamera(true);
        if (zoomOut) zoomCamera(false);

        Main.reDraw();
    }

    /**
     * Zooms the camera in/out depending on the direction given by input.
     * @param direction The direction that the camera is to move in
     */
    private static void zoomCamera(boolean direction) {
        WorldRegion world = World.getWorld();
        double delta = 1.2;
        double scale = world.getScaleY();
        double oldScale = scale;

        if (direction && scale < 2.4)
            scale *= delta;

        else if (!direction && scale > 0.5)
            scale /= delta;

        double f = (scale / oldScale) - 1;

        //Determining the shift in position of the camera as it zooms in on the center of the screen
        Bounds bounds = world.localToScene(world.getBoundsInLocal());
        double dx = (Main.initialScene.getWidth()/2.0 - (bounds.getWidth() / 2 + bounds.getMinX()));
        double dy = (Main.initialScene.getHeight()/2.0 - (bounds.getHeight() / 2 + bounds.getMinY()));

        //Applying the new scale
        world.setScaleX(scale);
        world.setScaleY(scale);

        //Applying the new translation
        world.setLayoutX(world.getLayoutX() - f * dx);
        world.setLayoutY(world.getLayoutY() - f * dy);
    }

    static void setNorth(boolean moving) {
        north = moving;
    }

    static void setEast(boolean moving) {
        east = moving;
    }

    static void setSouth(boolean moving) {
        south = moving;
    }

    static void setWest(boolean moving) {
        west = moving;
    }

    static void setZoomIn(boolean zooming) {
        zoomIn = zooming;
    }

    static void setZoomOut(boolean zooming) {
        zoomOut = zooming;
    }
}