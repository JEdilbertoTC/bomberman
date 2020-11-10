import greenfoot.*; 

public class BotonStart extends Boton
{
    Menu menu;
    public BotonStart(){
        setImage("images/start.png");
    }

    public void act(){
        checkMouse();

        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new Instrucciones());
            //Menu.rola.pause();
        }
    }    
}
