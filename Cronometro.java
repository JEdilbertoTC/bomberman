import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Cronometro extends Hud{
    private final int SEGUNDO = 60;
    private final int MINUTO = SEGUNDO*60;
    private int minutos = 0;
    private int tiempoLimite = MINUTO * 2;
    private int segundos = 0;
    public void act() {
        reloj();
    }  

    public void reloj(){
        minutos = tiempoLimite/MINUTO;
        segundos = tiempoLimite/SEGUNDO;
        tiempoLimite--;
        if(tiempoLimite > MINUTO){
            getWorld().showText(minutos +":"+ Math.abs(60-segundos),850,10);
        } else{
            getWorld().showText(minutos +":"+ segundos,850,10);
            
        }
        if(tiempoLimite < SEGUNDO*40){
            Mundo.rola[Mundo.CANCION_POCO_TIEMPO].playLoop();
            Mundo.rola[Mundo.CANCION_INICIO].stop();
        }
        if(tiempoLimite == 0){
            Greenfoot.setWorld(new GameOver());
        }
    }
}
