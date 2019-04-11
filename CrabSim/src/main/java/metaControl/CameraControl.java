package metaControl;

import entities.players.Player;
import entities.players.PlayerHandler;
import main.Main;
import world.World;
import world.regions.WorldRegion;

/**
 * Handles all of the camera movements sent by Input.java. Translates and scales the corresponding scene accordingly.
 */
public class CameraControl {

    /**
     * Updates the camera movement based off of the direction set to true.
     */
    public static void updateCamera() {
        WorldRegion world = World.getWorld();

        world.setLayoutX(-PlayerHandler.getPlayer(1).getLayoutX() + Main.initialScene.getWidth() / 2.0);
        world.setLayoutY(-PlayerHandler.getPlayer(1).getLayoutY() + Main.initialScene.getHeight() / 2.0);

        Main.reDraw();
    }
}