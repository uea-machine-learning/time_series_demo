package week_9_demo.number_and_ellipsis;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Number {

    public static void main(String[] args) {
        int[] arr1 = new int[100];
        ArrayList<Integer> arr2 = new ArrayList<>();
        int blah=33;
        Integer x=33;
        if(blah == x)
            System.out.println(" Ints equal");
        if(x instanceof Object)
            System.out.println(" x an object");
        Integer y = new Integer(55);
        Double z=33.0;
        int zz=x+y;
        double a=z;


        //BUILT IN SORTING
        ArrayList<Integer> ar=new ArrayList<>();
        int[] ar2=new int[100];
        Random r= new Random();
        for(int i=0;i<100;i++){
            ar2[i]=r.nextInt();
            ar.add(ar2[i]);
        }
        Arrays.sort(ar2);
        Collections.sort(ar);
        for(int i=0;i<100;i++) {
            System.out.println(ar.get(i)+"   "+ar2[i]);
        }
        max(3,76,8,9);
        max(3,6,9);

    }
    public static int max(int ... vals){
        int m=vals[0];
        for(int i=1;i<vals.length;i++){
            if(vals[i]>m)
                m=vals[i];
        }
        return m;

    }




}
