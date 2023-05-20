package PingPongPackage;
import java.awt.*;
import java.awt.event.*;

public class Paddle extends Rectangle 
{
    private int id;
    private int yVelocity;
    int speed = 5;
    private Color c;

    public Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, Color c, int id)
    {
        super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
        this.id = id;
        this.c = c;
    }

    public void keyPressed(KeyEvent e)
    {
        switch(id)
        {
            case 1:
                if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_A)
                {
                    setYDirection(-speed);
                    move();
                }
                if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_D)
                {
                    setYDirection(speed);
                    move();
                }
                break;
            case 2:
                if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_LEFT)
                {
                    setYDirection(-speed);
                    move();
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_RIGHT)
                {
                    setYDirection(speed);
                    move();
                }
                break;        
        }
        
    }

    public void keyReleased(KeyEvent e)
    {
        switch(id)
        {
            case 1:
                if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_A)
                {
                    setYDirection(0);
                    move();
                }
                if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_D)
                {
                    setYDirection(0);
                    move();
                }
                break;
            case 2:
                if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_LEFT)
                {
                    setYDirection(0);
                    move();
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_RIGHT)
                {
                    setYDirection(0);
                    move();
                }
                break;        
        }
    }

    public void setYDirection(int yDirection)
    {
        yVelocity = yDirection;
    }

    public void move()
    {
        y += yVelocity;
    }

    public void draw(Graphics g)
    {
        g.setColor(c);
        g.fillRect(x, y, width, height);
    }
}
