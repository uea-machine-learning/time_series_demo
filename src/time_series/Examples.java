package time_series;

import time_series.distances.Distance;
import time_series.distances.EuclideanDistance;
import time_series.distances.EuclideanTimeSeriesDistance;
import time_series.distances.TimeSeriesDistance;

import java.util.Comparator;

public class Examples {
    static double[] randomTimeSeries(int n){
        double[] ts= new double[n];
        for(int i=0;i<n;i++)
            ts[i] = Math.random();
        return ts;
    }
    static double[][] randomSetOfTimeSeries(int m, int n){
        double[][] ts= new double[m][];
        for(int i=0;i<m;i++)
            ts[i] = randomTimeSeries(n);
        return ts;
    }
    static double distance(double[] x, double[] y){
        double d=0;
        for(int i=0;i<x.length;i++)
            d+=(x[i]-y[i])*(x[i]-y[i]);
        return Math.sqrt(d);

    }
    static public double minimumDistance(double[][] data, double[] query, Distance dist){
        double minSoFar = distance(data[0],query);
        for(int i=1;i<data.length;i++){
            double temp = dist.distance(data[i],query);
            if(temp<minSoFar)
                minSoFar=temp;
        }
        return minSoFar;
    }
    static public double minimumDistance(TimeSeries[] data, TimeSeries query, TimeSeriesDistance dist){
        double minSoFar = dist.distance(data[0],query);
        for(int i=1;i<data.length;i++){
            double temp = dist.distance(data[i],query);
            if(temp<minSoFar)
                minSoFar=temp;
        }
        return minSoFar;
    }
    static public TimeSeries minimumTimeSeries(TimeSeries[] data){
        TimeSeries minSoFar = data[0];
        for(int i=1;i<data.length;i++){
            if(minSoFar.compareTo(data[i])>0)
                minSoFar=data[i];
        }
        return minSoFar;
    }
    static public TimeSeries minimumTimeSeries(TimeSeries[] data, Comparator<TimeSeries> cmp){
        TimeSeries minSoFar = data[0];
        for(int i=1;i<data.length;i++){
            if(cmp.compare(minSoFar,data[i])>0)
                minSoFar=data[i];
        }
        return minSoFar;
    }

    public static void week7LiveDemo(){
        double[] query = randomTimeSeries(100);
        double[][] database = randomSetOfTimeSeries(50,100);
        double minDist = minimumDistance(database,query, new EuclideanDistance());
        System.out.println(" Min Euclidean distance = "+minDist);
        minDist = minimumDistance(database,query, new ManhattanDistance());
        System.out.println(" Min Manhattan distance = "+minDist);

        TimeSeries[] ts = new TimeSeries[50];
        for(int i=0;i<50;i++){
            ts[i] = new TimeSeries(database[i]);
        }
        TimeSeries tsQuery=new TimeSeries(query);
        EuclideanTimeSeriesDistance ed = new EuclideanTimeSeriesDistance();
        minDist = minimumDistance(ts,tsQuery,ed);
        System.out.println(" Min ED distance = "+minDist);
        TimeSeries min= minimumTimeSeries(ts);
        System.out.println("min series = "+min);
        min= minimumTimeSeries(ts, new SumComparator());
        System.out.println("min series = "+min);
        min= minimumTimeSeries(ts, new MaxComparator());
        System.out.println("min series = "+min);
    }
    public static void week8LiveDemo() {
//Create a TimeSeriesCollection size 10
        TimeSeriesCollection tsc= new TimeSeriesCollection();
        for(int i=0;i<10;i++) {
            double[] query = randomTimeSeries(100);
            tsc.addTimeSeries(new TimeSeries(query));
        }
//I want to process all time series with a max value greater than 1
//This breaks all encapsulation
        MaxThresholdSelector max = new MaxThresholdSelector(0.99);
        for(int i=0;i<tsc.currentSize;i++)
            if(max.select(tsc.ts[i]))
                System.out.println("Selected series "+i+" with max = "+tsc.ts[i].getMax());
//ITERATORS:
// 1. Create an iterator that iterates over all



    }
    public static void main(String[] args) {
//        week7LiveDemo();
        week8LiveDemo();

    }
}
