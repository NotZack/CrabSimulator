import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lobster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lobster extends Actor
{
    
    int fireRate = 60;
    /**
     * Act - do whatever the Lobster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(Greenfoot.getRandomNumber(20));
        turn(Greenfoot.getRandomNumber(20));
        
        if (fireRate >= 60) {
                Actor bullet = new EnemyBullet();
                bullet.setRotation(this.getRotation() + 270);
                getWorld().addObject(bullet, this.getX(), this.getY());
                fireRate = 0;
        }
        fireRate++;
    }    
}
