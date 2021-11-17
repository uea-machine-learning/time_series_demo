package week_8_demo;


import week_8_demo.nestedclasses.Student;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author ajb
 */
public class MoreNestedExamples {

    public static void processStudent(Student s){
        
        
    }





//Static and non static nested classes can be attributes of the class
    
    StaticNested sn;    
//The difference is that the methods of the InnerNested class can refer directly to the enclosing object    
    InnerNested in;
    String n;
    public MoreNestedExamples(String s){
        n=s;
        sn=new  StaticNested();
        in=new InnerNested();
    }
    public void aMethod(){
//Both of these are ok        
       StaticNested localSN=new  StaticNested();
//localIN is associated with the calling object (this)       
       InnerNested localIN=new InnerNested();
       StaticNested localSN2=new  StaticNested();
//If I want to connect a static nested to the calling object, I have to do it explicitly.
       localSN2.connectToOuter(this);
    }
    
    public String toString(){
          return "\n\nThis is the outer class object called "+n;
    }
    public static class StaticNested{
        String s="Static";
        MoreNestedExamples outer;
//If I want to connect a static nested to an instance of the outer class, I have to do 
//it explicitly.         
        public void connectToOuter(MoreNestedExamples w){
            outer=w;
        }
        public String toString(){
            String str= "\n\nThis is a stand alone object that is logically located inside class, but not associated with any instance of Week2Lecture4";
            str+="\n if I want to refer to an instance of the outer object, I need to connect explicitly";
            if(outer!=null)
                str+="\n Connected to "+outer.n;
            return str;
        }
    }
    public class InnerNested{
        String s="inner";
        public String toString(){
            String s= "\n\nThis is an object that is logically located inside an object of class Week2Lecture4";
            s+="\n Outer object accessed like this"+ MoreNestedExamples.this;
            s+="\n I can refer directly to the attributes of the outer object like this"+sn.toString();
            s+="\n even if it is myself: "+in.s;
            return s;
        }
        
    }
    
    
    public static void nestedClasses(){
//BASIC SYNTAX  EXAMPLES        
//Four types of nested classes.
//1. Static nested classes. NOT ASSOCIATED WITH AN OBJECT        
        StaticNested s= new StaticNested();
        System.out.println("\n****************Static nested classes.*******************\n NOT ASSOCIATED WITH AN OBJECT\n"+s);
//2. Inner nested classes. ALWAYS ASSOCIATED WITH AN OUTER CLASS OBJECT
        MoreNestedExamples x=new MoreNestedExamples("OUTER");
        InnerNested n=x.new InnerNested();
        System.out.println("\n****************Inner nested classes*******************\n. ALWAYS ASSOCIATED WITH AN OUTER CLASS OBJECT\n"+n);      
        
//3. Local nested classed. Defined in a method, can only be used in that method
//It can have the         
        class LocalNested{
            String s;
            LocalNested(String str){
                s=str;
            }
            public String toString(){
                return "Local nested class "+s;
            }
        }
        LocalNested ln1=new LocalNested("Local1");
        LocalNested ln2=new LocalNested("Local2");
        System.out.println("\n****************Local nested classed.**************\nDefined in a method, can only be used in that method and are not linked to any other objects\n"+ln1+"\n"+ln2);
        
//4. Anonymous classes. These always implement some interface or extend a class (usually the former.
// They can only be instantiated once.
        Comparator c1=new Comparator(){ 
            public int compare(Object o1, Object o2){
                return(((LocalNested)o1).s.compareTo(((LocalNested)o2).s));
            }
        };
        System.out.println("\n****************Anonymous Classes **************\n. Throw away class");
        
        System.out.println(" I am using an anonymous class to compare two Local Inner Classes. Very odd!");
        System.out.println(" COMPARE ="+ c1.compare(ln1, ln2));       
    }

    enum Season{WINTER, SPRING, SUMMER, AUTUMN}
    enum Grade{
        FIRST(70), TWO_ONE(60), TWO_TWO(50), THIRD(40), FAIL(0);
	final int boundary;
	Grade(int x){
		boundary=x;
	}
	public double getBoundary(){return boundary;}
}

    public static void enumTypes(){
//Enum types can be attributes of a class or local variables        
          Season s1=Season.WINTER;
          Season s2=Season.SPRING;
          Season s3=Season.WINTER;
          
//You can use == to test equality, since the is only ONE instance of each Season value           
          if(s1==s3)
              System.out.println(" Equal seasons");
          for(Season s:Season.values())
              System.out.println("Season ="+s);
          for(Grade g:Grade.values())
              System.out.println("Grade ="+g+" boundary ="+g.getBoundary());
          
    }
    public static void numbers(){
//Boxing: you can use primitives and Number objects interchangeably 
        Integer a=10;
        int b=a;
        int c=1;
        System.out.println(" a ="+a+" b = "+b);
//Use with collections        
        ArrayList<Integer> list= new ArrayList<>();
        list.add(b);
        a=list.get(0);
        b=list.get(0);
        System.out.println(" a ="+a+" b = "+b);
//Use with primitive operators        
        b=a+10;
        Integer d=50,e=10;
        System.out.println(" a/d="+a/d);
        e=(a+b*c)*e;
        System.out.println(" e="+e);
        
    }
    public static double average(double...numbers){
//Java allows methods with a variable argument list. the ... operator is called an ELLIPSIS
// numbers is just an array. The JVM works out how big numbers needs to be and puts your arguments in the array
    double s=0;
    for(int i=0;i<numbers.length;i++)
            s+=numbers[i];
    return s/numbers.length;
    }
    public static void ellipsis(){
        double d1=100,d2=33,d3=333;
        double mean;
        mean=average(d1);
        System.out.println(" mean ="+mean);
        mean=average(d1,d2);
        System.out.println(" mean ="+mean);
        mean=average(d1,d2,d3);
        System.out.println(" mean ="+mean);

    }
    
    
    public static void main(String[] args){
        nestedClasses();
//        enumTypes();
 //       numbers();
 //       ellipsis();
    }
}
