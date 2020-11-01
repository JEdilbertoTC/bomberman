import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Muro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Solido extends Actor
{
    /**
     * Act - do whatever the Muro wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Solido(){
        dibujamuro();
    }
    
    public void dibujamuro(){
        setImage("images/MuroSolido.png");
    }
}
