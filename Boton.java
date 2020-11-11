import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Boton extends Actor
{
    private boolean mouseOver = false;
    private static int MAX_TRANS = 255;
    
    public void checkMouse(){

        if(Greenfoot.mouseDragged(null)){
            mouseOver = Greenfoot.mouseDragged(null);

        }

        if(mouseOver){
            adjustTransparency(MAX_TRANS/3);

        }
        else{
            adjustTransparency(255);
        }
    }

    public void adjustTransparency(int adjust){
        GreenfootImage tempImage = getImage();
        tempImage.setTransparency(adjust);
        setImage(tempImage);
    }

}
