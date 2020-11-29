import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Cronometro extends Actor
{
    private final int SEGUNDO = 60;
    private final int MINUTO = SEGUNDO*60;
    private int minutos = 0;
    private int tiempoLimite = MINUTO*2;
    private int segundos = 0;
    public void act() {
        reloj();
    }  

    public void reloj(){
        minutos = tiempoLimite/MINUTO;
        segundos = tiempoLimite/SEGUNDO;
        tiempoLimite--;
        if(tiempoLimite > MINUTO){
            getWorld().showText(minutos +":"+ Math.abs(60-segundos),30,30);
        } else{
            getWorld().showText(minutos +":"+ segundos,30,30);
            
        }
        if(tiempoLimite < SEGUNDO*40){
            Mundo.rola[1].playLoop();
            Mundo.rola[0].stop();
        }
        if(tiempoLimite == 0)
            Greenfoot.stop();
    }
}
