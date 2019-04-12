package world.regions;

import javafx.scene.Group;
import world.Tile;

public class BinRegion extends Group {

    int binId;

    BinRegion(int id) {
        this.setId(id);
    }

    private void setId(int id) {
        binId = id;
    }

    public void addTile(Tile newTile) {
        this.getChildren().add(newTile);
    }

    public int getBinId() {
        return binId;
    }

    public int getMaxX() {
        return (int) this.getChildren().get(this.getChildren().size() - 1).getLayoutX() + 400;
    }

    public int getMaxY() {
        return (int) this.getChildren().get(this.getChildren().size() - 1).getLayoutY() + 400;
    }
}
