package week_8_demo.nestedclasses;
import week_8_demo.nestedclasses.ColourPalate.Colour;

/**
 * Code to demonstrate the declaration and usage of static nested class
 */
public class StaticNestedExamples {

    private PublicNestedClass one;
    private PrivateNestedClass two;

    public static class PublicNestedClass{
//Stuff
    }
    private static class PrivateNestedClass{
//Stuff
    }

    public void dummyFunction(PublicNestedClass a, PrivateNestedClass b){
        PublicNestedClass foo=new PublicNestedClass();
    }
    public static void staticDummy(){
        PublicNestedClass foo=new PublicNestedClass();
        PrivateNestedClass bar=new PrivateNestedClass();
    }
    public static void main(String[] args) {
        Colour black = new Colour(0,0,0);
       ColourPalate myColours=new ColourPalate();
        myColours.addColour(black);

//Create an outer class object
        StaticNestedExamples a=new StaticNestedExamples();
//Create an inner class object
        PrivateNestedClass b = new PrivateNestedClass();
//Create an inner class object in another class
        StaticNestedExamples.PublicNestedClass p=new StaticNestedExamples.PublicNestedClass();

    }


}
