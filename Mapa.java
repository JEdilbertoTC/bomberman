import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Mapa extends World
{
    private final int columnas = 19;//Tamaño i
    private final int filas = 21; // Tamaño j
    private int mapa[][];
    private Bomberman bomberman = new Bomberman();
    public Mapa()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        mapa = new int [columnas][filas];
        generaMapa();

        dibujaMapa();
        addObject(new Bomberman(), 50,50);
        
        
    }

    public void generaMapa(){
        for(int i = 0; i < columnas; i++){
            for(int j = 0; j < filas;j++){
                if((i==0) ||(j==0) || (i==columnas-1) || (j==filas-1)){
                    mapa[i][j] = 1; //muro fijo
                } else if(i%2 == 0 && j%2 == 0){ // Muros interiores del mapa
                    mapa[i][j] = 1; 
                } else if((i ==1 && j == 1) || (i ==2 && j==1) || (i==1 && j==2)){//Para las posiciones iniciales del jugador
                    mapa[i][j] = 0;
                } else{
                    mapa[i][j] =  Greenfoot.getRandomNumber(2)+2; // Posiciones al azar, para destruible o suelo
                }
            }
        }
    }
    
    public void dibujaMapa(){
        int x, y=0;
        for(int i = 0; i < columnas; i++){
            x =0;
            for(int j = 0; j < filas;j++){
                if(mapa[i][j] == 1){
                    addObject(new Solido(),x,y);
                }else if(mapa[i][j] ==3){
                    addObject(new Destruible(),x,y);
                }else if(mapa[i][j] ==0 || mapa[i][j] == 2){
                    addObject(new Suelo(),x, y);
                }
                x+= 50;
            }
            y+= 50;
        }
    }
}
