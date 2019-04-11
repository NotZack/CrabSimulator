package metaControl;

import entities.players.PlayerHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import main.Main;
import org.jetbrains.annotations.NotNull;

public class Input {

    public static void enableInput(@NotNull Scene scene) {

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {

            KeyCode keyPressed = key.getCode();

            //Fullscreens the sim window
            if (keyPressed.equals(KeyCode.F)) Main.initFullScreen();

            if (keyPressed.equals(KeyCode.W)) PlayerHandler.getPlayer(1).relocate(PlayerHandler.getPlayer(1).getLayoutX() + 10, PlayerHandler.getPlayer(1).getLayoutY() + 10);
            //TODO: Remove debug
            if (keyPressed.equals(KeyCode.O)) {
                System.out.println("DEBUG");
            }
        });

        scene.addEventHandler(KeyEvent.KEY_RELEASED, (key) -> {
            KeyCode keyReleased = key.getCode();

        });
    }
}