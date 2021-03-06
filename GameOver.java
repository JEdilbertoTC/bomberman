import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;

public class GameOver extends World{
    
    public static GreenfootSound rola = new GreenfootSound("sounds/gameOver.wav");
    private Bomberman instancia = Bomberman.getInstance();
    public GameOver(){
        super(900, 600, 1);
        guardaPuntuacion();
        Mundo.rola[Mundo.CANCION_INICIO].pause();
        Mundo.rola[Mundo.CANCION_POCO_TIEMPO].pause();
        rola.setVolume(60);
        rola.playLoop();
        addObject(new VolverAJugar(), 350, 550);
        addObject(new Salir(), 550, 550);
    }

    public void guardaPuntuacion (){
        GameRecord gameRecord = GameRecord.getReferencia();
        try(FileWriter writer = new FileWriter(new File("puntaje.txt"),true)){
            writer.write(instancia.getPuntuacion()+","+instancia.getNombre()+System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} 