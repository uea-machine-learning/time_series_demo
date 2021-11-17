package time_series;

public class TimeSeriesCollection {
//No checking of overflow, no validation etc etc
    TimeSeries[] ts;
    int currentSize=0;
    public TimeSeriesCollection(){
        ts= new TimeSeries[50];
    }
    public void addTimeSeries(TimeSeries t){
        ts[currentSize++]=t;
    }


}
