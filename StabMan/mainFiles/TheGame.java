package mainFiles;
import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
public class TheGame{
    static int difficulty =Driver.difficulty;
    ArrayList<Room> rooms = new ArrayList<Room>(); 
    static ArrayList<JPanel> hearts = new ArrayList<>(); 
    static JFrame theFrame = Driver.theFrame;
    public static volatile JLayeredPane layeredPane = new JLayeredPane();
    static JPanel theGamePanel = new JPanel();
    static JPanel firstDoor = new JPanel();
    static JPanel secondDoor = new JPanel();
    static JPanel playerAvatar = new JPanel();
    static Player thePlayer = new Player(60,370,(int)(14*Math.pow(.7,Driver.difficulty)+.5),5,2);
    static Weapon theWeapon = new Weapon();
    static JPanel playerHealthDisplay = new JPanel();
    public static void initializeGame() throws Exception{
        makeTransistionIntoGame();
        for(int i =0;i<15;i++){
            Room.roomsCleared.add(new Boolean(false));
        }
        Room.roomsCleared.set(0,new Boolean(true));
    }
    public static void reinitializeGame(){
        Player.gameOverScreen.removeAll();
        Player.health = (int)(14*Math.pow(.7,Driver.difficulty)+.5);
        Player.maxHealth = (int)(14*Math.pow(.7,Driver.difficulty)+.5);
        try {
            remakeTransistionIntoGame();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Room.roomsCleared.clear();
        for(int i =0;i<15;i++){
            Room.roomsCleared.add(new Boolean(false));
        }
        Room.roomsCleared.set(0,new Boolean(true));
    }
    public static void makePlayerHealthShow(){
        playerHealthDisplay.removeAll();
        hearts.clear();
        playerHealthDisplay.setBounds(15,15,200,15);
        playerHealthDisplay.setBackground(new Color(55,55,55));
        for(int i =0;i<Player.maxHealth;i++){
            JPanel tempPanel = new JPanel();
            tempPanel.setBackground(new Color(50,0,0));
            tempPanel.setLocation(5,5);
            playerHealthDisplay.add(tempPanel);
            hearts.add(tempPanel);
        }
        if(Menu.firstAttempt){
            layeredPane.add(playerHealthDisplay,0);   
        }
    }
    public static void redrawPlayerHealthPanel() throws Exception{
        for(int i =0;i<Player.maxHealth;i++){
            JPanel tempPanel = hearts.get(i);
            tempPanel.setBackground(new Color(50,0,0));
        }
        for(int i =0;i<Player.maxHealth-Player.health;i++){
            JPanel tempPanel = hearts.get(Player.maxHealth-i-1);
            tempPanel.setBackground(new Color(25,0,0));
        }
        layeredPane.repaint();
    }
    public static void makeTransistionIntoGame(){
        layeredPane.setBounds(0,0,825,825);
        theFrame.add(layeredPane);
        transistionIntoGame theTransistion = new transistionIntoGame();
        theTransistion.start();
        firstDoor.setBounds(0,358,35,75);
        secondDoor.setBounds(825-50,358,35,75);
        theGamePanel.setBounds(35,35,740,715);
        layeredPane.add(theGamePanel);
        layeredPane.add(firstDoor);
        layeredPane.add(secondDoor);
    }
    public static void remakeTransistionIntoGame() throws Exception{
        firstDoor.setBackground(Color.white);
        secondDoor.setBackground(Color.white);
        playerHealthDisplay.setVisible(false);
        RoomMap.theMapPanel.setVisible(false);
        Player.canLeave=true;
        playerAvatar.setLocation(9999,9999);
        Weapon.spearLocationX=9999;
        transistionIntoGame theTransistion = new transistionIntoGame();
        RoomMap.roomNumber=0;
        RoomMap.moveMarker();
        makePlayerHealthShow();
        redrawPlayerHealthPanel();
        theTransistion.start();
    }
    static class transistionIntoGame extends Thread{
        @Override
        public void run(){
            for(int i = 255;i>160;i--){
                try{
                    Thread.sleep(16);
                }catch(Exception e){}
                if(i<235){
                    secondDoor.setBackground(new Color(i+20,i+20,i+20));
                }
                theFrame.getContentPane().setBackground(new Color(i,i,i));
            }
             for(int i = 160;i>67;i--){
                try{
                    Thread.sleep(9);
                }catch(Exception e){}
                if(i<235){
                    secondDoor.setBackground(new Color(i+20,i+20,i+20));
                }
                theGamePanel.setBackground(new Color(i+40,i+40,i+40));
                theFrame.getContentPane().setBackground(new Color(i,i,i));
            }
            for(int i = 67;i>55;i--){
                try{
                    Thread.sleep(22);
                }catch(Exception e){}
                if(i<235){
                    secondDoor.setBackground(new Color(i+20,i+20,i+20));
                }
                theGamePanel.setBackground(new Color(i+40,i+40,i+40));
                theFrame.getContentPane().setBackground(new Color(i,i,i));
            }
            playerAvatar.setBounds(-50,35,50,50);
            playerAvatar.setBackground(new Color(50,2,50));
            playerAvatar.repaint();
            if(Menu.firstAttempt){
                layeredPane.add(playerAvatar,0);
            }
            for(int i = 0;i<110;i++){
                try{
                    Thread.sleep(16);
                }catch(Exception e){}
                playerAvatar.setLocation(-50+i,370);
            }
            for(int i=235;i>55;i--){
                try {
                    Thread.sleep(14);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                firstDoor.setBackground(new Color(i,i,i));
            }
            Player.y=370;
            Player.x=60;
            thePlayer.makePlayerMove();
            if(Menu.firstAttempt){
                RoomMap.makeMap();
            }else{
                RoomMap.remakeMap();
            }
            makePlayerHealthShow();   
            Weapon.makeSpear();
            theWeapon.addMyKeyListener();
            RoomMap.theMapPanel.setVisible(true);
            playerHealthDisplay.setVisible(true);
        }
    }
}