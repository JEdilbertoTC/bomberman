import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Nivel extends Hud{

    public void act(){
        getWorld().showText("NIVEL"+":"+Mundo.numEnemigos, 764, 10);
    }    
}
