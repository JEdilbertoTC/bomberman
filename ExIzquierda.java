import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ExIzquierda extends Explosion{

    public void act(){
        animaExplosion(2);
        verificaMuros();
        verificaExplosion();
    }    
}
