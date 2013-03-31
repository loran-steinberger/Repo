import sofia.micro.*;
import java.util.*;
import sofia.graphics.*;

// -------------------------------------------------------------------------
/**
 * ChessBoardTest
 *  Tests the Chessboard World.
 *
 *  @author Loran Steinberger (bkwrm215)
 *  @version (2012.12.10)
 */
public class ChessboardTest extends TestCase
{
    //~ Fields ................................................................
    private Chessboard chessboard;
    private King wKing;
    private King bKing;
    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new ChessboardTest test object.
     */
    public ChessboardTest()
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
        wKing = new King(true);
        bKing = new King(false);
    }

    // ----------------------------------------------------------
    /**
     * tests the chessboard's act method
     */
    public void testAct()
    {
        chessboard.act();

        assertEquals("Two Player Chess", chessboard.getTitle().getText());

        chessboard.add(wKing, 4, 4);

        chessboard.act();
        assertEquals("GAME OVER", chessboard.getEndTitle().getText());

    }

    /**
     * tests the chessboard's clearBoard method
     */
    public void testClearBoard()
    {
        chessboard.add(wKing, 4, 4);
        chessboard.clearBoard();

        assertEquals(0, chessboard.getObjects().size());
    }

    /**
     * tests the chessboard's started method
     */
    public void testStarted()
    {
        chessboard = new Chessboard();

        chessboard.started();

        assertEquals(32, chessboard.getObjects().size());
    }

    /**
     * tests the chessboard's stopped method
     */
    public void testStopped()
    {
        chessboard.add(wKing, 4, 4);
        chessboard.add(bKing, 5, 5);

        chessboard.stopped();

        assertEquals("Two Player Chess", chessboard.getTitle().getText());

        bKing.remove();

        chessboard.stopped();

        assertEquals("White Wins!", chessboard.getWhiteWins().getText());

        chessboard.add(bKing, 5, 5);
        wKing.remove();

        chessboard.stopped();
        assertEquals("Black Wins!", chessboard.getBlackWins().getText());
    }

    /**
     * tests the chessboard's getWhiteTurn method
     */
    public void testGetWhiteTurn()
    {
        assertTrue(chessboard.getWhiteTurn());
    }

    /**
     * tests the chessboard's get Title method
     */
    public void testGetTitle()
    {
        assertEquals("Two Player Chess", chessboard.getTitle().getText());
    }

    /**
     * tests the chessboard's get EndTitle method
     */
    public void testGetEndTitle()
    {
        assertEquals("GAME OVER", chessboard.getEndTitle().getText());
    }
    
    /**
     * tests the chessboard's get WhiteWon method
     */
    public void testGetWhiteWins()
    {
        assertEquals("White Wins!", chessboard.getWhiteWins().getText());
    }
    
    /**
     * tests the chessboard's get BlackWon method
     */
    public void testGetBlackWins()
    {
        assertEquals("Black Wins!", chessboard.getBlackWins().getText());
    }
}
