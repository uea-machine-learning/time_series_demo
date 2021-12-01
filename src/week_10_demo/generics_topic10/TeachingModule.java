package week_10_demo.generics_topic10;

import java.util.ArrayList;
import java.util.Iterator;

public class TeachingModule implements Iterable<Student>{
    ArrayList<Student> myStudents;
    ArrayList<Teacher> myTeachers;

    public TeachingModule(ArrayList<Student>  students){
//        myStudents=students; //NOT A DEEP COPY, reference to an arraylist
        myStudents = new ArrayList<>(students); // Copies all references in students to myStudents
//        myStudents = new ArrayList(); // Copies all references in students to myStudents
//        for(Object s:students){
//            myStudents.add(s.clone()); //Only if implements Clonable interfact
        }

    public TeachingModule(ArrayList<Student>  students, ArrayList<Teacher> teachers){
        this(students);
        myTeachers = new ArrayList<>(teachers);
    }

    @Override
    public String toString(){
        return myStudents.toString();
    }
    public static void main(String[] args) {
        //Quick demo of memory differences
        ArrayList ar=Student.createExampleArray();
        ArrayList ar2=Student.createExampleArray();
        TeachingModule tm1 = new TeachingModule(ar);
        System.out.println(" Array"+ar);
        System.out.println(" Module"+tm1);
        ar.remove(2);
        System.out.println(" Array"+ar);
        System.out.println(" Module"+tm1);
        Student bob = ((Student)ar.get(0));
        bob.score=0;
        System.out.println(" Array"+ar);
        System.out.println(" Module"+tm1);


    }

    @Override
    public Iterator<Student> iterator() {
        return new MyStudentIterator();
    }
    public Iterator<Teacher> getTeacherIterator() {
        return new MyTeacherIterator();
    }

    private class MyStudentIterator implements Iterator<Student> {
        int pos=0;
        @Override
        public boolean hasNext() {
            return myStudents.size()>pos;
        }

        @Override
        public Student next() {
            return myStudents.get(pos++);
        }
    }
    private class MyTeacherIterator implements Iterator<Teacher> {
        int pos=0;
        @Override
        public boolean hasNext() {
            return myTeachers.size()>pos;
        }

        @Override
        public Teacher next() {
            return myTeachers.get(pos++);
        }
    }


}
