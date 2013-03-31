import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  Rook Test
 *  Test the Rook methods
 *  @author Loran Steinberger (bkwrm215)
 *  @version (2012.12.10)
 */
public class RookTest extends TestCase
{
    //~ Fields ................................................................
    private Chessboard chessboard;
    private Rook rook;
    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new RookTest test object.
     */
    public RookTest()
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
        rook = new Rook(true);
        chessboard.add(rook, 4, 4);

    }

    // ----------------------------------------------------------
    /**
     * tests the Rook Constructor
     */
    public void testRookConstructor()
    {
        assertEquals(1, chessboard.getObjects(Rook.class).size());
    }
    
}
