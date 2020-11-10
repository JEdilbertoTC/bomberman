import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Cronometro extends Actor
{
    private int minutos = 0;
    private int tiempolimite = 3600*2;
    private int segundos = 0;
    public static GreenfootSound rola = new GreenfootSound("sounds/Time Running Out.mp3");
    public void act() {
        reloj();
    }  

    public void reloj(){
        minutos = tiempolimite/3600;

        segundos = tiempolimite/60;
        tiempolimite--;
        if(tiempolimite > 3600){
            getWorld().showText(minutos +":"+ Math.abs(60-segundos),30,30);
        } else{
            getWorld().showText(minutos +":"+ segundos,30,30);
            if(segundos <40){
                rola.setVolume(40);
                rola.playLoop();
            }
        }

        if(tiempolimite == 0)
            Greenfoot.stop();
            rola.stop();
    }
}
