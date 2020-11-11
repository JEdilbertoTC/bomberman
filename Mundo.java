import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
import java.util.*;
public class Mundo extends World
{   
    private final int columnas = 29;//Tamaño i
    private final int filas = 33; // Tamaño j
    public static int mapa[][];
    private Bomberman bomberman = new Bomberman();

    Hud hud = new Hud();
    public static GreenfootSound rola[] = new GreenfootSound[2];

    public Mundo()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels  
        super(900, 600, 1);
        rola[0] = new GreenfootSound("sounds/MusicaFondo.wav");
        rola[1] = new GreenfootSound("sounds/Time_Running_Out.wav");
        mapa = new int [columnas][filas];
        generaMapa();
        dibujaMapa();
        addObject(new Bomberman(), 30, 30);
        addObject(new Cronometro(), 0, 0);
        addObject(new Enemigo(), 200,200);

        //Creacion del HUD//
        //bomberman.setVida(vida);
        hud.hudStatus();
        addObject(hud,520,750);

        rola[0].setVolume(40);
        rola[1].setVolume(40);
        rola[0].playLoop();

        rola[0].setVolume(40);
        rola[1].setVolume(40);
        rola[0].playLoop();

    }

    public static int[][] getMapa(){
        return mapa;
    }

    public void generaMapa(){
        for(int i = 0; i < columnas; i++){
            for(int j = 0; j < filas;j++){
                if((i==0) ||(j==0) || (i==columnas-1) || (j==filas-1)){
                    mapa[i][j] = 1; //muro fijo
                }else if(i%2 == 0 && j%2 == 0){ // Muros interiores del mapa
                    mapa[i][j] = 1; 
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
                if(mapa[i][j] == 1){
                    addObject(new Solido(),x,y);
                }else if(mapa[i][j] ==3){
                    addObject(new Destruible(),x,y);
                }else if(mapa[i][j] ==0 || mapa[i][j] == 2){
                    addObject(new Suelo(),x, y);
                }
                x+= 30;
            }
            y+= 30;
        }

    }
}