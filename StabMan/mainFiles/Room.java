package mainFiles;
import javax.swing.*;
import javax.swing.plaf.basic.BasicSliderUI;

import java.awt.*;
import java.util.ArrayList;

import enemies.*;
import rooms.*;

public class Room{
    public static ArrayList<Boolean> roomsCleared = new ArrayList<>();
    static JPanel firstDoor = TheGame.firstDoor;
    static JPanel secondDoor = TheGame.secondDoor;
    public static int currentRoomNumber = RoomMap.roomNumber;
    int roomNumber;
    JPanel avatar;
    public static int numEnemies;
    Room(int roomNumber,JPanel avatar){
        this.avatar = avatar;
        this.roomNumber =roomNumber;
    }
    public JPanel getAvatar(){
        return avatar;
    }
    public static boolean checkIfAllRoomsCleared(){
        for(int i =0;i<Driver.difficulty*5;i++){
            if(!roomsCleared.get(i)){
                return false;
            }
        }
        return true;
    }
    public void closeDoors(){
        if(roomNumber==0){
            Player.canLeave = true;
        }
        if(roomsCleared.get(currentRoomNumber)){
            Player.canLeave = true;
        }
        if(roomNumber==0&&checkIfAllRoomsCleared()){
            Player.canLeave = false;
            if(secondDoor.getBackground().equals(new Color(75,75,75))){
                for(int i =75; i>55;i--){
                    try {
                        Thread.sleep(15);
                    }catch (InterruptedException e) {}
                    secondDoor.setBackground(new Color(i,i,i));
                } 
            }        
        }
        if(!(numEnemies==0)){
            if(firstDoor.getBackground().equals(new Color(75,75,75))||firstDoor.getBackground().equals(new Color(74,74,74))){
                for(int i =75; i>55;i--){
                    try {
                        Thread.sleep(15);
                    } catch (InterruptedException e) {}
                    firstDoor.setBackground(new Color(i,i,i));
                    } 
                }       
            if(secondDoor.getBackground().equals(new Color(75,75,75))){
                for(int i =75; i>55;i--){
                    try {
                        Thread.sleep(15);
                    }catch (InterruptedException e) {}
                    secondDoor.setBackground(new Color(i,i,i));
                } 
            }     
        }
    }
    public void openFirstDoor(){
        if(roomNumber==0&&checkIfAllRoomsCleared()){
            for(int i =55; i<235;i++){
                try {
                    Thread.sleep(15);
                } catch (InterruptedException e) {}
                firstDoor.setBackground(new Color(i,i,i));
                } 
                System.out.println("huh");
        }
    }
   public void openDoors(){
        if(numEnemies==0&&roomNumber>0&&roomNumber<RoomMap.numRooms-1){
            for(int i =55; i<75;i++){
                try {
                    Thread.sleep(15);
                } catch (InterruptedException e) {}
                firstDoor.setBackground(new Color(i,i,i));
                secondDoor.setBackground(new Color(i,i,i));
                } 
        }
        else if(numEnemies==0&&roomNumber==RoomMap.numRooms-1){
            for(int i =55; i<75;i++){
                try {
                    Thread.sleep(15);
                } catch (InterruptedException e) {}
                firstDoor.setBackground(new Color(i,i,i));
                } 
        }
    }

    public static void setUpRoom(){
        if(Driver.difficulty==1){
            diffOneRoomSetup();
        }
        if(Driver.difficulty==2){
            diffTwoRoomSetup();
        }
        if(Driver.difficulty==3){
            diffThreeRoomSetup();
        }
    }

    public static void diffOneRoomSetup(){
        currentRoomNumber = RoomMap.roomNumber;
        if(currentRoomNumber==0){
            firstDoor.setBackground(new Color(55,55,55));
        }
        else if(currentRoomNumber==1&&!roomsCleared.get(currentRoomNumber)){
            firstDoor.setBackground(new Color(75,75,75));
            secondDoor.setBackground(new Color(75,75,75));
            RoomOne.createRoomOne();
            Room.numEnemies =RoomOne.numEnemies;
        }
        else if(currentRoomNumber==2&&!roomsCleared.get(currentRoomNumber)){
            firstDoor.setBackground(new Color(75,75,75));
            secondDoor.setBackground(new Color(75,75,75));
            RoomTwo.createRoomOne();
            Room.numEnemies =RoomTwo.numEnemies;
        }
        else if(currentRoomNumber==3&&!roomsCleared.get(currentRoomNumber)){
            firstDoor.setBackground(new Color(75,75,75));
            secondDoor.setBackground(new Color(75,75,75));
            RoomThree.createRoomOne();
            Room.numEnemies =RoomThree.numEnemies;
        }
        else if(roomsCleared.get(currentRoomNumber)&&currentRoomNumber>0){
            firstDoor.setBackground(new Color(75,75,75));
            secondDoor.setBackground(new Color(75,75,75));
        }
        else if(currentRoomNumber==RoomMap.numRooms-1&&!roomsCleared.get(currentRoomNumber)){
            Room.numEnemies =BossRoom.numEnemies;
            BossRoom.createFinalRoom();
        }
        else{
            secondDoor.setBackground(new Color(55,55,55));
        }
    }

    public static void diffTwoRoomSetup(){
        currentRoomNumber = RoomMap.roomNumber;
        if(currentRoomNumber==0){
            firstDoor.setBackground(new Color(55,55,55));
        }
        else if(currentRoomNumber==1&&!roomsCleared.get(currentRoomNumber)){
            firstDoor.setBackground(new Color(75,75,75));
            secondDoor.setBackground(new Color(75,75,75));
            RoomThree.createRoomOne();
            Room.numEnemies =RoomThree.numEnemies;
        }
        else if(currentRoomNumber==2&&!roomsCleared.get(currentRoomNumber)){
            firstDoor.setBackground(new Color(75,75,75));
            secondDoor.setBackground(new Color(75,75,75));
            RoomFour.createRoomOne();
            Room.numEnemies =RoomFour.numEnemies;
        }
        else if(currentRoomNumber==3&&!roomsCleared.get(currentRoomNumber)){
            firstDoor.setBackground(new Color(75,75,75));
            secondDoor.setBackground(new Color(75,75,75));
            RoomFive.createRoomOne();
            Room.numEnemies =RoomFive.numEnemies;
        }
        else if(currentRoomNumber==4&&!roomsCleared.get(currentRoomNumber)){
            firstDoor.setBackground(new Color(75,75,75));
            secondDoor.setBackground(new Color(75,75,75));
            RoomSix.createRoomOne();
            Room.numEnemies =RoomSix.numEnemies;
        }
        else if(currentRoomNumber==5&&!roomsCleared.get(currentRoomNumber)){
            firstDoor.setBackground(new Color(75,75,75));
            secondDoor.setBackground(new Color(75,75,75));
            RoomSeven.createRoomOne();
            Room.numEnemies =RoomSeven.numEnemies;
        }
        else if(currentRoomNumber==6&&!roomsCleared.get(currentRoomNumber)){
            firstDoor.setBackground(new Color(75,75,75));
            secondDoor.setBackground(new Color(75,75,75));
            RoomEight.createRoomOne();
            Room.numEnemies =RoomEight.numEnemies;
        }
        else if(currentRoomNumber==7&&!roomsCleared.get(currentRoomNumber)){
            firstDoor.setBackground(new Color(75,75,75));
            secondDoor.setBackground(new Color(75,75,75));
            RoomNine.createRoomOne();
            Room.numEnemies =RoomNine.numEnemies;
        }
        else if(currentRoomNumber==8&&!roomsCleared.get(currentRoomNumber)){
            firstDoor.setBackground(new Color(75,75,75));
            secondDoor.setBackground(new Color(75,75,75));
            RoomTen.createRoomOne();
            Room.numEnemies =RoomTen.numEnemies;
        }
        else if(currentRoomNumber==3&&roomsCleared.get(currentRoomNumber)){
            firstDoor.setBackground(new Color(75,75,75));
            secondDoor.setBackground(new Color(75,75,75));
            RoomFive.replaceSpikes();
        }
        else if(currentRoomNumber==4&&roomsCleared.get(currentRoomNumber)){
            firstDoor.setBackground(new Color(75,75,75));
            secondDoor.setBackground(new Color(75,75,75));
            RoomSix.replaceSpikes();
        }
        else if(currentRoomNumber==7&&roomsCleared.get(currentRoomNumber)){
            firstDoor.setBackground(new Color(75,75,75));
            secondDoor.setBackground(new Color(75,75,75));
            RoomNine.replaceSpikes();
        }
        else if(roomsCleared.get(currentRoomNumber)&&currentRoomNumber>0){
            firstDoor.setBackground(new Color(75,75,75));
            secondDoor.setBackground(new Color(75,75,75));
        }
        else if(currentRoomNumber==RoomMap.numRooms-1&&!roomsCleared.get(currentRoomNumber)){
            Room.numEnemies =BossRoom.numEnemies;
            BossRoom.createFinalRoom();
        }
        else{
            secondDoor.setBackground(new Color(55,55,55));
        }
    }

    public static void diffThreeRoomSetup(){
        currentRoomNumber = RoomMap.roomNumber;
        if(currentRoomNumber==0){
            firstDoor.setBackground(new Color(55,55,55));
        }
        else if(currentRoomNumber==1&&!roomsCleared.get(currentRoomNumber)){
            firstDoor.setBackground(new Color(75,75,75));
            secondDoor.setBackground(new Color(75,75,75));
            RoomEleven.createRoomOne();
            Room.numEnemies =RoomEleven.numEnemies;
        }
        else if(currentRoomNumber==2&&!roomsCleared.get(currentRoomNumber)){
            firstDoor.setBackground(new Color(75,75,75));
            secondDoor.setBackground(new Color(75,75,75));
            RoomTwelve.createRoomOne();
            Room.numEnemies =RoomTwelve.numEnemies;
        }
        else if(currentRoomNumber==3&&!roomsCleared.get(currentRoomNumber)){
            firstDoor.setBackground(new Color(75,75,75));
            secondDoor.setBackground(new Color(75,75,75));
            RoomThirteen.createRoomOne();
            Room.numEnemies =RoomThirteen.numEnemies;
        }
        else if(currentRoomNumber==4&&!roomsCleared.get(currentRoomNumber)){
            firstDoor.setBackground(new Color(75,75,75));
            secondDoor.setBackground(new Color(75,75,75));
            RoomFourteen.createRoomOne();
            Room.numEnemies =RoomFourteen.numEnemies;
        }
        else if(currentRoomNumber==5&&!roomsCleared.get(currentRoomNumber)){
            firstDoor.setBackground(new Color(75,75,75));
            secondDoor.setBackground(new Color(75,75,75));
            RoomFifteen.createRoomOne();
            Room.numEnemies =RoomFifteen.numEnemies;
        }
        else if(currentRoomNumber==6&&!roomsCleared.get(currentRoomNumber)){
            firstDoor.setBackground(new Color(75,75,75));
            secondDoor.setBackground(new Color(75,75,75));
            RoomSixteen.createRoomOne();
            Room.numEnemies =RoomSixteen.numEnemies;
        }
        else if(currentRoomNumber==7&&!roomsCleared.get(currentRoomNumber)){
            firstDoor.setBackground(new Color(75,75,75));
            secondDoor.setBackground(new Color(75,75,75));
            RoomSeventeen.createRoomOne();
            Room.numEnemies =RoomSeventeen.numEnemies;
        }
        else if(currentRoomNumber==8&&!roomsCleared.get(currentRoomNumber)){
            firstDoor.setBackground(new Color(75,75,75));
            secondDoor.setBackground(new Color(75,75,75));
            RoomEighteen.createRoomOne();
            Room.numEnemies =RoomEighteen.numEnemies;
        }
        else if(currentRoomNumber==9&&!roomsCleared.get(currentRoomNumber)){
            firstDoor.setBackground(new Color(75,75,75));
            secondDoor.setBackground(new Color(75,75,75));
            RoomNineteen.createRoomOne();
            Room.numEnemies =RoomNineteen.numEnemies;
        }
        else if(currentRoomNumber==10&&!roomsCleared.get(currentRoomNumber)){
            firstDoor.setBackground(new Color(75,75,75));
            secondDoor.setBackground(new Color(75,75,75));
            RoomTwenty.createRoomOne();
            Room.numEnemies =RoomTwenty.numEnemies;
        }
        else if(currentRoomNumber==11&&!roomsCleared.get(currentRoomNumber)){
            firstDoor.setBackground(new Color(75,75,75));
            secondDoor.setBackground(new Color(75,75,75));
            RoomTwentyone.createRoomOne();
            Room.numEnemies =RoomTwentyone.numEnemies;
        }
        else if(currentRoomNumber==12&&!roomsCleared.get(currentRoomNumber)){
            firstDoor.setBackground(new Color(75,75,75));
            secondDoor.setBackground(new Color(75,75,75));
            RoomTwentytwo.createRoomOne();
            Room.numEnemies =RoomTwentytwo.numEnemies;
        }
        else if(currentRoomNumber==13&&!roomsCleared.get(currentRoomNumber)){
            firstDoor.setBackground(new Color(75,75,75));
            secondDoor.setBackground(new Color(75,75,75));
            RoomTwentythree.createRoomOne();
            Room.numEnemies =RoomTwentythree.numEnemies;
        }        
        else if(currentRoomNumber==2&&roomsCleared.get(currentRoomNumber)){
            firstDoor.setBackground(new Color(75,75,75));
            secondDoor.setBackground(new Color(75,75,75));
            RoomTwelve.replaceSpikes();
        }
        else if(currentRoomNumber==4&&roomsCleared.get(currentRoomNumber)){
            firstDoor.setBackground(new Color(75,75,75));
            secondDoor.setBackground(new Color(75,75,75));
            RoomFourteen.replaceSpikes();
        }
        else if(currentRoomNumber==6&&roomsCleared.get(currentRoomNumber)){
            firstDoor.setBackground(new Color(75,75,75));
            secondDoor.setBackground(new Color(75,75,75));
            RoomSixteen.replaceSpikes();
        }
        else if(currentRoomNumber==RoomMap.numRooms-1&&!roomsCleared.get(currentRoomNumber)){
            Room.numEnemies =BossRoom.numEnemies;
            BossRoom.createFinalRoom();
        }
        else{
            secondDoor.setBackground(new Color(55,55,55));
        }
    }
}