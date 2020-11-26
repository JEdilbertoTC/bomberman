import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ComoJugar extends Boton{

    public ComoJugar(){
<<<<<<< HEAD
        GreenfootImage instrucciones = new GreenfootImage("images/Como-Jugar.png");
=======
        GreenfootImage instrucciones = new GreenfootImage("images/ComoJugar.png");
>>>>>>> ff5ed21f3664c3a422286f571ef80ca2afa9f3a2
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
