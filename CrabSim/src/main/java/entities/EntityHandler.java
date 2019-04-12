package entities;

import java.util.ArrayList;

public class EntityHandler {

    private static ArrayList<Being> allEntities = new ArrayList<>();

    public static ArrayList<Being> getEntities() {
        return allEntities;
    }

    public static void addEntity(Being newEntity) {
        allEntities.add(newEntity);
    }
}
