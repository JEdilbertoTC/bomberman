import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
public class Bomba extends Actor{
    private GreenfootImage bomba[];
    private int currentSprite;
    private int delaySprite;
    private boolean estado = false;
    private int tiempoExplosion = 0;
    private Bomberman bomberman;
    public Bomba(){

        bomba = new GreenfootImage[3];

        bomba[0] = new GreenfootImage("images/bomba1.png");
        bomba[1] = new GreenfootImage("images/bomba2.png");
        bomba[2] = new GreenfootImage("images/bomba3.png");
        bomba[0].scale(20,20);
        bomba[2].scale(20,20);
        bomba[1].scale(20,20);
    }

    public void act(){

        ponBomba();
        quitaBomba();

        //DestruirMuros();

    }  

    protected void ponBomba(){

        if(delaySprite >= 15){
            currentSprite = ((++currentSprite) % bomba.length);
            setImage(bomba[currentSprite]);
            delaySprite = 0;
        }
        tiempoExplosion++;
        delaySprite++;

    }

    public void DestruirMuros(){
        ArrayList <Object>objetos = (ArrayList)getObjectsInRange(10,Destruible.class);
        for(int i = 0; i< objetos.size();i++){
            getWorld().removeObject((Actor) objetos.get(i));
        }
    }

    public void quitaBomba(){
        if(tiempoExplosion > 220){
            getWorld().removeObject(this);
            tiempoExplosion = 0;
            Bomberman.bombas.removeFirst();
        }
        tiempoExplosion++;

    }

}
