import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Puntaje extends Hud{

    public void act(){
        getWorld().showText("PUNTUACION"+":"+hud.getPuntuacion(), 800, 80);
    }    
}
