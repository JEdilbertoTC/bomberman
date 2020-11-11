import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
public class Bomba extends Actor{

    private GreenfootImage bomba[];
    private int currentSprite;
    private int delaySprite;
    private boolean estado = false;
    private int tiempoExplosion = 0;
    private Explosion explosion;

    public Bomba(){

        bomba = new GreenfootImage[3];

        bomba[0] = new GreenfootImage("images/BOMBA/bomba1.png");
        bomba[1] = new GreenfootImage("images/BOMBA/bomba2.png");
        bomba[2] = new GreenfootImage("images/BOMBA/bomba3.png");
        bomba[0].scale(20,20);
        bomba[2].scale(20,20);
        bomba[1].scale(20,20);
    }

    public void act(){

        dibujaBomba();
        verificaExplosion();
    }  

    protected void dibujaBomba(){

        if(delaySprite >= 15){
            currentSprite = ((++currentSprite) % bomba.length);
            setImage(bomba[currentSprite]);
            delaySprite = 0;
        }
        tiempoExplosion++;
        delaySprite++;

    }

    public void verificaExplosion(){
        if(tiempoExplosion > 220){
            //destruirMuros();
            tiempoExplosion = 0;
            getWorld().addObject(new Explosion(), getX(),getY());
            getWorld().addObject(new ExIzquierda(),getX()-20,getY());
            getWorld().addObject(new ExDerecha(),getX()+20,getY());
            getWorld().addObject(new ExVertical(),getX(),getY()+20);
            getWorld().addObject(new ExVertical(),getX(),getY()-20);
            Bomberman.bombas.removeFirst();
            getWorld().removeObject(this);    
        }
        tiempoExplosion++;
    }

}
