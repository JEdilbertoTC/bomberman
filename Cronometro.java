import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Cronometro extends Actor
{
    private int minutos = 0;
    private int tiempoLimite = 3600*2; //2 Minutos
    private int segundos = 0;
    public void act() {
        reloj();
    }  

    public void reloj(){
        minutos = tiempoLimite/3600;
        segundos = tiempoLimite/60;
        tiempoLimite--;
        if(tiempoLimite > 3600){
            getWorld().showText(minutos +":"+ Math.abs(60-segundos),30,30);
        } else{
            getWorld().showText(minutos +":"+ segundos,30,30);
            
        }
        if(tiempoLimite < 60*40){// 40 Segundos
            Mundo.rola[1].playLoop();
            Mundo.rola[0].stop();
        }
        if(tiempoLimite == 0)
            Greenfoot.stop();
    }
}
