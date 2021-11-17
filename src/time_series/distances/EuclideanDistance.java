package time_series.distances;

public class EuclideanDistance implements Distance {

    public double distance(double[] x, double[] y){
        double d=0;
        for(int i=0;i<x.length;i++)
            d+=(x[i]-y[i])*(x[i]-y[i]);
        return Math.sqrt(d);

    }

}
