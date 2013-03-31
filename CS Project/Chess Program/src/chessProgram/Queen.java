import sofia.micro.*;
import java.util.*;

//-------------------------------------------------------------------------
/**
 *  Queen Piece
 *  The Queen moves diagonally and straight in 8 different directions.
 *
 *  @author Loran Steinberger (bkwrm215)
 *  @version (2012.12.08)
 */
public class Queen extends Piece
{
    //~ Fields ................................................................


    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new Queen object.
     * @param color true if white and false if black
     */
    public Queen(boolean color)

    {
        super(color);
        if (color)
        {
            this.setImage("wq.png");
        }
        else
        {
            this.setImage("bq.png");
        }

        legalVectors.add(new int[] {-1, -1});
        legalVectors.add(new int[] {-1, 0});
        legalVectors.add(new int[] {-1, 1}); 
        legalVectors.add(new int[] {0, -1}); 
        legalVectors.add(new int[] {0, 1});
        legalVectors.add(new int[] {1, -1}); 
        legalVectors.add(new int[] {1, 0}); 
        legalVectors.add(new int[] {1, 1});

    }
    //~ Methods ...............................................................

}
