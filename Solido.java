import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Solido extends Muro{
    public Solido(){
        sprite = new GreenfootImage("images/MATERIALES/MuroSolido.png");
        dibujamuro();
    }
    
    public void dibujamuro(){
        sprite.scale(30,30);
        setImage(sprite);
    }
}
