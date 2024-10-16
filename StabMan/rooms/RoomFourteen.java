package rooms;

import enemies.*;
import floor_traps.*;
import mainFiles.Enemy;
import java.util.ArrayList;
import java.util.Random;
public class RoomFourteen {
    static final int numTraps = 12;
    public static int numEnemies = 15;
    static ArrayList<Spike> spikes = new ArrayList<Spike>();
    public static void createRoomOne(){
        Random rand = new Random();
        for(int i = 0; i<numTraps;i++){
            int rand1 = rand.nextInt(150,500);
            int rand2 = rand.nextInt(150,600);
            int rand3 = rand.nextInt(0,75);
            int rand4 = rand.nextInt(0,75);
            Spike tempSpike = new Spike();
            tempSpike.create(rand1,rand2,rand3,rand4);
            spikes.add(tempSpike);
        }
        for(int i = 0; i<numEnemies;i++){
            int rand1 = rand.nextInt(150,500);
            int rand2 = rand.nextInt(150,600);
            Enemy tempGhoul = new FastGhoul();
            tempGhoul.create(rand1,rand2);
        }
    }
    public static void replaceSpikes(){
        for(int i=0;i <numTraps;i++){
            spikes.get(i).create(spikes.get(i).x,spikes.get(i).y,spikes.get(i).xSize,spikes.get(i).ySize);
        }
    }
}
