package week_9_demo.serialisation;

public class Part2Solution {
/*
1. Find the class \texttt{week_9_demo.serialisation.TeachingModule} you developed for the iterators lab sheet, or download it again.
2. Make it serialisable but without a unique identifier (i.e. no \texttt{serialVersionUID}.
3. item Create and populate a \texttt{week_9_demo.serialisation.TeachingModule} object. Try saving and loading this, and verify it is the same.
4. Add a field to the \texttt{week_9_demo.serialisation.TeachingModule} (any field will do). What do you think will happen if you try reload the object now? Try it out.
5.  If a field is transient it is not stored when the object is serialised. Make one of the fields of \texttt{week_9_demo.serialisation.TeachingModule} transient and verify this is the case.
*/


    public static void main(String[] args) {
//NOTE for part 2 and 3 you need to make week_9_demo.serialisation.Student Serializable also. This is a teaching point, not a mistake :)
//Write a toString method for week_9_demo.serialisation.TeachingModule for better formatted output
///Comment and uncomment code to follow the argument

        TeachingModule tm = new TeachingModule();
        System.out.println(" TM = "+tm);
        Serialisation.writeToFile(tm,"tm_part2");
//TRY THIS BEFORE AND AFTER ADDING toString()

        Object o=Serialisation.readFromFile("tm_part1");
        TeachingModule tm2 = (TeachingModule)o;
        System.out.println(" reloaded ="+tm2);
//TRY THIS BEFORE AND AFTER ADDING toString(). After adding toString it should crash.

//Now add the UID

    }

}
