package rooms;

import enemies.*;
import mainFiles.Enemy;

public class RoomTwentyone {
        public boolean roomCleared =false;
    public static int numEnemies = 45;
    public static void createRoomOne(){
        for(int i = 0;i<15;i++){
            Enemy tempSpeedGhoul1 = new Ghoul();
            tempSpeedGhoul1.create(400, 35+i*(705/15));
        }
        for(int i = 0;i<15;i++){
            Enemy tempSpeedGhoul1 = new FastGhoul();
            tempSpeedGhoul1.create(500, 35+i*(705/15));
        }
        for(int i = 0;i<15;i++){
            Enemy tempSpeedGhoul1 = new AggressiveFly();
            tempSpeedGhoul1.create(600, 35+i*(705/15));
        }
    }
    public static void replaceSpikes(){}
}
