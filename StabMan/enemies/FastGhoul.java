package enemies;

import java.awt.Color;

import javax.swing.JPanel;

import mainFiles.TheGame;

public class FastGhoul extends Ghoul{
    public FastGhoul(){
        ghoulColor = new Color(17,153,153);
        dead=false;
        health = 10;
        speed = 9;
        size =15;
        damage = 1;
        avatar = new JPanel();
        layerForEnemy = new JPanel();
        layerForEnemy.setBackground(new Color(0,0,0,0));
        layerForEnemy.setLayout(null);
        layerForEnemy.setBounds(35,35,740,715);
    }
    @Override
    public void create(int x, int y) {
        super.create(x, y);
        avatar.setBackground(ghoulColor);
        TheGame.layeredPane.repaint();
    }
}