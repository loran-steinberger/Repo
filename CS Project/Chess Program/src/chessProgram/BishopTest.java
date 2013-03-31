import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  Bishop Test
 *  Test the bishop's methods.
 *
 *  @author  Loran Steinberger (bkwrm215)
 *  @version (2012.12.10)
 */
public class BishopTest extends TestCase
{
    //~ Fields ................................................................

    private Chessboard chessboard;
    private Bishop bishop;
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new BishopTest test object.
     */
    public BishopTest()
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
        bishop = new Bishop(true);
        chessboard.add(bishop, 4, 4);

    }


    // ----------------------------------------------------------
    /**
     * tests the bishop's constructor
     */
    public void testBishopConstructor()
    {
        assertEquals(1, chessboard.getObjects(Bishop.class).size());
    }

}
