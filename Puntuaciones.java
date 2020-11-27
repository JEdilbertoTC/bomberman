import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;

public class Puntuaciones extends World{

    public Puntuaciones(){    
        super(900, 600, 1);
        lecturaPuntuaciones();
    }

    public void lecturaPuntuaciones(){
        int incrementoY = 0;
        try (FileReader fr = new FileReader(new File("puntaje.txt"))){
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while((linea=br.readLine())!=null){
                showText(linea, 20, 20+incrementoY);
                incrementoY +=20;
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
