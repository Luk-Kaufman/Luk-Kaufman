package rooms;

import java.util.ArrayList;
import java.util.Random;

import enemies.*;
import mainFiles.*;
import floor_traps.*;

public class RoomFour{
    public boolean roomCleared =false;
    public static int numEnemies = 24;
    final static int radius =250;
    static int xInc = radius/(numEnemies/2);
    public static void createRoomOne(){
        int count = 0;
        int x =0;
        int y = 0;
        int startingX=170;
        int startingY=350;
        for(int i =0;i<numEnemies/2;i++){
            x+=xInc;
            y= (int)(Math.sqrt(radius*radius-x*x));
            Exploader theExploader = new Exploader();
            theExploader.create(x+startingX,y+startingY);
            count++;
        }
        startingY+=110;
        startingX+=25;
        for(int i =numEnemies/2;i<numEnemies;i++){
            x-=xInc;
            y= -(int)(Math.sqrt(radius*radius-x*x));
            Exploader theExploader = new Exploader();
            theExploader.create(x+startingX,y+startingY);
            count++;
        }
        System.out.println(count);
    }
    public static void replaceSpikes(){}
}