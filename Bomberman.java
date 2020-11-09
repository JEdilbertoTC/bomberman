
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*; 

public class Bomberman extends Actor
{
    private final int DERECHA = 1;
    private final int IZQUIERDA = 2;
    private final int ARRIBA = 0;
    private final int ABAJO = 3;
    private enum Direccion{IZQUIERDA,DERECHA,ARRIBA,ABAJO};
    private GreenfootImage bomberman[][];
    private int currentX;
    private int currentY;
    private int velocidad;
    private int dx;
    private int dy;
    private int delaySprite;
    private Direccion direccion = Direccion.DERECHA;
    private int currentSprite;
    public static LinkedList<Bomba> bombas = new LinkedList<Bomba>();
    private int limiteBombas;
    public Bomberman(){
        limiteBombas = 3;
        bomberman = new GreenfootImage[4][4];
        
        bomberman[ARRIBA][0] = new GreenfootImage("images/ParadoArriba.png");
        bomberman[ARRIBA][1] = new GreenfootImage("images/atras2.png");
        bomberman[ARRIBA][2] = new GreenfootImage("images/atras3.png");
        bomberman[ARRIBA][3] = new GreenfootImage("images/atras4.png");
        
        bomberman[DERECHA][0] = new GreenfootImage("images/vueltaDerecha.png");
        bomberman[DERECHA][1] = new GreenfootImage("images/paradoDerecha.png");
        bomberman[DERECHA][2] = new GreenfootImage("images/derecha1.png");
        bomberman[DERECHA][3] = new GreenfootImage("images/derecha2.png");

        bomberman[IZQUIERDA][0] = new GreenfootImage("images/vueltaIzquierda.png");
        bomberman[IZQUIERDA][1] = new GreenfootImage("images/paradoIzquierda.png");
        bomberman[IZQUIERDA][2] = new GreenfootImage("images/izquierda1.png");
        bomberman[IZQUIERDA][3] = new GreenfootImage("images/izquierda2.png");
        
        bomberman[ABAJO][0] = new GreenfootImage("images/paradoAbajo.png");    
        bomberman[ABAJO][1] = new GreenfootImage("images/abajo1.png");
        bomberman[ABAJO][2] = new GreenfootImage("images/abajo2.png");
        bomberman[ABAJO][3] = new GreenfootImage("vueltaIzquierda.png");
        for(int i = 0; i < 4;i++){
            for(int j = 0; j <4;j++){
                bomberman[i][j].scale(25,35);
            }
        }
    }

    public void act(){
        String tecla = Greenfoot.getKey();
        setLocation(getX() + dx, getY() + dy);
        MueveBomberman();
        PonBomba(tecla); 
        ChecaParedes();
    }

    public void BombermanQuieto(){
        if(dx == 0  && dy == 0){
            switch(direccion){
                case IZQUIERDA:
                setImage(bomberman[IZQUIERDA][1]);
                break;

                case DERECHA:
                setImage(bomberman[DERECHA][1]);

                break;

                case ARRIBA:
                setImage(bomberman[ARRIBA][0]);
                break;

                case ABAJO:
                setImage(bomberman[ABAJO][0]);
                break;
            }
        }
    }

    public void MueveBomberman(){
        CambiaSprites();
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
    
    public void PonBomba(String tecla){
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

    public void CambiaSprites(){
        
        if(dx != 0 || dy !=0){
            switch(direccion){

                case IZQUIERDA:
                if(delaySprite >= 15){
                    currentSprite = ((++currentSprite) % 4);
                    if(currentSprite == 0){
                        currentSprite++;
                    }
                    setImage(bomberman[IZQUIERDA][currentSprite]);
                    delaySprite = 0;

                }
                break;

                case DERECHA:
                if(delaySprite >= 15){
                    currentSprite = ((++currentSprite) % 4);
                    if(currentSprite == 0){
                        currentSprite++;
                    }
                    setImage(bomberman[DERECHA][currentSprite]);
                    delaySprite = 0;
                }
                break;

                case ARRIBA:
                if(delaySprite >= 15){
                    currentSprite = (++currentSprite) % 4;
                    setImage(bomberman[ARRIBA][currentSprite]);
                    delaySprite = 0;
                }
                break;

                case ABAJO:
                if(delaySprite >= 15){
                    currentSprite = ((++currentSprite) % 4);
                    if(currentSprite == 0){
                        currentSprite++;
                    }
                    setImage(bomberman[ABAJO][currentSprite]);
                    delaySprite = 0;
                }
                break;
            }
            delaySprite++;
        }
    }

    public void ChecaParedes(){

        Destruible destruible = null;
        Solido solido = null;
        Bomba bomba2 = null;

        switch(direccion){

            case ARRIBA:
            destruible = (Destruible)getOneObjectAtOffset(0, -10, Destruible.class);
            solido = (Solido)getOneObjectAtOffset(0, -10, Solido.class);
            bomba2 = (Bomba)getOneObjectAtOffset(0, -10, Bomba.class);
            break;

            case ABAJO:
            destruible = (Destruible)getOneObjectAtOffset(0, 17, Destruible.class);
            solido = (Solido)getOneObjectAtOffset(0, 17, Solido.class);
            bomba2 = (Bomba)getOneObjectAtOffset(0, 17, Bomba.class);
            break;

            case DERECHA:
            destruible = (Destruible)getOneObjectAtOffset(12,0, Destruible.class);
            solido = (Solido)getOneObjectAtOffset(12,0, Solido.class);
            bomba2 = (Bomba)getOneObjectAtOffset(12, 0, Bomba.class);
            break;

            case IZQUIERDA:
            destruible = (Destruible)getOneObjectAtOffset(-15, 0, Destruible.class);
            solido = (Solido)getOneObjectAtOffset(-15, 0, Solido.class);
            bomba2 = (Bomba)getOneObjectAtOffset(-15, 0, Bomba.class);
            break;
        }

        if(destruible != null || solido != null || bomba2!= null){
            dx = dy = 0;
        } 
    }
   

}
