import greenfoot.*; 

public class BotonStart extends Boton
{
    Menu menu;
    public BotonStart(){
        GreenfootImage start = new GreenfootImage("images/start.png");
        start.scale(100,20);
        setImage(start);
    }

    public void act(){

        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new Mundo());
            //Menu.rola.pause();
        }
    }    
}
