package rooms;

import java.util.ArrayList;
import java.util.Random;

import enemies.*;
import mainFiles.*;
import floor_traps.*;

public class RoomFive{
    public boolean roomCleared =false;
    public static int numEnemies = 8;
    final static int radius =250;
    static int xInc = radius/(numEnemies/2);
    public static void createRoomOne(){
        Spike topLeft = new Spike();
        topLeft.create(75, 55, 300,270);
        Spike topRight = new Spike();
        topRight.create(430, 55, 265,265);
        Spike bottomLeft = new Spike();
        bottomLeft.create(75,390, 300,270);
        Spike bottomRight = new Spike();
        bottomRight.create(430, 405, 265,255);
        Ghoul tempGhoul1 = new Ghoul();
        tempGhoul1.create(15, 15);
        Ghoul tempGhoul2 = new Ghoul();
        tempGhoul2.create(370, 15);
        Ghoul tempGhoul3 = new Ghoul();
        tempGhoul3.create(630, 15);
        Ghoul tempGhoul4 = new Ghoul();
        tempGhoul4.create(370, 350);
        Ghoul tempGhoul5 = new Ghoul();
        tempGhoul5.create(630, 350);
        Ghoul tempGhoul6 = new Ghoul();
        tempGhoul6.create(15, 670);
        Ghoul tempGhoul7 = new Ghoul();
        tempGhoul7.create(370, 670);
        Ghoul tempGhoul8 = new Ghoul();
        tempGhoul8.create(630, 670);
    }
    public static void replaceSpikes(){
        Spike topLeft = new Spike();
        topLeft.create(75, 55, 300,270);
        Spike topRight = new Spike();
        topRight.create(430, 55, 265,265);
        Spike bottomLeft = new Spike();
        bottomLeft.create(75,390, 300,270);
        Spike bottomRight = new Spike();
        bottomRight.create(430, 405, 265,255);
    }
}