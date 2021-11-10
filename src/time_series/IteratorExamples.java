package time_series;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class IteratorExamples {


    public static void main(String[] args) {
        System.out.println("Iterators");
        ArrayList<String> blah= new ArrayList<>();
        blah.add("Come");
        blah.add("On");
        blah.add("You");
        blah.add("Reds");

        Iterator<String> strIt;
        strIt=blah.iterator();
        while(strIt.hasNext())
            System.out.println(strIt.next());
        System.out.println("**********************");

        for(String s:blah)
            System.out.println(s);



        HashSet<String> hs = new HashSet<>();
        hs.add("Come");
        hs.add("On");
        hs.add("You");
        hs.add("Reds");
        for(String s:hs)
            System.out.println(s);
        System.out.println("**********************");
        strIt=hs.iterator();
        while(strIt.hasNext())
            System.out.println(strIt.next());
        System.out.println("**********************");

        TimeSeriesCollection tsCollection = new TimeSeriesCollection();
//        for(TimeSeries s:TimeSeriesCollection)
//            System.out.println(" s = "+s);
        TSIterator<TimeSeries> tsThing;
        tsThing = new TSIterator<>(tsCollection);
        while(tsThing.hasNext())
            System.out.println(tsThing.next());
        System.out.println("**********************");







    }
}
