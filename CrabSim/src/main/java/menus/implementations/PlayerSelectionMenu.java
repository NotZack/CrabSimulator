package menus.implementations;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
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

    private static ImageView selection1;

    public PlayerSelectionMenu() {
        createMenu();
    }

    private void createMenu() {
        titleText.setFill(Color.BLUE);
        titleText.setFont(Font.font("Verdana", FontWeight.BOLD, 64));

        selection1 = new ImageView(AssetLoading.crabSprite);

        selection1.setOnMouseClicked(event -> {
            PlayerChoices.setPlayerChosenSprite(selection1.getImage());
            MenuHandler.getMenuPane().getChildren().clear();
            Main.simInit();
        });

        MenuHandler.getMenuPane().getChildren().clear();
        MenuHandler.getMenuPane().getChildren().addAll(background, titleText, selection1);
        updatePlacements();
    }

    private void updatePlacements() {
        double screenX = Main.initialScene.getWidth();
        double screenY = Main.initialScene.getHeight();

        titleText.relocate((screenX / 2) - 325, (screenY / 2) - 100);
        selection1.relocate((screenX / 2) - 50, (screenY / 2) + 10);
    }
}
