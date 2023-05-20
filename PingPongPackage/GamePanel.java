package PingPongPackage;
import java.util.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class GamePanel extends JPanel implements Runnable
{
    private static final int GAME_WIDTH = 1000;
    private static final int GAME_HEIGHT = (int) (GAME_WIDTH * (0.5555));

    private static Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
    
    private static final int BALL_DIAMETER = 20; //pixels
    
    private static final int PADDLE_WIDTH = 25;
    private static final int PADDLE_HEIGHT = 100;

    private boolean bothAI;
    private boolean rightAI;
    private boolean noAI;

    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Paddle paddle1;
    Paddle paddle2;
    AI_Paddle AI1;
    AI_Paddle AI2;

    Ball ball;
    Score score;

    public GamePanel(boolean bothAI, boolean rightAI, boolean noAI)
    {
        this.bothAI = bothAI;
        this.rightAI = rightAI;
        this.noAI = noAI;

        newPaddles();
        newBall();

        score = new Score(GAME_WIDTH, GAME_HEIGHT);
        
        this.setFocusable(true);
        this.addKeyListener(new AL());

        this.setPreferredSize(SCREEN_SIZE);

        gameThread = new Thread(this);
        gameThread.start();
    }    

    public void newBall()
    {
        random = new Random();
        if(bothAI)
        {
            ball = new Ball((GAME_WIDTH-BALL_DIAMETER)/2, (GAME_HEIGHT-BALL_DIAMETER)/2, BALL_DIAMETER, BALL_DIAMETER, true);
        }
        else
        {
            ball = new Ball((GAME_WIDTH-BALL_DIAMETER)/2, (GAME_HEIGHT-BALL_DIAMETER)/2, BALL_DIAMETER, BALL_DIAMETER, false);
        }

    }

    public void newPaddles()
    {
        if(noAI)
        {
            paddle1 = new Paddle(0, (GAME_HEIGHT/2)-(PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, Color.RED, 1);
            paddle2 = new Paddle((GAME_WIDTH-PADDLE_WIDTH), (GAME_HEIGHT/2)-(PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, Color.BLUE, 2);
        }
        else if(rightAI)
        {
            paddle1 = new Paddle(0, (GAME_HEIGHT/2)-(PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, Color.RED, 1);
            AI2 = new AI_Paddle((GAME_WIDTH-PADDLE_WIDTH), (GAME_HEIGHT/2)-(PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, Color.BLUE);
        }
        else if(bothAI)
        {
            AI1 = new AI_Paddle(0, (GAME_HEIGHT/2)-(PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, Color.RED);
            AI2 = new AI_Paddle((GAME_WIDTH-PADDLE_WIDTH), (GAME_HEIGHT/2)-(PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, Color.BLUE);
        }
    }

    public void paint(Graphics g)
    {
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image,0,0, this);
    }

    public void draw(Graphics g)
    {
        if(noAI)
        {
            paddle1.draw(g);
            paddle2.draw(g);
        }
        else if(rightAI)
        {
            paddle1.draw(g);
            AI2.draw(g);
        }
        else if(bothAI)
        {
            AI1.draw(g);
            AI2.draw(g);
        }


        ball.draw(g);
        score.draw(g);
    }

    public void move()
    {
        if(noAI)
        {
            paddle1.move();
            paddle2.move();
        }
        else if(rightAI)
        {
            paddle1.move();
            AI2.move(ball.y);
        }
        else if(bothAI)
        {
            AI1.move(ball.y);
            AI2.move(ball.y);
        }

        ball.move();
    }

    public void checkCollision()
    {
        //bounce ball off top & bottom window edges
        if(ball.y <= 0)
        {
            ball.setYDirection(-ball.getYVelocity());
        }
        if(ball.y >= GAME_HEIGHT - BALL_DIAMETER)
        {
            ball.setYDirection(-ball.getYVelocity());
        }

        //bounces ball off of the paddles
        if(paddle1 != null && ball.intersects(paddle1))
        {
            ball.setXVelocity(Math.abs(ball.getXVelocity()));            
            ball.setXVelocity(ball.getXVelocity() + 0.5);

            if(ball.getYVelocity() > 0)
            {
                ball.setYVelocity(ball.getYVelocity() + 0.5);
            }
            else
            {
                ball.setYVelocity(ball.getYVelocity() - 0.5);
            }
            
            ball.setXDirection(ball.getXVelocity());
            ball.setYDirection(ball.getYVelocity());
        }
        if(paddle2 != null && ball.intersects(paddle2))
        {
            ball.setXVelocity(Math.abs(ball.getXVelocity()));
            
            
            ball.setXVelocity(ball.getXVelocity() + 0.5);
            if(ball.getYVelocity() > 0)
            {
                ball.setYVelocity(ball.getYVelocity() + 0.5);
            }
            else
            {
                ball.setYVelocity(ball.getYVelocity() - 0.5);
            }
            
            ball.setXDirection(-ball.getXVelocity());
            ball.setYDirection(ball.getYVelocity());
        }
        if(AI1 != null && ball.intersects(AI1))
        {
            ball.setXVelocity(Math.abs(ball.getXVelocity()));            
            ball.setXVelocity(ball.getXVelocity() + 0.5);

            if(ball.getYVelocity() > 0)
            {
                ball.setYVelocity(ball.getYVelocity() + 0.5);
            }
            else
            {
                ball.setYVelocity(ball.getYVelocity() - 0.5);
            }
            
            ball.setXDirection(ball.getXVelocity());
            ball.setYDirection(ball.getYVelocity());
        }
        if(AI2 != null && ball.intersects(AI2))
        {
            ball.setXVelocity(Math.abs(ball.getXVelocity()));
            
            
            ball.setXVelocity(ball.getXVelocity() + 0.5);
            if(ball.getYVelocity() > 0)
            {
                ball.setYVelocity(ball.getYVelocity() + 0.5);
            }
            else
            {
                ball.setYVelocity(ball.getYVelocity() - 0.5);
            }
            
            ball.setXDirection(-ball.getXVelocity());
            ball.setYDirection(ball.getYVelocity());
        }

        //stops paddles at window edges
        if(paddle1 != null && paddle1.y <= 0)
        {
            paddle1.y = 0;
        }

        if(paddle1 != null && paddle1.y >= GAME_HEIGHT-PADDLE_HEIGHT)
        {
            paddle1.y = GAME_HEIGHT-PADDLE_HEIGHT;
        }

        if(paddle2 != null && paddle2.y <= 0)
        {
            paddle2.y = 0;
        }

        if(paddle2 != null && paddle2.y >= GAME_HEIGHT-PADDLE_HEIGHT)
        {
            paddle2.y = GAME_HEIGHT-PADDLE_HEIGHT;
        }

        //give a player a point and creates new paddles & ball
        if(ball.x <= 0)
        {
            score.player2++;
            Score.addRecord(0);
            newPaddles();
            newBall();
            //System.out.println("Player 2: " + score.player2);
        }
        else if(ball.x >= GAME_WIDTH-BALL_DIAMETER)
        {
            score.player1++;
            Score.addRecord(1);
            newPaddles();
            newBall();
            //System.out.println("Player 1: " + score.player1);
        }
    }

    public void run()
    {
        long lastTime = System.nanoTime(); //Research
        double amountOfTicks = 100.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;

        while(true)
        {
            long now = System.nanoTime();
            delta += (now - lastTime)/ns;
            lastTime = now;
            if(delta >= 1)
            {
                move();
                checkCollision();
                repaint();
                delta--;
                //System.out.println("TEST");
            }
        }
    }

    public class AL extends KeyAdapter
    {
        public void keyPressed(KeyEvent e)
        {
            if(paddle1 != null && paddle2 != null)
            {
                paddle1.keyPressed(e);
                paddle2.keyPressed(e);
            }
            if(paddle1 != null && paddle2 == null)
            {
                paddle1.keyPressed(e);
                //paddle2.keyPressed(e);
            }
            if(AI1 != null && AI2 != null)
            {
                
            }
            else
            {
                ball.keyPressed(e);
            }
        }

        public void keyReleased(KeyEvent e)
        {
            if(paddle1 != null && paddle2 != null)
            {
                paddle1.keyReleased(e);
                paddle2.keyReleased(e);
            }
            if(paddle1 != null && paddle2 == null)
            {
                paddle1.keyReleased(e);
                //paddle2.keyReleased(e);
            }
            ball.keyReleased(e);
        }
    }
}
