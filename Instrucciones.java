import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Instrucciones extends World{

    public Instrucciones(){
        super(900,600,1);
        prepare();
    }

    private void prepare(){
        addObject(new Regresar(),800,550);
        addObject(new BotonStart(),600,550);

    }

}
