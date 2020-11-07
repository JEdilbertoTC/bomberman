import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mapa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mapa extends Actor
{
    private final int columnas = 29;//Tamaño i
    private final int filas = 33; // Tamaño j
    public static int mapa[][];
    private Bomberman bomberman = new Bomberman();

    public Mapa(){
        mapa = new int [columnas][filas];
        generaMapa();
    }

    public void dibujaMapa(){
        int x, y=0;
        for(int i = 0; i < columnas; i++){
            x =0;
            for(int j = 0; j < filas;j++){
                if(mapa[i][j] == 1){
                    getWorld().addObject(new Solido(),x,y);
                }else if(mapa[i][j] ==3){
                    getWorld().addObject(new Destruible(),x,y);
                }else if(mapa[i][j] ==0 || mapa[i][j] == 2){
                    getWorld().addObject(new Suelo(),x, y);
                }
                x+= 30;
            }
            y+= 30;
        }

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

    public void act(){
        //dibujaMapa();

    }    
}
