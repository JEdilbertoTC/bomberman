import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
public class Mundo extends World{   
    private final int COLUMNAS = 21;
    private final int FILAS = 31;
    private final int SOLIDO = 1;
    private final int SUELO = 2;
    private final int DESTRUIBLE = 3;
    public int mapa[][];
    public static GreenfootSound rola[] = new GreenfootSound[2];
    public static LinkedList<Enemigo> enemigos;
    public static LinkedList<Mejora> mejoras;
    public static int numEnemigos = 1;
    public static int numMejoras = numEnemigos;
    public static final int CANCION_INICIO = 0;
    public static final int CANCION_POCO_TIEMPO = 1;
    private Bomberman bomberman = Bomberman.getInstance();
    public Mundo(){    
        super(900, 600, 1);
        enemigos = new LinkedList<Enemigo>();
        mejoras = new LinkedList<Mejora>();
        rola[CANCION_INICIO] = new GreenfootSound("sounds/MusicaFondo.wav");
        rola[CANCION_POCO_TIEMPO] = new GreenfootSound("sounds/Time_Running_Out.wav");
        mapa = new int [COLUMNAS][FILAS];
        generaMapa();
        dibujaBase();
        dibujaMejoras();
        dibujaMapa();
        dibujaEnemigos();  
        addObject(bomberman, 30, 30);
        addObject(new Cronometro(), 0, 0);
        addObject(new Puntaje(),0,0);
        addObject(new Hud(),810,50);
        addObject(new Nivel(), 0, 0);

        rola[CANCION_INICIO].setVolume(40);
        rola[CANCION_POCO_TIEMPO].setVolume(40);
        rola[CANCION_INICIO].pause();
        rola[CANCION_POCO_TIEMPO].pause();
        rola[CANCION_INICIO].playLoop();
    }

    public void dibujaEnemigos(){
        while(numEnemigos > enemigos.size()){
            int xEnemigo = new Random().nextInt(FILAS);
            int yEnemigo = new Random().nextInt(COLUMNAS);
            if((mapa[yEnemigo][xEnemigo]!=DESTRUIBLE)&&(mapa[yEnemigo][xEnemigo]!=SOLIDO)&&(mapa[yEnemigo][xEnemigo]==SUELO)){
                addObject(new Enemigo(),xEnemigo*30,yEnemigo*30);
                enemigos.add(new Enemigo());
            }
        }
    }
    
    public void dibujaMejoras(){
        while(numMejoras > mejoras.size()){
            int xMejora = new Random().nextInt(FILAS);
            int yMejora = new Random().nextInt(COLUMNAS);
            if((mapa[yMejora][xMejora]==DESTRUIBLE)&&(mapa[yMejora][xMejora]!=SOLIDO)&&(mapa[yMejora][xMejora]!=SUELO)){
                SelectorDeMejoras selector = new SelectorDeMejoras();
                Mejora opcion = selector.selector(new Random().nextInt(Mejora.NUMERO_MEJORAS));
                addObject(opcion,xMejora*30,yMejora*30);
                mejoras.add(new Mejora());
            }
        }
    }

    public void generaMapa(){
        for(int i = 0; i < COLUMNAS; i++){
            for(int j = 0; j < FILAS;j++){
                if((i==0) ||(j==0) || (i==COLUMNAS-1) || (j==FILAS-1)){
                    mapa[i][j] = SOLIDO; 
                }else if(i%2 == 0 && j%2 == 0){ // Muros interiores del mapa
                    mapa[i][j] = SOLIDO; 
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
        for(int i = 0; i < COLUMNAS; i++){
            x = 0;
            for(int j = 0; j<FILAS; j++){
                addObject(new Suelo(), x, y);
                x+= 30;
            }
            y+= 30;
        }
    }

    public void dibujaMapa(){
        int x, y =0;
        for(int i = 0; i < COLUMNAS; i++){
            x = 0;
            for(int j = 0; j < FILAS;j++){
                if(mapa[i][j] == SOLIDO){
                    addObject(new Solido(),x,y);
                }else if(mapa[i][j] ==DESTRUIBLE){
                    addObject(new Destruible(),x,y);
                }
                x+= 30;
            }
            y+= 30;
        }
    }
}