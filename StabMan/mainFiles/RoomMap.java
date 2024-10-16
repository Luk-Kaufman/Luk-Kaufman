package mainFiles;
import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

public class RoomMap{
    static int numRooms = 5*Driver.difficulty;
    static JLayeredPane layeredPane = TheGame.layeredPane;
    public static int roomNumber=0;
    static public JPanel theMapPanel = new JPanel();
    public static ArrayList<Room> rooms = new ArrayList<>();
    
    public static void remakeMap(){
        numRooms = 5*Driver.difficulty;
        theMapPanel.removeAll();
        rooms.clear();
        for(int i = 0; i<numRooms;i++){
            JPanel tempRoomAvatar = new JPanel();
            tempRoomAvatar.setBounds(i*5,15,15,15);
            tempRoomAvatar.setBackground(new Color(80, 80, 80));
            theMapPanel.add(tempRoomAvatar);
            Room tempRoom = new Room(i, tempRoomAvatar);
            rooms.add(tempRoom);
        }
        rooms.get(0).getAvatar().setBackground(new Color(115,115,115));
        System.out.println();
    }
    public static void makeMap(){
        for(int i = 0; i<numRooms;i++){
            JPanel tempRoomAvatar = new JPanel();
            tempRoomAvatar.setBounds(i*5,15,15,15);
            tempRoomAvatar.setBackground(new Color(80, 80, 80));
            theMapPanel.add(tempRoomAvatar);
            Room tempRoom = new Room(i, tempRoomAvatar);
            rooms.add(tempRoom);
        }
        theMapPanel.setBounds(500,15,250,20);
        theMapPanel.setBackground(new Color(55, 55, 55));
        layeredPane.add(theMapPanel,1);
        rooms.get(0).getAvatar().setBackground(new Color(115,115,115));
        System.out.println();
    }

    public static void moveMarker(){
        for(int i =0; i<numRooms;i++){
            rooms.get(i).getAvatar().setBackground(new Color(80, 80, 80));
        }
        rooms.get(roomNumber).getAvatar().setBackground(new Color(115,115,115));
    }
}