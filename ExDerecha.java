import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ExDerecha extends Explosion{

    public void act(){ 
        animaExplosion(1);
        verificaMuros();
        verificaExplosion();
    }    

    public void verificaMuros(){
        Actor destruible = null;
        destruible = (Destruible)getOneObjectAtOffset(5, 0,Destruible.class);

        if(destruible != null){
            getWorld().removeObject(destruible);
        }
    }
}
