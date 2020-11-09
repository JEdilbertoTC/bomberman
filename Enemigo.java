import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math; 

public class Enemigo extends Personaje{
    
    public Enemigo(){
        sprites = new GreenfootImage[1][6];
        sprites[0][0] = new GreenfootImage("images/enemigo1.png");
        sprites[0][1] = new GreenfootImage("images/enemigo2.png");
        sprites[0][2] = new GreenfootImage("images/enemigo3.png");
        sprites[0][3] = new GreenfootImage("images/enemigo4.png");
        sprites[0][4] = new GreenfootImage("images/enemigo5.png");
        sprites[0][5] = new GreenfootImage("images/enemigo6.png");
        for(int i = 0; i< 6;i++){
            sprites[0][i].scale(20,20);
        }
    }

    public void act(){
        setLocation(getX()+dx, getY());
        dx = 1;
        dibujaEnemigo();  
        mueveEnemigo();
    }

    public void dibujaEnemigo(){
        if(delaySprite >= 8){
            currentSprite = ((++currentSprite) % 6);
            setImage(sprites[0][currentSprite]);
            delaySprite = 0;

        }
        delaySprite++;
    }
    
    public void mueveEnemigo(){
    }
}
