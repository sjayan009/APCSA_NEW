package PingPongPackage;
import java.awt.*;
import java.util.*;

public class Score extends Rectangle
{
    private static int GAME_WIDTH;
    private static int GAME_HEIGHT;

    
    private static ArrayList<Integer> record = new ArrayList<Integer>();

    public int player1;
    public int player2;

    public Score(int GAME_WIDTH, int GAME_HEIGHT)
    {
        Score.GAME_WIDTH = GAME_WIDTH;
        Score.GAME_HEIGHT = GAME_HEIGHT;
    }

    /*
     *  From Player 1's Perspective
     *  Adds records starting from index 0
     *  Record of 0 means Loss
     *  Record of 1 means Win
     */
    public static void addRecord(int x)
    {
        record.add(x);
        System.out.println(record);
    }

    public static void display()
    {
        System.out.println(record);
    }

    public void draw(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Times New Roman", Font.PLAIN, 50));

        g.drawLine(GAME_WIDTH/2, 0, GAME_WIDTH/2, GAME_HEIGHT);

        g.drawString(String.valueOf(player1), GAME_WIDTH/2 - 85, 50);
        g.drawString(String.valueOf(player2), GAME_WIDTH/2 + 60, 50);
    }
}
