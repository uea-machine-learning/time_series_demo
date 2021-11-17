package week_8_demo.enumtypes;
public class EnumExamples {

enum Grade{
FIRST(70), TWO_ONE(60), TWO_TWO(50), THIRD(40), FAIL(0);
	final int boundary;
	Grade(int x){
		boundary=x;
	}

	@Override
	public String toString(){
		return "Grade Boundary = "+boundary;
	}

}


    
}
