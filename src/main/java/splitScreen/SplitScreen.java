package splitScreen;

import entities.players.Player;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SplitScreen extends Pane {

    public Pane paneToUpdate;
    public Rectangle cover;

    SplitScreen(Player player) {
        paneToUpdate = new Pane();
        player.screen = this;

        paneToUpdate.setBorder(new Border(new BorderStroke(Color.color(Math.random(), Math.random(), Math.random()),
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        Rectangle testRec = new Rectangle();
        testRec.setLayoutX(100);
        testRec.setWidth(50);
        testRec.setHeight(50);
        testRec.setLayoutY(100);
        testRec.setFill(Color.color(Math.random(), Math.random(), Math.random()));
        paneToUpdate.getChildren().add(testRec);
        this.getChildren().addAll(paneToUpdate);
    }
}