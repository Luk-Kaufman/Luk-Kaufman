package rooms;

import java.util.ArrayList;

import enemies.*;
import floor_traps.Spike;
import mainFiles.Enemy;
import mainFiles.Room;

public class RoomNineteen {
     static final int numTraps = 0;
    static final int xOfset = 75;
    public static int numEnemies = 36;
    static int realNumEnemies= 0;
    static ArrayList<Spike> spikes = new ArrayList<Spike>();
    public static void createRoomOne(){
        makeSquareOfFlys(5,145);
        makeSquareOfFastGhouls(3,300);
        makeSquareOfGhouls(1,370);
    }
    public static void replaceSpikes(){}
    public static void makeSquareOfFlys(int numFlysPerRow,int startingPos){
        for(int i = 0;i<numFlysPerRow+1;i++){
            Enemy tempFly = new AggressiveFly();
            tempFly.create(xOfset+startingPos+((775-startingPos*2)/numFlysPerRow)*i, startingPos);
        }
        for(int i = 1;i<numFlysPerRow;i++){
            Enemy tempFly = new AggressiveFly();
           tempFly.create(xOfset+startingPos, startingPos+((775-startingPos*2)/numFlysPerRow)*i);
        }
        for(int i = 1;i<numFlysPerRow+1;i++){
            Enemy tempFly = new AggressiveFly();
            tempFly.create(xOfset+775-startingPos, startingPos+((775-startingPos*2)/numFlysPerRow)*i);
        }
        for(int i = 0;i<numFlysPerRow;i++){
            Enemy tempFly = new AggressiveFly();
            tempFly.create(xOfset+startingPos+((775-startingPos*2)/numFlysPerRow)*i,775-startingPos);
        }
    }
    public static void makeSquareOfGhouls(int numFlysPerRow,int startingPos){
        for(int i = 0;i<numFlysPerRow;i++){
            Enemy tempFly = new Ghoul();
            tempFly.create(xOfset+startingPos+((775-startingPos*2)/numFlysPerRow)*i, startingPos);
        }
        for(int i = 0;i<numFlysPerRow;i++){
            Enemy tempFly = new Ghoul();
            tempFly.create(xOfset+startingPos+((775-startingPos*2)/numFlysPerRow)*numFlysPerRow, startingPos+((775-startingPos*2)/numFlysPerRow)*i);
        }
        for(int i = 1;i<numFlysPerRow+1;i++){
            Enemy tempFly = new Ghoul();
            tempFly.create(xOfset+775-startingPos, startingPos+((775-startingPos*2)/numFlysPerRow)*i);
        }
        for(int i = 0;i<numFlysPerRow;i++){
            Enemy tempFly = new Ghoul();
            tempFly.create(xOfset+startingPos+((775-startingPos*2)/numFlysPerRow)*i,775-startingPos);
        }
    }
    public static void makeSquareOfFastGhouls(int numFlysPerRow,int startingPos){
        for(int i = 0;i<numFlysPerRow+1;i++){
            Enemy tempFly = new FastGhoul();
            tempFly.create(xOfset+startingPos+((775-startingPos*2)/numFlysPerRow)*i, startingPos);
        }
        for(int i = 1;i<numFlysPerRow;i++){
            Enemy tempFly = new FastGhoul();
           tempFly.create(xOfset+startingPos, startingPos+((775-startingPos*2)/numFlysPerRow)*i);
        }
        for(int i = 1;i<numFlysPerRow+1;i++){
            Enemy tempFly = new FastGhoul();
            tempFly.create(xOfset+775-startingPos, startingPos+((775-startingPos*2)/numFlysPerRow)*i);
        }
        for(int i = 0;i<numFlysPerRow;i++){
            Enemy tempFly = new FastGhoul();
            tempFly.create(xOfset+startingPos+((775-startingPos*2)/numFlysPerRow)*i,775-startingPos);
        }
    }
}
