import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ComoJugar extends Boton{

    public ComoJugar(){
        GreenfootImage instrucciones = new GreenfootImage("images/Como-Jugar.png");
        instrucciones.scale(200,30);
        setImage(instrucciones);
    }

    public void act(){
        if(Greenfoot.mouseClicked(this)){

            Greenfoot.setWorld(new Instrucciones());
            Menu.rola.pause();
        }
    }    
}
