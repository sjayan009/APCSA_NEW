import PingPongPackage.*;
import TicTacToePackage.*;
import javax.swing.*;

public class Main extends JFrame
{
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 400;

    public Main()
    {
        this.setTitle("Game Selection");
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setVisible(true);
        this.setLocationRelativeTo(null);

        this.setLayout(null);

        JPanel pingPongPanel = new JPanel();
        pingPongPanel.setBounds(40, 20, 400, 60);
        //pingPongPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        createPingPong(pingPongPanel);

        JPanel ticTacToePanel = new JPanel();
        ticTacToePanel.setBounds(40, 80, 400, 60);
        createTicTacToe(ticTacToePanel);


        this.add(pingPongPanel);
        this.add(ticTacToePanel);

        this.setVisible(true);
    }

    /*
     * Adds Elements to Ping Pong Panel
     */
    private void createPingPong(JPanel p)
    {
        ButtonGroup b1 = new ButtonGroup();

        JLabel pingPongLabel = new JLabel("Ping Pong Game: ");
        JRadioButton rb1 = new JRadioButton("Both AI");
        JRadioButton rb2 = new JRadioButton("Right AI");
        JRadioButton rb3 = new JRadioButton("No AI");

        b1.add(rb1);
        b1.add(rb2);
        b1.add(rb3);

        JButton play = new JButton("Play");
        play.addActionListener(e -> pingPongClick(p, rb1, rb2, rb3));
        
        p.add(pingPongLabel);
        p.add(rb1);
        p.add(rb2);
        p.add(rb3);
        p.add(play);
    }

    /*
     * Ping Pong Game Instructions
     */
    private void pingPongClick(JPanel p, JRadioButton rb1, JRadioButton rb2, JRadioButton rb3) 
    {
        if(rb1.isSelected() == false && rb2.isSelected() == false && rb3.isSelected() == false)
        {
            JOptionPane.showMessageDialog(p, "You Must Select a Option", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            String msg = "Player 1 (Left): Use W or A to move up. Use D or S to move down. \n" + 
                         "Player 2 (Right): Use UP or LEFT arrow key to move up. Use DOWN or RIGHT arrow key to move down. \n" + 
                         "Note: If you have chosen 'Right AI', then the instructions for Player 2 don't apply. \n" + 
                         "Press the SPACEBAR to start the ball!"; 

            JOptionPane.showMessageDialog(p, msg, "Game Instructions", JOptionPane.INFORMATION_MESSAGE);
            new PingPong(rb1.isSelected(), rb2.isSelected(), rb3.isSelected());
        }
    }

    /*
     * Adds Tic Tac Toe Elements to Tic Tac Toe Panel
     */
    private void createTicTacToe(JPanel p)
    {
        ButtonGroup b1 = new ButtonGroup();

        JLabel ticTacToeLabel = new JLabel("Tic Tac Toe Game: ");
        JRadioButton rb1 = new JRadioButton("Terminal");

        b1.add(rb1);

        JButton play = new JButton("Play");
        play.addActionListener(e -> ticTacToeClick(p, rb1));

        p.add(ticTacToeLabel);
        p.add(rb1);
        p.add(play);

    }

    private void ticTacToeClick(JPanel p, JRadioButton r1)
    {
        if(r1.isSelected() == false)
        {
            JOptionPane.showMessageDialog(p, "You Must Select a Option", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(p, "Follow Terminal Instructions", "Rules", JOptionPane.INFORMATION_MESSAGE);
            new Terminal().run();
        }
    }
    public static void main(String[] args) 
    {
        System.out.println("Hello!");
        new Main();
    }    
}
