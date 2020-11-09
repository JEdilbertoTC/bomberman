import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math; 

public class Enemigo extends Actor
{
    GreenfootImage enemigo[];
    private int delaySprite;
    private int currentSprite;
    private int dx;
    public Enemigo(){
        enemigo = new GreenfootImage[6];
        enemigo[0] = new GreenfootImage("images/enemigo1.png");
        enemigo[1] = new GreenfootImage("images/enemigo2.png");
        enemigo[2] = new GreenfootImage("images/enemigo3.png");
        enemigo[3] = new GreenfootImage("images/enemigo4.png");
        enemigo[4] = new GreenfootImage("images/enemigo5.png");
        enemigo[5] = new GreenfootImage("images/enemigo6.png");
        for(int i = 0; i< 6;i++){
            enemigo[i].scale(20,20);
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
            setImage(enemigo[currentSprite]);
            delaySprite = 0;

        }
        delaySprite++;
    }
    
    public void mueveEnemigo(){
    }
}
