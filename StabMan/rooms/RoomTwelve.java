package rooms;

import java.util.ArrayList;
import java.util.Random;

import enemies.*;
import mainFiles.*;
import floor_traps.*;

public class RoomTwelve{
    public boolean roomCleared =false;
    public static int numEnemies = 6;
    public static void createRoomOne(){
        Spike spike = new Spike();
        spike.create(100, 50, 500, 550);
        Spike spike2 = new Spike();
        spike2.create(600, 550, 50, 900);
        for(int i = 0;i<numEnemies;i++){
            Enemy tempGhoul = new FastGhoul();
            tempGhoul.create(700/numEnemies*i+75,35);
        }

    }
    public static void replaceSpikes(){
        Spike spike = new Spike();
        spike.create(100, 50, 500, 550);
        Spike spike2 = new Spike();
        spike2.create(600, 600, 50, 900);
    }
}