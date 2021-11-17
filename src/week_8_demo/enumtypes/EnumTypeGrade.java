
package week_8_demo.enumtypes;

/** Example of an enum type as an anonymous inner class
 *
 */
public class EnumTypeGrade {
/* enum Grade{
FIRST(70), TWO_ONE(60), TWO_TWO(50), THIRD(40), FAIL(0);

	final int boundary;
	Grade(int x){
		boundary=x;
	}
        
}
*/
 static public abstract class Grade{
     final int boundary;
     private Grade(int b){
         boundary=b;
     }
     public static final Grade FIRST = new Grade(70){
     //This is an anonymous inner class 
     };
     public static final Grade TWO_ONE = new Grade(60){};
     public static final Grade TWO_TWO = new Grade(50){};
     public static final Grade THIRD = new Grade(40){};
     public static final Grade FAIL = new Grade(0){};
     
 }
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(Grade.FIRST);
        
        Grade myGrade=Grade.THIRD;
    }
    
}
