package time_series;

import java.util.Iterator;

public class TSIterator<TimeSeries> implements Iterator<TimeSeries> {

    TimeSeriesCollection collection;

    public TSIterator(TimeSeriesCollection s){
        collection = s;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public TimeSeries next() {
        return null;
    }
}
