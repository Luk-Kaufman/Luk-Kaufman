package rooms;

import enemies.*;
import mainFiles.Enemy;

public class RoomTwentytwo{
        public boolean roomCleared =false;
    public static int numEnemies = 40;
    public static void createRoomOne(){
        for(int i = 0;i<10;i++){
            Enemy tempSpeedGhoul1 = new Ghoul();
            tempSpeedGhoul1.create(200+i*(575/10),200);
        }
        for(int i = 0;i<10;i++){
            Enemy tempSpeedGhoul1 = new FastGhoul();
            tempSpeedGhoul1.create(200+i*(575/10),100);
        }
        for(int i = 0;i<10;i++){
            Enemy tempSpeedGhoul1 = new AggressiveFly();
            tempSpeedGhoul1.create(200+i*(575/10),600);
        }
        for(int i = 0;i<10;i++){
            Enemy tempSpeedGhoul1 = new Exploader();
            tempSpeedGhoul1.create(200+i*(575/10),650);
        }
    }
    public static void replaceSpikes(){}
}
