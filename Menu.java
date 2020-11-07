import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Algo2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{

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
        addObject(botonStart,204,168);

    }

    public void pausaMusica(){
        rola.stop();
    }
}
