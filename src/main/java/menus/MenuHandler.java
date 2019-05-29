package menus;

import javafx.scene.layout.Pane;
import menus.implementations.PlayerSelectionMenu;
import menus.implementations.TitleMenu;

public class MenuHandler {

    private static Pane activeMenu = new Pane();

    public static Pane startTitleMenu() {
        new TitleMenu();
        return activeMenu;
    }

    public static void startPlayerSelection() {
        new PlayerSelectionMenu();
    }

    public static Pane getMenuPane() {
        return activeMenu;
    }
}
