import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Hud extends Actor
{
    
    public Hud(){

    }
    
    public void act(){
        hudStatus();
    }
    
    public void hudStatus(){
        setImage("HUD/HUD"+Bomberman.vidas+".png");
    }
}