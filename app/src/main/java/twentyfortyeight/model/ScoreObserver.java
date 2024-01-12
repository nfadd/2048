package model;

import java.util.Iterator;

public interface ScoreObserver
{
   public void update(Iterator<Integer> scoreIterator);
}
