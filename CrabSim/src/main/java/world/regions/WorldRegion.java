package world.regions;

import javafx.scene.layout.Pane;

public class WorldRegion extends Pane {

    private int minBinRegionId;
    private int maxBinRegionId;

    public void setBinRegionIds(int min, int max) {
        minBinRegionId = min;
        maxBinRegionId = max;
    }

    int getMinBinRegionId() {
        return minBinRegionId;
    }

    int getMaxBinRegionId() {
        return maxBinRegionId;
    }
}
