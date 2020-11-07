
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
        MueveBomberman();
        CambiaSprites(direccion);  
        ChecaParedes();
        //DestruirMuros();
    }

    public void BombermanQuieto(Direccion direccion){
        if(dx == 0  && dy == 0){
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

    public void MueveBomberman(){
        dx = dy = 0;
        if(Greenfoot.isKeyDown("up")){
            dy = -1;
            direccion = Direccion.ARRIBA;

        } else if(Greenfoot.isKeyDown("down")){
            dy = 1;
            direccion = Direccion.ABAJO;

        } else if(Greenfoot.isKeyDown("left")){
            dx = -1;
            direccion = Direccion.IZQUIERDA;

        } else if(Greenfoot.isKeyDown("right")){
            dx = 1;
            direccion = Direccion.DERECHA;
        } else{
            BombermanQuieto(direccion);
        }
    }

    public void PonBomba(Direccion direccion){
        switch(direccion){
            case IZQUIERDA:
            getWorld().addObject(new Bomba(), getX(),getY()+3);
            break;

            case DERECHA:
            getWorld().addObject(new Bomba(), getX(),getY()+5);
            break;

            case ARRIBA:
            getWorld().addObject(new Bomba(), getX(),getY()+3);
            break;

            case ABAJO:
            getWorld().addObject(new Bomba(), getX(),getY()+3);
            break;
        }
    }

    //public void DestruirMuros(){
    //  bomba = (Bomba)getNeighbours(10, false, Destruible.class);
    //}

    public void CambiaSprites(Direccion direccion){
        if(dx != 0 || dy !=0){
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

    public void ChecaParedes(){
        Destruible destruible = null;
        Solido solido = null;
        Bomba bomba2 = null;
        switch(direccion){

            case ARRIBA:
            destruible = (Destruible)getOneObjectAtOffset(0, -10, Destruible.class);
            solido = (Solido)getOneObjectAtOffset(0, -10, Solido.class);
            bomba2 = (Bomba)getOneObjectAtOffset(0, -10, Bomba.class);
            break;

            case ABAJO:
            destruible = (Destruible)getOneObjectAtOffset(0, 17, Destruible.class);
            solido = (Solido)getOneObjectAtOffset(0, 17, Solido.class);
            bomba2 = (Bomba)getOneObjectAtOffset(0, 17, Bomba.class);
            break;

            case DERECHA:
            destruible = (Destruible)getOneObjectAtOffset(15,0, Destruible.class);
            solido = (Solido)getOneObjectAtOffset(15,0, Solido.class);
            bomba2 = (Bomba)getOneObjectAtOffset(15, 0, Bomba.class);
            break;

            case IZQUIERDA:
            destruible = (Destruible)getOneObjectAtOffset(-15, 0, Destruible.class);
            solido = (Solido)getOneObjectAtOffset(-15, 0, Solido.class);
            bomba2 = (Bomba)getOneObjectAtOffset(-15, 0, Bomba.class);
            break;
        }
        if(destruible != null || solido != null || bomba2!= null){
            dx = dy = 0;
        } 
    }

}
