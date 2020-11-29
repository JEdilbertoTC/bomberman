import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class Explosion extends Personaje{
    private int tiempoExplosion;
    private final int ENMEDIO = 0;
    private final int DERECHO = 1;
    private final int IZQUIERDA = 2;
    private final int VERTICAL = 3;
    public Explosion(){
        sprites = new GreenfootImage[4][4];
        sprites[ENMEDIO][0] = new GreenfootImage("images/EXPLOSION/explosionEnMedio1.png");
        sprites[ENMEDIO][1] = new GreenfootImage("images/EXPLOSION/explosionEnMedio2.png");
        sprites[ENMEDIO][2] = new GreenfootImage("images/EXPLOSION/explosionEnMedio3.png");
        sprites[ENMEDIO][3] = new GreenfootImage("images/EXPLOSION/explosionEnMedio4.png");

        sprites[DERECHO][0] = new GreenfootImage("images/EXPLOSION/explosionBDerecho1.png");
        sprites[DERECHO][1] = new GreenfootImage("images/EXPLOSION/explosionBDerecho2.png");
        sprites[DERECHO][2] = new GreenfootImage("images/EXPLOSION/explosionBDerecho3.png");
        sprites[DERECHO][3] = new GreenfootImage("images/EXPLOSION/explosionBDerecho4.png");

        sprites[IZQUIERDA][0] = new GreenfootImage("images/EXPLOSION/explosionIzquierda1.png");
        sprites[IZQUIERDA][1] = new GreenfootImage("images/EXPLOSION/explosionIzquierda2.png");
        sprites[IZQUIERDA][2] = new GreenfootImage("images/EXPLOSION/explosionIzquierda3.png");
        sprites[IZQUIERDA][3] = new GreenfootImage("images/EXPLOSION/explosionIzquierda4.png");

        sprites[VERTICAL][0] = new GreenfootImage("images/EXPLOSION/explosionVertical1.png");
        sprites[VERTICAL][1] = new GreenfootImage("images/EXPLOSION/explosionVertical2.png");
        sprites[VERTICAL][2] = new GreenfootImage("images/EXPLOSION/explosionVertical2.png");
        sprites[VERTICAL][3] = new GreenfootImage("images/EXPLOSION/explosionVertical3.png");

        sprites[ENMEDIO][0].scale(20,20);
        sprites[ENMEDIO][1].scale(20,20);
        sprites[ENMEDIO][2].scale(20,20);
        sprites[ENMEDIO][3].scale(20,20);

        sprites[IZQUIERDA][0].scale(40,20);
        sprites[IZQUIERDA][1].scale(40,20);
        sprites[IZQUIERDA][2].scale(40,20);
        sprites[IZQUIERDA][3].scale(40,20);

        sprites[DERECHO][0].scale(40,20);
        sprites[DERECHO][1].scale(40,20);
        sprites[DERECHO][2].scale(40,20);
        sprites[DERECHO][3].scale(40,20);

        sprites[VERTICAL][0].scale(20,45);
        sprites[VERTICAL][1].scale(20,45);
        sprites[VERTICAL][2].scale(20,45);
        sprites[VERTICAL][3].scale(20,45);
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
        if(tiempoExplosion > 50){
            getWorld().removeObject(this);

        }
        tiempoExplosion++;
    }

    public void verificaEnemigo(int dx, int dy){
        Actor enemigo = null;
        enemigo = (Enemigo)getOneObjectAtOffset(dx, dy, Enemigo.class);
        if(enemigo != null){
            Mundo.enemigos.removeFirst();
            getWorld().removeObject(enemigo);
        }

    }

    public void verificaMuros(){
        if(isTouching(Destruible.class)){
            removeTouching(Destruible.class);
            Puntaje.setPuntuacion(100);
        }  
    }
}
