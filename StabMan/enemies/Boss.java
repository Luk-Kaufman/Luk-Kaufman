package enemies;

import java.awt.Color;
import java.util.Random;

import javax.swing.JPanel;

import mainFiles.Driver;
import mainFiles.Player;
import mainFiles.RoomMap;
import mainFiles.TheGame;

public class Boss extends Producer{
    public Boss(){
        ghoulColor = new Color(255,151,153);
        dead=false;
        health = 200*Driver.difficulty;
        speed = 15;
        size =150;
        damage = 1;
        avatar = new JPanel();
        layerForEnemy = new JPanel();
        layerForEnemy.setBackground(new Color(0,0,0,0));
        layerForEnemy.setLayout(null);
        layerForEnemy.setBounds(35,35,740,715);
    }    
    @Override 
    //This actually does Nothing
    public void damagePlayerIfOnPlayer(){
        int playerX = Player.x-35;
        int playerY = Player.y-35;
        if((this.x+size>playerX&&playerX+Player.size>this.x)&&(this.y+size>playerY&&playerY+Player.size>this.y)){
            Player.lowerHealth(damage);  
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
        EmemyCreationThread thread3 = new EmemyCreationThread();
        thread.start();
        thread2.start();
        thread3.start();
    }
        class EmemyCreationThread extends Thread{
        public void run(){
            while(!Player.dead&&!Player.gameOver&&!dead&&RoomMap.rooms.get(RoomMap.roomNumber).numEnemies<25){
                try {
                    Thread.sleep((int)(1+1000*.35*RoomMap.rooms.get(RoomMap.roomNumber).numEnemies));
                } catch (InterruptedException e) {}
                Random rand = new Random();
                int randomNum = rand.nextInt(101);
                if(randomNum<20){
                    Fly tempFly = new Fly();
                    tempFly.create((int)x+size/2,(int)y+size/2);
                    RoomMap.rooms.get(RoomMap.roomNumber).numEnemies++;
                }
                else if(randomNum<50){
                    AggressiveFly tempFly = new AggressiveFly();
                    tempFly.create((int)x+size/2,(int)y+size/2);
                    RoomMap.rooms.get(RoomMap.roomNumber).numEnemies++;
                }else if(randomNum<75){
                    Ghoul tempGhoul = new Ghoul();
                    tempGhoul.create((int)x+size/2,(int)y+size/2);
                    RoomMap.rooms.get(RoomMap.roomNumber).numEnemies++;
                }
                else if(randomNum<90){
                    FastGhoul tempGhoul = new FastGhoul();
                    tempGhoul.create((int)x+size/2,(int)y+size/2);
                    RoomMap.rooms.get(RoomMap.roomNumber).numEnemies++;
                }
                else if(randomNum<94){
                    Shooter tempShooter = new Shooter();
                    tempShooter.create((int)x+size/2,(int)y+size/2);
                    RoomMap.rooms.get(RoomMap.roomNumber).numEnemies++;
                }
                else if(randomNum<99){
                    Exploader tempExploader = new Exploader();
                    tempExploader.create((int)x+size/2,(int)y+size/2);
                    RoomMap.rooms.get(RoomMap.roomNumber).numEnemies++;
                }
                else{
                    Producer tempProducer = new Producer();
                    tempProducer.create((int)x+size/2,(int)y+size/2);
                    RoomMap.rooms.get(RoomMap.roomNumber).numEnemies++;
                }
            }
        }
    }
}