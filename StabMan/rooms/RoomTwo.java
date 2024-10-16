package rooms;

import java.util.ArrayList;
import java.util.Random;

import enemies.*;
import mainFiles.*;
import floor_traps.*;

public class RoomTwo{
    public boolean roomCleared =false;
    public static int numEnemies = 15;
    public static void createRoomOne(){
        Random rand = new Random();
        for(int i =0;i<10;i++){
            Ghoul theGhoul = new Ghoul();
            theGhoul.create(rand.nextInt(150,650),rand.nextInt(50,650));
        }
        for(int i =0;i<5;i++){
            AggressiveFly theFly = new AggressiveFly();
            theFly.create(rand.nextInt(150,650),rand.nextInt(50,650));
        }
    }
    public static void replaceSpikes(){}
}