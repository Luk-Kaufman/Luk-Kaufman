package rooms;

import enemies.Boss;

public class BossRoom {
    public boolean roomCleared =false;
    public static int numEnemies = 1;
    public static void createFinalRoom(){
        Boss finalBoss = new Boss();
        finalBoss.create(400, 400);   
    }
}