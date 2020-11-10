import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Instrucciones here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Instrucciones extends Menu
{
    
    public Instrucciones()
    {
        prepare();
    }
    
    private void prepare(){

        BotonSkip botonSkip = new BotonSkip();
        addObject(botonSkip,850,550);

    }

    public void pausaMusica(){
        rola.stop();
    }
}
