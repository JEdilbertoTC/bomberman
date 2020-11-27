import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;

public class Records extends Boton{
    public Records(){
        GreenfootImage records = new GreenfootImage("images/BOTONES/records.png");
        records.scale(100,20);
        setImage(records);
    }

    public void act(){
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new Puntuaciones());
        }
    }
}