package week_8_demo.nestedclasses;

import java.util.Arrays;
import java.util.Comparator;

public class AllNestedClassesExample {
	String name;
	int number;
	NestedClass n;
	public AllNestedClassesExample(){
		name="Tony";
		number=1;
		n=new NestedClass();
	}
	public String toString(){ return name+","+number;}
	public InnerClass innerClassFactory(){
		return new InnerClass();
	}
	
/************* INNER CLASS ****************************/	
	public class InnerClass{
// Attributes related to a instance of InnerClass
		double score;
// All inner Nested classes are not allowed statics 		
/*		static double x=100;
		public static void myStatic(){}
Give errors
*/
//Inner class can access the attributes of the calling object
		public InnerClass(){
/*When created an inner class must be called in association
	with a particular object*/	
			score=0;	
//		This will alter the calling object's attributes, since whe			
			name="Geoff";		
			number=2;
		}
		public void changeCallingObject(String s, int n){
			name=s;
			number=n;
		}
		public  void setScore(double d){score =d;}
		public String toString(){ return name+","+number+","+score;}
		
/*Advanced features: Although the inner class can see the methods and attributes of the outer class , things get
	confusing with overloading! This for example is recursive
		public String toString(){ return toString()+","+score;}
but how do I call the outer class toString method? 
	You can access the outer object like this, 
	
		public String toString(){ return NestedClassesExample.this.toString()+","+score;}
	
	but it still seems confusing, it must store a separate NestedClassesExample.this for each inner object */
		public AllNestedClassesExample getOuterObject(){ return AllNestedClassesExample.this;}

	}

	/************* NESTED CLASS ****************************/	
	public static class NestedClass{
//Static nested class is independent of any particular object
		boolean finished;
		
		public NestedClass(){
			finished=false;
// hence this makes no sense and will not compile
//		name="Geoff";		
//		number=2;
		}
		public void setFinished(boolean f){finished=f;}
		public String toString(){ return ""+finished;}
	}
/************** Interfaces can also Nested classes, but they are by default STATIC, i.e. not related 
 to a particular instance of the outer class. Hence these two declarations are the same	****/
	 interface anonymousClassExample1{
		int someMethod(int a);
	}
	public interface anonymousClassExample2{
		int someMethod(int a);
	}
	public static void localExample(){
		Student[] myClass=Student.createExampleArray();
		class LocalCompAge implements Comparator<Student>{
			@Override
			public int compare(Student o1, Student o2) {
				return o2.age-o1.age;
			}
		}
		Comparator<Student> local= new LocalCompAge();
		Arrays.sort(myClass, local);
		System.out.println(" SORT by age reverse, local");
		for(Student s:myClass)
			System.out.println(s);

	}
	public static void anonExample(){
		Student[] myClass=Student.createExampleArray();
		Arrays.sort(myClass, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o2.name.compareTo(o1.name);
			}
		});
		for(Student s:myClass)
			System.out.println(s);
		Comparator<Student> cmp= new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o2.age-o1.age;
			}
		};
		System.out.println(" SORT by age reverse, anonymous");
		Arrays.sort(myClass, cmp);
	}

	public static void comparatorExample() {
		Student[] myClass=Student.createExampleArray();

		Comparator compName=new Student.CompareByName();
		Arrays.sort(myClass,compName);
		System.out.println(" SORT by name, static nested");
		for(Student s:myClass)
			System.out.println(s);
		Arrays.sort(myClass,new Student.CompareByAge());
		System.out.println(" SORT by age, static nested");
		for(Student s:myClass)
			System.out.println(s);

		Comparator inner = myClass[0].new CompByName();
		Arrays.sort(myClass,inner);
		System.out.println(" SORT by name, inner");
		for(Student s:myClass)
			System.out.println(s);
		Arrays.sort(myClass, myClass[0].new CompByAge());
		System.out.println(" SORT by age, inner");
		for(Student s:myClass)
			System.out.println(s);
		class LocalCompAge implements Comparator<Student>{
			@Override
			public int compare(Student o1, Student o2) {
				return o2.age-o1.age;
			}
		}
		Comparator<Student> local= new LocalCompAge();
		Arrays.sort(myClass, local);
		System.out.println(" SORT by age reverse, inner");
		for(Student s:myClass)
			System.out.println(s);
		Arrays.sort(myClass, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o2.name.compareTo(o1.name);
			}
		});
		System.out.println(" SORT by name reverse, anonymous");
		for(Student s:myClass)
			System.out.println(s);


	}

	public static void main(String[] args){
		comparatorExample();
		System.exit(0);
//Without an import
	 	StaticNestedExamples.PublicNestedClass pub=new StaticNestedExamples.PublicNestedClass();
//With an import


/*Only Creates a NestedClassExample, no instances of the inner classes*/
		AllNestedClassesExample thing=new AllNestedClassesExample();
		System.out.println("Example 1: "+thing);
/***************** INNER CLASS EXAMPLES **************/		
		System.out.println("*************** INNER CLASS EXAMPLES **********************");
//Creates an instance of the InnerClass, which alters the calling object in its constructor */
		InnerClass inner=thing.new InnerClass();
		System.out.println("Example 2 (thing changed by innerclass constructor): "+thing);
//The syntax above is not commonly used, usually you would use a method to create the object
		InnerClass inner2=thing.innerClassFactory();
//We can call methods on inner2 that will alter thing
		inner2.changeCallingObject("Bob", 3);
		System.out.println("Example 3 (thing changed by innerclass method): "+thing);
/*Or we can just alter its own state. There can be independent instances of the inner class associated 
	with a single instance of the outer class*/
		
//These do the both change the state of thing
		inner.changeCallingObject("Bob", 3);
		inner2.changeCallingObject("Alice", 4);
//These alter two different InnerClass objects
		inner.setScore(100);
		System.out.println("Inner 1: "+inner);
		inner2.setScore(50);
		System.out.println("Inner 2: "+inner2);

//Advanced features		
		//What if I do this?!?
		InnerClass inner3=new AllNestedClassesExample().new InnerClass();
//Somehow, the outer class still is accessible, even though we have not stored a reference to it in this method
		inner3.changeCallingObject("Fred",22);
		System.out.println("Inner 3: "+inner3);
//This is because the inner class stores a reference to the outer object, which you can retrieve. 
		AllNestedClassesExample[] in=new AllNestedClassesExample[3];
		in[0]=inner.getOuterObject();
		in[1]=inner2.getOuterObject();
		in[2]=inner3.getOuterObject();
		for(AllNestedClassesExample n:in)
			System.out.println("Outer Object >"+n);
		
		
/**************** NESTED CLASS EXAMPLE ******************/	
		System.out.println("*************** STATIC NESTED CLASS EXAMPLES **********************");
//Its all much simpler with nested classes! This creates a NestedClass object independent of any object		
		NestedClass nested=new NestedClass();
//Usually nested classes are fields within an outer class object and are not seen outside the class
		thing=new AllNestedClassesExample();
//NestedClassesExample has a NestedClass attribute called n. 		
		System.out.println("Nested 1:"+thing.n);
		thing.n.setFinished(true);
		System.out.println("Nested 2:"+thing.n);

/**************** LOCAL CLASS EXAMPLE ******************/	
		System.out.println("*************** LOCAL NESTED CLASS EXAMPLES **********************");
// All useage must be after the declaration!	ERROR HERE:	LocalClass first=new LocalClass();

/*Local classes can only be used within the method/block they are created. 
 * It used to be the case they had to be final, but not in Java 7 onwards. So
 * you can use inheritance with them ........
 */	
		class LocalClass{
			double x,y;
			public LocalClass(double a, double b){x=a;y=b;}
			public String toString(){return x+","+y;}
		}
		LocalClass l1=new LocalClass(1,2);
		System.out.println("Local 1:"+l1);
//You can restrict it further by making a block of code
		{
			class BlahBlah{
				int a;
				public BlahBlah(int b){a=b;}
				public String toString(){return ""+a;}
			}	
			BlahBlah blah=new BlahBlah(11);
		}
//Cant do it here, out of the block of code		BlahBlah blah2=new BlahBlah(11);
		/**************** ANONYMOUS CLASS EXAMPLE ******************/	
		System.out.println("*************** ANONYMOUS CLASS EXAMPLES **********************");
/*Anonymous classes are one off deals that implement interfaces, 
		the resulting one off object is usually passed to a method
*/

		AllNestedClassesExample.anonymousClassExample1 a1=new AllNestedClassesExample.anonymousClassExample1(){
			public int someMethod(int a){
				return a*100;
			}
		}; //Note you have to finish off this with a semi colon
		System.out.println("anonymous 1:"+a1.someMethod(20));
		dummy2(new AllNestedClassesExample.anonymousClassExample2(){
			public int someMethod(int a){
				return a-100;
			}
		}
		);
	}
	public void dummy(){
		//You cannot refer to LocalClass here
		//LocalClass l=new LocalClass();
	}
	
	public static void dummy2(AllNestedClassesExample.anonymousClassExample2 a2){
		//You cannot refer to LocalClass here
		//LocalClass l=new LocalClass();
		System.out.println("anonymous 2:"+a2.someMethod(30));
	}
	
}


