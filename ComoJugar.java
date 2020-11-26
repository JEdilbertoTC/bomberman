import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ComoJugar extends Boton{

    public ComoJugar(){
        GreenfootImage instrucciones = new GreenfootImage("images/comoJugar.png");
        instrucciones.scale(100,20);
        setImage(instrucciones);
    }

    public void act(){
        if(Greenfoot.mouseClicked(this)){

            Greenfoot.setWorld(new Instrucciones());
            Menu.rola.pause();
        }
    }    
}
