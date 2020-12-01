import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math; 
import java.util.*;

public class Enemigo extends Personaje{
    
    private String key;
    private final int DERECHA = 1;
    private final int IZQUIERDA = 2;
    private final int ARRIBA = 0;
    private final int ABAJO = 3;
    private int direccion = DERECHA;
    private Bomberman bomberman = Bomberman.getInstance();
    private Random Direccion;
    private int DireccionX;
    private int DireccionY;
    private int CambiaDireccion=0;
    private int x;
    private int y;

    public Enemigo(){
        sprites = new GreenfootImage[1][6];
        sprites[0][0] = new GreenfootImage("images/ENEMIGO/enemigo1.png");
        sprites[0][1] = new GreenfootImage("images/ENEMIGO/enemigo2.png");
        sprites[0][2] = new GreenfootImage("images/ENEMIGO/enemigo3.png");
        sprites[0][3] = new GreenfootImage("images/ENEMIGO/enemigo4.png");
        sprites[0][4] = new GreenfootImage("images/ENEMIGO/enemigo5.png");
        sprites[0][5] = new GreenfootImage("images/ENEMIGO/enemigo6.png");
        for(int i = 0; i< 6;i++){
            sprites[0][i].scale(25,25);
        }
    }

    public void act(){
        dibujaEnemigo();  
        muevete();
        tocadoPorExplosion();
        if(Mundo.enemigos.size()<=0){
            Mundo.numEnemigos++;
            Greenfoot.setWorld(new Mundo());
        }
    }

    public void dibujaEnemigo(){
        if(delaySprite >= 8){
            currentSprite = ((++currentSprite) % 6);
            setImage(sprites[0][currentSprite]);
            delaySprite = 0;
        }
        delaySprite++;
    }

    public void muevete(){
        dx = dy = 0;
        Actor muro = null;
            
        switch(direccion){
            case DERECHA: 
            muro = (Muro)getOneObjectAtOffset(15,12, Muro.class);
            dx = 1;
            dy = 0;
            break;

            case IZQUIERDA:
            muro = (Muro)getOneObjectAtOffset(-15, 13, Muro.class);
            dx = -1;
            dy = 0;
            break;

            case ARRIBA:
            muro = (Muro)getOneObjectAtOffset(6, -10,Muro.class);
            dx = 0;
            dy = -1;
            break;
            
            case ABAJO:
            muro = (Muro)getOneObjectAtOffset(6, 19, Muro.class);
            dx = 0;
            dy = 1;
            break;
        }
        if(muro != null ){
            dx = dy = 0;
            direccion = Greenfoot.getRandomNumber(4);
        }
        setLocation(getX()+dx, getY()+dy);
    }

    public void tocadoPorExplosion(){
        if(isTouching(Explosion.class)){
            bomberman.sumaPuntuacion(1000);
            Mundo.enemigos.removeFirst();
            getWorld().removeObject(this);
        }
    }

}
