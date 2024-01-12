package model;
import view.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class ScoreTest {
    @Test
    public void testInitValue(){
        Score score = new Score();
        assertEquals("Initial value after instatiation should be set to zero", 0, score.getScore());
    }

    @Test
    public void testUpdate(){
        Score score = new Score();
        score.newScore(16);
        assertEquals("Current score should be updated to 16", 16, score.getScore());
    }

    @Test 
    public void testReset(){
        Score score = new Score();
        score.newScore(4);
        score.reset();
        assertEquals("Current score should be reset to 0", 0, score.getScore());
    }
}
