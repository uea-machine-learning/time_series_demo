package week_8_demo.nestedclasses;

public class ColourPalate{
    private Colour[] myPalate;
    private int size=0;
    private int maxSize=100;
    public ColourPalate(){
        myPalate=new Colour[maxSize];
    }
    /**
     * TODO Add checks for exceeding size
     * @param c a colour
     */
    public void addColour(Colour c){
        myPalate[size++]=c;
    }
    public static class Colour{
        private int red;
        private int green;
        private int blue;
        public Colour(int r, int g, int b){
            red=r;green=g;blue=b;
        }
        public int toGreyScale(){
            return red+green+blue;
        }
    }

    /**
     * TODO Add checks for exceeding size
     * @param r Red
     * @param g Green
     * @param b Blue
     */
    public void addRGB(int r, int g, int b){
        myPalate[size++]=new Colour(r,g,b);
    }

}
