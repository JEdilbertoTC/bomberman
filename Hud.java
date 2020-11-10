import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Hud extends Actor
{
    private int vida;
    
    public Hud(){

    }
    
    public void act() 
    {
        // Add your action code here.
    }
    
    public void hudStatus(int vida){
        setImage("HUD/HUD"+vida+".png");
    }
}