package view;
import model.*;

import javax.swing.*;
import java.awt.*;

public class BoardGUI extends JPanel{
    public Board board;

    public BoardGUI(Board board){
        this.board = board;

        this.setLayout(new GridLayout(board.row, board.col));
        board.nums = new Tile[board.row][board.col];

        for(int i = 0; i < board.row; i++){
            for(int j = 0; j < board.col; j++){
                board.nums[i][j] = new Tile(0);
                this.add(board.nums[i][j]);
            }
        }
    }
}
