package rooms;

import java.util.ArrayList;
import java.util.Random;

import enemies.*;
import mainFiles.*;
import floor_traps.*;

public class RoomEight{
    public boolean roomCleared =false;
    public static int numEnemies = 27;
    public static void createRoomOne(){
       Random rand = new Random(); 
        for(int i = 0;i<12;i++){
            int randX1 = rand.nextInt(50,700);
            int randX2 = rand.nextInt(50,700);
            int randX3 = rand.nextInt(50,700);
            int randX4 = rand.nextInt(50,700);
            int randX5 = rand.nextInt(50,700);
            int randX6 = rand.nextInt(50,700);
            if(i<10){
                Enemy tempExploader = new Exploader();
                tempExploader.create(randX1, randX2);
            }
            Enemy tempFly = new Fly();
            tempFly.create(randX5, randX4);
            if(i<5){
                Enemy tempGhoul = new Ghoul();
                tempGhoul.create(randX3, randX6);
            }
        }
    }
    public static void replaceSpikes(){}
}