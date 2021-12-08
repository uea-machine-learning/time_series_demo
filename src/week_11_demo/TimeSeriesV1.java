package week_11_demo;

/**
 *
 */

public class TimeSeriesV1 implements Comparable<TimeSeriesV1>{


    public double[] data;
    TimeSeriesStats stats;

    interface Selector<T>{
        boolean select(T t);
    }
    static class Selector1 implements Selector<TimeSeriesV1>{
        @Override
        public boolean select(TimeSeriesV1 t) {
            return t.stats.mean>0;
        }
    }




    public TimeSeriesV1(double [] d){
        stats=new TimeSeriesStats();
        stats.findStats();

    }

    @Override
    public int compareTo(TimeSeriesV1 o) {
        return Double.compare(stats.mean,o.stats.mean);
    }

    class TimeSeriesStats{
        double mean;
        double variance;
        double max;
        double min;
        void findStats(){
            mean=0;
            for(double d:data)
                mean+=d;
            mean/=data.length;

        }

    }

//Overriding the the hashCode() is generally necessary whenever equals() is overridden to maintain the general contract
// for the hashCode() method, which states that equal objects must have equal hash codes.
    @Override
    public boolean equals(Object o){
        //When are two series equal? When all the values are the same .... do we have a tolerance?
        if(!(o instanceof TimeSeriesV1))
            return false;
        TimeSeriesV1 other=(TimeSeriesV1)o;
        if(this.data.length!=other.data.length)
            return false;
        for(int i=0;i<this.data.length;i++)
            if(this.data[i]!=other.data[i]) //Could introduce a tolerance here
                return false;
        return true;
    }
    @Override
    public int hashCode(){
        //How to make a hashCode that ensures that when equal is true, hashcodes are the same, but also makes
        //The hash codes as different as possible? (wish to minimize the chance of different series having the same hash
        // code (see DSA semester 2)
        return 0;
    }
    public static void main(String[] args) {

    }

}
