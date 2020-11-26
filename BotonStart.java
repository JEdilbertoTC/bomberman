import greenfoot.*; 

public class BotonStart extends Boton
{
    Menu menu;
    public BotonStart(){
        GreenfootImage start = new GreenfootImage("images/start.png");
        start.scale(300,300);
        setImage(start);
    }

    public void act(){

        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new Mundo());
            Menu.rola.pause();
        }
    }    
}
