import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Hud extends Actor{
    int bomba;
    int vida;
    private GreenfootImage sprites[][];
    public Hud(){
        sprites = new GreenfootImage[4][4];
        sprites[0][0] = new GreenfootImage("images/HUD/HUD0-0.png");
        sprites[0][1] = new GreenfootImage("images/HUD/HUD0-1.png");
        sprites[0][2] = new GreenfootImage("images/HUD/HUD0-2.png");
        sprites[0][3] = new GreenfootImage("images/HUD/HUD0-3.png");
        sprites[1][0] = new GreenfootImage("images/HUD/HUD1-0.png");
        sprites[1][1] = new GreenfootImage("images/HUD/HUD1-1.png");
        sprites[1][2] = new GreenfootImage("images/HUD/HUD1-2.png");
        sprites[1][3] = new GreenfootImage("images/HUD/HUD1-3.png");
        sprites[2][0] = new GreenfootImage("images/HUD/HUD2-0.png");
        sprites[2][1] = new GreenfootImage("images/HUD/HUD2-1.png");
        sprites[2][2] = new GreenfootImage("images/HUD/HUD2-2.png");
        sprites[2][3] = new GreenfootImage("images/HUD/HUD2-3.png");
        sprites[3][0] = new GreenfootImage("images/HUD/HUD3-0.png");
        sprites[3][1] = new GreenfootImage("images/HUD/HUD3-1.png");
        sprites[3][2] = new GreenfootImage("images/HUD/HUD3-2.png");
        sprites[3][3] = new GreenfootImage("images/HUD/HUD3-3.png");
    }
    
    public void act(){
        hudStatus();
    }
    
    public void hudStatus(){
        setImage(sprites[Bomberman.getVidas()][Bomberman.getBombas()]);
    }
    
    
}