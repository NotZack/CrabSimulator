package main;

import entities.Being;
import entities.Collision;
import entities.EntityHandler;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import entities.enemies.EnemyHandler;
import entities.players.PlayerHandler;
import menus.MenuHandler;
import metaControl.CameraControl;
import metaControl.Input;
import world.World;
import world.regions.BinRegionHandler;
import world.regions.WorldRegion;

import java.util.ArrayList;

public class Main extends Application {

    private static Group root = new Group();
    public static Scene initialScene = new Scene(root, 800, 600, Color.BLACK);
    private static long simSpeed = 128_666_666L;

    private static boolean paused;

    private static double deltaTime = 0;

    private static Stage primaryStage;

    public static void simInit() {
        Input.enableInput(initialScene);
        World.init();
        EnemyHandler.init();
        PlayerHandler.init();

        Platform.runLater(() ->
            root.getChildren().add(World.getWorld())
        );

        simLoop();
    }

    public static void initFullScreen() {
        primaryStage.setFullScreen(true);
    }

    private static void simLoop() {
        //timer runs constantly
        //Time difference from last frame
        AnimationTimer simLoop = new AnimationTimer() {
            private long lastUpdate = 0;

            @Override
            public void handle(long frameTime) {
                CameraControl.updateCamera();

                //Time difference from last frame
                deltaTime = 0.00000001 * (frameTime - lastUpdate);

                if (deltaTime <= 0.1 || deltaTime >= 1.0)
                    deltaTime = 0.00000001 * simSpeed;

                if (frameTime - lastUpdate >= simSpeed) {
                    if (!paused)
                        updateTick();
                    lastUpdate = frameTime;
                }
            }
        };
        simLoop.start();
    }

    private static void updateTick() {
        boolean collided = false;

        ArrayList<Being> entityList = EntityHandler.getEntities();
        //Decides what action each cow should be doing
        for (int i = 0; i < entityList.size(); i++) {
            for (Being being : entityList) {
                collided = Collision.checkCollision(entityList.get(i), being);

                if (collided)
                    Collision.handleCollision(entityList.get(i), being);
            }

            if (!collided)
                entityList.get(i).update();

            collided = false;
            entityList.get(i).update();
        }
    }

    public static void reDraw() {
        WorldRegion world = World.getWorld();
        ArrayList<Integer> toDraw = new ArrayList<>();

        for (int i = 0; i < ((world.getMaxBinRegionId() - world.getMinBinRegionId()) + 1); i++) {
            if (BinRegionHandler.ghostRegions.get( (world.getMinBinRegionId() + i) ).localToScene(
                    BinRegionHandler.ghostRegions.get( (world.getMinBinRegionId() + i) ).getBoundsInLocal()
            ).intersects(0, 0, initialScene.getWidth(), initialScene.getHeight())
            )
                toDraw.add(BinRegionHandler.binRegionMap.get( (world.getMinBinRegionId() + i) ).getBinId());
        }
        if (!toDraw.isEmpty())
            BinRegionHandler.setActiveRegions(toDraw);
    }

    @Override
    public void start(Stage primaryStage) {
        Main.primaryStage = primaryStage;
        primaryStage.setTitle("CrabSim");

        primaryStage.show();
        primaryStage.setScene(initialScene);

        LoadConfiguration.loadConfigurationFile();
        AssetLoading.init();

        if (LoadConfiguration.isFullscreen())
            initFullScreen();

        root.getChildren().add(MenuHandler.startTitleMenu());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
