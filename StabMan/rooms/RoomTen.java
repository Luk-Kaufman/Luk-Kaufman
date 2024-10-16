package rooms;

import java.util.ArrayList;
import java.util.Random;

import enemies.*;
import mainFiles.*;
import floor_traps.*;

public class RoomTen{
    public boolean roomCleared =false;
    public static int numEnemies = 1;
    public static void createRoomOne(){
        Enemy tempFly = new Fly();
        tempFly.create(50, 280);
    }
    public static void replaceSpikes(){}
}