package rooms;

import enemies.AggressiveFly;
import mainFiles.Enemy;

public class RoomTwentythree {
    public boolean roomCleared =false;
    public static int numEnemies = 1;
    public static void createRoomOne(){
        Enemy tempSpeedGhoul1 = new AggressiveFly();
        tempSpeedGhoul1.create(370,370);
    }
    public static void replaceSpikes(){}
}
