package who_wants_to_be_a_millionaire;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author GGPC
 */
public class GameStateTest {
    
    public GameStateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // Test that QuestionNum is equal to zero on initialisation
    @Test
    public void testGetQuestionNum() {
        GameState instance = new GameState();
        int expResult = 0;
        int result = instance.getQuestionNum();
        assertEquals(expResult, result);
    }

    // Test that gameOver is false on initialisation
    @Test
    public void testIsGameOver() {
        GameState instance = new GameState();
        boolean expResult = false;
        boolean result = instance.isGameOver();
        assertEquals(expResult, result);
    }

    // Test that incrementQuestion correctly changes questionNum
    @Test
    public void testIncrementQuestion() {
        GameState instance = new GameState();
        instance.incrementQuestion();
        int expResult = 1;
        int result = instance.getQuestionNum();
        assertEquals(expResult, result);
    }

    // Test that winnings increase with correct questions
    @Test
    public void testGetCurrentWinnings() {
        GameState instance = new GameState();
        instance.incrementQuestion();
        instance.incrementQuestion();
        int expResult = 200;
        int result = instance.getCurrentWinnings();
        assertEquals(expResult, result);
    }

    // Test GetNextWinnings returns the next winnings level in the list
    @Test
    public void testGetNextWinnings() {
        GameState instance = new GameState();
        int expResult = 100;
        int result = instance.getNextWinnings();
        assertEquals(expResult, result);
    }


    // Test game is ended by SetGameOver
    @Test
    public void testSetGameOver() {
        GameState instance = new GameState();
        instance.setGameOver();
        boolean expResult = true;
        boolean result = instance.isGameOver();
        assertEquals(expResult, result);
    }

    // Test game is ended by WalkAway
    @Test
    public void testWalkAway() {
        GameState instance = new GameState();
        instance.walkAway();
        boolean expResult = true;
        boolean result = instance.isGameOver();
        assertEquals(expResult, result);
    }
    
}
