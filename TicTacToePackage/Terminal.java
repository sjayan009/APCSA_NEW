package TicTacToePackage;

import java.util.Scanner;

public class Terminal 
{
    private GamePiece[][] gameBoard = new GamePiece[3][3];
    private Scanner sc = new Scanner(System.in);

    /*
     * Parameters: 'X' or 'O', row, column
     * Post Condition: Game Piece properly inserted in gameBoard 
     */
    public void playerTurn(Player p, int row, int c)
    {
        if(isCoordinateValid(row, c))
        {
            gameBoard[row][c] = new GamePiece(p.getValue());
            System.out.println("Game Piece Successfully Implemented");
            displayBoard();
        }
        else
        {
            while(isCoordinateValid(row, c) != true)
            {
                System.out.println("Improper Coordinate. Pick a new coordinate.");
                System.out.print("Please enter a row number: ");
                row = sc.nextInt();
                System.out.print("Please enter a column number: ");
                c = sc.nextInt();
            }
            playerTurn(p, row, c);
        }
    }

    /*
     * Checks if coordinate passed through parameters is a plausible place to keep Game Piece 'X' or 'O'
     */
    public boolean isCoordinateValid(int row, int column)
    {
        if(row <= 2 && column <= 2)
        {
            if(gameBoard[row][column].getValue().equals("_"))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        return false;
    }

    /*
     * Fills 3 x 3 Board with _ 
     */
    public void fillBoard()
    {
        for(int i = 0; i < gameBoard.length; i++)
        {
            for(int c = 0; c < gameBoard.length; c++)
            {
                gameBoard[i][c] = new GamePiece("_");
            }
        }
    }

    /*
     * Displays the Board using a for each loop
     */
    public void displayBoard()
    {
        for(GamePiece[] g : gameBoard)
        {
            for(GamePiece obj : g)
            {
                System.out.print(obj.getValue() + " ");
            }
            System.out.println();
        }
    }

    /*
     * Checks if a player has won the game
     */
    public boolean win()
    {
        if(diagonal())
        {
            return true;
        }
        else if(row())
        {
            return true;
        }
        else if(column())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean diagonal()
    {
        boolean val1 = false;
        boolean val2 = false;

        if(gameBoard[0][0].getValue().equals("_") == false && gameBoard[1][1].getValue().equals("_") == false && gameBoard[2][2].getValue().equals("_") == false)
        {
            if(gameBoard[0][0].getValue().equals(gameBoard[1][1].getValue()) && gameBoard[1][1].getValue().equals(gameBoard[2][2].getValue()))
            {
                val1 = true;
            }
        }
    
        if(gameBoard[2][0].getValue().equals("_") == false && gameBoard[1][1].getValue().equals("_") == false && gameBoard[0][2].getValue().equals("_") == false)
        {
            if(gameBoard[2][0].getValue().equals(gameBoard[1][1].getValue()) && gameBoard[1][1].getValue().equals(gameBoard[0][2].getValue()))
            {
                val2 = true;
            }
        }

        if(val1 == true || val2 == true)
        {
            return true;
        }
        return false;
    }

    public boolean row() 
    {
        for(int row = 0; row < gameBoard.length; row++) 
        {
            String first = gameBoard[row][0].getValue();
            boolean allEqual = true;
            if(first.equals("_") == false)
            {
                for(int col = 1; col < gameBoard[row].length; col++) 
                {
                    if(!gameBoard[row][col].getValue().equals(first)) 
                    {
                        allEqual = false;
                        break;
                    }
                }
                if(allEqual) 
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean column() 
    {
        for (int col = 0; col < gameBoard.length; col++) 
        {
            boolean colEqual = true;
            String colValue = gameBoard[0][col].getValue();
            if(colValue.equals("_") == false)
            {
                for (int row = 1; row < gameBoard.length; row++) 
                {
                    if (!gameBoard[row][col].getValue().equals(colValue)) 
                    {
                        colEqual = false;
                        break;
                    }
                }
                if (colEqual) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /*
     * Checks if there is a draw
     */
    public boolean draw()
    {
        boolean val = false;

        for(int i = 0; i < gameBoard.length; i++)
        {
            for(int c = 0; c < gameBoard.length; c++)
            {
                if(gameBoard[i][c].getValue().equals("X") || gameBoard[i][c].getValue().equals("O") && gameBoard[i][c] != null)
                {
                    val = true;
                }
                else
                {
                    val = false;
                    return val;
                }
            }
        }

        return val;
    }

    /*
     * Method used to run the game
     */
    public void run()
    {
        Player p1;
        Player p2;
        String s = "";
        while (!s.equals("X") && !s.equals("O")) {
            System.out.println("Enter X or O:");
            s = sc.next().toUpperCase();
        }

        p1 = new Player(s);
        if(s.equals("X")) { p2 = new Player("O"); }
        else { p2 = new Player("X"); }

        fillBoard();
        displayBoard();

        int i = 0;
        while(win() == false || draw() == true)
        {
            if(i % 2 == 0)
            {
                System.out.println("Player 1 Turn");
                System.out.print("Please enter a row number: ");
                int row = sc.nextInt();
                System.out.print("Please enter a column number: ");
                int c = sc.nextInt();
                playerTurn(p1, row, c);
            }
            else
            {
                System.out.println("Player 2 Turn");
                System.out.print("Please enter a row number: ");
                int row = sc.nextInt();
                System.out.print("Please enter a column number: ");
                int c = sc.nextInt();
                playerTurn(p2, row, c);
            }
            i++;

            //System.out.println("i: " + i);
            //System.out.println(win());
            if(draw())
            {
                System.out.println("No One Won The Game");
                break;
            }
        }
        if(draw() == false)
        {
            if(i % 2 == 0)
            {
                System.out.println("Player 2 has won the game");
            }
            else if(i % 2 == 1)
            {
                System.out.println("Player 1 has won the game");
            }
        }

        //System.out.println(p1.getValue() + " " + p1.getID()); Test --> Successfull
        //System.out.println(p2.getValue() + " " + p2.getID()); Test --> Successfull

        
        
    }
}
