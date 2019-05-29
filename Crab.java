    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    
    //GreenfootImage textImage = new GreenfootImage("" + (crabX), 12, Color.WHITE, Color.BLACK);
        
    //setImage(textImage);
    //textImage.drawString("", 50, 50);
    public class Crab extends Actor
    {
        boolean isMoving = true;
        
        int fireRate = 50;
        /**
         * Act - do whatever the Crab wants to do. This method is called whenever
         * the 'Act' or 'Run' button gets pressed in the environment.
         */
        public void act() 
        {
            int howFar = Greenfoot.getRandomNumber(10);
            int rotate = Greenfoot.getRandomNumber(5);
            
        if (isMoving) {
                
            move(howFar);
    
            if (Greenfoot.isKeyDown("left")) {
                turn(-rotate);
            }
            if (Greenfoot.isKeyDown("right")) {
                turn(rotate);
            }
            if (Greenfoot.isKeyDown("up") && fireRate >= 50) {
                Actor bullet = new Bullet();
                bullet.setRotation(this.getRotation() + 270);
                getWorld().addObject(bullet, this.getX(), this.getY());
                fireRate = 0;
            }
            fireRate++;
        }
        
        Actor worm;
        worm = getOneObjectAtOffset(0,0, Worm.class);
        
        if (worm != null) {
            World world;
            world = getWorld();
            world.removeObject(worm);
            
            Greenfoot.playSound("eating.wav");
            addScore();
            
            if (getWorld().getObjects(Worm.class).isEmpty()) {
                Greenfoot.playSound("victory.mp3");
                Greenfoot.stop();
            }
        }
        
        Actor lobster = getOneObjectAtOffset(0,0, Lobster.class);
        Actor pelican = getOneObjectAtOffset(0,0, Pelican.class);
        
        if (isMoving && (lobster != null || pelican != null)) {
            World world;
            world = getWorld();

            Greenfoot.playSound("eating.wav");
            
            isMoving = false;
            
            Actor amb = new Ambulance();
            getWorld().addObject(amb, 1, (int) this.getY());
            
            Actor loserScreen = new Loser();
            GreenfootImage textImage = new GreenfootImage("You are lose", 69, Color.WHITE, Color.BLACK);
            
            loserScreen.setImage(textImage);
            textImage.drawString("gdrgdrgdrg", 5, 5);
            if (loserScreen != null) {
                world.addObject(loserScreen, world.getWidth() / 2,world.getHeight() / 2);
            }
        }
    }    
    public void addScore() {
        if (!getWorld().getObjects(Counter.class).isEmpty()) {
            ((Counter) getWorld().getObjects(Counter.class).get(0)).add(1);
        }
    }
   
}
