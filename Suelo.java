import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Suelo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Suelo extends Muro{
    
    public Suelo(){
        sprite = new GreenfootImage("images/Suelo.png"); 
        dibujamuro();
    }
    
    public void dibujamuro(){
        sprite.scale(30,30);
        setImage(sprite);
    }   
}
