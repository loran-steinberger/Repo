import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  Queen Test
 *  tests the queen's methods
 *
 *  @author Loran Steinberger (bkwrm215)
 *  @version (2012.12.10)
 */
public class QueenTest extends TestCase
{
    //~ Fields ................................................................
    private Chessboard chessboard;
    private Queen queen;
    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new QueenTest test object.
     */
    public QueenTest()
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
        queen = new Queen(true);
        chessboard.add(queen, 4, 4);

    }

    // ----------------------------------------------------------
    /**
     * test queen constructor
     * tests the queen's constructor
     */
    public void testQueenConstructor()
    {
        assertEquals(1, chessboard.getObjects(Queen.class).size());
    }
}
