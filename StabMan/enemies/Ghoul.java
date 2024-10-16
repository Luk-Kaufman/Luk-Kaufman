package enemies;

import java.awt.Color;

import javax.swing.JPanel;

import mainFiles.*;
import rooms.*;

public class Ghoul extends Enemy{
    Color ghoulColor = new Color(17,77,47);
    boolean damaged = false;
    public Ghoul(){
        dead=false;
        health = 20;
        speed = 25;
        size =25;
        damage = 1;
        avatar = new JPanel();
        layerForEnemy = new JPanel();
        layerForEnemy.setBackground(new Color(0,0,0,0));
        layerForEnemy.setLayout(null);
        layerForEnemy.setBounds(35,35,740,715);
    }
    public void damagePlayerIfOnPlayer(){
        int playerX = Player.x-35;
        int playerY = Player.y-35;
        if((this.x+size>playerX&&playerX+Player.size>this.x)&&(this.y+size>playerY&&playerY+Player.size>this.y)){
            Player.lowerHealth(damage);  
        }
    }
    public void takeDamageIfOnSpear(){
        int spearX = Weapon.spearLocationX-35;
        int spearY = Weapon.spearLocationY-35;
        if((this.x+size>spearX&&spearX+Weapon.weaponSize>this.x)&&(this.y+size>spearY&&spearY+Weapon.weaponSize>this.y)){
            if(Weapon.canHitSomething){
                damaged = true;
                lowerHealth(Player.damage);
            }
        }
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
            if((this.x+this.size/2)>(playerX+Player.size/2)){
                this.x--;
                avatar.setLocation(x-1,y);
            }
            if((this.x+this.size/2)<(playerX+Player.size/2)){
                this.x++;
                avatar.setLocation(x+1,y);
            }
            if((this.y+this.size/2)>(playerY+Player.size/2)){
                this.y--;
                avatar.setLocation(x,y-1);
            }
            if((this.y+this.size/2)<(playerY+Player.size/2)){
                this.y++;
                avatar.setLocation(x,y+1);
            }
            TheGame.layeredPane.repaint();
        }
    }

    @Override
    public void create(int x, int y) {
        this.x =x;
        this.y= y;
        avatar.setBounds(x,y,size,size);
        avatar.setBackground(ghoulColor);
        layerForEnemy.add(avatar);
        TheGame.layeredPane.add(layerForEnemy,2);
        TheGame.layeredPane.repaint();
        MovementThread thread = new MovementThread();
        ColorChangeThread thread2 = new ColorChangeThread();
        thread.start();
        thread2.start();
    }

    @Override
    public void hitPlayer() {

    }

    @Override
    public void lowerHealth(int damage) {
        health-= Player.damage;
        Weapon.canHitSomething = false;
        if(health<1){
            dead = true;
            RoomMap.rooms.get(RoomMap.roomNumber).numEnemies--;
            RoomMap.rooms.get(RoomMap.roomNumber).closeDoors();
            RoomMap.rooms.get(RoomMap.roomNumber).openDoors();
           if(RoomMap.rooms.get(RoomMap.roomNumber).numEnemies<1){
                Player.canLeave = true;
                Room.roomsCleared.set(RoomMap.roomNumber,true);
            }
        }
    }
    class ColorChangeThread extends Thread{
        public void run(){
            while (!dead&&!Player.gameOver) {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {}
                if(damaged){
                    avatar.setBackground(new Color(25,0,0));
                    damaged=false;
                    TheGame.layeredPane.repaint();
                    try {
                    Thread.sleep(200);
                    } catch (InterruptedException e) {}
                    avatar.setBackground(ghoulColor);
                    TheGame.layeredPane.repaint();
                }                
            }

        }
    }
    class MovementThread extends Thread{
        public void run(){
            try {
                Thread.sleep(1800);
            } catch (InterruptedException e) {}
            move();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {}
                avatar.setBackground(new Color(17,77,47,200));
                avatar.setVisible(false);
                TheGame.layeredPane.repaint();
        }
    }
}