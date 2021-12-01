package week_10_demo.generics_topic11;

public class Wrapper<E> {
    E obj;
    public Wrapper(E a){
        obj=a;
    }
    public E get(){ return obj;}

    public void set(E a){ obj=a;}

    public static void main(String[] args) {
        Wrapper<Double> w1 = new Wrapper<>(10.0);
        Wrapper<Integer> w2 = new Wrapper<>(10);
        Wrapper<String> w4 = new Wrapper<>("blah");

        Wrapper<? extends Number> w3 = new Wrapper<>(10);
        w3=w2;




    }
}
