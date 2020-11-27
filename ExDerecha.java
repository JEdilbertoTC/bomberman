import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ExDerecha extends Explosion{

    public void act(){ 
        animaExplosion(1);
        verificaMuros();
        verificaExplosion();
    }    

    public void verificaMuros(){
        Actor destruible = null;
        Actor bomberman = null;
        destruible = (Destruible)getOneObjectAtOffset(5, 0,Destruible.class);
        bomberman = (Bomberman)getOneObjectAtOffset(5, 0,Bomberman.class);
        
        if(destruible != null){
            Puntaje.setPuntuacion(100);
            getWorld().removeObject(destruible);
        }
    }
}
