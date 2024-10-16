package mainFiles;
import javax.swing.*;

import rooms.RoomOne;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Player implements KeyListener{
    static JFrame theFrame = Driver.theFrame;
    public static int x;
    public static int maxHealth;
    public static boolean dead = false;
    public static boolean gameOver = false;
    boolean buttonPressedA = false;
    boolean buttonPressedS = false;
    boolean buttonPressedD = false;
    boolean buttonPressedW = false;
    public static boolean canLeave = true;
    public static boolean invincible = false;
    public static int y;
    public static int health;
    public static int damage;
    //lower is faster
    int realSpeed=10;
    int speed;
    public static int size = 50;
    public static JPanel playerAvatar=TheGame.playerAvatar;
    public static JPanel gameOverScreen = new JPanel();
    Player(int x,int y,int health,int damage,int speed){
        this.x =x;
        this.maxHealth = health;
        this.y=y;
        this.health=health;
        this.damage=damage;
        this.speed =speed;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public static void lowerHealth(int damage) {
        if(!invincible&&!dead){
            if(RoomMap.rooms.get(RoomMap.roomNumber).numEnemies<1){
                Player.canLeave = true;
                Room.roomsCleared.set(RoomMap.roomNumber,true);
            }
            health -= damage;
            invincible = true;
            InvincibleThread tempThread = new InvincibleThread();
            tempThread.start();
            try {
                TheGame.redrawPlayerHealthPanel();
            } catch (Exception e) {}
            if(health <1){
                dead = true;
            }
        }
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public void setRealSpeed(int realSpeed){
        this.realSpeed = realSpeed;
    }
    public synchronized boolean isButtonPressedA() {
        return buttonPressedA;
    }
    public synchronized boolean isButtonPressedS() {
        return buttonPressedS;
    }
    public synchronized boolean isButtonPressedW() {
        return buttonPressedW;
    }
    public boolean isButtonPressedD() {
        return buttonPressedD;
    }
    public void makePlayerMove(){
        theFrame.addKeyListener(this);
        MovementThread theMovment = new MovementThread();
        theMovment.start();
    }
static class InvincibleThread extends Thread{
    public void run(){
        playerAvatar.setBackground(new Color(25,0,0));
        TheGame.layeredPane.repaint();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {}
        invincible=false;
        playerAvatar.setBackground(new Color(50,2,50));
        TheGame.layeredPane.repaint();
    }
}
class MovementThread extends Thread{
    public void run(){
        boolean gameWon =false;
        System.out.println("Movement Running");
            int rightSpeed=0;
            int downSpeed=0;
            theFrame.requestFocus();
        while(!dead){
            rightSpeed=0;
            downSpeed=0;
            if(isButtonPressedA()){
                rightSpeed-=speed;
            }
            if(isButtonPressedD()){
                rightSpeed+=speed;
            }
            if(isButtonPressedW()){
                downSpeed-=speed;
            }
            if(isButtonPressedS()){
                downSpeed+=speed;
            }
            if((isButtonPressedW()||isButtonPressedA()||isButtonPressedS()||isButtonPressedD())){
                try {
                    Thread.sleep(realSpeed);
                } catch (InterruptedException e) {}
                playerAvatar.setLocation(x+rightSpeed,y);
                Weapon.theSpear.setLocation(Weapon.spearLocationX+rightSpeed,Weapon.spearLocationY);
                x+=rightSpeed;
                Weapon.spearLocationX+=rightSpeed;
                if(checkForImpassableTerrain()){
                    playerAvatar.setLocation(x-rightSpeed,y);
                    Weapon.theSpear.setLocation(Weapon.spearLocationX-rightSpeed,Weapon.spearLocationY);
                    Weapon.spearLocationX-=rightSpeed;
                    x-=rightSpeed;
                } 
                playerAvatar.setLocation(x,y+downSpeed);
                Weapon.theSpear.setLocation(Weapon.spearLocationX,Weapon.spearLocationY+downSpeed);
                y+=downSpeed;
                Weapon.spearLocationY+=downSpeed;
                if(checkForImpassableTerrain()){
                    playerAvatar.setLocation(x,y-downSpeed);
                    Weapon.theSpear.setLocation(Weapon.spearLocationX,Weapon.spearLocationY-downSpeed);
                    Weapon.spearLocationY-=downSpeed;
                    y-=downSpeed;
                }
                if(checkForRightDoor()){
                    RoomMap.roomNumber++;
                    playerAvatar.setLocation(-60,y);
                    Weapon.theSpear.setLocation(9999,9999);
                    Weapon.spearLocationY = 9999;
                    Weapon.spearLocationX = 9999;
                    RoomMap.moveMarker();
                    Room.setUpRoom();
                    canLeave = false;
                    if(RoomMap.roomNumber==RoomMap.numRooms-1){
                        Room.secondDoor.setBackground(new Color(55,55,55));
                        TheGame.layeredPane.repaint();
                    }
                    for(int i = 5;i<50;i++){
                        try {
                            Thread.sleep(realSpeed);
                        } catch (InterruptedException e) {}
                        playerAvatar.setLocation(i,y);
                        x = i;
                    }
                    if(!Room.roomsCleared.get(Room.currentRoomNumber)){
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {}
                    }
                    RoomMap.rooms.get(RoomMap.roomNumber).closeDoors();
                }
                if(checkForLeftDoor()){
                    if(RoomMap.roomNumber==0){
                        dead= true;
                        gameWon = true;
                        break;
                    }
                    RoomMap.roomNumber--;
                    playerAvatar.setLocation(750,y);
                    Weapon.theSpear.setLocation(9999,9999);
                    Weapon.spearLocationY = 9999;
                    Weapon.spearLocationX = 9999;
                    RoomMap.moveMarker();
                    Room.setUpRoom();
                    canLeave = false;
                    for(int i = 750;i>700;i--){
                        try {
                            Thread.sleep(realSpeed);
                        } catch (InterruptedException e) {}
                        playerAvatar.setLocation(i,y);
                        x = i;
                    }
                    RoomMap.rooms.get(RoomMap.roomNumber).closeDoors();
                    RoomMap.rooms.get(RoomMap.roomNumber).openFirstDoor();
                }
            }
        }
        gameOver=true;
        Weapon.spearLocationX=9999;
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {}
        gameOverScreen.setBounds(0, 0,875, 875);
        gameOverScreen.setBackground(Color.black);
        gameOverScreen.setLayout(null);
        gameOverScreen.setVisible(true);
        JLabel gameOverText = new JLabel();
        if(gameWon){
            gameOverText.setText("You Win!");
        }else{
            gameOverText = new JLabel("Game Over");
        }
        gameOverText.setBounds(378,300,250,60);
        gameOverText.setForeground(Color.white);
        JButton backToMainMenuButton = new JButton("Back To Main Menu");
        backToMainMenuButton.setBounds(335,350,150,50);
        backToMainMenuButton.addActionListener(e->{
            Menu.firstAttempt=false;
            TheGame.layeredPane.setVisible(false);
            Color color = UIManager.getColor ( "Panel.background" );
            theFrame.getContentPane().setBackground(color);  
            Menu.settings.setVisible(true);
            Menu.instructions.setVisible(true);
            Menu.startGame.setVisible(true);
        });
        Weapon.theSpear.setLocation(9999,9999);
        gameOverScreen.add(gameOverText,BorderLayout.CENTER);
        gameOverScreen.add(backToMainMenuButton,BorderLayout.SOUTH);
        TheGame.layeredPane.add(gameOverScreen,0);
              try {
            Thread.sleep(500);
        } catch (InterruptedException e) {}
        TheGame.layeredPane.repaint();
    }
        public boolean checkForLeftDoor(){
            if(x<1){
                return true;
            }
            return false;
        }
        public boolean checkForRightDoor(){
            if(x>750){
                return true;
            }
            return false;
        }
       public boolean checkForImpassableTerrain(){
        if(x>726&&(y<385&&y>357)&&RoomMap.roomNumber<RoomMap.numRooms-1&&canLeave){
            return false;
        }
        if(x<36&&(y<385&&y>357)&&RoomMap.roomNumber>0&&canLeave){
            return false;
        }
        if(x<36&&(y<385&&y>357)&&RoomMap.roomNumber==0&&Room.checkIfAllRoomsCleared()){
            return false;
        }
        if(x<34||x>726){
            return true;
        }
        if(y<34||y>701){
            return true;
        }
        return false;
    }   
}
        @Override
        public void keyTyped(KeyEvent e) {}
        @Override
        public void keyPressed(KeyEvent e) {
            int theKey =e.getKeyCode();
            if(theKey==87){
                buttonPressedW= true;
            }
            if(theKey==83){
                buttonPressedS = true;
            }
            if(theKey==65){
                buttonPressedA = true;
            }
            if(theKey==68){
                buttonPressedD = true;
            }
        }        
        @Override
        public void keyReleased(KeyEvent e) {
            int theKey =e.getKeyCode();
            if(theKey==87){
                buttonPressedW= false;
            }
            if(theKey==83){
                buttonPressedS = false;
            }
            if(theKey==65){
                buttonPressedA = false;
            }
            if(theKey==68){
                buttonPressedD = false;
            }
        }   
}