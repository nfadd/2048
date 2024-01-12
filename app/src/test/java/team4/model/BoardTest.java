package model;

import view.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {
    public Board board;
    public BoardGUI gui;
	public int count;
    
    @Test
    public void setValueTest(){
        board = new Board();
        gui = new BoardGUI(board);
        board.setValue(8, 2, 1);
        assertTrue("Value should be 8", board.getValue(2,1) == 8);
    }

    @Test
    public void resetTest(){
        board = new Board();
        gui = new BoardGUI(board);
        board.setValue(2, 0, 1);
        board.setValue(4, 1, 1);
        board.setValue(8, 3, 2);
        board.setValue(16, 2, 0);
        board.reset();
        
        count = 0;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                count += board.getValue(i, j);
            }
        }
        assertEquals("The entire board value should be 0", 0, count);
    }

    @Test
    public void isEmptyTest(){
        board = new Board();
        gui = new BoardGUI(board);
        boolean flag = board.isEmpty();
        assertTrue("There should be no tiles present", flag);
    }

    @Test
    public void isFilledTest(){
        board = new Board();
        gui = new BoardGUI(board);
        board.setValue(2, 0, 0);
        board.setValue(4, 1, 0);
        board.setValue(8, 2, 0);
        board.setValue(16, 3, 0);
        board.setValue(2, 0, 1);
        board.setValue(4, 1, 1);
        board.setValue(8, 2, 1);
        board.setValue(16, 3, 1);
        board.setValue(2, 0, 2);
        board.setValue(4, 1, 2);
        board.setValue(8, 2, 2);
        board.setValue(16, 3, 2);
        board.setValue(2, 0, 3);
        board.setValue(4, 1, 3);
        board.setValue(8, 2, 3);
        board.setValue(16, 3, 3);

        boolean flag = board.isFilled();
        assertTrue("The board should be filled with tiles", flag);
    }

    @Test
    public void addTileWhenEmptyTest(){
        board = new Board();
        gui = new BoardGUI(board);
        board.addTile();

        count = 0;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(board.getValue(i, j) != 0){
                    count++;
                }
            }
        }
        assertEquals("There should be two tiles present at the start of the game", 2, count);
    }

    @Test
    public void addTileDuringTest(){
        board = new Board();
        gui = new BoardGUI(board);
        board.addTile();
        board.addTile();

        count = 0;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(board.getValue(i, j) != 0){
                    count++;
                }
            }
        }
        assertEquals("There should be three tiles present", 3, count);
    }
}
