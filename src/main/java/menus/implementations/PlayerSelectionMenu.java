package menus.implementations;

import entities.players.Crab;
import entities.players.Player;
import entities.players.PlayerHandler;
import entities.players.Shrimp;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import main.AssetLoading;
import main.Main;
import menus.MenuHandler;
import metaControl.Input;

public class PlayerSelectionMenu {

    private static Rectangle background = new Rectangle(0, 0, Main.initialScene.getWidth(), Main.initialScene.getHeight());

    private static Text titleText = new Text("SELECT PLAYER");
    private static Button submitButton = new Button("Submit");

    private static ImageView crab;
    private static ImageView shrimp;

    private static Text playerText = new Text("NumberOfPlayers");
    private static Text rotateLeftKey = new Text();
    private static Text rotateRightKey = new Text();
    private static Text shootKey = new Text();

    private static Button keyMapSubmitButton = new Button("SUBMIT KEYS");
    private static TextField numOfPlayers = new TextField();

    public PlayerSelectionMenu() {
        createMenu();
    }

    private void createMenu() {
        titleText.setFill(Color.BLUE);
        titleText.setFont(Font.font("Verdana", FontWeight.BOLD, 64));

        playerText.setFill(Color.BLUE);
        playerText.setFont(Font.font("Verdana", FontWeight.BOLD, 18));

        rotateLeftKey.setFill(Color.BLUE);
        rotateLeftKey.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        rotateRightKey.setFill(Color.BLUE);
        rotateRightKey.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        shootKey.setFill(Color.BLUE);
        shootKey.setFont(Font.font("Verdana", FontWeight.BOLD, 12));

        keyMapSubmitButton.setOpacity(0);
        keyMapSubmitButton.setDisable(true);

        numOfPlayers.setFocusTraversable(false);

        crab = new ImageView(AssetLoading.crabSprite);
        shrimp = new ImageView(AssetLoading.shrimpSprite);

        disableSpriteSelection();

        crab.setOnMouseClicked(event -> {
            PlayerHandler.createNewPlayer(new Crab());
            controlsSelection();
        });
        shrimp.setOnMouseClicked(event -> {
            PlayerHandler.createNewPlayer(new Shrimp());
            controlsSelection();
        });
        keyMapSubmitButton.setOnMouseClicked(event -> {
            clearKeysChosen();
            Input.disableInputMapping();
            spriteSelectionText();
            enableSpriteSelection();

            if (PlayerHandler.getPlayersList().size() == PlayerHandler.numberOfPlayers) {
                MenuHandler.getMenuPane().getChildren().clear();
                Main.simInit();
            }
        });

        submitButton.setOnAction(event -> {
            try {
                PlayerHandler.clearPlayers();
                PlayerHandler.setNumberOfPlayers(Integer.parseInt(numOfPlayers.getCharacters().toString()));
                clearKeysChosen();
                Input.disableInputMapping();

                spriteSelectionText();
                enableSpriteSelection();

            } catch (NumberFormatException e) {
                System.out.println("Thats not a number dummy");
            }
        });

        MenuHandler.getMenuPane().getChildren().clear();
        MenuHandler.getMenuPane().getChildren().addAll(background, titleText, crab, shrimp, playerText, submitButton, rotateLeftKey, rotateRightKey, keyMapSubmitButton, shootKey, numOfPlayers);
        updatePlacements();
    }

    private void updatePlacements() {
        double screenX = Main.initialScene.getWidth();
        double screenY = Main.initialScene.getHeight();

        titleText.relocate((screenX / 2) - 325, (screenY / 2) - 100);

        crab.relocate((screenX / 2) - 50, (screenY / 2) + 20);
        shrimp.relocate((screenX / 2) + 75, (screenY / 2) + 20);
        playerText.relocate((screenX / 2) - 400, (screenY / 2) - 10);
        submitButton.relocate((screenX / 2) - 225, (screenY / 2) + 20);
        numOfPlayers.relocate((screenX / 2) - 400, (screenY / 2) + 20);

        rotateLeftKey.relocate((screenX / 2) - 400, (screenY / 2) + 75);
        shootKey.relocate((screenX / 2) - 400, (screenY / 2) + 100);
        rotateRightKey.relocate((screenX / 2) - 400, (screenY / 2) + 125);

        keyMapSubmitButton.relocate((screenX / 2) - 400, (screenY / 2) + 155);
    }

    private void spriteSelectionText() {
        numOfPlayers.setDisable(false);
        submitButton.setDisable(false);
        submitButton.setOpacity(1);
        playerText.setText("PLAYER " + (PlayerHandler.getPlayersList().size() + 1) + " SELECT CRUSTACEAN");
    }

    private void controlsSelection() {
        playerText.setText("PLAYER " + (PlayerHandler.getPlayersList().size()) + " INPUT CONTROLS");
        rotateLeftKey.setText("Rotate Left: ");
        shootKey.setText("Shoot: ");
        rotateRightKey.setText("Rotate Right");
        keyMapSubmitButton.setOpacity(1);
        keyMapSubmitButton.setDisable(false);
        numOfPlayers.setDisable(true);
        submitButton.setDisable(true);
        submitButton.setOpacity(0.25);
        Input.mapNextLocalInput(PlayerHandler.getPlayer(PlayerHandler.getPlayersList().size()));
    }

    public static void updateKeysChosenText() {
        if (PlayerHandler.getPlayer(PlayerHandler.getPlayersList().size()).rotateLeftKey != null)
            rotateLeftKey.setText("Rotate Left: " + PlayerHandler.getPlayer(PlayerHandler.getPlayersList().size()).rotateLeftKey.getName());
        if (PlayerHandler.getPlayer(PlayerHandler.getPlayersList().size()).shootKey != null)
            shootKey.setText("Shoot: " + PlayerHandler.getPlayer(PlayerHandler.getPlayersList().size()).shootKey.getName());
        if (PlayerHandler.getPlayer(PlayerHandler.getPlayersList().size()).rotateRightKey != null)
            rotateRightKey.setText("Rotate Right: " + PlayerHandler.getPlayer(PlayerHandler.getPlayersList().size()).rotateRightKey.getName());
    }

    private static void clearKeysChosen() {
        rotateLeftKey.setText("");
        shootKey.setText("");
        rotateRightKey.setText("");
        keyMapSubmitButton.setDisable(true);
        keyMapSubmitButton.setOpacity(0);
    }

    private void enableSpriteSelection() {
        crab.setDisable(false);
        crab.setOpacity(1);

        shrimp.setDisable(false);
        shrimp.setOpacity(1);
    }

    private void disableSpriteSelection() {
        crab.setDisable(true);
        crab.setOpacity(0.25);

        shrimp.setDisable(true);
        shrimp.setOpacity(0.25);
    }
}
