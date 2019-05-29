package menus.implementations;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import main.Main;
import menus.MenuHandler;

public class TitleMenu {

    private static Rectangle background = new Rectangle(0, 0, Main.initialScene.getWidth(), Main.initialScene.getHeight());

    private static Text titleText = new Text("CRAB SIMULATOR");
    private static Button startButton = new Button("Start");
    private static Button exitButton = new Button("Exit");

    public TitleMenu() {
        createMenu();
    }

    private void createMenu() {
        titleText.setFill(Color.BLUE);
        titleText.setFont(Font.font("Verdana", FontWeight.BOLD, 64));

        startButton.setOnAction(event -> {
            MenuHandler.startPlayerSelection();
        });

        exitButton.setOnAction(event -> {
            Platform.exit();
            System.exit(0);
        });

        MenuHandler.getMenuPane().getChildren().clear();
        MenuHandler.getMenuPane().getChildren().addAll(background, titleText, startButton, exitButton);
        updatePlacements();
    }

    private void updatePlacements() {
        double screenX = Main.initialScene.getWidth();
        double screenY = Main.initialScene.getHeight();

        titleText.relocate((screenX / 2) - 325, (screenY / 2) - 100);
        startButton.relocate((screenX / 2) - 50, (screenY / 2) - 10);
        exitButton.relocate((screenX / 2) - 50, (screenY / 2) + 10);
    }
}
