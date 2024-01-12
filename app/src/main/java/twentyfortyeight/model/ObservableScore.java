package model;

import java.util.ArrayList;

public class ObservableScore extends Score
{
    protected ArrayList<ScoreObserver> observers;

    public ObservableScore()
    {
        super();
        this.observers = new ArrayList<ScoreObserver>();
    }

    public void addScoreObserver(ScoreObserver observer)
    {
       this.observers.add(observer);
       observer.update(this.iterator());
    }

    public void notifyObservers()
    {
       for(ScoreObserver observer: this.observers)
       {
          observer.update(this.iterator());
       }
    }

    @Override 
    public void newScore(int value)
    {
        super.newScore(value);
        notifyObservers();
    }

    @Override 
    public void reset()
    {
        super.reset();
        notifyObservers();
    }
}
