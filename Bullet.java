
    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    
    /**
     * Write a description of class Bullet here.
     * 
     * @author (your name) 
     * @version (a version number or a date)
     */
    public class Bullet extends Actor
    {
        
        int lastY;
        int lastX;
        boolean dead = false;
        
        /**
         * Act - do whatever the Bullet wants to do. This method is called whenever
         * the 'Act' or 'Run' button gets pressed in the environment.
         */
        public void act() 
        {
            Actor possibleCollide = getOneObjectAtOffset(0,0, Object.class);
            
            if (possibleCollide != null && !(possibleCollide instanceof EnemyBullet) && !(possibleCollide instanceof Crab)  && !(possibleCollide instanceof Counter)) {
                World world;
                world = getWorld();
                
                world.removeObject(possibleCollide);
                world.removeObject(this);
                dead = true;
                
                if (possibleCollide instanceof Worm) {
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
                    if (this.getRotation() != 0)
                        this.setRotation(this.getRotation() + 90 + (Greenfoot.getRandomNumber(60)));
                    else {
                        this.setRotation(90);
                    }
                
            }
        }
    }    
}
