import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Menu extends World{

    public static GreenfootSound rola = new GreenfootSound("sounds/Carga.wav");
    
    public Menu(){    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 600, 1);
        Greenfoot.start();
        GameOver.rola.pause();
        rola.setVolume(40);
        rola.playLoop();
        prepare();
    }

    private void prepare(){
        
        addObject(new BotonStart(),450,140);
        addObject(new ComoJugar(),450,190);
        addObject(new Records(), 450,240);
    }

    public void pausaMusica(){
        rola.stop();
    }
}
