import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Menu extends World{

    public static GreenfootSound rola = new GreenfootSound("sounds/Carga.wav");
    
    public Menu(){    
        super(900, 600, 1);
        Greenfoot.start();
        GameOver.rola.pause();
        rola.setVolume(40);
        rola.playLoop();
        prepare();
    }

    private void prepare(){
        addObject(new Start(),450,140);
        addObject(new ComoJugar(),450,190);
        addObject(new Records(), 450,240);
    }

    public void pausaMusica(){
        rola.stop();
    }
}
