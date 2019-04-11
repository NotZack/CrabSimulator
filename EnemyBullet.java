import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyBullet extends Actor
{
    int lastX;
    int lastY;
    boolean dead = false;
    /**
     * Act - do whatever the EnemyBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Actor possibleCollide = getOneObjectAtOffset(0,0, Object.class);
        
        if (possibleCollide != null && !(possibleCollide instanceof Bullet) && !(possibleCollide instanceof Loser) && !(possibleCollide instanceof Lobster)  && !(possibleCollide instanceof Worm) && !(possibleCollide instanceof Pelican) && !(possibleCollide instanceof Counter)) {
            World world;
            world = getWorld();
            
            if (!(possibleCollide instanceof Crab)) {
                world.removeObject(possibleCollide);
            }
            else {
                ((Crab) possibleCollide).isMoving = false;
                Actor amb = new Ambulance();
                world.addObject(amb, 1, (int) this.getY());
                
                Actor loserScreen = new Loser();
                GreenfootImage textImage = new GreenfootImage("You are lose", 69, Color.WHITE, Color.BLACK);
                
                loserScreen.setImage(textImage);
                textImage.drawString("gdrgdrgdrg", 5, 5);
                
                if (loserScreen != null) {
                    world.addObject(loserScreen, world.getWidth() / 2,world.getHeight() / 2);
                }
            }
            
            world.removeObject(this);
            dead = true;

            
            if (world.getObjects(Worm.class).isEmpty()) {
                Greenfoot.playSound("victory.mp3");
                Actor loserScreen = new Loser();
                GreenfootImage textImage = new GreenfootImage("You are lose", 69, Color.WHITE, Color.BLACK);
                
                loserScreen.setImage(textImage);
                textImage.drawString("gdrgdrgdrg", 5, 5);
                if (loserScreen != null) {
                    world.addObject(loserScreen, world.getWidth() / 2,world.getHeight() / 2);
                    Greenfoot.stop();
                }
            }
        }
        
        if (!dead) {
            
            lastY = this.getY();
            lastX = this.getX();
            
            move(10);
            
            if (this.getX() == lastX || this.getY() == lastY) {
                World world;
                world = getWorld();
                world.removeObject(this);
                dead = true;
            }
        }
    }    
}
