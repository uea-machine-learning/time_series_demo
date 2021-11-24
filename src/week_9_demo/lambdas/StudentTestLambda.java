package week_9_demo.lambdas;

import java.util.Comparator;
import java.util.function.Predicate;

public class StudentTestLambda {


    public static void main(String[] args) {
        //Static nested
        Comparator<Student> cmp = new Student.StudentScoreCompare();
        //Anonymous
        Comparator<Student> cmp2 = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return 0;
            }
        };
        //Lambda
        Comparator<Student> cmp3 = (o1, o2) -> 0;
        //Same with selector and predictate
/*
        Selector<Student> sel1 = new Selector<Student>(){
            public boolean select(Student o){
                return false;
            }
        };
        Selector<Student> sel2 = s -> false;
        Predicate<Selector> sel3 = s -> false;
*/    }
}
