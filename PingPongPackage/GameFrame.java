package PingPongPackage;
import javax.swing.*;

import java.awt.*;

public class GameFrame extends JFrame
{
    private GamePanel panel;

    public GameFrame(boolean bothAI, boolean rightAI, boolean noAI)
    {
        panel = new GamePanel(bothAI, rightAI, noAI);

        this.add(panel);
        this.setTitle("Pong Game");
        this.setResizable(false);
        this.setBackground(Color.BLACK);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        this.pack(); //Research More

        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
