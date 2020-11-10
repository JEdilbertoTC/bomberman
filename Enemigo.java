import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math; 
import java.util.*;
public class Enemigo extends Personaje{
     /*---Random---*/
    private String key;
    protected Random Direccion;
    protected int DireccionX;
    protected int DireccionY;
    protected int CambiaDireccion=0;
    protected int x;
    protected int y;
    
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
        IAenemigo();
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
    
    public void IAenemigo(){
        key = Greenfoot.getKey();
        int x = getX();
        int y = getY();
        Actor bomberman = getWorld().getObjects(Bomberman.class).get(0);
        int xBomberman = bomberman.getX();
        int yBomberman = bomberman.getY();
        
        mueveAleatorio(15);      
        //perseguir(xBomberman, x, yBomberman, y);
    
        /*--- Controles de frameStill ---
        if(key==null){
            frameContainer.setFrameStill(0);
        } else {
            frameContainer.setFrameStill(1);
        }*/
        
        setLocation(x,y);
    }
    
    public void perseguir(int xB, int x, int yB, int y){
        if(xB<x){
            this.x = x;
            DireccionX= -1;
        }
        else{
            this.x = x;
            DireccionX= 1;
        }
        if(yB<y){
            this.y = y;
        }
        else{
            this.y = y;
        }
    }
    
    public void mueveAleatorio(int cambio){
        if(CambiaDireccion==0){
            DireccionX = Direccion.nextInt(2); //Numero aleatorio entre 0 y 1
            DireccionY = Direccion.nextInt(2); //Numero aleatorio entre 0 y 1
            CambiaDireccion=cambio;
        }
        else{
            CambiaDireccion--;
        }
        if(DireccionX==0){
            this.x = x;
        }
        if(DireccionX==1){
            this.x = x;
        }
        if(DireccionY==0){
            this.y = y;
        }
        if(DireccionY==1){
            this.y = y;
        }
    }
    
}