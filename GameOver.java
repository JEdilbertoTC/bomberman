import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GameOver extends World{
    public static GreenfootSound rola = new GreenfootSound("sounds/gameOver.wav");
    public GameOver(){
        super(900, 600, 1);
        rola.setVolume(60);
        rola.playLoop();
        addObject(new VolverAJugar(), 350, 550);
        addObject(new Salir(), 550, 550);
    }
    
    
}