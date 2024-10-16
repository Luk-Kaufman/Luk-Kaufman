package enemies;

import java.awt.Color;
import java.util.Random;

import javax.swing.JPanel;

import mainFiles.*;

public class Fly extends Enemy{
    int flaps = 0;
    int randomY = 675;
    int randomX = 675;
    public Fly(){
        dead=false;
        health = 1;
        speed = 40;
        size =6;
        damage = 0;
        avatar = new JPanel();
        layerForEnemy = new JPanel();
        layerForEnemy.setBackground(new Color(0,0,0,0));
        layerForEnemy.setLayout(null);
        layerForEnemy.setBounds(35,35,740,715);
    }

    @Override
    public void move() {
        while(!dead&&!Player.gameOver){
            flaps++;
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {}
            checkIfOnPlayer();
            checkIfSpear();
            double randomNumberX = Math.random()*randomX;
            double randomNumberY = Math.random()*randomY;
            if(flaps==75){
                flaps = 0;
                Random r = new Random();
                randomX = r.nextInt(745*2)+130;
                randomY = r.nextInt(745*2)+130;
            }
            if(x<randomNumberX){
                avatar.setLocation(x+1,y);
                x++;
            }else{
                avatar.setLocation(x-1,y);
                x--;
            }
            if(y<randomNumberY){
                avatar.setLocation(x,y+1);
                y++;
            }else{
                avatar.setLocation(x,y-1);
                y--;
            }
            TheGame.layeredPane.repaint();
        }
    }

    @Override
    public void create(int x,int y) {
        this.x =x;
        this.y= y;
        avatar.setBounds(x,y,size,size);
        avatar.setBackground(new Color(38,36,36));
        layerForEnemy.add(avatar);
        TheGame.layeredPane.add(layerForEnemy,1);
        TheGame.layeredPane.repaint();
        MovementThread thread = new MovementThread();
        thread.start();
    }

    @Override
    public void hitPlayer(){

    }
    public void lowerHealth(int damage){
        health-= damage;
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
    public boolean checkIfOnPlayer(){
        int playerX = Player.x-35;
        int playerY = Player.y-35;
        if((this.x+size>playerX&&playerX+Player.size>this.x)&&(this.y+size>playerY&&playerY+Player.size>this.y)){
            return true;
        }
        return false;
    }
    public void checkIfSpear(){
        int spearX = Weapon.spearLocationX-35;
        int spearY = Weapon.spearLocationY-35;
        if((this.x+size>spearX&&spearX+Weapon.weaponSize>this.x)&&(this.y+size>spearY&&spearY+Weapon.weaponSize>this.y)){
            if(Weapon.canHitSomething){
                lowerHealth(Player.damage);
            }
        }
    }
    class MovementThread extends Thread{
        public void run(){
            move();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {}
                avatar.setBackground(new Color(38,36,36,200));
                avatar.setVisible(false);
                TheGame.layeredPane.repaint();
        }
    }
}