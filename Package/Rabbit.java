package Package;

import java.awt.Color;

public class Rabbit extends Animal
{
    private int level;
    public String type = "Rabbit";

    public Rabbit()
    {

    }

    public Rabbit(String genus)
    {
        super(genus, 50, 1, new Color(119, 42, 148), 0.5, 0.2, 0.1);
        level = 1;
    }

    public int getLevel()
    {
        return level;
    }
}
