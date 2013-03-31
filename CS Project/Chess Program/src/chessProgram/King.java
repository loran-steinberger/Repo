import sofia.micro.*;
import java.util.*;
//-------------------------------------------------------------------------
/**
 *  King Actor
 *  Kings can move one space in any direction. 
 *  This piece must be captured to win the game.
 *
 *  @author Loran Steinberger (bkwrm215)
 *  @version (2012.12.09)
 */
public class King extends Piece
{
    //~ Fields ................................................................

    private ArrayList<int[]> legalMoves;

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new BlackKing object.
     * @param color true if white and false if black
     */
    public King(boolean color)
    {
        super(color);
        if (color)
        {
            this.setImage("wk.png");
        }
        else
        {
            this.setImage("bk.png");
        }
        legalVectors.add(new int[] {-1, -1}); 
        legalVectors.add(new int[] {-1, 0}); 
        legalVectors.add(new int[] {-1, 1}); 
        legalVectors.add(new int[] {0, -1}); 
        legalVectors.add(new int[] {0, 1}); 
        legalVectors.add(new int[] {1, -1}); 
        legalVectors.add(new int[] {1, 0}); 
        legalVectors.add(new int[] {1, 1});
        
        legalMoves = new ArrayList<int[]>();

    }

    //~ Methods ...............................................................

    /**
     * getLegalMoves method
     * @return gives ArrayList of int arrays containing the coordinate pairs
     * (delta x, delta y) of legal moves 
     */
    public ArrayList<int[]> getLegalMoves()
    {
        legalMoves.clear();

        for (int[] vector : this.getLegalVectors())
        {
            if ((this.getGridX() + vector[0] < 8) && 
                (this.getGridX() + vector[0] > -1) 
                && (this.getGridY() + vector[1] < 8) && 
                (this.getGridY() + vector[1] > -1))
            {
                if (this.getOneObjectAtOffset(vector[0], 
                    vector[1], Piece.class) == null)
                {
                    legalMoves.add(vector);
                }
                else if ((this.getOneObjectAtOffset(vector[0], vector[1], 
                        Piece.class).getIsWhite()) != this.getIsWhite())
                {
                    legalMoves.add(vector);
                }
                else
                {
                    continue;
                }
            }
        }
        return legalMoves;

    }


}
