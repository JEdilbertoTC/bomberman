import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Regresar extends Boton{
    
    public Regresar(){
        GreenfootImage start = new GreenfootImage("images/BOTONES/regresar.png");
        start.scale(100,20);
        setImage(start);
    }
    
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new Menu());
        }
    }    
}
