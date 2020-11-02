import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Muro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Solido extends Actor
{
    private GreenfootImage solido = new GreenfootImage("images/MuroSolido.png");
    public Solido(){
        dibujamuro();
    }
    
    public void dibujamuro(){
        solido.scale(50,50);
        setImage(solido);
    }
}
