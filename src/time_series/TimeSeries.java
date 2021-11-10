package time_series;

public class TimeSeries implements Comparable<TimeSeries>{
    double[] series;
    int classValue; //values 0== negative, 1 == positive
    String patientName;
    public TimeSeries(double[] d){
        series =d;
    }

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
