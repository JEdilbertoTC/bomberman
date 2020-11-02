
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Bomberman extends Actor
{
    private enum Direccion{IZQUIERDA,DERECHA,ARRIBA,ABAJO};
    private GreenfootImage bombermanarriba[];
    private GreenfootImage bombermanabajo[];
    private GreenfootImage bombermanizquierda[];
    private GreenfootImage bombermanderecha[];
    private int currentX;
    private int currentY;
    private int velocidad;
    private int dx;
    private int dy;
    private int delaySprite;
    private Direccion direccion = Direccion.DERECHA;
    private int currentSprite;
    public Bomberman(){
        bombermanarriba = new GreenfootImage[4];
        bombermanabajo = new GreenfootImage[3];
        bombermanizquierda = new GreenfootImage[4];
        bombermanderecha = new GreenfootImage[4];
        
        bombermanarriba[0] = new GreenfootImage("images/ParadoArriba.png");
        bombermanarriba[1] = new GreenfootImage("images/atras2.png");
        bombermanarriba[2] = new GreenfootImage("images/atras3.png");
        bombermanarriba[3] = new GreenfootImage("images/atras4.png");
        bombermanarriba[0].scale(20,30);
        
        bombermanderecha[0] = new GreenfootImage("images/vueltaDerecha.png");
        bombermanderecha[1] = new GreenfootImage("images/paradoDerecha.png");
        bombermanderecha[2] = new GreenfootImage("images/derecha1.png");
        bombermanderecha[3] = new GreenfootImage("images/derecha2.png");
        
        bombermanizquierda[0] = new GreenfootImage("images/vueltaIzquierda.png");
        bombermanizquierda[1] = new GreenfootImage("images/paradoIzquierda.png");
        bombermanizquierda[2] = new GreenfootImage("images/izquierda1.png");
        bombermanizquierda[3] = new GreenfootImage("images/izquierda2.png");
        
        
        bombermanabajo[0] = new GreenfootImage("images/paradoAbajo.png");    
        bombermanabajo[1] = new GreenfootImage("images/abajo1.png");
        bombermanabajo[2] = new GreenfootImage("images/abajo2.png");
    }
    public void act(){
        String tecla = Greenfoot.getKey();
        
        setLocation(getX() + dx, getY() + dy);
        if(tecla!=null){
            MueveBomberman(tecla);
        }
        
        CambiaSprites(direccion);   
        //BombermanQuieto(direccion,tecla);
    }
    
    public void BombermanQuieto(Direccion direccion, String tecla){
        if(tecla== null){
        switch(direccion){
            case IZQUIERDA:
            setImage(bombermanizquierda[1]);
            break;
            case DERECHA:
            setImage(bombermanderecha[1]);
            break;
            case ARRIBA:
            setImage(bombermanarriba[0]);
            break;
            case ABAJO:
            setImage(bombermanabajo[0]);
            break;
        }
        }
    }
    public void MueveBomberman(String tecla){
        dx = dy = 0;
        switch(tecla){
            case "up":
            dy = -1;
            direccion = Direccion.ARRIBA;
            break;
            case "down":
            dy = 1;
            direccion = Direccion.ABAJO;
            break;
            case "left":
            dx = -1;
            direccion = Direccion.IZQUIERDA;
            break;
            case "right":
            dx = 1;
            direccion = Direccion.DERECHA;
            break;
        }
    }
    
    public void CambiaSprites(Direccion direccion){
        
        switch(direccion){
            case IZQUIERDA:
            if(delaySprite >= 15){
                currentSprite = ((++currentSprite) % bombermanizquierda.length);
                if(currentSprite == 0){
                    currentSprite++;
                }
                setImage(bombermanizquierda[currentSprite]);
                delaySprite = 0;
            }
            break;
            case DERECHA:
            if(delaySprite >= 15){
                currentSprite = ((++currentSprite) % bombermanderecha.length);
                if(currentSprite == 0){
                    currentSprite++;
                }
                setImage(bombermanderecha[currentSprite]);
                delaySprite = 0;
            }
            break;
            case ARRIBA:
            if(delaySprite >= 15){
                currentSprite = (++currentSprite) % bombermanarriba.length;
                setImage(bombermanarriba[currentSprite]);
                delaySprite = 0;
            }
        
            break;
            case ABAJO:
            if(delaySprite >= 15){
                currentSprite = ((++currentSprite) % bombermanabajo.length);
                if(currentSprite == 0){
                    currentSprite++;
                }
                setImage(bombermanabajo[currentSprite]);
                delaySprite = 0;
            }
            break;

        }
        delaySprite++;
    }
    
}
