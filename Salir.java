import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Salir extends Boton{

    public Salir(){
        GreenfootImage salir = new GreenfootImage("images/BOTONES/salir.png");
        salir.scale(100,20);
        setImage(salir);
    }

    public void act(){
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new Menu());
        }
    }
}
