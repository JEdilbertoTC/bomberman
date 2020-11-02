import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Destruible here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Destruible extends Actor
{
    private GreenfootImage destruible = new GreenfootImage("images/MuroDestruible.png");
    public Destruible(){
        dibujamuro();
    }
    
    
    public void dibujamuro(){
        destruible.scale(50,50);
        setImage(destruible);
    }
}
