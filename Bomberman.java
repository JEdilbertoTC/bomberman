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
    private int limiteBombas;
    protected static int vidas;
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
        String tecla = Greenfoot.getKey();
        setLocation(getX() + dx, getY() + dy);
        mueveBomberman();
        verificaBomba(tecla); 
        checaParedes();
        if(tocadoPorEnemigo()){
            vidas--;
            setLocation(100,100);
        }
    }

    public void BombermanQuieto(){
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
            BombermanQuieto();
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

        Destruible destruible = null;
        Solido solido = null;
        Bomba bomba2 = null;

        switch(direccion){

            case ARRIBA:
            destruible = (Destruible)getOneObjectAtOffset(6, -10,Destruible.class);//3
            solido = (Solido)getOneObjectAtOffset(6, -10, Solido.class);//3
            bomba2 = (Bomba)getOneObjectAtOffset(0, -10, Bomba.class);
            break;

            case ABAJO:
            destruible = (Destruible)getOneObjectAtOffset(6, 19, Destruible.class);
            solido = (Solido)getOneObjectAtOffset(6, 19, Solido.class);
            bomba2 = (Bomba)getOneObjectAtOffset(0, 17, Bomba.class);
            break;

            case DERECHA:
            destruible = (Destruible)getOneObjectAtOffset(15,12, Destruible.class);
            solido = (Solido)getOneObjectAtOffset(15,12, Solido.class);
            bomba2 = (Bomba)getOneObjectAtOffset(12, 0, Bomba.class);
            break;

            case IZQUIERDA:
            destruible = (Destruible)getOneObjectAtOffset(-15, 13, Destruible.class);
            solido = (Solido)getOneObjectAtOffset(-15, 13, Solido.class);
            bomba2 = (Bomba)getOneObjectAtOffset(-15, 0, Bomba.class);
            break;
        }

        if(destruible != null || solido != null || bomba2!= null){
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
    
    public boolean sinVida(){
        boolean bandera = false;
        if(getVida() == 0){
            bandera = true;
        }
        return bandera;
    }
   
    public void setVida(int vidas){
        this.vidas = vidas;
        System.out.println("Vida: "+vidas);
    }
    
    public int getVida(){
        return vidas;
    }
    
    
}