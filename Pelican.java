import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pelican here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pelican extends Actor
{
    
    int counter = 0;
    /**
     * Act - do whatever the Pelican wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        counter++;
        
        if (counter == 100) {
            turn(Greenfoot.getRandomNumber(200));
            counter = 0;
        }
        move(Greenfoot.getRandomNumber(5));
    }    
}
