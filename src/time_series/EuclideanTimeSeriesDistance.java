package time_series;

public class EuclideanTimeSeriesDistance implements TimeSeriesDistance{
    @Override
    public double distance(TimeSeries x, TimeSeries y) {
        double d=0;
        for(int i=0;i<x.series.length;i++)
            d+=(x.series[i]-y.series[i])*(x.series[i]-y.series[i]);
        return Math.sqrt(d);
    }
}
