import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BotonSalir here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BotonSalir extends Boton
{
    public BotonSalir(){
        GreenfootImage botonSalir = new GreenfootImage("images/Salir.png");
        botonSalir.scale(200,30);
        setImage(botonSalir);
    }

    public void act() {
        if(Greenfoot.mouseClicked(this)){

            Greenfoot.setWorld(new Menu());
            Menu.rola.pause();
        }
    }    
   
}
