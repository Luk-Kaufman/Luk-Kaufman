package rooms;

import enemies.*;
import mainFiles.Enemy;

public class RoomSeventeen {
    public boolean roomCleared =false;
    public static int numEnemies = 25;
    public static final int numEnemiesInBox = 15;
    public static void createRoomOne(){
        int numenemiesperrow = numEnemiesInBox/3;
        for(int i = 0;i<numEnemiesInBox/3;i++){
            Enemy tempExploader = new Exploader();
            tempExploader.create(700/numenemiesperrow*i,35);
        }
        for(int i = 0;i<numEnemiesInBox/3;i++){
            Enemy tempGhoul = new FastGhoul();
            tempGhoul.create(700,700/numenemiesperrow*i+35);
        }
        for(int i = 0;i<numEnemiesInBox/3;i++){
            Enemy tempExploader = new Exploader();
            tempExploader.create(700/numenemiesperrow*i,665);
        }
        for(int i = 0;i<10;i++){
            Enemy tempFly = new AggressiveFly();
            tempFly.create(350,350);
        }

    }
    public static void replaceSpikes(){}
}
