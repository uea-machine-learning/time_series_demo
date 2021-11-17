package week_7_demo.functors;

public class CompareStudentsByName implements CompareStudent {
    @Override
    public int compare(Student a, Student b) {
        return a.getName().compareTo(b.getName());
    }
}
