import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ExDerecha extends Explosion{

    public void act(){ 
        animaExplosion(1);
        verificaMuros();
        verificaExplosion();
    }    

    public void verificaMuros(){
        Actor destruible = null;
        Actor actor = null;
        destruible = (Destruible)getOneObjectAtOffset(5, 0,Destruible.class);
        actor = (Bomberman)getOneObjectAtOffset(5, 0,Bomberman.class);
        
        if(destruible != null){
            Bomberman.puntuacion+= 100;
            getWorld().removeObject(destruible);
        }
    }
}
