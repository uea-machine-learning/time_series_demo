package time_series;

import week_7_demo.functors.Selector;

/**
 * Class to select time series where the max value is above a certain threshold
 */
public class MaxThresholdSelector implements Selector {
    double threshold=0;
    public MaxThresholdSelector(){}
    public MaxThresholdSelector(double m){threshold = m;}

    @Override
    public boolean select(Object o) {
        if(!(o instanceof TimeSeries))
            throw new RuntimeException("ERROR, passed a non time series of type "+o.getClass().getSimpleName());
        TimeSeries t = (TimeSeries)o;
        if(t.getMax()>threshold)
            return true;
        return false;
    }
}
