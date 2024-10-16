package rooms;

import java.util.ArrayList;
import java.util.Random;

import enemies.*;
import mainFiles.*;
import floor_traps.*;

public class RoomEleven{
    public boolean roomCleared =false;
    public static int numEnemies = 30;
    public static void createRoomOne(){
        int numenemiesperrow = numEnemies/3;
        for(int i = 0;i<10;i++){
            Enemy tempFly = new AggressiveFly();
            tempFly.create(700/numenemiesperrow*i,35);
        }
        for(int i = 0;i<10;i++){
            Enemy tempFly = new AggressiveFly();
            tempFly.create(700,700/numenemiesperrow*i);
        }
        for(int i = 0;i<10;i++){
            Enemy tempFly = new AggressiveFly();
            tempFly.create(700/numenemiesperrow*i,700);
        }

    }
    public static void replaceSpikes(){}
}