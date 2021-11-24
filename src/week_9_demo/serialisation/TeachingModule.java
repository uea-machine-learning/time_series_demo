package week_9_demo.serialisation;

import java.io.Serializable;
import java.util.Iterator;

/**
 * Class to store data on a UEA module, including student information
 */
public class TeachingModule implements Iterable<Student>, Serializable {

    private static final long serialVersionUID = 100L;


    private Student[] students;
    private int numStudents=0;
    private int capacity=10;
    public int getNumStudents(){ return numStudents;}
    public Student getStudent(int i){ return students[i];}

    public TeachingModule(){
//Sets up a dummy example object for teaching purposes
        numStudents=4;
        students=new Student[numStudents];
        students[0]= new Student("CMP","BOB",52);
        students[1]= new Student("BIO","ALICE",67);
        students[2]= new Student("CMP","SARAH",42);
        students[3]= new Student("ENV","JOHN",66);
    }
    //Should do range checking but hey
    public void swapStudents(int a, int b) {
        Student temp=students[a];
        students[a]=students[b];
        students[b]=temp;
    }
    public void removeLast(){
        numStudents--;
    }

    public static TeachingModule createTestModule(){
        TeachingModule m=new TeachingModule();
        return m;
    }

    public String toString(){
        return super.toString()+ " num students ="+numStudents;

    }
   public class ModuleIterator implements Iterator<Student>{
        int pos;
        public ModuleIterator(){
            pos=0;
        }
        @Override
        public boolean hasNext() {
            if(pos<numStudents)
                return true;
            return false;
        }

        @Override
        public Student next() {
            return students[pos++];
        }
        }

    @Override
    public Iterator<Student> iterator() {
        return new ModuleIterator();
    }
}
