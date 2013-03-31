import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  Pawn Test
 *  tests the pawn's methods
 *
 *  @author Loran Steinberger (bkwrm215)
 *  @version (2012.12.10)
 */
public class PawnTest extends TestCase
{
    //~ Fields ................................................................
    private Chessboard chessboard;
    private Pawn pawn;
    private Knight knight;
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new PawnTest test object.
     */
    public PawnTest()
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
        knight = new Knight(false);
        chessboard.clearBoard();
        pawn = new Pawn(true);
        chessboard.add(pawn, 4, 4);

    }

    // ----------------------------------------------------------
    /**
     * test Act
     * tests the pawn's act method
     */
    public void testAct()
    {
        pawn.act();
        assertEquals(0, chessboard.getObjects(Queen.class).size());
        
        pawn.setGridLocation(3, 7);
        pawn.act();
        
        assertEquals(1, chessboard.getObjects(Queen.class).size());
    }
    
    /**
     * tests the pawn's get Legal Moves method
     */
    public void testGetLegalMoves()
    {
        assertEquals(1, pawn.getLegalMoves().size());
        
        pawn.setGridLocation(0, 6);
        chessboard.add(knight, 1, 5);
        
        assertEquals(3, pawn.getLegalMoves().size());
    }

}
