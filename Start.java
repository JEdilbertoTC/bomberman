import greenfoot.*; 

public class Start extends Boton
{
    Menu menu;
    public Start(){
        GreenfootImage start = new GreenfootImage("images/BOTONES/start.png");
        start.scale(100,20);
        setImage(start);
    }

    public void act(){
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new Mundo());
            Menu.rola.pause();
        }
    }    
}
