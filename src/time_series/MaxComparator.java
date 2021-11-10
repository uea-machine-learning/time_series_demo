package time_series;

import java.util.Comparator;

public class MaxComparator implements Comparator<TimeSeries> {
    @Override
    public int compare(TimeSeries x, TimeSeries y) {
        double max1=x.series[0],max2=y.series[0];
        for(int i=1;i<x.series.length;i++) {
            if(max1<x.series[i])
                max1=x.series[i];
            if(max2<y.series[i])
                max2=y.series[i];
        }
        int diff=0;
        if(max1<max2)
            diff=-1;
        else if(max1>max2)
            diff=1;

        return diff;
    }
}
