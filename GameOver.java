import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GameOver extends World{

    public GameOver(){
        super(900, 600, 1);
        
        addObject(new VolverAJugar(), 350, 550);
        addObject(new Salir(), 550, 550);
    }
    
    
}