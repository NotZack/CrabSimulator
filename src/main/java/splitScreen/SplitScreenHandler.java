package splitScreen;

import entities.players.Player;
import entities.players.PlayerHandler;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import main.Main;
import worldModel.World;

import java.util.ArrayList;

public class SplitScreenHandler {

    private static ArrayList<SplitScreen> allScreens = new ArrayList<>();

    public static void initPlayerScreen(Player player) {
        SplitScreen playerScreen = new SplitScreen(player);
        playerScreen.setBorder(new Border(new BorderStroke(Color.color(Math.random(), Math.random(), Math.random()),
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        allScreens.add(playerScreen);
        calculateScreenPosition(playerScreen);
        createCopyNodes(playerScreen);

        playerScreen.cover = new Rectangle(0,0, playerScreen.getPrefWidth(), playerScreen.getPrefHeight());
        playerScreen.cover.setFill(Color.RED);
        playerScreen.paneToUpdate.setClip(playerScreen.cover);
    }

    private static void createCopyNodes(SplitScreen playerScreen) {
        for (Node modelNode : World.getWorld().getChildren()) {
            if (modelNode instanceof ImageView) {
                if (modelNode instanceof Player) {
                    System.out.println(playerScreen + "Here");
                }
                ImageView copyNode = new ImageView(((ImageView) modelNode).getImage());
                copyNode.translateXProperty().bind(modelNode.translateXProperty());
                copyNode.translateYProperty().bind(modelNode.translateYProperty());
                copyNode.rotateProperty().bind(modelNode.rotateProperty());
                playerScreen.paneToUpdate.getChildren().add(copyNode);
            }
        }
    }

    private static void calculateScreenPosition(SplitScreen screen) {
        int xPanes = (PlayerHandler.numberOfPlayers / 4.0 > 1.0) ? 4 : PlayerHandler.numberOfPlayers;
        int yPanes = (PlayerHandler.numberOfPlayers / 4) + ((PlayerHandler.numberOfPlayers % 4 > 0) ? 1 : 0);
        int thisXIndex = allScreens.indexOf(screen) % 4;
        int thisYIndex = allScreens.indexOf(screen) / 4;

        double screenWidth = Main.initialScene.getWidth() / xPanes;
        double screenHeight = Main.initialScene.getHeight() / yPanes;

        screen.setLayoutX(thisXIndex * screenWidth);
        screen.setLayoutY(thisYIndex * screenHeight);

        screen.setPrefWidth(screenWidth);
        screen.setPrefHeight(screenHeight);
    }

    public static ArrayList<SplitScreen> getAllScreens() {
        return allScreens;
    }
}