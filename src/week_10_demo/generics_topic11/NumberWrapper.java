package week_10_demo.generics_topic11;

public class NumberWrapper<E extends Number> {
    E obj;
    public void add(E a){
        obj=a;
    }
    public E get(){
        return obj;
    }
    public static void main(String[] args) {
        NumberWrapper raw= new NumberWrapper();
        NumberWrapper<Double> d= new NumberWrapper<>();
        NumberWrapper<Integer> i= new NumberWrapper<>();
        NumberWrapper<Number> n= new NumberWrapper<>();
        d.add(55.0);
        i.add(55);
        n.add(44.775454);
        n.add(55);
        n=i;









    }
}
