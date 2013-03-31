import sofia.micro.*;
import java.util.*;
//-------------------------------------------------------------------------
/**
 *  Pawn Actor
 * Pawns move one space, attack diagonally forward, and can move two spaces
 * forward on their first move.
 * Reach  the opposite side of the board to promote your pawn to a queen.
 *
 *  @author Loran Steinberger (bkwrm215)
 *  @version (2012.12.06)
 */
public class Pawn extends Piece
{
    //~ Fields ................................................................

    private ArrayList<int[]> legalMoves;
    private Queen queen;
    private Piece offsetObject;

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new Pawn object.
     * @param color true if white and false if black
     */
    public Pawn(boolean color)
    {
        super(color);
        if (color)
        {
            this.setImage("wp.png");
        }
        else
        {
            this.setImage("bp.png");
        }

        legalVectors.add(new int[] {0, 1}); 
        legalVectors.add(new int[] {0, -1}); 
        legalVectors.add(new int[] {1, 1}); 
        legalVectors.add(new int[] {1, -1}); 
        legalVectors.add(new int[] {-1, 1}); 
        legalVectors.add(new int[] {-1, -1});
        queen = new Queen(color);

        legalMoves = new ArrayList<int[]>();
    }

    //~ Methods ...............................................................
    /**
     * act Method for pawn
     * checks for reaching the opposite side of the board, and automatically 
     * promotes the pawn to a queen.
     */
    public void act()
    {
        if ((this.getGridY() == 0) || (this.getGridY() == 7))
        {
            this.getWorld().add(queen, this.getGridX(), this.getGridY());
            this.remove();
        }
    }

    /**
     * get Legal Moves
     * returns an arraylist of legal moves
     * @return legalMoves for this pawn's location
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
                offsetObject = this.getOneObjectAtOffset(vector[0], 
                    vector[1], Piece.class);
                if ((((vector[0] == 0) && (offsetObject == null)) 
                    || ((vector[0] != 0) && (offsetObject != null) && 
                    (offsetObject.getIsWhite() != this.getIsWhite()))) &&  
                    (((this.getIsWhite()) && (vector[1] < 0)) 
                    || ((!this.getIsWhite()) && (vector[1] > 0))) )
                {
                    legalMoves.add(vector);
                }
            }
        }
        if ((this.getIsWhite()) && (this.getGridY() == 6) && 
            (this.getOneObjectAtOffset(0, -2, Piece.class) == null))
        {
            legalMoves.add(new int[] {0, -2});
        }
        else if ((!this.getIsWhite()) && (this.getGridY() == 1) && 
            (this.getOneObjectAtOffset(0, 2, Piece.class) == null))
        {
            legalMoves.add(new int[] {0, 2});
        }
        return legalMoves;
    }

}
