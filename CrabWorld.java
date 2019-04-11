import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CrabWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CrabWorld extends World
{

    /**
     * Constructor for objects of class CrabWorld.
     * 
     */
    public CrabWorld()
    {    
        super(560, 560, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Worm worm = new Worm();
        addObject(worm,252,273);
        Worm worm2 = new Worm();
        addObject(worm2,264,332);
        Worm worm3 = new Worm();
        addObject(worm3,267,397);
        Worm worm4 = new Worm();
        addObject(worm4,303,331);
        Worm worm5 = new Worm();
        addObject(worm5,342,399);
        Crab crab = new Crab();
        addObject(crab,305,172);
        Counter counter = new Counter();
        addObject(counter,63,50);
        Lobster lobster = new Lobster();
        addObject(lobster,71,332);
        removeObject(worm3);
        removeObject(worm5);
        removeObject(worm4);
        removeObject(worm2);
        crab.setLocation(490,317);
        Pelican pelican = new Pelican();
        addObject(pelican,142,145);
        Lobster lobster2 = new Lobster();
        addObject(lobster2,406,176);
        Lobster lobster3 = new Lobster();
        addObject(lobster3,408,483);
        Lobster lobster4 = new Lobster();
        addObject(lobster4,335,327);
        Worm worm6 = new Worm();
        addObject(worm6,147,444);
        Worm worm7 = new Worm();
        addObject(worm7,344,439);
        Worm worm8 = new Worm();
        addObject(worm8,303,80);
        Worm worm9 = new Worm();
        addObject(worm9,473,444);
        Worm worm10 = new Worm();
        addObject(worm10,493,234);
        Worm worm11 = new Worm();
        addObject(worm11,413,55);
        Worm worm12 = new Worm();
        addObject(worm12,78,208);
        removeObject(worm7);
        removeObject(lobster3);
        removeObject(worm9);
        removeObject(lobster4);
        removeObject(worm);
        removeObject(worm6);
        removeObject(lobster);
        removeObject(worm12);
        removeObject(pelican);
        removeObject(worm8);
        removeObject(lobster2);
        removeObject(worm10);
        removeObject(worm11);
    }
}
