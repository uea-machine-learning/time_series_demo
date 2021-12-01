package week_9_demo.serialisation;/*
iterators.week_9_demo.serialisation.Student example used in lecture 1
 */

import java.io.*;
import java.util.ArrayList;

public class Student implements Serializable{
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private String school;
    private int shoeSize;

    public Student() {
    }
    public Student(Student s) {
        name = s.name;
        age = s.age;
        school=s.school;
    }
    public Student(String n, int s) {
        name = n;
        age = s;
    }
    public Student(String sk, String n, int s) {
        this(n,s);
        school=sk;
    }


    public void setAge(int s) {
        age = s;
    }

    public int getAge() {
        return age;
    }

    public void setName(String s) {
        name = s;
    }
    public String getName() {
        return name;
    }

    public Student higherScore (Student a){
        if(age >a.age)
                    return this;
        return a;
    }

//Static variables and methods
    private static String university="UEA";
    public static int numStudents=0;

    public static void setUni(String s)
    {
            university=s;
    }
    public static void setNumStudent(int a){numStudents=a;}
    public String toString(){
        return name+" aged = "+age;
    }


    public static void main(String[] args) throws IOException {
    //Simple serialisation example
        Student sam = new Student("Sam",66);
        FileOutputStream fos = new FileOutputStream("MyStudent.ser");
        ObjectOutputStream out = new ObjectOutputStream(fos);
        out.writeObject(sam);
        out.close();
        ArrayList<String> str = new ArrayList<>();
        str.add("Hello");
        str.add("World");
        fos=new FileOutputStream("Arr.ser");
        out.writeObject(str);
        out.close();



    }

}
