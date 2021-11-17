package week_8_demo.enumtypes;

import java.text.*;
import java.util.Random;

public class EnumTypesExamples {
	public static final int ENGLAND= 0;
	public static final int FRANCE = 1;
	public static final int GERMANY = 2;
	public static final int ITALY= 3;

	public static void enumOldSchool() {
		int myCountry=ENGLAND;
		int fr=FRANCE;
		boolean biggest=biggestCountry(myCountry);
		boolean next=biggestCountry(-10);
		int conquered=myCountry+fr;
	}
	public static boolean biggestCountry(int a){
			if(a==2)//Germany the biggest
				return true;
			return false;
	}

		public enum Suit{CLUBS, SPADES, DIAMONDS, HEARTS}

	public enum ScienceSchool {CMP,BIO,MTH,ENV,CHE,PHA}
	public enum UEAFaculty {SCI,HUM,MED,SOC}



	public static void main(String[] args) {
	ScienceSchool x=ScienceSchool.BIO;
		ScienceSchool y=ScienceSchool.PHA;
		System.out.println("ORDINAL for "+x+"  = "+x.ordinal()+" "+y.getClass().isEnum());
		System.out.println("ORDINAL for "+y+"  = "+y.ordinal()+"   "+x.getClass().hashCode());
		for(UEAFaculty f:UEAFaculty.values())
			System.out.println("ORDINAL for "+f+"  = "+f.ordinal());


		ScienceSchool[] allSchools= ScienceSchool.values();
		UEAFaculty[] allFaculties= UEAFaculty.values();
		for(ScienceSchool s:allSchools)
			System.out.print(s+" ");
		System.out.println("");
		for(UEAFaculty u:allFaculties)
			System.out.print(u+" ");
	}

    
    
    
//Basic use of enums 
	enum Season{WINTER, SPRING, SUMMER, AUTUMN}
	enum Base{A,C,G,T}
	public static Base shiftBase(Base b){
//Enums make switches much clearer and easier to read		
		switch(b){
		case A: //You dont write Base.A, otherwise gives you an error!
			return Base.C;
		case C:
			return Base.G;
		case G:
			return Base.T;
		case T:
			return Base.A;
		}
		return b;
	}
	public static Base mutate(Base b, double p){
//with a given probability, shift the base
		Random rand=new Random();
		if(rand.nextDouble()<p)
			return shiftBase(b);
		return b;
	}


	
	public static void basicExample(){
//Declaring an enum variable		
		Season mySeason=Season.WINTER;
		Base x=Base.A;
		
		System.out.println(" My Favorite Season is "+mySeason);
		System.out.println(" The first letter in my genome is "+x);
		System.out.println(" Shift this letter and you "+shiftBase(x));
		
		System.out.println(" All Possible seasons are");
		for(Season s: Season.values())
			System.out.println(s);
		System.out.println(" The ordinal position of base "+x+" is "+x.ordinal());
		
	}
	
	// We can associate data and methods to enum types
	enum Grade{
		FIRST(70), TWO_ONE(60), TWO_TWO(50), THIRD(40), FAIL(0);
			final int boundary;
			Grade(int x){
				boundary=x;
			}
			public double getBoundary(){return boundary;}
	}
	public static Grade setGrade(double mark){
		for(Grade g:Grade.values()){
			if(mark>g.getBoundary()) return g;
		}
		return Grade.FAIL;
	}
//	EnumSet and EnumMap examples
	public static void advancedExample(){
		double mark=88;
		Grade myGrade=setGrade(mark);
		System.out.println(" my mark is "+mark+" my grade is "+myGrade);
	}
	
	
/*	public static void main(String[] args){
		basicExample();
		advancedExample();
		planets(100);
		planets(60);
		MutableEnum m1=MutableEnum.FIRST;
		MutableEnum m2=MutableEnum.FIRST;
		m1.x=100;
		System.out.println("m1.x="+m1.x+" m2.x ="+m2.x);
		
	}
*/	public enum Planet { 
		MERCURY (3.303e+23, 2.4397e6), 
		VENUS (4.869e+24, 6.0518e6), 
		EARTH (5.976e+24, 6.37814e6);
		private final double mass; // in kilograms 
		private final double radius; // in meters 
	
		Planet(double mass, double radius) { 
			this.mass = mass; this.radius = radius; 
		} 
		public static final double G = 6.67300E-11; 
		public double surfaceWeight(double otherMass) { return otherMass * surfaceGravity(); }
		public double surfaceGravity() { 
			return G * mass / (radius * radius); 
		} 
	}

	public static void planets(double earthWeight)
	{
		double mass = earthWeight/Planet.EARTH.surfaceGravity();
		DecimalFormat df=new DecimalFormat("###.#");
		for (Planet p : Planet.values()) 
			System.out.println("Your weight on Planet:"+p+" ="+ df.format(p.surfaceWeight(mass)));
	} 
	public enum MutableEnum{
		FIRST(10), SECOND(20),THIRD(30);
		public int x;
		MutableEnum(int a){x=a;}
	}
	
}
