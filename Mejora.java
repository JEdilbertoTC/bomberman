import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Mejora extends Personaje{
    public Mejora(){
        sprites = new GreenfootImage[3][2];
        sprites[0][0] = new GreenfootImage("POWERUPS/pCalavera1.png");
        sprites[0][1] = new GreenfootImage("POWERUPS/pCalavera2.png");
        sprites[1][0] = new GreenfootImage("POWERUPS/pVida1.png");
        sprites[1][1] = new GreenfootImage("POWERUPS/pVida2.png");
        sprites[2][0] = new GreenfootImage("POWERUPS/pBomba1.png");
        sprites[2][1] = new GreenfootImage("POWERUPS/pBomba2.png");
        
        for(int i = 0; i< 3; i++){
            for(int j = 0; j < 2; j++){
                sprites[i][j].scale(30,30);
            }
        }
    }

    public void act(){
        animaMejora();
    }

    public void animaMejora(){
        if(delaySprite >= 5){
            currentSprite = ((++currentSprite) % 2);
            setImage(sprites[2][currentSprite]);
            delaySprite = 0;

        }
        delaySprite++;
    }
}
