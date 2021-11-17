package week_7_demo.functors;

import java.util.Comparator;

public class CompareStudentsBySchool implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getSchool().compareTo(o2.getSchool());
    }

}
