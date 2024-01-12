package model;

import java.util.ArrayList;
import java.util.Iterator;

public class Score implements Iterable<Integer>{

    private ArrayList<Integer> scores;
    public int currentScore;

    public Score(){
        scores = new ArrayList<Integer>();
        currentScore = 0;
    }

    public int getScore(){
        return currentScore;
    }

    public void newScore(int value){
        currentScore += value;
    }

    public void reset(){
        currentScore = 0;
    }

    @Override 
    public Iterator<Integer> iterator(){
        scores.add(currentScore);
        return scores.iterator();
    }
}