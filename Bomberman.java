import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*; 

public class Bomberman extends Personaje{

    private final int DERECHA = 1;
    private final int IZQUIERDA = 2;
    private final int ARRIBA = 0;
    private final int ABAJO = 3;
    private GreenfootImage bomberman[][];
    private Direccion direccion = Direccion.DERECHA;
    public static LinkedList<Bomba> bombas = new LinkedList<Bomba>();
    private static int limiteBombas;
    private static int vidas;
    public Bomberman(){
        limiteBombas = 1;
        vidas = 3;
        sprites = new GreenfootImage[4][4];
        sprites[ARRIBA][0] = new GreenfootImage("images/BOMBERMAN/ParadoArriba.png");
        sprites[ARRIBA][1] = new GreenfootImage("images/BOMBERMAN/atras2.png");
        sprites[ARRIBA][2] = new GreenfootImage("images/BOMBERMAN/atras3.png");
        sprites[ARRIBA][3] = new GreenfootImage("images/BOMBERMAN/atras4.png");

        sprites[DERECHA][0] = new GreenfootImage("images/BOMBERMAN/vueltaDerecha.png");
        sprites[DERECHA][1] = new GreenfootImage("images/BOMBERMAN/paradoDerecha.png");
        sprites[DERECHA][2] = new GreenfootImage("images/BOMBERMAN/derecha1.png");
        sprites[DERECHA][3] = new GreenfootImage("images/BOMBERMAN/derecha2.png");

        sprites[IZQUIERDA][0] = new GreenfootImage("images/BOMBERMAN/vueltaIzquierda.png");
        sprites[IZQUIERDA][1] = new GreenfootImage("images/BOMBERMAN/paradoIzquierda.png");
        sprites[IZQUIERDA][2] = new GreenfootImage("images/BOMBERMAN/izquierda1.png");
        sprites[IZQUIERDA][3] = new GreenfootImage("images/BOMBERMAN/izquierda2.png");

        sprites[ABAJO][0] = new GreenfootImage("images/BOMBERMAN/paradoAbajo.png");    
        sprites[ABAJO][1] = new GreenfootImage("images/BOMBERMAN/abajo1.png");
        sprites[ABAJO][2] = new GreenfootImage("images/BOMBERMAN/abajo2.png");
        sprites[ABAJO][3] = new GreenfootImage("BOMBERMAN/vueltaIzquierda.png");
        for(int i = 0; i < 4;i++){
            for(int j = 0; j <4;j++){
                sprites[i][j].scale(25,35);
            }
        }
    }

    public void act(){
        if(tieneVidas()){
            String tecla = Greenfoot.getKey();
            setLocation(getX() + dx, getY() + dy);
            mueveBomberman();
            verificaBomba(tecla); 
            checaParedes();
            verificaMejora();
            if(tocadoPorEnemigo()){
                vidas--;
                setLocation(30,30);
            }
            verificaVidaExplosion();
        } else {
            Greenfoot.setWorld(new GameOver());
            Mundo.rola[Mundo.CANCION_INICIO].pause();
            Mundo.rola[Mundo.CANCION_POCO_TIEMPO].pause();
        }
    }
    
    public boolean tieneVidas(){
        return vidas >0;
    }

    public void bombermanQuieto(){
        if(dx == 0  && dy == 0){
            switch(direccion){
                case IZQUIERDA:
                setImage(sprites[IZQUIERDA][1]);
                break;

                case DERECHA:
                setImage(sprites[DERECHA][1]);

                break;

                case ARRIBA:
                setImage(sprites[ARRIBA][0]);
                break;

                case ABAJO:
                setImage(sprites[ABAJO][0]);
                break;
            }
        }
    }

    public void mueveBomberman(){
        cambiaSprites();
        dx = dy = 0;
        if(Greenfoot.isKeyDown("up")){
            dy = -1;
            direccion = Direccion.ARRIBA;

        } else if(Greenfoot.isKeyDown("down")){
            dy = 1;
            direccion = Direccion.ABAJO;

        } else if(Greenfoot.isKeyDown("left")){
            dx = -1;
            direccion = Direccion.IZQUIERDA;

        } else if(Greenfoot.isKeyDown("right")){
            dx = 1;
            direccion = Direccion.DERECHA;
        } else{
            bombermanQuieto();
        }
    }

    public void verificaBomba(String tecla){
        if(tecla == "space"){
            if(bombas.size() < limiteBombas ){
                switch(direccion){
                    case IZQUIERDA:
                    getWorld().addObject(new Bomba(), getX(),getY()+3);
                    break;

                    case DERECHA:
                    getWorld().addObject(new Bomba(), getX(),getY()+5);
                    break;

                    case ARRIBA:
                    getWorld().addObject(new Bomba(), getX(),getY()+3);
                    break;

                    case ABAJO:
                    getWorld().addObject(new Bomba(), getX(),getY()+3);
                    break;
                }
                bombas.add(new Bomba());
            }
        }

    }

    public void cambiaSprites(){

        if(dx != 0 || dy !=0){
            switch(direccion){

                case IZQUIERDA:
                if(delaySprite >= 7){
                    currentSprite = ((++currentSprite) % 4);
                    if(currentSprite == 0){
                        currentSprite++;
                    }
                    setImage(sprites[IZQUIERDA][currentSprite]);
                    delaySprite = 0;

                }
                break;

                case DERECHA:
                if(delaySprite >= 7){
                    currentSprite = ((++currentSprite) % 4);
                    if(currentSprite == 0){
                        currentSprite++;
                    }
                    setImage(sprites[DERECHA][currentSprite]);
                    delaySprite = 0;
                }
                break;

                case ARRIBA:
                if(delaySprite >= 7){
                    currentSprite = (++currentSprite) % 4;
                    setImage(sprites[ARRIBA][currentSprite]);
                    delaySprite = 0;
                }
                break;

                case ABAJO:
                if(delaySprite >= 7){
                    currentSprite = ((++currentSprite) % 4);
                    if(currentSprite == 0){
                        currentSprite++;
                    }
                    setImage(sprites[ABAJO][currentSprite]);
                    delaySprite = 0;
                }
                break;
            }
            delaySprite++;
        }
    }

    public void checaParedes(){
        Actor muro = null;

        switch(direccion){
            case ARRIBA:
            muro = (Muro)getOneObjectAtOffset(6, -10,Muro.class);//3
            break;

            case ABAJO:
            muro = (Muro)getOneObjectAtOffset(6, 19, Muro.class);
            break;

            case DERECHA:
            muro = (Muro)getOneObjectAtOffset(15,12, Muro.class);
            break;

            case IZQUIERDA:
            muro = (Muro)getOneObjectAtOffset(-15, 13, Muro.class);
            break;
        }
        if(muro != null){
            dx = dy = 0;
        } 
    }

    public boolean tocadoPorEnemigo(){
        boolean bandera = false;
        Actor Enemigo;
        Enemigo = getOneObjectAtOffset(0,-10,Enemigo.class);
        if(Enemigo != null){
            World detect;
            detect = getWorld();
            bandera = true;
        }
        return bandera;
    }

    public void verificaMejora(){
        if(isTouching(Mejora.class)){
            removeTouching(Mejora.class);
        }
    }

    public void verificaVidaExplosion(){
        if(isTouching(Explosion.class)){
            setVidas(-1);
            setLocation(30, 30);
        } 
    }
    
    public static int getVidas(){
        return vidas;
    }
    
    public static void setVidas(int vida){
        vidas+= vida;
    }

}