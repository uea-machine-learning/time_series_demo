package week_11_demo;

import java.sql.Time;
import java.util.*;

public class TimeSeriesTester {

    public static void main(String[] args) {
        double[] exampleTimeSeries = {1.0,2.0,3.0,4.0,5.0};
        List<TimeSeriesV3> myList;
        Set<TimeSeriesV3> mySet;
        mySet=new HashSet<>();
        Map<String, TimeSeriesV1> myMap=new HashMap<>();
        ArrayList<String> names=new ArrayList<>();
        names.add("BOB");
        names.add("ALICE");
        names.add("ALICE");

        TimeSeriesV1[] data= new TimeSeriesV1[10];
        for(int i=0;i<10;i++)
            data[i]=new TimeSeriesV1(exampleTimeSeries);
        HashSet<TimeSeriesV1> myHash= new HashSet<>();
        for(TimeSeriesV1 t:data) {
            myHash.add(t);
            myMap.put("X",t);
        }
        System.out.println(" My Set Size  = "+myHash.size());
        System.out.println(" My Map size  = "+myMap.size());



        System.exit(0);

        Collection<String> col;
        List<String> a;
        Set<String> b;
        a=new LinkedList<>();
        a=new ArrayList<>();

        b=new TreeSet<>();
        b=new HashSet<>();



        a.add("Arsenal");
        a.add(0,"Arsenal");
        a.contains("Arsenal");

        b.add("Arsenal");
        b.add("Arsenal");
        b.contains("Arsenal");
//        b.add(4,"asdasd");
        System.out.println(" Size of b = "+b.size());






        TimeSeriesV1 myTS=new TimeSeriesV1(exampleTimeSeries);
//        myTS.data.add(33.0);

        TimeSeriesV2<Double> myTS2=new TimeSeriesV2(exampleTimeSeries);;
        myTS2.data.add(33.0);

        TimeSeriesV2<Integer> myTS3=new TimeSeriesV2(exampleTimeSeries);;
        myTS3.data.add(33);





/*
        TimeSeriesV2<Number> myTS4=new TimeSeriesV2(exampleTimeSeries);;
        myTS3.data.add(33);
        myTS2.data.add(33.0);
//        numbers.add(new Double(4));
        List<Number> myList;

        ArrayList<? extends Number> numbers=new ArrayList<>();

        ArrayList<?> numbers2=new ArrayList<>();
        ArrayList numbers3=new ArrayList<>();

        ArrayList<Double> myDoubles= new ArrayList<>();
        ArrayList<String> temp= new ArrayList<>();
        numbers=myDoubles;
*/






    }


}
