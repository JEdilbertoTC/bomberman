import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ExIzquierda extends Explosion{

    public void act(){

        animaExplosion(2);
        verificaMuros();
        verificaExplosion();
    }    
    
    public void verificaMuros(){
        Destruible destruible = null;
        destruible = (Destruible)getOneObjectAtOffset(-15, 0,Destruible.class);
        if(destruible != null){
            Bomberman.puntuacion+= 100;
            getWorld().removeObject(destruible);
        }
    }
}
