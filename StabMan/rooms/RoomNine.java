package rooms;

import java.util.ArrayList;
import java.util.Random;

import enemies.*;
import mainFiles.*;
import floor_traps.*;

public class RoomNine{
    public boolean roomCleared =false;
    public static int numEnemies = 4;
    public static void createRoomOne(){
        Spike spike1 = new Spike();
        spike1.create(95, 55, 100,770);
        Spike spike2 = new Spike();
        spike2.create(290, 0, 100,500);
        Spike spike3 = new Spike();
        spike3.create(485, 55, 100,770);
        Spike spike4 = new Spike();
        spike4.create(680, 0, 100,322);
        Spike spike5 = new Spike();
        spike5.create(680, 399, 100,770);
       Enemy tempProducer1 = new Shooter();
        tempProducer1.create(15, 15);
        Enemy tempProducer2 = new Shooter();
        tempProducer2.create(630, 15);
        Enemy tempProducer3 = new Shooter();
        tempProducer3.create(15, 620);
        Enemy tempProducer4 = new Shooter();
        tempProducer4.create(630, 620);
    }
    public static void replaceSpikes(){
        Spike spike1 = new Spike();
        spike1.create(95, 55, 100,770);
        Spike spike2 = new Spike();
        spike2.create(290, 0, 100,500);
        Spike spike3 = new Spike();
        spike3.create(485, 55, 100,770);
        Spike spike4 = new Spike();
        spike4.create(680, 0, 100,322);
        Spike spike5 = new Spike();
        spike5.create(680, 399, 100,770);
    }
}