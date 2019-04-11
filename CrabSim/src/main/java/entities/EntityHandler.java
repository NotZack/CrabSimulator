package entities;

import entities.players.Player;

import java.util.ArrayList;

public class EntityHandler {

    private static ArrayList<Player> players = new ArrayList<>();

    private static ArrayList<Being> allEntities = new ArrayList<>();

    public static ArrayList<Being> getEntities() {
        return allEntities;
    }
}
