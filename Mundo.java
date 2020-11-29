
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
public class Mundo extends World{   
    
    private final int columnas = 29;
    private final int filas = 33;
    private final int FIJO = 1;
    private final int SUELO = 2;
    private final int DESTRUIBLE = 3;
    public int mapa[][];
    private Bomberman bomberman = new Bomberman();
    public static GreenfootSound rola[] = new GreenfootSound[2];
    public static LinkedList<Enemigo> enemigos;
    public static int numEnemigos = 1;
    public static final int CANCION_INICIO = 0;
    public static final int CANCION_POCO_TIEMPO = 0;
    public Mundo()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels  
        super(900, 600, 1);
        enemigos = new LinkedList<Enemigo>();
        rola[CANCION_INICIO] = new GreenfootSound("sounds/MusicaFondo.wav");
        rola[CANCION_POCO_TIEMPO] = new GreenfootSound("sounds/Time_Running_Out.wav");
        mapa = new int [columnas][filas];
        generaMapa();
        dibujaMapa();
        addObject(new Bomberman(), 30, 30);
        addObject(new Cronometro(), 0, 0);
        addObject(new Puntaje(),0,0);
        addObject(new Hud(),350,550);
        
        rola[CANCION_INICIO].setVolume(40);
        rola[CANCION_POCO_TIEMPO].setVolume(40);
        rola[CANCION_INICIO].playLoop();

        rola[CANCION_INICIO].setVolume(40);
        rola[CANCION_POCO_TIEMPO].setVolume(40);
        rola[CANCION_INICIO].playLoop();
    }
    public void dibujaEnemigos(int x, int y){
        while(numEnemigos > enemigos.size()){
            addObject(new Enemigo(),x,y);
            enemigos.add(new Enemigo());
        }
    }
    
    public void generaMapa(){
        for(int i = 0; i < columnas; i++){
            for(int j = 0; j < filas;j++){
                if((i==0) ||(j==0) || (i==columnas-1) || (j==filas-1)){
                    mapa[i][j] = FIJO; 
                }else if(i%2 == 0 && j%2 == 0){ // Muros interiores del mapa
                    mapa[i][j] = FIJO; 
                }else if((i ==1 && j == 1) || (i ==2 && j==1) || (i==1 && j==2)){//Para las posiciones iniciales del jugador
                    mapa[i][j] = 0;
                }else{
                    mapa[i][j] =  Greenfoot.getRandomNumber(2)+2; // Posiciones al azar, para destruible o suelo
                }
            }
        }
    }

    public void dibujaBase(){
        int x, y = 0;
        for(int i = 0; i < columnas; i++){
            x = 0;
            for(int j = 0; j<filas; j++){
                addObject(new Suelo(), x, y);
                x+= 30;
            }
            y+= 30;
        }
    }

    public void dibujaMapa(){
        dibujaBase();
        int x, y =0;
        for(int i = 0; i < columnas; i++){
            x = 0;
            for(int j = 0; j < filas;j++){
                if(mapa[i][j] == FIJO){
                    addObject(new Solido(),x,y);
                }else if(mapa[i][j] ==DESTRUIBLE){
                    addObject(new Destruible(),x,y);
                }else if(mapa[i][j] != 0 && mapa[i][j] !=DESTRUIBLE && mapa[i][j] != FIJO && mapa[i][j] ==2){
                    dibujaEnemigos(new Random().nextInt(getWidth()),new Random().nextInt(getHeight()));
                }
                x+= 30;
            }
            y+= 30;
        }
        
    }
}