import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class VolverAJugar extends Boton{

    public VolverAJugar(){
        GreenfootImage volverAJugar = new GreenfootImage("images/BOTONES/volverAJugar.png");
        volverAJugar.scale(200,30);
        setImage(volverAJugar);
    }

    public void act() {
        if(Greenfoot.mouseClicked(this)){

            Greenfoot.setWorld(new Mundo());
            Menu.rola.pause();
            GameOver.rola.pause();
        }
    }    
}
