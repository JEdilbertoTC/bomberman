import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*; 

public class Bomberman extends Personaje{
    private static Bomberman bomberman = new Bomberman();
    private final int DERECHA = 1;
    private final int IZQUIERDA = 2;
    private final int ARRIBA = 0;
    private final int ABAJO = 3;
    private Direccion direccion;
    private LinkedList<Bomba> bombas;
    private int limiteBombas;
    private int vidas;
    private int puntuacion;
    private String nombre;
    private int tiempoExplosion = 0;
    private final int PUNTOS_MEJORA = 10000;
    public static final int PUNTOS_MURO = 100;
    public static final int PUNTOS_ENEMIGO = 1000;

    private Bomberman(){
        limiteBombas = 1;
        vidas = 1;
        puntuacion = 0;
        nombre = "";
        sprites = new GreenfootImage[4][4];
        bombas = new LinkedList<Bomba>();
        direccion = Direccion.DERECHA;
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
            quitaBombas();
            checaParedes();
            verificaMejora();
            if(tocadoPorEnemigo()){
                vidas--;
                setLocation(30,30);
            }
            verificaVidaExplosion();
        } else {
            getWorld().showText("INGRESA NICKNAME: ", 350, 250);
            String tecla = Greenfoot.getKey();
            if(tecla != null  && tecla != "backspace" && tecla != "enter"){
                nombre += tecla;
            }
            if(tecla == "backspace" && nombre.length()> 0)
                nombre = nombre.substring(0, nombre.length()-1);
            getWorld().showText(nombre, 500, 250);
            if(tecla == "enter"){
                Greenfoot.setWorld(new GameOver());
                bomberman = null;
                Mundo.rola[Mundo.CANCION_INICIO].pause();
                Mundo.rola[Mundo.CANCION_POCO_TIEMPO].pause();
            }
        }
    }

    public boolean tieneVidas(){
        return vidas > 0;
    }

    public boolean seEstaMoviendo(){
        return dx == 0 || dy == 0;
    }

    public void bombermanQuieto(){
        if(seEstaMoviendo()){
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
            if(bombas.size() < limiteBombas){
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

    public void quitaBombas(){
        if(bombas.size()> 0){
            if(tiempoExplosion > 110){
                bombas.removeFirst();
                tiempoExplosion = 0;
            }
            tiempoExplosion++;
        }
    }

    public void cambiaSprites(){
        if(seEstaMoviendo()){
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
            if(isTouching(MejoraBomba.class)){
                incrementarLimiteBombas(1);
            } else if(isTouching(MejoraCalavera.class)){
                sumaVidas(-1);
            }else if(isTouching(MejoraVida.class)){
                sumaVidas(1);
            }
            sumaPuntuacion(PUNTOS_MEJORA);
            removeTouching(Mejora.class);
        }
    }

    public void verificaVidaExplosion(){
        if(isTouching(Explosion.class)){
            sumaVidas(-1);
            setLocation(30, 30);
        } 
    }

    public int getVidas(){
        return vidas;
    }

    public void sumaVidas(int vida){
        vidas+= vida;
    }

    public int getPuntuacion(){
        return puntuacion;
    }

    public void incrementarLimiteBombas(int bomba){
        limiteBombas+= bomba;
    }

    public void sumaPuntuacion(int puntos){
        puntuacion += puntos;
    }

    public static Bomberman getInstance(){
        if(bomberman == null){
            return new Bomberman();
        }
        return bomberman;
    }
    
    public int getBombas(){
        return limiteBombas;
    }

    public String getNombre(){
        return nombre;
    }
}