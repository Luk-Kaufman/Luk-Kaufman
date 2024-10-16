package rooms;

import enemies.*;
import floor_traps.*;
import mainFiles.Enemy;
import java.util.ArrayList;
import java.util.Random;
public class RoomSixteen {
    static final int numTraps = 6;
    static final int xPosOfPoint = 250;
    static final int yPosOfPoint = 358;
    public static int numEnemies = 3;
    static ArrayList<Spike> spikes = new ArrayList<Spike>();
    public static void createRoomOne(){
        Spike spike1 = new Spike();
        Spike spike2 = new Spike();
        Spike spike3 = new Spike();
        Spike spike4 = new Spike();
        Spike spike5 = new Spike();
        Spike spike6 = new Spike();
        spike1.create(50,50,600,50);
        spike2.create(50,600,600,50);
        spike3.create(50,50,50,200);
        spike4.create(50,400,50,250);
        spike5.create(600,50,50,200);
        spike6.create(600,450,50,200);
        spikes.add(spike1);
        spikes.add(spike2);
        spikes.add(spike3);
        spikes.add(spike4);
        spikes.add(spike5);
        spikes.add(spike6);
        Producer prod = new Producer();
        prod.create(650, 375);
        Shooter shooter1= new Shooter();
        shooter1.create(35, 35);
        Shooter shooter2= new Shooter();
        shooter2.create(35,635);
    }
    public static void replaceSpikes(){
        for(int i=0;i <numTraps;i++){
            spikes.get(i).create(spikes.get(i).x,spikes.get(i).y,spikes.get(i).xSize,spikes.get(i).ySize);
        }
    }
}
