import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;

public class Records extends Boton{
<<<<<<< HEAD
    
    public Records(){
        GreenfootImage records = new GreenfootImage("images/Records.png");
        records.scale(200,30);
        setImage(records);
=======
    public Records(){
        setImage("images/Records.png");
>>>>>>> ff5ed21f3664c3a422286f571ef80ca2afa9f3a2
    }
    
    public void act(){
        if(Greenfoot.mouseClicked(this)){
            LeeFichero();
            Greenfoot.setWorld(new Puntuaciones());
            Menu.rola.pause();
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

