package rooms;

import java.util.ArrayList;
import java.util.Random;

import enemies.*;
import mainFiles.*;
import floor_traps.*;

public class RoomSix{
    public boolean roomCleared =false;
    public static int numEnemies = 4;
    final static int radius =250;
    static int xInc = radius/(numEnemies/2);
    public static void createRoomOne(){
        Spike temSpike = new Spike();
        temSpike.create(350, 300, 50,50);
        Enemy tempProducer1 = new Producer();
        tempProducer1.create(15, 15);
        Enemy tempProducer2 = new Producer();
        tempProducer2.create(630, 15);
        Enemy tempProducer3 = new Producer();
        tempProducer3.create(15, 620);
        Enemy tempProducer4 = new Producer();
        tempProducer4.create(630, 620);
    }
    public static void replaceSpikes(){
        Spike temSpike = new Spike();
        temSpike.create(350, 300, 50,50);
    }
}