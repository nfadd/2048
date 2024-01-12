package model;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;
import java.io.*;
import java.net.URL;

public class LeaderboardTest {
    private Leaderboard leaderboard;
    private File file;
    private String compare;
    
	@Test  // original leaderTest is 1000, 500, 250, 125, 50
	public void leaderboardCalcTest(){
		leaderboard = new Leaderboard();
		leaderboard.leaderboardCalculation(99999, "leaderTest.txt");
		try {
			File file = new File("leaderTest.txt");
			BufferedReader br = new BufferedReader(new FileReader(file)); 
				
			compare = br.readLine();
			
			int textVal= Integer.parseInt(compare);
			assertEquals("Error: leaderboard was not updated", 99999, textVal);
		}
		catch (IOException e){
			e.getMessage();
		}
		
	}
		
	 
}
