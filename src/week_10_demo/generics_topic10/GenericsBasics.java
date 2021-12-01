package week_10_demo.generics_topic10;
//Code on Topic 10: basics of generics

import java.util.ArrayList;

public class GenericsBasics {


    public static void main(String[] args) {
        // Basic type safety
            //Generics with Arrays: diamond operator
        ArrayList<String> str1 = new ArrayList<>();
        ArrayList raw1 = new ArrayList();
        str1.add("Forty");
        str1.add("Nine");
        str1.add("Undefeated");
        raw1.add("Forty");
        raw1.add("Nine");
        raw1.add("Undefeated");
        //TYPE SAFETY

        //NO NEED TO CAST

      //Generics with classes: Comparable, Comparators, Iterable, Iterator,
        ArrayList myClass = Student.createExampleArray();
        //Show non generic usage


        //Convert Student to be generic


      //Generics with Lambdas


    }


}
