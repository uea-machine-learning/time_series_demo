/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week_10_demo.generics_topic10;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Predicate;

/**
 *
 * @author ajb. Example of using generic types to make your code clearer
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






    static class CompareByScore implements Comparator{
        @Override
        public int compare(Object t, Object t1) {
            double diff= ((Student)t).score-((Student)t1).score;
            if(diff>0) return 1;
            if(diff<0) return -1;
            return 0;
        }
    }
    static class compareByYear implements Comparator{
        @Override
        public int compare(Object t, Object t1) {
            return ((Student) t).year-((Student) t1).year;
        }
    }

    public static ArrayList createExampleArray(){
        ArrayList  s = new ArrayList();
        s.add(new Student("BOB",85,2));
        s.add(new Student("ALICE",68,1));
        s.add(new Student("CHRIS",55,3));
        s.add(new Student("KATE",55,2));
        return s;

    }
    public static ArrayList selectStudents(ArrayList students, Selector sel){
        ArrayList res=new ArrayList();
        for(Object s:students){
            if(sel.select(s))
                res.add(s);
        }
        return res;
    }
    public static ArrayList selectStudentsPredicate(ArrayList students, Predicate sel){
        ArrayList res=new ArrayList();
        for(Object s:students){
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
        Selector sel=s->((Student)s).year==1;
        ArrayList full=createExampleArray();
        ArrayList  year2=selectStudents(full,sel);

        ArrayList temp=selectStudents(full,
                new Selector() {
                    @Override
                    public boolean select(Object o) {
                        return ((Student)o).name.equals("BOB");
                    }
                }
        );
        for(Object s:temp)
            System.out.println(s);
        temp=selectStudents(full,o->((Student) o).name.equals("ALICE"));
        Predicate pred = s->((Student)s).year==1;
        ArrayList year1=selectStudentsPredicate(full,pred);
        Comparator cmp2 = new StudentScoreCompare();
        Collections.sort(full,cmp2);
        System.out.println(" full = "+full);

    }

    static class StudentScoreCompare implements Comparator{

        @Override
        public int compare(Object o1, Object o2) {
            if(((Student)o1).score>((Student)o2).score)
                return 1;
            if(((Student)o1).score<((Student)o2).score)
                return -1;
            return 0;
        }
    }

    static class SelectYear1 implements Selector{
        @Override
        public boolean select(Object o) {
            if(((Student)o).year==1) return true;
            return false;
        }

    }



}
