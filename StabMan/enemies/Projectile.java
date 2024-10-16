package enemies;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

import mainFiles.*;

public class Projectile extends Enemy{
    int xDirection;
    int yDirection;
    public Projectile(){
        dead=false;
        health = 20;
        speed = 5;
        size =5;
        damage = 1;
        avatar = new JPanel();
        layerForEnemy = new JPanel();
        layerForEnemy.setBackground(new Color(0,0,0,0));
        layerForEnemy.setLayout(null);
        layerForEnemy.setBounds(35,35,740,715);
    }
    public void setDirection(int xDirection,int yDirection){
        this.xDirection = xDirection;
        this.yDirection = yDirection;
    }
    @Override
    public void move() {
        while(!dead&&!Player.dead&&!Player.gameOver){
            if(x==35||y==35||x==770||y==745){
                dead = true;
            }
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {}
            avatar.setLocation(x+xDirection, y+yDirection);
            x=x+xDirection;
            y=y+yDirection;
            int playerX = Player.x;
            int playerY = Player.y;
            if((this.x+size>playerX&&playerX+Player.size>this.x)&&(this.y+size>playerY&&playerY+Player.size>this.y)){
                hitPlayer();  
            }
            TheGame.layeredPane.repaint();
        }
    }

    @Override
    public void create(int x, int y) {
        this.x =x;
        this.y= y;
        avatar.setBounds(x,y,size,size);
        avatar.setBackground(new Color(38,36,36));
        layerForEnemy.add(avatar);
        TheGame.layeredPane.add(avatar,1);
        TheGame.layeredPane.revalidate();
        TheGame.layeredPane.repaint();
        MovementThread thread = new MovementThread(); 
        thread.start();
    }

    @Override
    public void hitPlayer(){
        Player.lowerHealth(damage);
        dead=true;
    }

    @Override
    public void lowerHealth(int damage) {
        //Cannot be killed
    }
    class MovementThread extends Thread{
        public void run(){
            move();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {}
                avatar.setBackground(new Color(38,36,36,200));
                avatar.setVisible(false);
                FixLayeredPaneThread thread = new FixLayeredPaneThread();
                thread.start();
        }
    }
    class FixLayeredPaneThread extends Thread{
        public void run(){
            for(int i =0;i<200;i++){
                    try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {}
                    try {
                        TheGame.layeredPane.remove(avatar);
                        TheGame.layeredPane.revalidate();
                        TheGame.layeredPane.repaint();   
                    } catch (Exception e) {}
                }
        }
    }
}