import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Instrucciones extends Menu{
    
    public Instrucciones(){
        prepare();
    }
    
    private void prepare(){

        BotonStart botonStart = new BotonStart();
        addObject(botonStart,850,550);

    }

    public void pausaMusica(){
        rola.stop();
    }
}
