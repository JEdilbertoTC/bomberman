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
            LeeFichero();
            Greenfoot.setWorld(new Puntuaciones());
        }
    }

    public void LeeFichero (){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File ("Puntuaciones/Records.txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            String linea;
            while((linea=br.readLine())!=null)
                System.out.println(linea);
        }
        catch(Exception e){
            e.printStackTrace();
        }finally{
            try{                    
                if( null != fr ){   
                    fr.close();     
                }                  
            }catch (Exception e2){ 
                e2.printStackTrace();
            }
        }
    }
}

