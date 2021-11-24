/*
Basic Car class for Java Lab 3 on prog 2
 */
package week_9_demo.lambdas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;

/**
 *
 * @author ajb
 */
public class Car {

    String make;
    String colour;
    int doors;
    int type; //0=hatch back, 1= sedan, /2=SUV
    double engineSize;

    public Car(String b,String c, int d, int t, double e){
        make=b;
        colour=c;
        doors=d;
        type=t;
        engineSize=e;
    }
    public String toString(){
        return colour+" "+make;
    }

    public String getColour(){ return colour; }
   static ArrayList<Car> createCars(){
        ArrayList<Car> cars=new ArrayList<>();
        cars.add(new Car("BMW","Blue",2,1,2000));
        cars.add(new Car("BMW","Red",4,2,3000));
        cars.add(new Car("BMW","Blue",4,3,2000));
        cars.add(new Car("Audi","White",2,2,1600));
        cars.add(new Car("Audi","Blue",2, 1,2000));
        cars.add(new Car("Mercedes","Red",2, 2,2000));
        cars.add(new Car("Mercedes","White",4, 1,4000));
        cars.add(new Car("Mercedes","Black",4, 2,3000));
        return cars;
    }
    public static class CompareEngine implements Comparator<Car>{
        @Override
        public int compare(Car o1, Car o2) {
            if(o1.engineSize-o2.engineSize>0) return 1;
            if(o1.engineSize-o2.engineSize<0) return -1;
            return 0;
        }
    }
    public static class BMWSelect implements Selector<Car>{
        //Task 3
        @Override
        public boolean select(Car o) {
            return o.make.toUpperCase().equals("BMW");
        }
    }
    public static class BMWTest implements Predicate<Car>{
        @Override
        public boolean test(Car car) {
            return car.make.toUpperCase().equals("BMW");
        }
    }

    public static void main(String[] args) {
        Selector<Car> lam= o -> o.make.toUpperCase().equals("BMW");
        Car myCar= new Car("X","Y",1,1,1);
        BMWSelect mySelect = new BMWSelect();
        Predicate<Car> myPred =o -> o.make.toUpperCase().equals("BMW");

        Predicate<Car> myPred2 =new Predicate<Car>() {
            @Override
            public boolean test(Car car) {
               return car.make.toUpperCase().equals("BMW");
            }
        };


        //        Function<Car,Boolean>



        boolean isIt = lam.select(myCar);
        isIt=mySelect.select(myCar);







        Comparator<Car> cmp = (a,b) -> a.doors-b.doors;
        ArrayList<Car> c=createCars();
        System.out.printf(" diff in doors car 1 and 2 ="+cmp.compare(c.get(0),c.get(1)));

    }
}
