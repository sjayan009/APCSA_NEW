package PingPongPackage;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Ball extends Rectangle
{
    private Random random;
    private double xVelocity;
    private double yVelocity;
    private double initialSpeed = 2;

    public Ball(int x, int y, int BALL_WIDTH, int BALL_HEIGHT, boolean isAI)
    {
        super(x, y, BALL_WIDTH, BALL_HEIGHT);
        random = new Random();
        
        if(isAI)
        {
            AI();
        }
    }

    public void setXVelocity(double x)
    {
        this.xVelocity = x;
    }

    public void setYVelocity(double y)
    {
        this.yVelocity = y;   
    }

    public double getXVelocity()
    {
        return xVelocity;
    }

    public double getYVelocity()
    {
        return yVelocity;   
    }

    public void setXDirection(double randomXDirection)
    {
        xVelocity = randomXDirection;
    }

    public void setYDirection(double randomYDirection)
    {
        yVelocity = randomYDirection; 
    }

    public void AI()
    {
        int randomXDirection = random.nextInt(2);
        if(randomXDirection == 0)
        {
            randomXDirection--;
        }
        setXDirection(randomXDirection*initialSpeed);

        int randomYDirection = random.nextInt(2);
        if(randomYDirection == 0)
        {
            randomYDirection--;
        }
        setYDirection(randomYDirection*initialSpeed);
    }

    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_SPACE && initialSpeed == 2 && this.x == (1000-20)/2 && this.y == ((int) (1000 * (0.5555))-20)/2)
        {
            int randomXDirection = random.nextInt(2);
            if(randomXDirection == 0)
            {
                randomXDirection--;
            }
            setXDirection(randomXDirection*initialSpeed);

            int randomYDirection = random.nextInt(2);
            if(randomYDirection == 0)
            {
                randomYDirection--;
            }
            setYDirection(randomYDirection*initialSpeed);
        }
    }

    public void keyReleased(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            //Do Nothing when SPACE is released
        }
    }

    public void move()
    {
        x += xVelocity;
        y += yVelocity;
    }

    public void draw(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, width, height);
    }
}
