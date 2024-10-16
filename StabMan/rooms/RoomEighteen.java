package rooms;

import java.util.ArrayList;

import enemies.*;
import floor_traps.Spike;
import mainFiles.Enemy;

public class RoomEighteen {
    static final int numTraps = 0;
    static final int xPosOfPoint = 650;
    static final int yPosOfPoint = 35;
    public static int numEnemies = 22;
    static ArrayList<Spike> spikes = new ArrayList<Spike>();
    public static void createRoomOne(){
        for(int i = 0; i<(numEnemies-2)/2;i++){
            Enemy tempGhoul = new FastGhoul();
            tempGhoul.create(xPosOfPoint,yPosOfPoint+(700/((numEnemies-2)/2))*i);
        }
        for(int i = 0; i<(numEnemies-2)/2;i++){
            Enemy tempGhoul = new FastGhoul();
            tempGhoul.create(xPosOfPoint-(350/((numEnemies-2)/2))*i,yPosOfPoint);
        }
            Enemy tempShooter1 = new Shooter();
            tempShooter1.create(35,600);
            Enemy tempShooter2 = new Shooter();
            tempShooter2.create(600,600);
    }
    public static void replaceSpikes(){}
}
