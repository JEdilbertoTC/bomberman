import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BotonSkip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BotonSkip extends Boton
{
    Instrucciones instruccion;
    public BotonSkip(){
        setImage("images/skip.png");
    }
    public void act() 
    {
       checkMouse();

        if(Greenfoot.mouseClicked(this)){

            Greenfoot.setWorld(new Mundo());
            Menu.rola.pause();
        }
    }    
}
