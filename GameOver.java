import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;

public class GameOver extends World{
    public static GreenfootSound rola = new GreenfootSound("sounds/gameOver.wav");
    public GameOver(){
        super(900, 600, 1);
        guardaPuntuacion();
        rola.setVolume(60);
        rola.playLoop();
        addObject(new VolverAJugar(), 350, 550);
        addObject(new Salir(), 550, 550);
    }

    public void guardaPuntuacion (){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("puntaje.txt");
            pw = new PrintWriter(fichero);
            pw.println(Puntaje.getPuntuacion());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
} 