package EvolutionGamePackage;


import java.awt.Color;
import java.util.Timer;

public class Rabbit extends Animal
{
    private int level;
    private int radius;
    public String type = "Rabbit";

    boolean movementAllowed;

    public Rabbit()
    {

    }

    public Rabbit(String genus)
    {
        super(genus, 50, 1, new Color(119, 42, 148), 0.2, 0.7, 0.1);
        level = 1;
        radius = 1;

        movementAllowed = true;
    }

    public int getLevel()
    {
        return level;
    }

    public int getRadius()
    {
        return radius;
    }

    
}
