package time_series;

import java.sql.Time;
import java.util.Iterator;

public class TimeSeriesCollection implements Iterable{
//No checking of overflow, no validation etc etc
    TimeSeries[] ts;
    int currentSize=0;
    public TimeSeriesCollection(){
        ts= new TimeSeries[50];
    }
    public void addTimeSeries(TimeSeries t){
        ts[currentSize++]=t;
    }


    @Override
    public Iterator iterator() {
        return new TimeSeriesCollectionIterator();
    }

    public class TimeSeriesCollectionIterator implements Iterator {
        int currentPos=0;

        public TimeSeriesCollectionIterator(){
            currentPos=0;
        }

        @Override
        public boolean hasNext() {
            return currentPos<currentSize;
        }

        @Override
        public Object next() {
            return ts[currentPos++];
        }
    }


}
