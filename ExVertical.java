import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ExVertical extends Explosion{

    public void act(){
        animaExplosion(3);
        verificaMuros();
        verificaExplosion();
    }
}
