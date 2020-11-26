import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class Explosion extends Personaje{
    private int tiempoExplosion;
    public Explosion(){
        sprites = new GreenfootImage[4][4];
        sprites[0][0] = new GreenfootImage("images/EXPLOSION/explosionEnMedio1.png");
        sprites[0][1] = new GreenfootImage("images/EXPLOSION/explosionEnMedio2.png");
        sprites[0][2] = new GreenfootImage("images/EXPLOSION/explosionEnMedio3.png");
        sprites[0][3] = new GreenfootImage("images/EXPLOSION/explosionEnMedio4.png");

        sprites[1][0] = new GreenfootImage("images/EXPLOSION/explosionBDerecho1.png");
        sprites[1][1] = new GreenfootImage("images/EXPLOSION/explosionBDerecho2.png");
        sprites[1][2] = new GreenfootImage("images/EXPLOSION/explosionBDerecho3.png");
        sprites[1][3] = new GreenfootImage("images/EXPLOSION/explosionBDerecho4.png");

        sprites[2][0] = new GreenfootImage("images/EXPLOSION/explosionIzquierda1.png");
        sprites[2][1] = new GreenfootImage("images/EXPLOSION/explosionIzquierda2.png");
        sprites[2][2] = new GreenfootImage("images/EXPLOSION/explosionIzquierda3.png");
        sprites[2][3] = new GreenfootImage("images/EXPLOSION/explosionIzquierda4.png");

        sprites[3][0] = new GreenfootImage("images/EXPLOSION/explosionVertical1.png");
        sprites[3][1] = new GreenfootImage("images/EXPLOSION/explosionVertical2.png");
        sprites[3][2] = new GreenfootImage("images/EXPLOSION/explosionVertical2.png");
        sprites[3][3] = new GreenfootImage("images/EXPLOSION/explosionVertical3.png");

        sprites[0][0].scale(20,20);
        sprites[0][1].scale(20,20);
        sprites[0][2].scale(20,20);
        sprites[0][3].scale(20,20);

        sprites[2][0].scale(50,20);
        sprites[2][1].scale(50,20);
        sprites[2][2].scale(50,20);
        sprites[2][3].scale(50,20);

        sprites[1][0].scale(53,20);
        sprites[1][1].scale(53,20);
        sprites[1][2].scale(53,20);
        sprites[1][3].scale(53,20);

        sprites[3][0].scale(25,50);
        sprites[3][1].scale(25,50);
        sprites[3][2].scale(25,50);
        sprites[3][3].scale(25,50);
    }

    public void act(){
        animaExplosion(0);
        verificaExplosion();
    }

    public void animaExplosion(int i){
        if(delaySprite >= 8){
            currentSprite = ((++currentSprite) % 4);
            setImage(sprites[i][currentSprite]);
            delaySprite = 0;
        }
        delaySprite++;
    }

    public void verificaExplosion(){
        if(tiempoExplosion > 100){
            getWorld().removeObject(this);
        }
        tiempoExplosion++;
    }

    public void quitaVida(){
        
    }
}
