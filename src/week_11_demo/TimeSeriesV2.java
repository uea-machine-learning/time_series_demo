package week_11_demo;

import java.util.ArrayList;

/**
 *
 */

public class TimeSeriesV2<T extends Number> implements Comparable<TimeSeriesV2>{


    public ArrayList<T> data;
    TimeSeriesStats stats;


    interface Selector<T>{
        boolean select(T t);
    }
    static class Selector1 implements Selector<TimeSeriesV2>{

        @Override
        public boolean select(TimeSeriesV2 t) {
            return t.stats.mean>0;
        }
    }




    public TimeSeriesV2(double [] d){
        data=new ArrayList<>();

//        for(double dd:d)
//            data.add(dd);
        stats=new TimeSeriesStats();
        stats.findStats();

    }

    @Override
    public int compareTo(TimeSeriesV2 o) {
        return Double.compare(stats.mean,o.stats.mean);
    }

    class TimeSeriesStats{
        double mean;
        double variance;
        double max;
        double min;
        void findStats(){
            mean=0;
//            for(double d:data)
//                mean+=d;
            mean/=data.size();

        }

    }

    public static void main(String[] args) {

    }




}
