package enemies;

import java.awt.Color;

import javax.swing.JPanel;

import mainFiles.Player;
import mainFiles.Room;
import mainFiles.RoomMap;
import mainFiles.TheGame;

public class Exploader extends Ghoul{
     public Exploader(){
        ghoulColor = new Color(102,0,0);
        dead=false;
        health = 15;
        speed = 35;
        size =25;
        damage = 3;
        avatar = new JPanel();
        layerForEnemy = new JPanel();
        layerForEnemy.setBackground(new Color(0,0,0,0));
        layerForEnemy.setLayout(null);
        layerForEnemy.setBounds(35,35,740,715);
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
        thread.start();
        thread2.start();
    }
    @Override 
    public void damagePlayerIfOnPlayer(){
        int playerX = Player.x-35;
        int playerY = Player.y-35;
        if((this.x+size>playerX&&playerX+Player.size>this.x)&&(this.y+size>playerY&&playerY+Player.size>this.y)){
            Player.lowerHealth(0);
            Player.health-=damage;  
            dead = true;
            RoomMap.rooms.get(RoomMap.roomNumber).numEnemies--;
            RoomMap.rooms.get(RoomMap.roomNumber).closeDoors();
            RoomMap.rooms.get(RoomMap.roomNumber).openDoors();
            try {
                TheGame.redrawPlayerHealthPanel();
            } catch (Exception e) {
                Player.dead = true;
            }
            if(RoomMap.rooms.get(RoomMap.roomNumber).numEnemies<1){
                Player.canLeave = true;
                Room.roomsCleared.set(RoomMap.roomNumber,true);
            }
        }
    }
}