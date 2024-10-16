package rooms;

import java.util.ArrayList;
import java.util.Random;

import enemies.*;
import mainFiles.*;
import floor_traps.*;

public class RoomOne{
    public boolean roomCleared =false;
    public static int numEnemies = 15;
    public static void createRoomOne(){
        Random rand = new Random();
        for(int i =0;i<15;i++){
            Fly theFly = new Fly();
            theFly.create(rand.nextInt(50,650),rand.nextInt(50,650));
        }
    }
    public static void replaceSpikes(){}
}