import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Suelo extends Actor{
    private GreenfootImage sprite;
    public Suelo(){
        sprite = new GreenfootImage("images/MATERIALES/Suelo.png"); 
        dibujamuro();
    }
    
    public void dibujamuro(){
        sprite.scale(30,30);
        setImage(sprite);
    }   
}
