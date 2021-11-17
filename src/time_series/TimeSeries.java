package time_series;

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
        double s1=0,s2=0;
        for(int i=0;i<this.series.length;i++) {
            s1 += this.series[i];
            s2 += o.series[i];
        }
        int diff=0;
        if(s1<s2)
            diff=-1;
        else if(s1>s2)
            diff=1;

        return diff;
    }
    @Override
    public String toString(){
        return series[0]+","+series[1];
    }
}
