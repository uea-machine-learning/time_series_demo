package week_9_demo.lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Predicate;

public class StudentTestLambda {


    public static void main(String[] args) {
        //Static nested
        Comparator<Student> cmp = new Student.StudentScoreCompare();
        Student alice = new Student("Alice", 75, 2);
        Student fred = new Student("Fred", 55, 3);
        int c = cmp.compare(alice,fred);
        System.out.println(" compare value = "+c);
        ArrayList<Student> arr = new ArrayList<>();
        arr.add(fred);
        arr.add(alice);
        arr.add(new Student("Kate",88,1));

        //Anonymous
        Comparator<Student> cmp2 = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) { return o1.year-o2.year;}
        };
        c = cmp2.compare(alice,fred);
        System.out.println(" compare value = "+c);
        Collections.sort(arr,cmp2);
        System.out.println(" arr = "+arr);
        //Lambda
        Comparator<Student> cmp3 = (o1, o2) -> o1.name.compareTo(o2.name);

        Collections.sort(arr,    (o1, o2) -> o1.year-o2.year                   );



        System.out.println(" arr = "+arr);
        Selector<Student> sel1 = new Student.SelectYear1();
        ArrayList<Student> year1 = Student.selectStudents(arr,sel1);
        System.out.println(" Year 1 = "+year1);
        Selector<Student> sel2 = new Selector<>(){
            public boolean select(Student o){
                return o.year==2;
            }
        };
        ArrayList<Student> year2 = Student.selectStudents(arr,sel2);
        System.out.println(" Year 2 = "+year2);
        Selector<Student> sel3 = s -> s.year==3;
        ArrayList<Student> year3 = Student.selectStudents(arr,sel3);
        System.out.println(" Year 3 = "+year3);


        Predicate<Student> sel4 = s -> s.score>70.0;
        ArrayList<Student> firsts = Student.selectStudentsPredicate(arr,sel4);
        System.out.println(" Firsts = "+firsts);
   }
}
