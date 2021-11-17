package time_series;

import java.util.Comparator;

public class SumComparator implements Comparator<TimeSeries> {

    //Breaks encapsulation
    @Override
    public int compare(TimeSeries x, TimeSeries y) {
        double s1=0,s2=0;
        for(int i=0;i<x.series.length;i++) {
            s1 += x.series[i];
            s2 += y.series[i];
        }
        int diff=0;
        if(s1<s2)
            diff=-1;
        else if(s1>s2)
            diff=1;

        return diff;
    }
}
