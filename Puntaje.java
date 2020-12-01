import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Puntaje extends Hud{
    private Bomberman bomberman = Bomberman.getInstance();
    public void act(){
        getWorld().showText("PUNTUACION"+":"+bomberman.getPuntuacion(), 800, 95);
    }    
}
