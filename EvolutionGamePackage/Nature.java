package EvolutionGamePackage;


import javax.swing.*;
import java.awt.Color;

public class Nature extends JPanel
{
    private int id;
    /*
     * id value description:
     * 0 - Water
     * 1 - Tree
     * 2 - Plant
     * 4 - Grass
    */
    
    public Nature()
    {

    }

    public Nature(int id)
    {
        this.id = id;
    }

    public Color getColor()
    {
        if(id == 0)
        {
            //Water = Blue
            return Color.BLUE;
        }
        else if(id == 1)
        {
            //Tree = Brown
            return new Color(150, 75, 0);
        }
        else if(id == 2)
        {
            //Plant =  Green
            return new Color(0,128,0);
        }
        else if(id == 4)
        {
            //Grass = Light Green
            return new Color(136, 213, 107);
        }
        return Color.WHITE;
    }

    public String getDescription()
    {
        if(id == 0)
        {
            return "Water";
        }
        else if(id == 1)
        {
            return "Tree";
        }
        else if(id == 2)
        {
            return "Plant";
        }
        return "";
    }

    public int getID()
    {
        return id;
    }
}