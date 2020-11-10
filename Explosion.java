import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Actor{
    GreenfootImage explosion[][] = new GreenfootImage[4][4];
    public Explosion(){
        explosion[0][0] = new GreenfootImage("images/explosionEnMedio1.png");
        explosion[0][1] = new GreenfootImage("images/explosionEnMedio2.png");
        explosion[0][2] = new GreenfootImage("images/explosionEnMedio3.png");
        explosion[0][3] = new GreenfootImage("images/explosionEnMedio4.png");
    }
    public void act(){
        // Add your action code here.
    }    
}
