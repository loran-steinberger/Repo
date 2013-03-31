import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  King Test
 *  Tests the King methods
 *
 *  @author Loran Steinberger (bkwrm215)
 *  @version (2012.12.10)
 */
public class KingTest extends TestCase
{
    //~ Fields ................................................................
    private King king;
    private Chessboard chessboard;
    private Pawn pawn;
    private Rook rook;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new KingTest test object.
     */
    public KingTest()
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
        pawn = new Pawn(true);
        chessboard.clearBoard();
        king = new King(true);
        chessboard.add(king, 4, 4);
        rook = new Rook(false);
    }

    // ----------------------------------------------------------

    /**
     * testGetLegalMoves
     * tests the King's get legal moves method
     */
    public void testGetLegalMoves()
    {
        assertEquals(8, king.getLegalMoves().size());

        king.setGridLocation(0, 0);

        assertEquals(3, king.getLegalMoves().size());

        chessboard.add(pawn, 0, 1);

        assertEquals(2, king.getLegalMoves().size());

        chessboard.add(rook, 1, 1);

        assertEquals(2, king.getLegalMoves().size());

    }
}
