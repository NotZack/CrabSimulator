package menus.implementations;

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
import menus.PlayerChoices;

public class PlayerSelectionMenu{

    private static Rectangle background = new Rectangle(0, 0, Main.initialScene.getWidth(), Main.initialScene.getHeight());

    private static Text titleText = new Text("SELECT PLAYER");
    private static Button submitButton = new Button("Submit");

    private static ImageView crab;
    private static ImageView shrimp;

    private static Text playerText = new Text("NumberOfPlayers");
    private static TextField numOfPlayers = new TextField();

    public PlayerSelectionMenu() {
        createMenu();
    }

    private void createMenu() {
        titleText.setFill(Color.BLUE);
        titleText.setFont(Font.font("Verdana", FontWeight.BOLD, 64));

        playerText.setFill(Color.BLUE);
        playerText.setFont(Font.font("Verdana", FontWeight.BOLD, 18));

        crab = new ImageView(AssetLoading.crabSprite);
        crab.setDisable(true);
        crab.setOpacity(0.25);

        shrimp = new ImageView(AssetLoading.shrimpSprite);
        shrimp.setDisable(true);
        shrimp.setOpacity(0.25);

        crab.setOnMouseClicked(event -> {
            PlayerChoices.setPlayerChosenSprite(crab.getImage());
            updateText();
        });
        shrimp.setOnMouseClicked(event -> {
            PlayerChoices.setPlayerChosenSprite(shrimp.getImage());
            updateText();
        });

        submitButton.setOnAction(event -> {
            try {
                PlayerChoices.setNumberOfPlayers(1);
                PlayerChoices.clearChosenSprites();
                PlayerChoices.setNumberOfPlayers(Integer.parseInt(numOfPlayers.getCharacters().toString()));

                crab.setDisable(false);
                crab.setOpacity(1);

                shrimp.setDisable(false);
                shrimp.setOpacity(1);

                updateText();

            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        });

        MenuHandler.getMenuPane().getChildren().clear();
        MenuHandler.getMenuPane().getChildren().addAll(background, titleText, crab, shrimp, playerText, submitButton, numOfPlayers);
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
    }

    private void updateText() {
        playerText.setText("PLAYER " + (PlayerChoices.getChosenSprites().size() + 1) + " CHOOSE");
    }
}
