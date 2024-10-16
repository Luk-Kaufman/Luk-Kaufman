package mainFiles;
import javax.swing.*;

import java.awt.*;
public class Menu{
    //initialize buttons
    public static boolean firstAttempt = true;
    static JButton settings = new JButton();
    static JButton easyButton = new JButton();
    static JButton mediumButton = new JButton();
    static JButton hardButton = new JButton();
    static JButton instructions = new JButton();
    static JButton startGame = new JButton();
    static JButton backToMainScreen = new JButton();
    
    public static void makeMenu()throws Exception{
        JFrame theFrame = Driver.theFrame;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        theFrame.setBounds(((int)screenSize.getWidth()/2)-825/2,((int)screenSize.getHeight()/2)-825/2,825,825);
        theFrame.setResizable(false);
        theFrame.setLayout(null);
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        
        //initialize text fields
        JTextField instructionsText =new JTextField("Will Add Later");
        JLabel difficultyLabel = new JLabel();

        //JButton back to main menu
        backToMainScreen.setBounds(308,25,200,30);
        backToMainScreen.setText("Back To Main Screen");
        backToMainScreen.setVisible(false);
        theFrame.add(backToMainScreen);
        backToMainScreen.addActionListener(e->{
            difficultyLabel.setVisible(false);
            easyButton.setVisible(false);
            mediumButton.setVisible(false);
            hardButton.setVisible(false);
            backToMainScreen.setVisible(false);
            instructionsText.setVisible(false);         
            startGame.setVisible(true);
            instructions.setVisible(true);
            settings.setVisible(true);
        });

        //JButton settings
        settings.setBounds(25,25,200,30);
        settings.setText("Open Settings");
        theFrame.add(settings);
        difficultyLabel.setBounds(358,125,100,100);
        difficultyLabel.setText("Difficulty Options:");
        theFrame.add(difficultyLabel);
        difficultyLabel.setVisible(false);
        easyButton.setBounds(25,225,200,30);
        easyButton.setText("Easy");
        easyButton.addActionListener(e->{ 
            Driver.difficulty = 1;
        });
        theFrame.add(easyButton);
        easyButton.setVisible(false);
        mediumButton.setBounds(308,225,200,30);
        mediumButton.setText("Medium");
        mediumButton.addActionListener(e->{ 
            Driver.difficulty = 2;
        });
        theFrame.add(mediumButton);
        mediumButton.setVisible(false);
        hardButton.setBounds(591,225,200,30);
        hardButton.setText("Hard");
        hardButton.addActionListener(e->{ 
            Driver.difficulty = 3;
        });
        theFrame.add(hardButton);
        hardButton.setVisible(false);
        settings.addActionListener(e->{    
            difficultyLabel.setVisible(true);
            easyButton.setVisible(true);
            mediumButton.setVisible(true);
            hardButton.setVisible(true);
            backToMainScreen.setVisible(true);        
            startGame.setVisible(false);
            settings.setVisible(false);
            instructions.setVisible(false);
        });

        //JButton startGame
        startGame.setBounds(308,25,200,30);
        startGame.setText("Start Game");
        theFrame.add(startGame);
        startGame.addActionListener(e->{
            if(firstAttempt){
                TheGame.layeredPane.setVisible(true);
                Player.dead = false;
                Player.gameOver = false;
                Player.gameOverScreen.setVisible(false);
                startGame.setVisible(false);
                settings.setVisible(false);
                instructions.setVisible(false);
                try {
                    TheGame.initializeGame();
                } catch (Exception e1) {}  
            }else{
                TheGame.layeredPane.setVisible(true);
                Player.dead = false;
                Player.gameOver = false;
                Player.gameOverScreen.setVisible(false);
                startGame.setVisible(false);
                settings.setVisible(false);
                instructions.setVisible(false);
                try {
                    TheGame.reinitializeGame();
                } catch (Exception e1) {}  
            }
           
        });
       
        //JButton instructions
        instructions.setBounds(591,25,200,30);
        instructions.setText("Open Instructions");
        instructionsText.setBounds(25,125,760,400);
        instructionsText.setBackground(new Color(200,200,200));
        instructionsText.setBorder(null);
        instructionsText.setEditable(false);
        instructionsText.setVisible(false);
        theFrame.add(instructions);
        theFrame.add(instructionsText);
        instructions.addActionListener(e->{
            startGame.setVisible(false);
            settings.setVisible(false);
            instructions.setVisible(false);
            instructionsText.setVisible(true);
            backToMainScreen.setVisible(true);
        });

        theFrame.setVisible(true);
    }
    public void remakeMenu(){

    }
}