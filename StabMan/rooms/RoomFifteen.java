package rooms;

import enemies.*;
import floor_traps.*;
import mainFiles.Enemy;
import java.util.ArrayList;
import java.util.Random;
public class RoomFifteen {
    static final int numTraps = 0;
    static final int xPosOfPoint = 250;
    static final int yPosOfPoint = 358;
    public static int numEnemies = 21;
    static ArrayList<Spike> spikes = new ArrayList<Spike>();
    public static void createRoomOne(){
        for(int i = 0; i<numEnemies/2;i++){
            Enemy tempGhoul = new FastGhoul();
            tempGhoul.create(xPosOfPoint+35+35*i,yPosOfPoint+30+30*i);
        }
        for(int i = 0; i<numEnemies/2;i++){
            Enemy tempGhoul = new FastGhoul();
            tempGhoul.create(xPosOfPoint+35+35*i,yPosOfPoint-30-30*i);
        }
            Enemy tempGhoul = new FastGhoul();
            tempGhoul.create(xPosOfPoint,yPosOfPoint);
    }
    public static void replaceSpikes(){}
}
