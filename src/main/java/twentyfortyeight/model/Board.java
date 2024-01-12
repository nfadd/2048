package model;

import view.*;

import java.util.Random;

public class Board {
    public final int row = 4;
    public final int col = 4;
    
    public Tile nums[][];

    public int getValue(int row, int col){
        return nums[row][col].getValue();
    }

    public void setValue(int value, int row, int col){
        nums[row][col].setValue(value);
        this.update();
    }

    public void update(){
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                nums[i][j].repaint();
            }
        }
    }
    
    public void reset(){
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                nums[i][j].setValue(0);
                this.update();
            }
        }
    }

    public boolean addTile(){
        Random random = new Random();

        int tempRow = random.nextInt(row);
        int tempCol = random.nextInt(col);

        if(this.isFilled()){
            return false;
        }

        if(this.isEmpty()){
            nums[tempRow][tempCol].setValue(2);
        }

        int percent = random.nextInt(100);
        if(nums[tempRow][tempCol].getValue() == 0){
            if(percent < 80){
                nums[tempRow][tempCol].setValue(2);
            }else{
                nums[tempRow][tempCol].setValue(4);
            }
        }else{
            this.addTile();
        }

        return true;
    }

    public boolean isEmpty(){
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(nums[i][j].getValue() != 0){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isFilled(){
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(nums[i][j].getValue() == 0){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkForWin(){
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(nums[i][j].getValue() == 2048){
                    return true;
                }
            }
        }
        return false;
    }
}
