package metaControl;

import entities.players.Player;
import java.util.ArrayList;

/**
 * Handles all of the camera movements sent by Input.java. Translates and scales the corresponding scene accordingly.
 */
public class CameraControl {

    private static ArrayList<CameraControl> cameras = new ArrayList<>();

    private Player playerParent;

    private boolean disabled = false;

    public CameraControl(Player playerParent) {
        this.playerParent = playerParent;
        cameras.add(this);
    }

    public static void updateAllCameras() {

        for (CameraControl camera : cameras) {
            if (camera.playerParent != null && !camera.disabled) {
                camera.playerParent.screen.paneToUpdate.setLayoutX((-camera.playerParent.getTranslateX() + (camera.playerParent.screen.getWidth() / 2.0)));
                camera.playerParent.screen.paneToUpdate.setLayoutY((-camera.playerParent.getTranslateY() + (camera.playerParent.screen.getHeight() / 2.0)));
                camera.playerParent.screen.cover.setLayoutX(-camera.playerParent.screen.paneToUpdate.getLayoutX());
                camera.playerParent.screen.cover.setLayoutY(-camera.playerParent.screen.paneToUpdate.getLayoutY());
            }
        }
    }

    public void disableCamera() {
        disabled = true;
    }
}