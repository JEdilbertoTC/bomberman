import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Salir extends Boton{

    public Salir(){
        GreenfootImage salir = new GreenfootImage("images/Salir.png");
        salir.scale(200,300);
        setImage(salir);
    }

    public void act(){
        if(Greenfoot.mouseClicked(this)){

            Greenfoot.setWorld(new Menu());
            Menu.rola.pause();
        }
    }
}
