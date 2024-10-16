package mainFiles;

import javax.swing.JPanel;

public abstract class Enemy{
    protected int x;
    protected int y;
    protected int health;
    protected boolean dead;
    protected int speed;
    protected int damage;
    protected int size;
    protected JPanel avatar;
    protected static JPanel layerForEnemy;
    public abstract void move();
    public abstract void create(int x,int y);
    public abstract void hitPlayer();
    public abstract void lowerHealth(int damage);
}