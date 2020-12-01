import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Hud extends Actor{

    private GreenfootImage sprites[][];
    private Bomberman bomberman = Bomberman.getInstance();
    public Hud(){
        int N=4;
        int i,j;
        sprites = new GreenfootImage[N][N];

        for(i=0;i<N;i++){
            for(j=0;j<N;j++){
                sprites[i][j] = new GreenfootImage("images/HUD/HUD"+i+"-"+j+".png");
            }
        }
    }

    public void act(){
        hudStatus();
    }

    public void hudStatus(){
        setImage(sprites[bomberman.getBombas()][bomberman.getVidas()]);
    }
}