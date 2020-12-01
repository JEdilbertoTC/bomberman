import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Hud extends Actor{

    
    private GreenfootImage sprites[];
    protected Bomberman hud = Bomberman.getInstancia();


    private GreenfootImage sprites[][];

    public Hud(){
        int N=4;
        sprites = new GreenfootImage[N][N];
        int i,j;

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

        setImage(sprites[hud.getVidas()]);

        setImage(sprites[Bomberman.getVidas()][Bomberman.getBombas()]);

    }

}