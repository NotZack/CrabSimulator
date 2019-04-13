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

    public static boolean disabled;

    /**
     * Updates the camera movement based off of the direction set to true.
     */
    public static void updateCamera() {
        WorldRegion world = World.getWorld();

        Player playerCenter = PlayerHandler.getPlayer(PlayerHandler.getPlayersList().get(0).playerId);

        if (playerCenter != null) {
            world.setTranslateX((-playerCenter.getTranslateX() + -playerCenter.getLayoutX()) + (Main.initialScene.getWidth() / 2.0));
            world.setTranslateY((-playerCenter.getTranslateY() + -playerCenter.getLayoutY()) + (Main.initialScene.getHeight() / 2.0));
        }

        Main.reDraw();
    }

    public static void disableCamera() {
        disabled = true;
    }
}