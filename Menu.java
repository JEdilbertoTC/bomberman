import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Menu extends World{

    public static GreenfootSound rola = new GreenfootSound("sounds/Carga.wav");
    
    public Menu(){    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1);
        Greenfoot.start();
        rola.setVolume(40);
        rola.playLoop();
        prepare();
    }

    private void prepare(){
        
        BotonStart botonStart = new BotonStart();
        ComoJugar comoJugar = new ComoJugar();
        addObject(comoJugar,204,250);
        //Records records = new Records();
        //addObject(records, 300,200);
        addObject(botonStart,204,168);

    }

    public void pausaMusica(){
        rola.stop();
    }
}
