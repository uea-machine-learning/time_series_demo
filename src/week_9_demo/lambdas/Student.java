/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week_9_demo.lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Predicate;

/**
 *
 * @author ajb
 */
public class Student {
    String name;
    double score;
    int year;
    Student(String n, double s, int y){
        score=s;
        name=n;
        year=y;
    }
    static class CompareByScore implements Comparator<Student>{
        @Override
        public int compare(Student t, Student t1) {
            double diff= t.score-t1.score;
            if(diff>0) return 1;
            if(diff<0) return -1;
            return 0;
        }
    }
    static class compareByYear implements Comparator<Student>{
        @Override
        public int compare(Student t, Student t1) {
            return t.year-t1.year;
        }
    }
    static class compareByName implements Comparator<Student>{
        @Override
        public int compare(Student t, Student t1) {
            return t.name.compareTo(t1.name);
        }
    }
    public static ArrayList<Student> createExampleArray(){
        ArrayList<Student> s = new ArrayList<>();
        s.add(new Student("BOB",85,2));
        s.add(new Student("ALICE",68,1));
        s.add(new Student("CHRIS",55,3));
        s.add(new Student("KATE",55,2));
        return s;

    }
    public static ArrayList<Student> selectStudents(ArrayList<Student> students, Selector<Student> sel){
        ArrayList<Student> res=new ArrayList<>();
        for(Student s:students){
            if(sel.select(s))
                res.add(s);
        }
        return res;
    }
    public static ArrayList<Student> selectStudentsPredicate(ArrayList<Student> students, Predicate<Student> sel){
        ArrayList<Student> res=new ArrayList<>();
        for(Student s:students){
            if(sel.test(s))
                res.add(s);
        }
        return res;
    }
    public String toString(){
        return name+" "+score+" "+year;
    }

    public static void main(String[] args) {
//Lambda expression
        Selector<Student> sel=(Student s)->s.year==1;
        ArrayList<Student> full=createExampleArray();
        ArrayList<Student>  year2=selectStudents(full,sel);

        ArrayList<Student>  temp=selectStudents(full,
                new Selector<Student>() {
                    @Override
                    public boolean select(Student o) {
                        return o.name.equals("BOB");
                    }
                }
        );



        for(Student s:temp)
            System.out.println(s);
        temp=selectStudents(full,(Student o)->o.name.equals("ALICE"));
        for(Student s:temp)
            System.out.println(s);
        Comparator<Student> cmp=(Student a, Student b)->a.year-b.year;
        Collections.sort(full,cmp);
        for(Student s:full)
            System.out.println(s);
        Comparator<Student> cmp2=(a, b)->a.name.compareTo(b.name);
        Collections.sort(full,cmp2);
        for(Student s:full)
            System.out.println(s);
        cmp2=(a, b)->{
            if(a.year>b.year)
                return 1;
            if(a.year<b.year)
                return -1;
            return 0;
        };
        Predicate<Student> pred = s->s.year==1;
        ArrayList<Student>  year1=selectStudentsPredicate(full,pred);

        Collections.sort(full,cmp2);


        Predicate p=Student::dummy;
    }
    static boolean dummy(Object a){
        return true;
    }

    static class StudentScoreCompare implements Comparator<Student>{

        @Override
        public int compare(Student o1, Student o2) {
            return 0;
        }
    }

    static class selectYear1 implements Selector{
        @Override
        public boolean select(Object o) {
            if(((Student)o).year==1) return true;
            return false;
        }

    }



}
