/*
Code to demonstrate week_9_demo.lambdas vs anonymous classes
*/
package week_9_demo.lambdas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;

/**
 *
 * @author ajb
 */
public class LambdaTest {

static ArrayList selectFromList(List a, Selector s){
	 ArrayList a2=new ArrayList();
       for(Object ob:a){
		if(s.select(ob))
			a2.add(ob);
	}
	return a2;
    }
    public static List makeExampleList(){
        LinkedList<Student> list=new LinkedList();
       list.add(new Student("Bob",44,1));
       list.add(new Student("Alice",58,3));
       list.add(new Student("Jim",63,2));
       list.add(new Student("Fred",88,1));
       list.add(new Student("Lucy",68,3));
       return list;
    }
    public static void main(String[] args) {




        selectExamplesWithLambdas();
//Generics with week_9_demo.lambdas
        BiFunction<Car,Student,String> bi =(a,b)->a.toString()+b.toString();
        Student bob=new Student("Bob",65,2);
        Car bmw= new Car("BMW","Blue",2,1,2000);
        String str=bi.apply(bmw,bob);
        
    }

    public static void selectExamplesWithLambdas() {
       List l=makeExampleList();
       Selector s=(Object o)-> ((Student)o).year==2;             
            
       ArrayList firstYears=selectFromList(l,(Object o)-> ((Student)o).year==1);
        System.out.println("First years with lambda="+firstYears);
       ArrayList secondYears=selectFromList(l,s);
        System.out.println("Second years ="+secondYears);
       ArrayList thirdYears=selectFromList(l,(Object o)-> ((Student)o).year==3);
        System.out.println("third years ="+thirdYears);
       Selector s2=(Object o)-> ((Student)o).score>40 && ((Student)o).score<=50;

       Selector s3=(Object o)-> {
           if(((Student)o).score>40 && ((Student)o).score<=50) return true;
           return false;
       };
       
       
        
        
        
//       for(String st:firstYears) System.out.println(st);
    }
    
    
    public static void selectExamplesWithFunctors() {
        LinkedList<Student> list=new LinkedList();
       list.add(new Student("Bob",44,1));
       list.add(new Student("Alice",58,3));
       list.add(new Student("Jim",63,2));
       list.add(new Student("Fred",88,1));
       list.add(new Student("Lucy",68,3));
       Selector s=new Student.selectYear1();
       ArrayList firstYears=selectFromList(list,s);
        System.out.println("First years ="+firstYears);
       ArrayList secondYears=selectFromList(list,new Selector(){
           public boolean select(Object o){
               if(((Student)o).year==2) return true;
               return false;
           }
       });
        System.out.println("Second years ="+secondYears);
        
        
        
//       for(String st:firstYears) System.out.println(st);
    }
    public interface Printer{
        void print(String s);
    }
    public interface Getter{
        double get(Object o);
    }
    public interface Comparator{
        int compare(Object o);
    }


}
