import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ExVertical extends Explosion{

    public void act(){
        animaExplosion(3);
        verificaMuros();
        verificaExplosion();
    }    

    public void verificaMuros(){
        Destruible dArriba = null;
        Destruible dAbajo = null;
        dArriba = (Destruible)getOneObjectAtOffset(0, -10,Destruible.class);
        dAbajo = (Destruible)getOneObjectAtOffset(0, 10, Destruible.class);
        if(dArriba != null || dAbajo != null){
            Puntaje.setPuntuacion(100);
            getWorld().removeObject(dArriba);
            getWorld().removeObject(dAbajo);
        }
    }
}
