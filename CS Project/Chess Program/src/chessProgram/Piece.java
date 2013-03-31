import sofia.micro.*;
import java.util.*;

//-------------------------------------------------------------------------
/**
 *  Piece Actor
 *  contains methods pertinent to all chess pieces
 *
 *  @author Loran Steinberger (bkwrm215)
 *  @version (2012.12.03)
 */
public class Piece extends Actor
{
    //~ Fields ................................................................

    private boolean isWhite;
    private Glow glow;
    private boolean isActive;
    private ArrayList<int[]> legalMoves;
    /**
     * legalVectors
     * will be overwritten by every chess piece upon construction.
     */
    public ArrayList<int[]> legalVectors;

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new Piece object.
     * @param color true if white and false if black.
     * 
     */
    public Piece(boolean color)
    {
        isWhite = color;
        isActive = false;
        legalVectors = new ArrayList<int[]>();
    }
    //~ Methods ...............................................................
    /**
     * onTap
     * called when user touches a piece.
     */
    public void onTap()
    {
        if (((this.getIsWhite()) && 
            (((Chessboard)(this.getWorld())).getWhiteTurn())) || 
            ((!this.getIsWhite()) && 
            (!((Chessboard)this.getWorld()).getWhiteTurn())))
        {

            if (!this.getIsActive())
            {
                this.showLegalMoves();
                this.setIsActive(true);
            }
            else 
            {
                for (Glow oldGlow : this.getWorld().getObjects(Glow.class))
                {
                    oldGlow.remove();
                    this.setIsActive(false);
                }
            }   

        }
    }      

    /**
     * showLegalMoves
     * adds glow actors to squares that are valid moves
     * after a piece as been selected by user.
     * 
     * 
     */
    public void showLegalMoves()
    {

        for (int[] legalMove : this.getLegalMoves())
        {
            glow = new Glow(this);
            this.getWorld().add(glow, this.getGridX() + legalMove[0], 
                this.getGridY() + legalMove[1]);
        }

    }

    /**
     * get Legal Moves
     * given legal vectors, finds legal moves for a specific piece.
     * @return returns all legal moves for the piece at this location
     * 
     */
    public ArrayList<int[]> getLegalMoves()
    {
        legalMoves = new ArrayList<int[]>();

        for (int[] vector : this.getLegalVectors())
        {
            for (int i = 1; i < 8; i++)
            {
                if ((this.getGridX() + i * vector[0] < 8) && 
                    (this.getGridX() + i * vector[0] > -1) && 
                    (this.getGridY() + i * vector[1] < 8) && 
                    (this.getGridY() + i * vector[1] > -1))
                {
                    if (this.getOneObjectAtOffset(i * vector[0], i * 
                        vector[1], Piece.class) == null)
                    {
                        legalMoves.add(new int[] {vector[0] * i, 
                            vector[1] * i});
                    }
                    else if ((this.getOneObjectAtOffset(i * vector[0], i * 
                        vector[1], Piece.class).getIsWhite()) != 
                        this.getIsWhite())
                    {
                        legalMoves.add(new int[] {vector[0] * i, 
                            vector[1] * i});
                        break;
                    }
                    else
                    {
                        break;
                    }
                }
            }
        }
        return legalMoves;
    }


    /**
     * get Is White
     * @return true if a piece is white 
     * and false if a piece is black
     */
    public boolean getIsWhite()
    {
        return isWhite;
    }

    /**
     * get Is Active
     * activation is dependent on has a piece been touched by 
     * a user, and are its legal moves displayed on the board.
     * @return true if activated and false if inactivated.
     */
    public boolean getIsActive()
    {
        return isActive;
    }

    /**
     * getLegalVectors
     * @return all possible legal vectors for this piece
     */
    public ArrayList<int[]> getLegalVectors()
    {
        return legalVectors;
    }

    /**
     * set Is Active
     * @param activity true if active and false if inactive.
     */
    public void setIsActive(boolean activity)
    {
        isActive = activity;
    }
}
