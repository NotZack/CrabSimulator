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
import splitScreen.SplitScreen;
import splitScreen.SplitScreenHandler;
import worldModel.World;

import java.util.ArrayList;

/**
 * Sets up JavaFX and runs the main game loop.
 */
public class Main extends Application {

    private static Stage primaryStage;

    private static Group root = new Group();
    public static Scene initialScene = new Scene(root, 800, 600, Color.BLACK);

    //Part of the main loop frame speed calculation
    private static long simSpeed = 20_666_666L;

    private static boolean paused;

    //The time in between frames used to smooth out movement
    public static double deltaTime = 0;

    /**
     * Initializes world objects and starts the main loop.
     */
    public static void simInit() {
        Input.enableInput(initialScene);
        World.init();
        EnemyHandler.init();
        PlayerHandler.init();

        Platform.runLater(() ->  {
            for (SplitScreen splitScreen : SplitScreenHandler.getAllScreens())
                root.getChildren().add(splitScreen);
        });
        simLoop();
    }

    /**
     * Makes the application fullscreen
     */
    public static void initFullScreen() {
        primaryStage.setFullScreen(true);
    }

    /**
     * Calls update methods periodically dependant on time between frames and the simSpeed.
     */
    private static void simLoop() {

        AnimationTimer simLoop = new AnimationTimer() {
            private long lastUpdate = 0;

            @Override
            public void handle(long frameTime) {

                //Time difference from last frame
                deltaTime = 0.00000001 * (frameTime - lastUpdate);

                if (deltaTime <= 0.1 || deltaTime >= 1.0)
                    deltaTime = 0.00000001 * simSpeed;

                if (frameTime - lastUpdate >= simSpeed) {
                    if (!paused)
                        updateTick();
                    lastUpdate = frameTime;
                }

                CameraControl.updateAllCameras();
            }
        };
        simLoop.start();
    }

    /**
     * Checks and updates every entity for collision.
     */
    private static void updateTick() {
        boolean collided = false;

        ArrayList<Being> entityList = EntityHandler.getEntities();
        //Decides what action each cow should be doing
        for (int i = 0; i < entityList.size(); i++) {
            if (entityList.get(i).markedAsDead)
                entityList.get(i).kill();
            for (Being being : entityList) {
                collided = Collision.checkCollision(entityList.get(i), being);

                if (collided)
                    Collision.handleCollision(entityList.get(i), being);
            }

            if (!collided)
                entityList.get(i).update();

            collided = false;
        }
    }

    /**
     * Sets up the application, gathering and placing all resources needed.
     * @param primaryStage The stage (window) of the JavaFX application
     */
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

    /**
     * Starts everything
     * @param args Environment variables
     */
    public static void main(String[] args) {
        launch(args);
    }
}
