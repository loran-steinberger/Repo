import sofia.micro.*;
import java.util.*;

//-------------------------------------------------------------------------
/**
 *  Bishop Actor
 *  Bishops move diagonally until the end of the board or another piece.
 *
 *  @author Loran Steinberger (bkwrm215)
 *  @version (2012.12.09)
 */
public class Bishop extends Piece
{
    //~ Fields ................................................................
    

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Bishop object.
     * @param color true for white and false for black
     */
    public Bishop(boolean color)
    {
        super(color);
        if (color)
        {
            this.setImage("wb.png");
        }
        else
        {
            this.setImage("bb.png");
        }

        legalVectors.add(new int[] {-1, -1});
        legalVectors.add(new int[] {-1, 1}); 
        legalVectors.add(new int[] {1, -1}); 
        legalVectors.add(new int[] {1, 1});

    }

    //~ Methods ...............................................................

    
}
