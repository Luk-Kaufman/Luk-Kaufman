package mainFiles;
import javax.swing.*;
public class Driver{
    //difficulty
    //1 is easy. 2 is medium. 3 is hard
    //defualt is easy
    public static int difficulty = 1;
    public static JFrame theFrame = new JFrame("StabMan");
    public static void main(String[] args) throws Exception {
        Menu.makeMenu();
    }
}