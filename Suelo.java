import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Suelo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Suelo extends Actor
{
    private GreenfootImage suelo = new GreenfootImage("images/Suelo.png"); 
    public Suelo(){
        dibujamuro();
    }
    public void dibujamuro(){
        suelo.scale(30,30);
        setImage(suelo);
    }   
}
