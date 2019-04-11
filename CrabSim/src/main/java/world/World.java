package world;


import world.regions.WorldRegion;

public class World {

    private static WorldRegion baseWorld;

    public static void init() {
        baseWorld = new WorldRegion();
        Tile.createTiles();
    }

    public static WorldRegion getWorld() {
        return baseWorld;
    }
}