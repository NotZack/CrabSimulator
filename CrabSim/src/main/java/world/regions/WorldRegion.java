package world.regions;

import javafx.scene.layout.Pane;

public class WorldRegion extends Pane {

    private int minBinRegionId;
    private int maxBinRegionId;

    public void setBinRegionIds(int min, int max) {
        minBinRegionId = min;
        maxBinRegionId = max;
    }

    public int getMinBinRegionId() {
        return minBinRegionId;
    }

    public int getMaxBinRegionId() {
        return maxBinRegionId;
    }
}
