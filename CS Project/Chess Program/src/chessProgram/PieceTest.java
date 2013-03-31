import sofia.micro.*;
import java.util.*;

// -------------------------------------------------------------------------
/**
 *  Piece Test
 *  Tests the Piece methods
 *
 *  @author Loran Steinberger (bkwrm215)
 *  @version (2012.12.08)
 */
public class PieceTest extends TestCase
{
    //~ Fields ................................................................
    private Chessboard chessboard;
    private Queen wQueen;
    private Queen bQueen;
    private Pawn pawn;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new PieceTest test object.
     */
    public PieceTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }

    //~ Methods ...............................................................
    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        chessboard = new Chessboard();
        chessboard.clearBoard();
        wQueen = new Queen(true);
        bQueen = new Queen(false);
        chessboard.add(wQueen, 4, 4);
        pawn = new Pawn(true);
    }

    // ----------------------------------------------------------
    /**
     * tests the piece's show legal moves method
     */
    public void testShowLegalMoves()
    {
        wQueen.showLegalMoves();

        assertEquals(27, chessboard.getObjects(Glow.class).size());
    }

    /**
     * tests the piece's get legal moves method
     */
    public void testGetLegalMoves()
    {
        assertEquals(27, wQueen.getLegalMoves().size());
        
        chessboard.add(bQueen, 4, 3);
        
        assertEquals(24, wQueen.getLegalMoves().size());
        
        chessboard.add(pawn, 3, 3);
        
        assertEquals(20, wQueen.getLegalMoves().size());

    }

    /**
     * tests the piece's get is white method
     */
    public void testGetIsWhite()
    {
        assertTrue(wQueen.getIsWhite());
    }

    /**
     * test on tap
     * tests the piece's on tap method
     */
    public void testOnTap()
    {
        wQueen.onTap();

        assertEquals(27, chessboard.getObjects(Glow.class).size());

        wQueen.setIsActive(true);

        wQueen.onTap();

        assertEquals(0, chessboard.getObjects(Glow.class).size());

        chessboard.add(bQueen, 2, 6); 

        bQueen.onTap();

        assertEquals(0, chessboard.getObjects(Glow.class).size());

    }

    /**
     * test Get Legal Vectors
     * tets the rook's getLegalVectors method.
     */
    public void testGetLegalVectors()
    {
        assertNotNull(wQueen.getLegalVectors());
    }

}
