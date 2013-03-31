import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  Knight Test
 *  test the Knight's methods
 *
 *  @author Loran Steinberger (bkwrm215)
 *  @version (2012.12.10)
 */
public class KnightTest extends TestCase
{
    //~ Fields ................................................................
    private Chessboard chessboard;
    private Knight knight;
    private Rook rook;
    private Pawn pawn;
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new KnightTest test object.
     */
    public KnightTest()
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
        knight = new Knight(true);
        chessboard.add(knight, 4, 4);
        rook = new Rook(false);

    }

    // ----------------------------------------------------------
    /**
     * test Get Legal Moves
     * tests the knight's get legal moves method
     */
    public void testGetLegalMoves()
    {
        assertEquals(8, knight.getLegalMoves().size());

        knight.setGridLocation(0, 0);

        assertEquals(2, knight.getLegalMoves().size());

        chessboard.add(pawn, 2, 1);

        assertEquals(1, knight.getLegalMoves().size());

        chessboard.add(rook, 1, 2);

        assertEquals(1, knight.getLegalMoves().size());
    }

}
