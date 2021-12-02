package week_10_demo.generics_topic11;

import java.util.ArrayList;
import java.util.Iterator;

public class Wrapper<E> {
    E obj;
    public Wrapper(E a){
        obj=a;
    }
    public E get(){ return obj;}

    public void set(E a){ obj=a;}

    public static void main(String[] args) {
        Wrapper<Double> w1 = new Wrapper<>(10.0);
        Wrapper<Integer> w2 = new Wrapper<>(10);
        Wrapper<String> w4 = new Wrapper<>("blah");

        Wrapper<? extends Number> w3 = new Wrapper<>(10);
        w3=w2;
        ArrayList<Integer> ar = new ArrayList<>();
        ar.add(44);
        ar.add(55);
        System.out.println(" Arr sum = "+sumArray(ar));
    }

    public static int sumArray(ArrayList b){
        Iterator it = b.iterator();
        int sum=0;
        for(Integer i:b)
            sum+=i;
        return sum;
    }


}
