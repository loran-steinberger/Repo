import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  Glow Actor
 *  Highlights cells that are legal moves.
 *
 *  @author Loran Steinberger (bkwrm215)
 *  @version (2012.12.09)
 */
public class Glow extends Actor
{
    //~ Fields ................................................................

    private Piece piece;
    

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Glow object.
     * @param parentPiece stores the Piece the glow is
     * associated with.
     */
    public Glow(Piece parentPiece)
    {
        piece = parentPiece;
    }

    //~ Methods ...............................................................

    /**
     * onTap method
     * called when the user touches a glow actor.
     */
    public void onTap()
    {
        // inactivate pieces 
        for (Piece otherPiece : this.getWorld().getObjects(Piece.class))
        {
            otherPiece.setIsActive(false);
        }
        
        //capture if needed
        if (this.getWorld().getObjectsAt(this.getGridX(), 
            this.getGridY(), Piece.class) != null)
        {
            for (Piece otherPiece : this.getWorld().getObjectsAt
            (this.getGridX(), this.getGridY(), Piece.class))
            {
                otherPiece.remove();
            }

        }
        // move piece to new location
        piece.setGridLocation(this.getGridX(), this.getGridY());

        // remove glows
        for (Glow glow : this.getWorld().getObjects(Glow.class))
        {
            glow.remove();
        }

        
        //see if any king is in check??

        //cycle turn
        Chessboard board = ((Chessboard)piece.getWorld());
        board.setWhiteTurn(!board.getWhiteTurn());

    }

}
