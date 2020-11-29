import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Puntaje extends Hud{
    private static int puntuacion = 0;

    public void act(){
        getWorld().showText("PUNTUACION"+":"+getPuntuacion(), 800, 80);
    }    
    public static void setPuntuacion(int puntos){
        puntuacion+= puntos;
    }
    
    public static int getPuntuacion(){
        return puntuacion;
    }
}
