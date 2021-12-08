package week_11_demo;

import java.util.AbstractList;
import java.util.ArrayList;

/**
 *
 */

public class TimeSeriesV3<T extends Number> extends AbstractList<T> implements Comparable<TimeSeriesV3> {


    public ArrayList<T> data;
    TimeSeriesStats stats;

    @Override
    public T get(int index) {
        return data.get(index);
    }

    @Override
    public int size() {
        return data.size();
    }
    @Override
    public T set(int position, T value){
        data.set(position,value);
        return value;
    }

    interface Selector<T>{
        boolean select(T t);
    }
    static class Selector1 implements Selector<TimeSeriesV3>{

        @Override
        public boolean select(TimeSeriesV3 t) {
            return t.stats.mean>0;
        }
    }




    public TimeSeriesV3(double [] d){
        data=new ArrayList<>();

//        for(double dd:d)
//            data.add(dd);
        stats=new TimeSeriesStats();
        stats.findStats();

    }

    @Override
    public int compareTo(TimeSeriesV3 o) {
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
