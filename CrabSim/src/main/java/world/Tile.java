package world;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.AssetLoading;
import main.LoadConfiguration;
import world.regions.BinRegion;
import world.regions.BinRegionHandler;

public class Tile extends ImageView {

    private BinRegion region;

    private Tile(double xCoord, double yCoord, Image sprite, BinRegion newRegion) {
        this.setImage(sprite);
        this.setLayoutX(xCoord);
        this.setLayoutY(yCoord);
        this.region = newRegion;
    }

    static void createTiles() {
        int horizontalRegions = LoadConfiguration.getWorldHRegions();
        int verticalRegions = (LoadConfiguration.isWorldSquare()) ? horizontalRegions : LoadConfiguration.getWorldVRegions();
        for (int i = 0; i < horizontalRegions; i++) {
            for (int j = 0; j < verticalRegions; j++) {
                BinRegion newRegion = BinRegionHandler.createNewRegion();
                BinRegionHandler.createGhostRegion(i * (LoadConfiguration.getBinRegionSize() * 400), j * (LoadConfiguration.getBinRegionSize() * 400), LoadConfiguration.getBinRegionSize() * 400, LoadConfiguration.getBinRegionSize() * 400, newRegion.getBinId());
                newRegion.relocate(i * (LoadConfiguration.getBinRegionSize() * 400), j * (LoadConfiguration.getBinRegionSize() * 400));

                for (int k = 0; k < LoadConfiguration.getBinRegionSize(); k++)
                    for (int h = 0; h < LoadConfiguration.getBinRegionSize(); h++)
                        newRegion.addTile(new Tile(400 * k, 400 * h, AssetLoading.defaultWorldTile, newRegion));
            }
        }
        World.getWorld().setBinRegionIds(0, BinRegionHandler.newestRegionId - 1);
    }

    public BinRegion getRegion() {
        return this.region;
    }
}
