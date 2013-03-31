import sofia.micro.*;
import java.util.*;
import sofia.graphics.*;
//-------------------------------------------------------------------------
/**
 *  Chessboard World
 *  Holds the instructions, Pieces, and Square highlights referred to 
 *  as glows. Checks for end game conditions.
 *
 *  @author Loran Steinberger (bkwrm215)
 *  @version (2012.12.03)
 */
public class Chessboard extends World
{
    //~ Fields ................................................................
    private Rook bRook;
    private Knight bKnight;
    private Bishop bBishop;
    private Queen bQueen;
    private King bKing;
    private Pawn bPawn;

    private Rook wRook;
    private Knight wKnight;
    private Bishop wBishop;
    private Queen wQueen;
    private King wKing;
    private Pawn wPawn;

    private TextShape title;
    private TextShape instruct1;
    private TextShape instruct2;
    private TextShape instruct3;

    private TextShape endTitle;
    private TextShape whiteWins;
    private TextShape blackWins;

    private boolean whiteTurn;
    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new ChessboardWhite object.
     */
    public Chessboard()
    {
        super(8, 8, 50);

        bRook = new Rook(false);
        this.add(bRook, 0, 0);

        bKnight = new Knight(false);
        this.add(bKnight, 1, 0);

        bBishop = new Bishop(false);
        this.add(bBishop, 2, 0);

        bQueen = new Queen(false);
        this.add(bQueen, 3, 0);

        bKing = new King(false);
        this.add(bKing, 4, 0);

        bBishop = new Bishop(false);
        this.add(bBishop, 5, 0);

        bKnight = new Knight(false);
        this.add(bKnight, 6, 0);

        bRook = new Rook(false);
        this.add(bRook, 7, 0);

        wRook = new Rook(true);
        wKnight = new Knight(true);
        wBishop = new Bishop(true);
        wQueen = new Queen(true);
        wKing = new King(true);

        for (int i = 0; i < 8; i++)
        {
            bPawn = new Pawn(false);
            wPawn = new Pawn(true);
            this.add(wPawn, i, 6);
            this.add(bPawn, i, 1);

        }

        this.add(wRook, 0, 7);
        this.add(wKnight, 1, 7);
        this.add(wBishop, 2, 7);
        this.add(wQueen, 3, 7);
        this.add(wKing, 4, 7);

        wRook = new Rook(true);
        wKnight = new Knight(true);
        wBishop = new Bishop(true);
        this.add(wBishop, 5, 7);
        this.add(wKnight, 6, 7);
        this.add(wRook, 7, 7);

        title = new TextShape("Two Player Chess"); 
        instruct1 = new TextShape("Click on a piece to show moves."); 
        instruct2 = new TextShape("Click on a move to accept.");
        instruct3 = new TextShape("Click Run to begin!");
        endTitle = new TextShape("GAME OVER"); 
        whiteWins = new TextShape("White Wins!");
        blackWins = new TextShape("Black Wins!");

        this.add(title, 4, 2);
        this.add(instruct1, 4, 3);
        this.add(instruct2, 4, 4);
        this.add(instruct3, 4, 5);

        title.setTypeSize(18);

        title.setColor(Color.black);
        instruct1.setColor(Color.black);
        instruct2.setColor(Color.black);
        instruct3.setColor(Color.black);
        endTitle.setColor(Color.red);
        whiteWins.setColor(Color.red);
        blackWins.setColor(Color.red);

        whiteTurn = true;

        this.setSpeed(100);
    }
    //~ Methods ...............................................................
    /**
     * Act Method
     * the world constantly checks for checkmate condition
     */
    public void act()
    {
        //check for checkmate- end game if so
        if ( this.getObjects(King.class).size() == 1  )
        {
            this.stop();
        }

    }        
    /**
     * Clear Board
     * The world removes all actors and text images.
     */
    public void clearBoard()
    {
        for (Actor object : this.getObjects(Piece.class))
        {
            this.remove(object);
        }

        this.remove(instruct1);
        this.remove(instruct2);
        this.remove(instruct3);
        this.remove(title);
    }

    /**
     * Started method
     * if the world has been started, this method removes all 
     * text images.
     */
    public void started()
    {

        this.remove(title);
        this.remove(instruct2);
        this.remove(instruct3);
        this.remove(instruct1);

    }

    /**
     * Stoppped method
     * if the world has been stopped, the instructions reappear
     * or the end game text appears.
     */
    public void stopped()
    {
        if (this.getObjects(King.class).size() == 2)
        {
            this.add(title, 4, 2);
            this.add(instruct1, 4, 3);
            this.add(instruct2, 4, 4);
            this.add(instruct3, 4, 5);
        }
        else 
        {

            this.add(endTitle, 4, 2);
            for (King king : this.getObjects(King.class))
            {
                if (((Piece)king).getIsWhite())
                {

                    this.add(whiteWins, 4, 3);
                }
                else
                {

                    this.add(blackWins, 4, 3);
                }
            }

        }

    }

    /**
     * get White Turn method
     * @return returns true if it is white's turn,
     * and false if it is blacks turn.
     */
    public boolean getWhiteTurn()
    {
        return whiteTurn;
    }

    /**
     * set White Turn
     * sets the value of the whiteTurn boolean.
     * @param turn true if set to white, false if set
     * to black.
     */
    public void setWhiteTurn(boolean turn)
    {
        whiteTurn = turn;
    }

    /**
     * getTitle
     * @return title TextShape
     */
    public TextShape getTitle()
    {
        return title;
    }

    /**
     * getEndTitle
     * @return endTitle TextShape
     */
    public TextShape getEndTitle()
    {
        return endTitle;
    }

    /**
     * getWhiteWon
     * @return whiteWon TextShape
     */
    public TextShape getWhiteWins()
    {
        return whiteWins;
    }

    /**
     * getBlackWon
     * @return blackWon TextShape
     */
    public TextShape getBlackWins()
    {
        return blackWins;
    }

}
