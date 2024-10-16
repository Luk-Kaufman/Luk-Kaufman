package enemies;

import java.awt.Color;

import javax.swing.JPanel;

import enemies.Producer.FlyCreationThread;
import mainFiles.Player;
import mainFiles.TheGame;

public class Shooter extends Ghoul{
    int intervalBetweenShots =340;
    public Shooter(){
        ghoulColor = new Color(102,51,0);
        dead=false;
        health = 10;
        speed = 9;
        size =15;
        damage = 0;
        avatar = new JPanel();
        layerForEnemy = new JPanel();
        layerForEnemy.setBackground(new Color(0,0,0,0));
        layerForEnemy.setLayout(null);
        layerForEnemy.setBounds(35,35,740,715);
    }
     @Override
     public void move(){
        while(!dead&&!Player.gameOver){
            damagePlayerIfOnPlayer();
            takeDamageIfOnSpear();
            try {
            Thread.sleep(speed);
            }catch (InterruptedException e) {}
            int playerX = Player.x-35;
            int playerY = Player.y-35;
            if((this.x+this.size/2)>(playerX+Player.size/2)&&x<700){
                this.x++;
                avatar.setLocation(x+1,y);
            }
            if((this.x+this.size/2)<(playerX+Player.size/2)&&x>35){
                this.x--;
                avatar.setLocation(x-1,y);
            }
            if((this.y+this.size/2)>(playerY+Player.size/2)&&y<665){
                this.y++;
                avatar.setLocation(x,y+1);
            }
            if((this.y+this.size/2)<(playerY+Player.size/2)&&y>35){
                this.y--;
                avatar.setLocation(x,y-1);
            }
            TheGame.layeredPane.repaint();
        }
    }
    @Override
    public void create(int x, int y){
        this.x =x;
        this.y= y;
        avatar.setBounds(x,y,size,size);
        avatar.setBackground(ghoulColor);
        layerForEnemy.add(avatar);
        TheGame.layeredPane.add(layerForEnemy,2);
        TheGame.layeredPane.repaint();
        MovementThread thread = new MovementThread();
        ColorChangeThread thread2 = new ColorChangeThread();
        ProjectileCreationThread thread3 = new ProjectileCreationThread();
        thread.start();
        thread2.start();
        thread3.start();
    }
    @Override 
    //This actually does Nothing
    public void damagePlayerIfOnPlayer(){

    }
    class ProjectileCreationThread extends Thread{
        public void run(){
            try {
            Thread.sleep(500);
        } catch (InterruptedException e) {}
            int shots = 0;
            while(!dead&&!Player.dead&&!Player.gameOver){
                try {
                    Thread.sleep(intervalBetweenShots);
                } catch (InterruptedException e) {}
                if(shots ==50){
                    shots = 0;
                    try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {}
                }
                Projectile tempProjectile = new Projectile();
                int xDirection=0;
                int yDirection=0;
                int playerX = Player.x-35;
                int playerY = Player.y-35;
                int playerXRelativeToProjectile = playerX-x;
                int playerYRelativeToProjectile = playerY-y;
                double degrees = (360/(2*Math.PI)*Math.atan2(playerYRelativeToProjectile,playerXRelativeToProjectile));
                if(degrees>=-22.5&&degrees<22.5){
                    xDirection=1;
                }
                if(degrees>=22.5&&degrees<67.5){
                    xDirection=1;
                    yDirection=1;
                }
                if(degrees>=67.5&&degrees<112.5){
                    yDirection=1;
                }
                if(degrees>=112.5&&degrees<157.5){
                    xDirection=-1;
                    yDirection=1;
                }
                if((degrees>=157.5&&degrees<=180)||degrees>=-180&&degrees<-157.5){
                    xDirection=-1;
                }
                if(degrees>=-157.5&&degrees<-112.5){
                    xDirection=-1;
                    yDirection=-1;
                }
                if(degrees>=-112.5&&degrees<-67.5){
                    yDirection=-1;
                }
                if(degrees>=-67.5&&degrees<-22.5){
                    xDirection=1;
                    yDirection=-1;
                }
                
                tempProjectile.setDirection(xDirection,yDirection);
                tempProjectile.create((int)x+size/2+35,(int)y+size/2+35);
                shots++;
            }
        }
    }
    
}