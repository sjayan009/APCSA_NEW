package PingPongPackage;
import java.awt.*;

public class AI_Paddle extends Rectangle
{
    int speed = 5;
    private Color c;

    public AI_Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, Color c)
    {
        super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
        this.c = c;
    }

    public void move(int ballY)
    {
        y = ballY;
    }

    public void draw(Graphics g)
    {
        g.setColor(c);
        g.fillRect(x, y, width, height);
    }
}
