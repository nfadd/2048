package twentyfortyeight;
import model.*;
import view.*;
import controller.*;

import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Driver {
    public static void main(String args[]){
        ArrayList<String> scores = new ArrayList<String>();

        Board board = new Board();
        ObservableScore score = new ObservableScore();
        Leaderboard leaderboard = new Leaderboard();
        BoardGUI boardGUI = new BoardGUI(board);
        LeaderboardGUI leaderboardGUI = new LeaderboardGUI();
        mainScreenGUI ui = new mainScreenGUI(score, boardGUI, leaderboardGUI);
        Controller controller = new Controller(board, score, leaderboard, ui, boardGUI);
        
        boardGUI.setFocusable(true);
        boardGUI.requestFocusInWindow();
        boardGUI.addKeyListener(controller);


        WindowAdapter adapter = new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                try
                {
                    File outFile = new File("scores.txt"); 
                    outFile.createNewFile();
                    FileWriter myWriter = new FileWriter(outFile);
                    for(int j = 0; j < 5; j++){
                        myWriter.write(leaderboard.scores.get(j));
                        myWriter.write("\n");
                    }
                    myWriter.close();
                }catch(IOException exception){
                    exception.getMessage();
                }
            }
        };

        try{
            File myObj = new File("scores.txt");
            Scanner myReader = new Scanner(myObj);
            boolean bool = true;
            while (myReader.hasNextLine()){
                String data = myReader.nextLine();
                int i = Integer.parseInt(data);
                if(controller.getScore() > i && bool){
                    String newleader = String.valueOf(controller.getScore());
					scores.add(newleader);
					bool = false;
                }
                scores.add(data);
            }
            myReader.close();
        }catch (IOException e){
            e.getMessage();
        }
        ui.addOnCloseListener(adapter);

        ui.addNewGameListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    controller.startNewGame();
                    boardGUI.requestFocusInWindow();
                }
            }
        );

        ui.addLeaderboardListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    controller.showLeaderboard(leaderboardGUI);
                }
            }
        );

        ui.addBackListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    controller.showMainScreen(leaderboardGUI);
                    boardGUI.requestFocusInWindow();
                }
            }
        );
        
        controller.startNewGame();
        score.addScoreObserver(ui);
    }
}
