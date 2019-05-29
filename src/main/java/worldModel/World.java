package worldModel;

import javafx.scene.layout.Pane;

public class World {

    private static Pane world;

    public static void init() {
        world = new Pane();
    }

    public static Pane getWorld() {
        return world;
    }
}
