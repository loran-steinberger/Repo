import sofia.micro.*;
import java.util.*;

//-------------------------------------------------------------------------
/**
 *  Knight Actor
 *  Knights move in L shapes, of every possible orientation.
 *
 *  @author Loran Steinberger (bkwrm215)
 *  @version (2012.12.09)
 */
public class Knight extends Piece
{
    //~ Fields ................................................................

    private ArrayList<int[]> legalMoves;

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new Knight object.
     * @param color true if white and false if black
     */
    public Knight(boolean color)
    {
        super(color);
        if (color)
        {
            this.setImage("wn.png");
        }
        else
        {
            this.setImage("bn.png");
        }
        legalVectors.add(new int[] {-2, -1});
        legalVectors.add(new int[] {-2, 1}); 
        legalVectors.add(new int[] {-1, -2});
        legalVectors.add(new int[] {-1, 2}); 
        legalVectors.add(new int[] {1, -2}); 
        legalVectors.add(new int[] {1, 2}); 
        legalVectors.add(new int[] {2, -1}); 
        legalVectors.add(new int[] {2, 1});
        
        legalMoves = new ArrayList<int[]>();

    }

    //~ Methods ...............................................................
    /**
     * getLegalMoves 
     * 
     * @return legalMoves for the knight at this location.
     * 
     */
    public ArrayList<int[]> getLegalMoves()
    {
        legalMoves.clear();

        for (int[] vector : this.getLegalVectors())
        {
            if ((this.getGridX() + vector[0] < 8) && 
                (this.getGridX() + vector[0] > -1) && 
                (this.getGridY() + vector[1] < 8) && 
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
