package metaControl;

import entities.players.Player;
import entities.players.PlayerHandler;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import main.Main;
import menus.MenuHandler;
import menus.implementations.PlayerSelectionMenu;
import org.jetbrains.annotations.NotNull;

public class Input {

    private static int keyMapCounter = 0;

    private static EventHandler<KeyEvent> keyMappingHandler;

    public static void enableInput(@NotNull Scene scene) {

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {

            KeyCode keyPressed = key.getCode();

            //Fullscreens the sim window
            if (keyPressed.equals(KeyCode.F)) Main.initFullScreen();

            for (Player player : PlayerHandler.getPlayersList()) {
                if (keyPressed.equals(player.rotateLeftKey))
                    player.setRotateLeft();
                else if (keyPressed.equals(player.shootKey))
                    player.setShoot();
                else if (keyPressed.equals(player.rotateRightKey))
                    player.setRotateRight();
            }

            //TODO: Remove debug
            if (keyPressed.equals(KeyCode.O)) {
                System.out.println("DEBUG");
            }
        });

        scene.addEventHandler(KeyEvent.KEY_RELEASED, (key) -> {
            KeyCode keyReleased = key.getCode();

            for (Player player : PlayerHandler.getPlayersList()) {
                if (keyReleased.equals(player.rotateLeftKey))
                    player.stopLeftRotate();
                else if (keyReleased.equals(player.shootKey))
                    player.stopShoot();
                else if (keyReleased.equals(player.rotateRightKey))
                    player.stopRightRotate();
            }
        });
    }

    public static void mapNextLocalInput(Player player) {

        keyMappingHandler = e -> {
            KeyCode keyPressed = e.getCode();

            keyMapCounter++;

            if (keyMapCounter == 1)
                player.rotateLeftKey = keyPressed;
            else if (keyMapCounter == 2)
                player.shootKey = keyPressed;
            else if (keyMapCounter == 3) {
                player.rotateRightKey = keyPressed;
                keyMapCounter = 0;
            }

            PlayerSelectionMenu.updateKeysChosenText();
        };

        MenuHandler.getMenuPane().addEventHandler(KeyEvent.KEY_PRESSED, keyMappingHandler);
    }

    public static void disableInputMapping() {
        keyMapCounter = 0;

        if (keyMappingHandler != null)
            MenuHandler.getMenuPane().removeEventHandler(KeyEvent.KEY_PRESSED, keyMappingHandler);
    }
}