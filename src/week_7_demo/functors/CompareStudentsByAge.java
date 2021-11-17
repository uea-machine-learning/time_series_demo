package week_7_demo.functors;

import java.util.Comparator;

/**
 * Comparator for student class
 */
public class CompareStudentsByAge implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b) {
        return a.getAge()-b.getAge();
    }
}
