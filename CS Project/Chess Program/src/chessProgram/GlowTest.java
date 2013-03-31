import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  GlowTest
 *  Tests the glow actor's methods
 *
 *  @author Loran Steinberger (bkwrm215)
 *  @version (2012.12.10)
 */
public class GlowTest extends TestCase
{
    //~ Fields ................................................................
    private Chessboard chessboard;
    private Glow glow;
    
    private Knight knight;
    private Pawn pawn;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new GlowTest test object.
     */
    public GlowTest()
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
        knight = new Knight(true);
        glow = new Glow(knight);
        
        pawn = new Pawn(false);
        chessboard.add(glow, 4, 4);
        chessboard.add(knight, 2, 3);
        chessboard.add(pawn, 4, 4);

    }

    // ----------------------------------------------------------
    /**
     * test On Tap method
     * tests the glow's on tap method
     */
    public void testOnTap()
    {
        glow.onTap();

        assertEquals(0, chessboard.getObjects(Pawn.class).size());

        assertEquals(4, knight.getGridX());
        assertEquals(4, knight.getGridY());

        assertEquals(0, chessboard.getObjects(Glow.class).size());

        assertFalse(knight.getIsActive());

        assertFalse(chessboard.getWhiteTurn());
       
        chessboard.add(glow, 2, 3);
        
        
        glow.onTap();
        
        assertEquals(2, pawn.getGridX());
        assertEquals(3, pawn.getGridY());
    }
}
