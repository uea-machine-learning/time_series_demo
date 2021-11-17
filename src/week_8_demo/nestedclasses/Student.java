package week_8_demo.nestedclasses;

import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ajb
 */
public class Student implements Comparable<Student>{
    int age; 
    String name;
    double mark;
    Student(){
        age=18;
        name="";
        mark=0;
    }
    Student(int a, String n){
        age=a;
        name=n;
    }
    double getModuleMark(){
        return mark;
    }

    @Override
    public int compareTo(Student o) {
//Compare name r ag
        return age-o.age;
    }
    public class CompByAge implements Comparator<Student>{
        public int compare(Student a, Student b){
            return a.age-b.age;
        }
    }
    public class CompByName implements Comparator<Student>{
        public int compare(Student a, Student b){
            return a.name.compareTo(b.name);
        }
    }
    public static class CompareByName implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.name.compareTo(o2.name);
        }
    }
    public static class CompareByAge implements Comparator<Student>{
        @Override
        public int compare(Student o1, Student o2) {
            return o1.age-o2.age;
        }
   }

   public static Student[] createExampleArray(){
        Student[] ar=new Student[5];
        ar[0]=new Student(19,"Alice");
        ar[1]=new Student(18,"Bob");
        ar[2]=new Student(21,"Christine");
        ar[3]=new Student(20,"Denis");
        ar[4]=new Student(19,"Evan");
        return ar;

   }
    @Override
   public String toString(){
        return name+","+age+","+mark;
   }
    public static void main(String[] args) {

//CLASS DEFINED IN A METHOD 
        Student bob=new Student();

        //LOADS OF BESPOKE CODE


        class MyComparator implements Comparator<Student>{
            @Override
            public int compare(Student o1, Student o2) {
                return 0;
            }
        }
        Comparator<Student> cmpStrangelyForHere = new MyComparator();
        Comparator<Student> duh = new Comparator<Student>(){
            @Override
            public int compare(Student o1, Student o2) {
                return o1.name.compareTo(o2.name);
            }

        };


        Comparator<Student> myThing = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.name.compareTo(o2.name);
            }
        };
        Comparator<Student> cmpStrangelyForHereAgain = new MyComparator();


        Comparator<Student> cmpStrangelyForHereAgainAgain = new MyComparator();


    }

}



