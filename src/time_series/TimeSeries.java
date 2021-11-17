package time_series;

import week_7_demo.functors.Selector;

import java.util.Comparator;

public class TimeSeries implements Comparable<TimeSeries>{
    public double[] series;
    double max, min, mean, stDeviation, sum;

    public TimeSeries(double[] d){
        series =d;
        calculateStats();
    }
    final void calculateStats(){
        mean=stDeviation=sum=0;
        min=mean=series[0];
        for(double d:series){
            sum+=d;
            if(d<min)
                min=d;
            if(d>max)
                max=d;
        }
        mean=sum/series.length;
        for(int i=0;i<series.length;i++)
            stDeviation= (series[i]-mean)*(series[i]-mean);
        stDeviation/=(series.length-1);
    }
    double getMax(){ return max;}
    /**
     *
     * @param o othe time series
     * @return difference in sum between
     */
    @Override
    public int compareTo(TimeSeries o) {
        if(sum>o.sum)
            return 1;
        if(sum<o.sum)
            return -1;
        return 0;
    }
    @Override
    public String toString(){
        return series[0]+","+series[1];
    }

    public static class SumComparator implements Comparator<TimeSeries> {

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
    public static class MaxComparator implements Comparator<TimeSeries> {
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

    public static class MaxThresholdSelector implements Selector {
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

    public static void main(String[] args) {
        TimeSeries.MaxThresholdSelector max= new TimeSeries.MaxThresholdSelector(0);
    }

}
