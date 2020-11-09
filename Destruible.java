import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Destruible here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Destruible extends Muro{
    
    public Destruible(){
        sprite = new GreenfootImage("images/MuroDestruible.png");
        dibujamuro();
    }
    
    public void dibujamuro(){
        sprite.scale(30,30);
        setImage(sprite);
    }
}
