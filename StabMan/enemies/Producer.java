package enemies;

import java.awt.Color;

import javax.swing.JPanel;

import mainFiles.Player;
import mainFiles.RoomMap;
import mainFiles.TheGame;

public class Producer extends Ghoul{
    public Producer(){
        ghoulColor = new Color(204,0,102);
        dead=false;
        health = 15;
        speed = 100;
        size =75;
        damage = 0;
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
        FlyCreationThread thread3 = new FlyCreationThread();
        thread.start();
        thread2.start();
        thread3.start();
    }
    @Override 
    //This actually does Nothing
    public void damagePlayerIfOnPlayer(){

    }
    class FlyCreationThread extends Thread{
        public void run(){
            while(!Player.dead&&!Player.gameOver&&!dead){
                try {
                    Thread.sleep(1250);
                } catch (InterruptedException e) {}
                AggressiveFly tempFly = new AggressiveFly();
                tempFly.create(x, y);
                RoomMap.rooms.get(RoomMap.roomNumber).numEnemies++;
            }
        }
    }
}