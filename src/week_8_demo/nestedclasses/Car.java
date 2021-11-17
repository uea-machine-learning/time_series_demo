package week_8_demo.nestedclasses;

/*
Basic Car class for Java
 */

import java.util.ArrayList;

/**
 *
 * @author ajb
 */
public class Car {
    private String make;
    private String colour;
    int doors;
    private int type; //0=hatch back, 1= sedan, /2=SUV
    double engineSize;

    public Car(String b,String c, int d, int t, double e){
        make=b;
        colour=c;
        doors=d;
        type=t;
        engineSize=e;
    }
    public static class BlueSelector implements Selector<Car>{
       @Override
        public boolean select(Car o) {
            return o.colour.toLowerCase().equals("blue");
        }
    }
    private static class TonyCarSelector implements Selector<Car>{
        @Override
        public boolean select(Car o) {
            return o.colour.toLowerCase().equals("blue") && o.make.toLowerCase().equals("bmw");
        }

    }


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
}
