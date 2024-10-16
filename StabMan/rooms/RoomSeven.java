package rooms;

import java.util.ArrayList;
import java.util.Random;

import enemies.*;
import mainFiles.*;
import floor_traps.*;

public class RoomSeven{
    public boolean roomCleared =false;
    public static int numEnemies = 5;
    public static void createRoomOne(){
        Enemy tempSpeedGhoul1 = new Ghoul();
        tempSpeedGhoul1.create(15, 15);
        Enemy tempSpeedGhoul2 = new Ghoul();
        tempSpeedGhoul2.create(630, 15);
        Enemy tempSpeedGhoul3 = new Ghoul();
        tempSpeedGhoul3.create(15, 620);
        Enemy tempSpeedGhoul4 = new Ghoul();
        tempSpeedGhoul4.create(630, 620);
        Enemy tempShooter = new Shooter();
        tempShooter.create(380, 450);
    }
    public static void replaceSpikes(){}
}