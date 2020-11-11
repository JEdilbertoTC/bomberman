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
        explosion[0][0] = new GreenfootImage("images/EXPLOSION/explosionEnMedio1.png");
        explosion[0][1] = new GreenfootImage("images/EXPLOSION/explosionEnMedio2.png");
        explosion[0][2] = new GreenfootImage("images/EXPLOSION/explosionEnMedio3.png");
        explosion[0][3] = new GreenfootImage("images/EXPLOSION/explosionEnMedio4.png");
        
        explosion[1][0] = new GreenfootImage("images/EXPLOSION/explosionBDerecho1.png");
        explosion[1][1] = new GreenfootImage("images/EXPLOSION/explosionBDerecho2.png");
        explosion[1][2] = new GreenfootImage("images/EXPLOSION/explosionBDerecho3.png");
        explosion[1][3] = new GreenfootImage("images/EXPLOSION/explosionBDerecho4.png");
        
        explosion[2][0] = new GreenfootImage("images/EXPLOSION/explosionIzquierda1.png");
        explosion[2][1] = new GreenfootImage("images/EXPLOSION/explosionIzquierda2.png");
        explosion[2][2] = new GreenfootImage("images/EXPLOSION/explosionIzquierda3.png");
        explosion[2][3] = new GreenfootImage("images/EXPLOSION/explosionIzquierda4.png");
        
        explosion[3][0] = new GreenfootImage("images/EXPLOSION/explosionVertical1.png");
        explosion[3][1] = new GreenfootImage("images/EXPLOSION/explosionVertical2.png");
        explosion[3][2] = new GreenfootImage("images/EXPLOSION/explosionVertical2.png");
        explosion[3][3] = new GreenfootImage("images/EXPLOSION/explosionVertical3.png");
    }
    public void act(){
        // Add your action code here.
    }    
}
