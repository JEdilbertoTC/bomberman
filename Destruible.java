import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Destruible extends Muro{
    
    public Destruible(){
        sprite = new GreenfootImage("images/MATERIALES/MuroDestruible.png");
        dibujamuro();
    }
    
    public void dibujamuro(){
        sprite.scale(30,30);
        setImage(sprite);
    }
}
