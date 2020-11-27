import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Puntaje extends Actor{

    public void act(){
        getWorld().showText("PUNTUACION"+":"+Bomberman.puntuacion, 800, 30);
    }    
}
