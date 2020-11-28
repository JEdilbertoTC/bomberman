import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ExDerecha extends Explosion{

    public void act(){ 
        animaExplosion(1);
        verificaMuros();
        verificaExplosion();
    }     
}
