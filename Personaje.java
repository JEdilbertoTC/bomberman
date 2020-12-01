import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Personaje extends Actor{
    protected static Bomberman instanciaBomberman = Bomberman.getInstancia();
    public enum Direccion{IZQUIERDA,DERECHA,ARRIBA,ABAJO};
    protected int delaySprite;
    protected int currentSprite;
    protected int dx;
    protected int dy;
    protected GreenfootImage sprites[][];
}
