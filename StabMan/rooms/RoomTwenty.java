package rooms;

import enemies.AggressiveFly;
import enemies.Shooter;
import mainFiles.Enemy;

public class RoomTwenty {
        public boolean roomCleared =false;
    public static int numEnemies = 23;
    public static void createRoomOne(){
        int numenemiesperrow = numEnemies/3;
        for(int i = 0;i<7;i++){
            Enemy tempFly = new AggressiveFly();
            tempFly.create(700/numenemiesperrow*i,35);
        }
        for(int i = 0;i<7;i++){
            Enemy tempFly = new AggressiveFly();
            tempFly.create(700,700/numenemiesperrow*i);
        }
        for(int i = 0;i<7;i++){
            Enemy tempFly = new AggressiveFly();
            tempFly.create(700/numenemiesperrow*i,700);
        }
        Enemy Shooter1 = new Shooter();
        Shooter1.create(700,700);
        Enemy Shooter2 = new Shooter();
        Shooter2.create(35,700);
    }
    public static void replaceSpikes(){}
}
