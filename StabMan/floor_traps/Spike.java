package floor_traps;

import java.awt.Color;

import javax.swing.JPanel;

import mainFiles.*;

public class Spike extends FloorAddons{
    public JPanel layerForFloorTrap;     
    int roomNum;
    public Spike(){
        roomNum=RoomMap.roomNumber;
        damage = 1;
        avatar = new JPanel();
        layerForFloorTrap = new JPanel();
        layerForFloorTrap.setBackground(new Color(0,0,0,0));
        layerForFloorTrap.setLayout(null);
        layerForFloorTrap.setBounds(35,35,740,715);
    }

    @Override
    public void create(int x, int y, int xSize, int ySize) {
        this.x =x;
        this.y= y;
        this.xSize =xSize;
        this.ySize= ySize;
        avatar.setBounds(x,y,xSize,ySize);
        avatar.setBackground(new Color(0,175,0));
        layerForFloorTrap.add(avatar);
        int indexOfPlayerAvatar = TheGame.layeredPane.getIndexOf(Player.playerAvatar);
        if(Menu.firstAttempt){
            TheGame.layeredPane.add(layerForFloorTrap,indexOfPlayerAvatar+1);
        }else{
            TheGame.layeredPane.add(layerForFloorTrap,indexOfPlayerAvatar+1);
        }
        TheGame.layeredPane.repaint();
        DamageThread thread = new DamageThread();
        thread.start();
    }

    @Override
    public boolean checkIfPlayerIsOver(){
        int playerX = Player.x-35;
        int playerY = Player.y-35;
        int rightBound = this.x+this.xSize;
        if(!(playerX+Player.size>this.x)){
            return false;
        }
        if(!(rightBound>playerX)){
            return false;
        }
        if(!(playerY+Player.size>this.y)){
            return false;
            }
        if(!(this.y+this.ySize>playerY)){
            return false;
            }
        return true;
    }

    class DamageThread extends Thread{
        public void run(){
            while(!Player.dead&&!Player.gameOver&&roomNum==RoomMap.roomNumber){
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {}
                if(checkIfPlayerIsOver()){
                    Player.lowerHealth(damage);
                }
            }
            layerForFloorTrap.remove(avatar);
            layerForFloorTrap.revalidate();
            layerForFloorTrap.repaint();
            TheGame.layeredPane.remove(layerForFloorTrap);
            TheGame.layeredPane.revalidate();
            TheGame.layeredPane.repaint();
        }
    }
}