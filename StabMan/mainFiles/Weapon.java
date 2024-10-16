package mainFiles;
import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Weapon implements KeyListener{
    static JPanel playerAvatar = Player.playerAvatar;
    volatile static boolean buttonPressed = false;
    public static int spearSpeed =10;
    public static int spearLocationX,spearLocationY=9999;
    public static JPanel theSpear = new JPanel();
    static boolean buttonPressedLeft = false ;
    static boolean buttonPressedDown = false;
    static boolean buttonPressedRight = false;
    static boolean buttonPressedUp = false;
    static boolean spearAttacking = false;
    static int spearDirection =-1;
    static int spearDistnce = 25;
    public static int weaponSize = 12;
    public static boolean canHitSomething = false;

    public void addMyKeyListener(){
        Driver.theFrame.addKeyListener(this);
    }

    public static void makeSpear(){
        SpearEventThread spearThread = new SpearEventThread();
        theSpear.setBounds(9999,9999,weaponSize,weaponSize);
        theSpear.setBackground(new Color(72,23,15));
        if(Menu.firstAttempt){
            TheGame.layeredPane.add(theSpear,0);
        }
        spearThread.start();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int theKey =e.getKeyCode();
            if(theKey==38&&!buttonPressedDown){
                buttonPressed=true;
                buttonPressedUp= true;
            }
            if(theKey==40&&!buttonPressedUp){
                buttonPressed=true;
                buttonPressedDown = true;
            }
            if(theKey==37&&!buttonPressedRight){
                buttonPressed=true;
                buttonPressedLeft = true;
            }
            if(theKey==39&&!buttonPressedLeft){
                buttonPressed=true;
                buttonPressedRight = true;
            }
            if(theKey==32){
                spearAttacking = true;
            }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int theKey =e.getKeyCode();
            try {
                Thread.sleep(15);
            }catch(Exception er){}
            if(theKey==38){
                buttonPressedUp= false;
            }
            if(theKey==40){
                buttonPressedDown = false;
            }
            if(theKey==37){
                buttonPressedLeft = false;
            }
            if(theKey==39){
                buttonPressedRight = false;
            }
    }
    static class SpearEventThread extends Thread{
        
        @Override
        public void run(){
            System.out.println("Spear Running");
            int rightSpeed=0;
            int downSpeed=0;
             try {
                Thread.sleep(15);
            } catch (InterruptedException e) {}
        while(!Player.dead&&!Player.gameOver){
            if(!spearAttacking){
                maneuverSpear(rightSpeed,downSpeed);
            }else{
                moveSpear();
            }
        }
        }
        
        private static void moveSpear(){
            int rightSpeed=0;
            int downSpeed=0;
            canHitSomething = true;
            for(int i = 0; i <spearDistnce;i++){
                try {
                    Thread.sleep(spearSpeed);
                }catch (InterruptedException e) {}
                if(spearDirection == 0){
                    rightSpeed = -1;
                    downSpeed = -1;
                }
                if(spearDirection == 1){
                    rightSpeed = 0;
                    downSpeed = -1;
                }
                if(spearDirection == 2){
                    rightSpeed = 1;
                    downSpeed = -1;
                }
                if(spearDirection == 3){
                    rightSpeed = 1;
                    downSpeed = 0;
                }
                if(spearDirection == 4){
                    rightSpeed = 1;
                    downSpeed = 1;
                }
                if(spearDirection == 5){
                    rightSpeed = 0;
                    downSpeed = 1;
                }
                if(spearDirection == 6){
                    rightSpeed = -1;
                    downSpeed = 1;
                }
                if(spearDirection == 7){
                    rightSpeed = -1;
                    downSpeed = 0;
                }
                spearMoveOutHelper(rightSpeed,downSpeed);
            }
            for(int i = 0; i <spearDistnce;i++){
                try {
                    Thread.sleep(spearSpeed);
                }catch (InterruptedException e) {}
                    spearMoveInHelper(rightSpeed,downSpeed);
            } 
            canHitSomething =false;
            spearAttacking =false;
        }
    }
        private static void spearMoveOutHelper(int rightSpeed,int downSpeed){
            theSpear.setLocation(spearLocationX+rightSpeed,spearLocationY+downSpeed);
            spearLocationX+=rightSpeed;
            spearLocationY+=downSpeed;
        }
        private static void spearMoveInHelper(int rightSpeed,int downSpeed){
            theSpear.setLocation(spearLocationX-rightSpeed,spearLocationY-downSpeed);
            spearLocationX-=rightSpeed;
            spearLocationY-=downSpeed;
        }
        private static void maneuverSpear(int rightSpeed, int downSpeed){
            if(buttonPressed){
                buttonPressed= false;
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {}
            rightSpeed=0;
            downSpeed=0;
            if(buttonPressedLeft&&!(buttonPressedDown||buttonPressedUp)){
                theSpear.setLocation(Player.x-31,Player.y+19);
                spearLocationX=Player.x-31;
                spearLocationY=Player.y+19;
                spearDirection = 7;
            }
            if(buttonPressedLeft&&(buttonPressedDown||buttonPressedUp)){
                if(buttonPressedDown){
                    theSpear.setLocation(Player.x-31,Player.y-69);
                    spearLocationX=Player.x-31;
                    spearLocationY=Player.y-69;
                    spearDirection = 6;
                }else{
                    theSpear.setLocation(Player.x-31,Player.y+19);
                    spearLocationX=Player.x-31;
                    spearLocationY=Player.y+19;
                    spearDirection = 0;
                }
            }
            if(buttonPressedRight&&!(buttonPressedDown||buttonPressedUp)){
                theSpear.setLocation(Player.x+69,Player.y+19);
                spearLocationX=Player.x+69;
                spearLocationY=Player.y+19;
                spearDirection = 3;
            }
            if(buttonPressedRight&&(buttonPressedDown||buttonPressedUp)){
                if(buttonPressedDown){
                    theSpear.setLocation(Player.x+40,Player.y+69);
                    spearLocationX=Player.x+40;
                    spearLocationY=Player.y+69;
                    spearDirection = 4;
                }else{
                    theSpear.setLocation(Player.x+40,Player.y+19);
                    spearLocationX=Player.x+40;
                    spearLocationY=Player.y+19;
                    spearDirection = 2;
                }
            }
            if(buttonPressedDown&&!(buttonPressedLeft||buttonPressedRight)){
                theSpear.setLocation(Player.x+19,Player.y+69);
                spearLocationX=Player.x+19;
                spearLocationY=Player.y+69;
                spearDirection = 5;
            }
            if(buttonPressedDown&&(buttonPressedLeft||buttonPressedRight)){
                if(buttonPressedLeft){
                    theSpear.setLocation(Player.x-31,Player.y+69);
                    spearLocationX=Player.x-31;
                    spearLocationY=Player.y+69;
                    spearDirection = 6;
                }else{
                    theSpear.setLocation(Player.x+69,Player.y+69);
                    spearLocationX=Player.x+69;
                    spearLocationY=Player.y+69;
                    spearDirection = 4;
                }
            }
            if(buttonPressedUp&&!(buttonPressedLeft||buttonPressedRight)){
                theSpear.setLocation(Player.x+19,Player.y-31);
                spearLocationX=Player.x+19;
                spearLocationY=Player.y-31;
                spearDirection = 1;
            }
            if(buttonPressedUp&&(buttonPressedLeft||buttonPressedRight)){
                if(buttonPressedLeft){
                    theSpear.setLocation(Player.x-31,Player.y-31);
                    spearLocationX=Player.x-31;
                    spearLocationY=Player.y-31;
                    spearDirection = 0;
                }else{
                    theSpear.setLocation(Player.x+69,Player.y-31);
                    spearLocationX=Player.x+69;
                    spearLocationY=Player.y-31;
                    spearDirection = 2;
                }
            }
            }
            
        }
    }