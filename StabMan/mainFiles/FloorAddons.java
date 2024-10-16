package mainFiles;

import javax.swing.JPanel;

public abstract class FloorAddons{
    public int x;
    public int y;
    public int xSize;
    public int ySize;
    protected int damage;
    protected JPanel avatar;
    public JPanel layerForFloorTrap;
    public abstract void create(int x,int y,int xSize,int ySize);
    public abstract boolean checkIfPlayerIsOver();
}