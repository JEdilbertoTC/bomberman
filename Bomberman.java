
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Bomberman extends Actor
{
    private enum Direccion{IZQUIERDA,DERECHA,ARRIBA,ABAJO};
    private GreenfootImage bombermanarriba[];
    private GreenfootImage bombermanabajo[];
    private GreenfootImage bombermanizquierda[];
    private GreenfootImage bombermanderecha[];
    private Bomba bomba;
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
        bombermanabajo = new GreenfootImage[4];
        bombermanizquierda = new GreenfootImage[4];
        bombermanderecha = new GreenfootImage[4];

        bombermanarriba[0] = new GreenfootImage("images/ParadoArriba.png");
        bombermanarriba[1] = new GreenfootImage("images/atras2.png");
        bombermanarriba[2] = new GreenfootImage("images/atras3.png");
        bombermanarriba[3] = new GreenfootImage("images/atras4.png");

        bombermanarriba[0].scale(25,35);
        bombermanarriba[1].scale(25,35);
        bombermanarriba[2].scale(25,35);
        bombermanarriba[3].scale(25,35);

        bombermanderecha[0] = new GreenfootImage("images/vueltaDerecha.png");
        bombermanderecha[1] = new GreenfootImage("images/paradoDerecha.png");
        bombermanderecha[2] = new GreenfootImage("images/derecha1.png");
        bombermanderecha[3] = new GreenfootImage("images/derecha2.png");

        bombermanderecha[0].scale(25,35);
        bombermanderecha[1].scale(25,35);
        bombermanderecha[2].scale(25,35);
        bombermanderecha[3].scale(25,35);  

        bombermanizquierda[0] = new GreenfootImage("images/vueltaIzquierda.png");
        bombermanizquierda[1] = new GreenfootImage("images/paradoIzquierda.png");
        bombermanizquierda[2] = new GreenfootImage("images/izquierda1.png");
        bombermanizquierda[3] = new GreenfootImage("images/izquierda2.png");

        bombermanizquierda[0].scale(25,35);
        bombermanizquierda[1].scale(25,35);
        bombermanizquierda[2].scale(25,35);
        bombermanizquierda[3].scale(25,35);

        bombermanabajo[0] = new GreenfootImage("images/paradoAbajo.png");    
        bombermanabajo[1] = new GreenfootImage("images/abajo1.png");
        bombermanabajo[2] = new GreenfootImage("images/abajo2.png");
        bombermanabajo[3] = new GreenfootImage("vueltaIzquierda.png");

        bombermanabajo[0].scale(25,35);
        bombermanabajo[1].scale(25,35);
        bombermanabajo[2].scale(25,35);
        bombermanabajo[3].scale(25,35); 

    }
    public void act(){
        String tecla = Greenfoot.getKey();
        setLocation(getX() + dx, getY() + dy);
        if(tecla!=null){
            MueveBomberman(tecla);
        }
        CambiaSprites(direccion);  
        ChecaParedes();

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
            case "space":
            bombermanPoneBomba(direccion);
            break;
        }
    }

    public void bombermanPoneBomba(Direccion direccion){
        switch(direccion){
            case IZQUIERDA:
            getWorld().addObject(new Bomba(), getX(),getY());
            break;
            case DERECHA:
            getWorld().addObject(new Bomba(), getX(),getY()+3);
            break;
            case ARRIBA:
            getWorld().addObject(new Bomba(), getX(),getY()+3);
            break;
            case ABAJO:
            getWorld().addObject(new Bomba(), getX(),getY());
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

    public void ChecaParedes(){
        Destruible destruible = null;
        Solido solido = null;

        switch(direccion){
            case ARRIBA:
            destruible = (Destruible)getOneObjectAtOffset(0, -10, Destruible.class);
            solido = (Solido)getOneObjectAtOffset(0, -10, Solido.class);
            break;
            case ABAJO:
            destruible = (Destruible)getOneObjectAtOffset(0, 17, Destruible.class);
            solido = (Solido)getOneObjectAtOffset(0, 17, Solido.class);
            break;
            case DERECHA:
            destruible = (Destruible)getOneObjectAtOffset(15,0, Destruible.class);
            solido = (Solido)getOneObjectAtOffset(15,0, Solido.class);
            break;
            case IZQUIERDA:
            destruible = (Destruible)getOneObjectAtOffset(-15, 0, Destruible.class);
            solido = (Solido)getOneObjectAtOffset(-15, 0, Solido.class);
            break;
        }
        if(destruible != null || solido != null){
            dx = 0;
            dy = 0;
        }
    }

}
