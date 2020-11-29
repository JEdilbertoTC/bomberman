import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Mejora extends Actor{
    protected GreenfootImage sprites [][];
    protected int delaySprite;
    protected int currentSprite;
    protected static final int NUMERO_MEJORAS = 3;
    protected final int MEJORA_CALAVERA = 0;
    protected final int MEJORA_VIDA = 1;
    protected final int MEJORA_BOMBA = 2;
    public Mejora(){
        
        sprites = new GreenfootImage[3][2];
        sprites[MEJORA_CALAVERA][0] = new GreenfootImage("POWERUPS/pCalavera1.png");
        sprites[MEJORA_CALAVERA][1] = new GreenfootImage("POWERUPS/pCalavera2.png");
        sprites[MEJORA_VIDA][0] = new GreenfootImage("POWERUPS/pVida1.png");
        sprites[MEJORA_VIDA][1] = new GreenfootImage("POWERUPS/pVida2.png");
        sprites[MEJORA_BOMBA][0] = new GreenfootImage("POWERUPS/pBomba1.png");
        sprites[MEJORA_BOMBA][1] = new GreenfootImage("POWERUPS/pBomba2.png");
        
        for(int i = 0; i< 3; i++){
            for(int j = 0; j < 2; j++){
                sprites[i][j].scale(30,30);
            }
        }
        
    }

    public void animaMejora(int tipo){
        if(delaySprite >= 5){
            currentSprite = ((++currentSprite) % 2);
            setImage(sprites[tipo][currentSprite]);
            delaySprite = 0;

        }
        delaySprite++;
    }
}
