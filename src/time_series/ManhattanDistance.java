package time_series;

public class ManhattanDistance implements Distance{

    public double distance(double[] x, double[] y){
        double d=0;
        for(int i=0;i<x.length;i++)
            d+= Math.abs(x[i]-y[i]);
        return d;

    }

}
