package week_10_demo.generics_topic10;
//Code on Topic 10: basics of generics

import java.util.ArrayList;
import java.util.Iterator;

public class GenericsBasics {


    public static void main(String[] args) {
        // Basic type safety
            //Generics with Arrays: diamond operator
        ArrayList<String> str1 = new ArrayList<String>();
        ArrayList raw1 = new ArrayList();
        str1.add("Forty");
        str1.add("Nine");
        str1.add("Undefeated");
        raw1.add("Forty");
        raw1.add("Nine");
        raw1.add("Undefeated");
        //TYPE SAFETY
//        str1.add(100);
        raw1.add(1000);

        //NO NEED TO CAST
        String s;
        Object obj = raw1.get(0);
        s = (String)obj;
        s = str1.get(0);


      //Generics with classes: Comparable, Comparators, Iterable, Iterator,
        ArrayList<Student> myClass = Student.createExampleArray();
        ArrayList<Teacher> teach = new ArrayList<>();
        teach.add(new Teacher("Tony"));
        teach.add(new Teacher("Gavin"));
        //Iterator
        TeachingModule tm = new TeachingModule(myClass,teach);


/*        Iterator<Student> myIterator = tm.iterator(); // Create a new MyIterator object connected to tm;
        while(myIterator.hasNext()){
            Student stude = myIterator.next();
            if(stude.name.equals("tony"))
                System.out.println("Hello");
        }
*/
        for(Student st:tm)
            System.out.println(" Student = " + st);
        Iterator<Teacher> ttttt = tm.getTeacherIterator();
        while(ttttt.hasNext()){
            Teacher t = ttttt.next();
            System.out.println(" Teacher = "+t);
        }

    }


}
