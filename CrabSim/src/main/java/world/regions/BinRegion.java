package world.regions;

import javafx.scene.Group;
import world.Tile;

public class BinRegion extends Group {

    int binId;

    BinRegion(int id) {
        this.setId(id);
    }

    private void setId(int id) {
        int binId = id;
    }

    public void addTile(Tile newTile) {
        this.getChildren().add(newTile);
    }

    public int getBinId() {
        return binId;
    }
}
