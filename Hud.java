import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Hud extends Actor{
    
    private GreenfootImage sprites[];
    private Bomberman bomberman = Bomberman.getInstance();
    public Hud(){
        sprites = new GreenfootImage[4];
        sprites[0] = new GreenfootImage("images/HUD/HUD0.png");
        sprites[1] = new GreenfootImage("images/HUD/HUD1.png");
        sprites[2] = new GreenfootImage("images/HUD/HUD2.png");
        sprites[3] = new GreenfootImage("images/HUD/HUD3.png");
    }
    
    public void act(){
        hudStatus();
    }
    
    public void hudStatus(){
        setImage(sprites[bomberman.getVidas()]);
    }
}