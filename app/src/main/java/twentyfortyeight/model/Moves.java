package model;

public class Moves {
    Board board;
    ObservableScore score;

    int value;
    int result;

    public Moves(Board board, ObservableScore score){
        this.board = board;
        this.score = score;
    }
    
    public boolean up(){
        for(int col = 0; col < 4; col++){
            result = 0;
            for(int row = 1; row < 4; row++){
                if(result == row || board.getValue(row, col) == 0){
                    continue;
                }else if(board.getValue(row, col) == board.getValue(result, col)){
                    value = board.getValue(result, col);
                    board.setValue(value * 2, result, col);
                    board.setValue(0, row, col);
                    score.newScore(value * 2);
                    if(board.checkForWin()){
                        return true;
                    }
                    result++;
                }else{
                    if(board.getValue(result, col) != 0){
                        result++;
                    }
                    if(result != row){
                        value = board.getValue(row, col);
                        board.setValue(value, result, col);
                        board.setValue(0, row, col);
                    }
                }
            }
        }
        board.update();
        return false;
    }

    public boolean down(){
        for(int col = 0; col < 4; col++){
            result = 3;
            for(int row = 3; row >= 0; row--){
                if(result == row || board.getValue(row, col) == 0){
                    continue;
                }else if(board.getValue(row, col) == board.getValue(result, col)){
                    value = board.getValue(result, col);
                    board.setValue(value * 2, result, col);
                    board.setValue(0, row, col);
                    score.newScore(value * 2);
                    if(board.checkForWin()){
                        return true;
                    }
                    result--;
                }else{
                    if(board.getValue(result, col) != 0){
                        result--;
                    }
                    if(result != row){
                        value = board.getValue(row, col);
                        board.setValue(value, result, col);
                        board.setValue(0, row, col);
                    }
                }
            }
        }
        board.update();
        return false;
    }

    public boolean left(){
        for(int row = 0; row < 4; row++){
            result = 0;
            for(int col = 1; col < 4; col++){
                if(result == col || board.getValue(row, col) == 0){
                    continue;
                }else if(board.getValue(row, col) == board.getValue(row, result)){
                    value = board.getValue(row, result);
                    board.setValue(value * 2, row, result);
                    board.setValue(0, row, col);
                    score.newScore(value * 2);
                    if(board.checkForWin()){
                        return true;
                    }
                    result++;
                }else{
                    if(board.getValue(row, result) != 0){
                        result++;
                    }
                    if(result != col){
                        value = board.getValue(row, col);
                        board.setValue(value, row, result);
                        board.setValue(0, row, col);
                    }
                }
            }
        }
        board.update();
        return false;
    }

    public boolean right(){
        for(int row = 0; row < 4; row++){
            result = 3;
            for(int col = 3; col >= 0; col--){
                if(result == col || board.getValue(row, col) == 0){
                    continue;
                }else if(board.getValue(row, col) == board.getValue(row, result)){
                    value = board.getValue(row, result);
                    board.setValue(value * 2, row, result);
                    board.setValue(0, row, col);
                    score.newScore(value * 2);
                    if(board.checkForWin()){
                        return true;
                    }
                    result--;
                }else{
                    if(board.getValue(row, result) != 0){
                        result--;
                    }
                    if(result != col){
                        value = board.getValue(row, col);
                        board.setValue(value, row, result);
                        board.setValue(0, row, col);
                    }
                }
            }
        }
        board.update();
        return false;
    }
}