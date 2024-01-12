package model;

import view.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class MovesTest {

    @Test
    public void emptyColumnUpTest(){
        Board board = new Board();
        BoardGUI gui = new BoardGUI(board);
        ObservableScore score = new ObservableScore();
        Moves mover = new Moves(board, score);

        board.setValue(2, 3, 0);
        mover.up();
        
        assertEquals("The tile should have moved up to the top row", 2, board.getValue(0, 0));
    }

    @Test
    public void columnWithDifferentTileUpTest(){
        Board board = new Board();
        BoardGUI gui = new BoardGUI(board);
        ObservableScore score = new ObservableScore();
        Moves mover = new Moves(board, score);

        board.setValue(2, 3, 0);
        board.setValue(4, 0, 0);
        mover.up();
        
        assertEquals("The tile should have moved up to the second row", 2, board.getValue(1, 0));
    }

    @Test
    public void columnWithSameTileUpTest(){
        Board board = new Board();
        BoardGUI gui = new BoardGUI(board);
        ObservableScore score = new ObservableScore();
        Moves mover = new Moves(board, score);

        board.setValue(2, 3, 0);
        board.setValue(2, 0, 0);
        mover.up();
        
        assertEquals("The tiles should have moved up to the top row and joined together", 4, board.getValue(0, 0));
    }

    @Test
    public void emptyColumnDownTest(){
        Board board = new Board();
        BoardGUI gui = new BoardGUI(board);
        ObservableScore score = new ObservableScore();
        Moves mover = new Moves(board, score);

        board.setValue(2, 0, 0);
        mover.down();
        
        assertEquals("The tile should have moved up to the bottom row", 2, board.getValue(3, 0));
    }

    @Test
    public void columnWithDifferentTileDownTest(){
        Board board = new Board();
        BoardGUI gui = new BoardGUI(board);
        ObservableScore score = new ObservableScore();
        Moves mover = new Moves(board, score);

        board.setValue(4, 3, 0);
        board.setValue(2, 0, 0);
        mover.down();
        
        assertEquals("The tile should have moved down to the third row", 2, board.getValue(2, 0));
    }

    @Test
    public void columnWithSameTileDownTest(){
        Board board = new Board();
        BoardGUI gui = new BoardGUI(board);
        ObservableScore score = new ObservableScore();
        Moves mover = new Moves(board, score);

        board.setValue(2, 0, 0);
        board.setValue(2, 3, 0);
        mover.down();
        
        assertEquals("The tiles should have moved down to the bottom row and joined together", 4, board.getValue(3, 0));
    }

    @Test
    public void emptyRowLeftTest(){
        Board board = new Board();
        BoardGUI gui = new BoardGUI(board);
        ObservableScore score = new ObservableScore();
        Moves mover = new Moves(board, score);

        board.setValue(2, 0, 3);
        mover.left();
        
        assertEquals("The tile should have moved left to the first column", 2, board.getValue(0, 0));
    }

    @Test
    public void rowWithDifferentTileLeftTest(){
        Board board = new Board();
        BoardGUI gui = new BoardGUI(board);
        ObservableScore score = new ObservableScore();
        Moves mover = new Moves(board, score);

        board.setValue(2, 0, 3);
        board.setValue(4, 0, 0);
        mover.left();
        
        assertEquals("The tile should have moved left to the second column", 2, board.getValue(0, 1));
    }

    @Test
    public void rowWithSameTileLeftTest(){
        Board board = new Board();
        BoardGUI gui = new BoardGUI(board);
        ObservableScore score = new ObservableScore();
        Moves mover = new Moves(board, score);

        board.setValue(2, 0, 0);
        board.setValue(2, 0, 3);
        mover.left();
        
        assertEquals("The tiles should have moved left to the first column and joined together", 4, board.getValue(0, 0));
    }

    @Test
    public void emptyRowRightTest(){
        Board board = new Board();
        BoardGUI gui = new BoardGUI(board);
        ObservableScore score = new ObservableScore();
        Moves mover = new Moves(board, score);

        board.setValue(2, 0, 0);
        mover.right();
        
        assertEquals("The tile should have moved right to the first column", 2, board.getValue(0, 3));
    }

    @Test
    public void rowWithDifferentTileRightTest(){
        Board board = new Board();
        BoardGUI gui = new BoardGUI(board);
        ObservableScore score = new ObservableScore();
        Moves mover = new Moves(board, score);

        board.setValue(2, 0, 0);
        board.setValue(4, 0, 3);
        mover.right();
        
        assertEquals("The tile should have moved right to the second column", 2, board.getValue(0, 2));
    }

    @Test
    public void rowWithSameTileRightTest(){
        Board board = new Board();
        BoardGUI gui = new BoardGUI(board);
        ObservableScore score = new ObservableScore();
        Moves mover = new Moves(board, score);

        board.setValue(2, 0, 0);
        board.setValue(2, 0, 3);
        mover.right();
        
        assertEquals("The tiles should have moved right to the last column and joined together", 4, board.getValue(0, 3));
    }
}
