package metaControl;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import main.Main;
import org.jetbrains.annotations.NotNull;

public class Input {

    public static void enableInput(@NotNull Scene scene) {

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {

            KeyCode keyPressed = key.getCode();

            //ActionHandler
            if (keyPressed.equals(KeyCode.W)) CameraControl.setNorth(true);
            if (keyPressed.equals(KeyCode.A)) CameraControl.setWest(true);
            if (keyPressed.equals(KeyCode.S)) CameraControl.setSouth(true);
            if (keyPressed.equals(KeyCode.D)) CameraControl.setEast(true);

            if (keyPressed.equals(KeyCode.UP)) CameraControl.setNorth(true);
            if (keyPressed.equals(KeyCode.LEFT)) CameraControl.setWest(true);
            if (keyPressed.equals(KeyCode.DOWN)) CameraControl.setSouth(true);
            if (keyPressed.equals(KeyCode.RIGHT)) CameraControl.setEast(true);

            //Zooming
            if (keyPressed.equals(KeyCode.Z)) CameraControl.setZoomIn(true);
            if (keyPressed.equals(KeyCode.X)) CameraControl.setZoomOut(true);

            //Fullscreens the sim window
            if (keyPressed.equals(KeyCode.F)) Main.initFullScreen();

            //TODO: Remove debug
            if (keyPressed.equals(KeyCode.O)) {
                System.out.println("DEBUG");
            }
        });

        scene.addEventHandler(KeyEvent.KEY_RELEASED, (key) -> {
            KeyCode keyReleased = key.getCode();

            //ActionHandler
            if (keyReleased.equals(KeyCode.W)) CameraControl.setNorth(false);
            if (keyReleased.equals(KeyCode.A)) CameraControl.setWest(false);
            if (keyReleased.equals(KeyCode.S)) CameraControl.setSouth(false);
            if (keyReleased.equals(KeyCode.D)) CameraControl.setEast(false);

            if (keyReleased.equals(KeyCode.UP)) CameraControl.setNorth(false);
            if (keyReleased.equals(KeyCode.LEFT)) CameraControl.setWest(false);
            if (keyReleased.equals(KeyCode.DOWN)) CameraControl.setSouth(false);
            if (keyReleased.equals(KeyCode.RIGHT)) CameraControl.setEast(false);

            //Zooming
            if (keyReleased.equals(KeyCode.Z)) CameraControl.setZoomIn(false);
            if (keyReleased.equals(KeyCode.X)) CameraControl.setZoomOut(false);
        });
    }
}
