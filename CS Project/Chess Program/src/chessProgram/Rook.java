import sofia.micro.*;
import java.util.*;

//-------------------------------------------------------------------------
/**
 *  Rook Piece
 *  Moves Left, Up, Down, and Right any number of squares.
 *
 *  @author Loran Steinberger (bkwrm215)
 *  @version (2012.12.07)
 */
public class Rook extends Piece
{
    //~ Fields ................................................................
    

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new Rook object.
     * @param color true if white and false if black
     */
    public Rook(boolean color)
    {
        super(color);
        if (color)
        {
            this.setImage("wr.png");
        }
        else
        {
            this.setImage("br.png");
        }
        legalVectors.add(new int[] {-1, 0}); 
        legalVectors.add(new int[] {0, -1}); 
        legalVectors.add(new int[] {0, 1}); 
        legalVectors.add(new int[] {1, 0});

    }

    //~ Methods ...............................................................


}
