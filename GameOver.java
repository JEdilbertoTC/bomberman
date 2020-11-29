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
        GameRecord gameRecord = new GameRecord();
        try(FileWriter writer = new FileWriter(new File("puntaje.txt"),true)){
            writer.write(gameRecord.getScore()+","+"nombre"+System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} 