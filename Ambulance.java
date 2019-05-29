import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ambulance here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ambulance extends Actor
{
    boolean dead = false;
    int lastX;

    /**
     * Act - do whatever the Ambulance wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        Actor crab = getOneObjectAtOffset(0,0, Crab.class);
        
        if (crab != null) {
            World world;
            world = getWorld();
            world.removeObject(crab);
        }
        
        if (!dead) {
            
            lastX = this.getX();
            
            move(5);
            
            if (this.getX() == lastX) {
                World world;
                world = getWorld();
                world.removeObject(this);
                dead = true;
            }
        }
    }    
}
