package TicTacToePackage;

public class Player 
{
    private GamePiece obj;
    private int ID;
    
    public Player(String value)
    {
        obj = new GamePiece(value);
        if(obj.getValue().equals("X"))
        {
            ID = 0;
        }
        else
        {
            ID = 1;
        }
    }

    public String getValue()
    {
        return obj.getValue();
    }

    public int  getID()
    {
        return ID;
    }
}
