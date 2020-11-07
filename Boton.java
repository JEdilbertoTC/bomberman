import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boton extends Actor
{
    /**
     * Act - do whatever the Boton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    private boolean mouseOver = false;
    private static int MAX_TRANS = 255;

    /**
     * Act - do whatever the Boton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
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

    public void act(){

    }

}
