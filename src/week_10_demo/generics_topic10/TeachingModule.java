package week_10_demo.generics_topic10;

import java.util.ArrayList;

public class TeachingModule {
    ArrayList myStudents;

    public TeachingModule(ArrayList students){
        myStudents=students; //NOT A DEEP COPY, reference to an arraylist
//        myStudents = new ArrayList(students); // Copies all references in students to myStudents
//        myStudents = new ArrayList(); // Copies all references in students to myStudents
//        for(Object s:students){
//            myStudents.add(s.clone()); //Only if implements Clonable interfact
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


}
