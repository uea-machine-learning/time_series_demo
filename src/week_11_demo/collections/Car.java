/*
Basic Car class for Java Lab 3 on prog 2
 */
package week_11_demo.collections;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

/**
 *
 * @author ajb
 */
public class Car implements Serializable {
    enum CarMakes{BMW,Mercedes,Ford,Toyota,Volkswagen,Honda,Cadillac,Chrysler,Tesla,Audi,LandRover}

    //Better to use an enum for makes
    private String make;
    public int doors;
    private String colour;
    private int type; //0=hatch back, 1= sedan, /2=SUV
    private double engineSize;
    static String foo="FOO";
    public String getMake(){ return make;}
    public Car(String make,String colour) {
        this.make=make;
        this.colour=colour;
    }
    public Car(String make) {
        this.make=make;
    }

    public Car(String make,String colour, int doors, int type, double engineSize){
        this.make=make;
        this.colour=colour;
        this.doors=doors;
        this.type=type;
        this.engineSize=engineSize;
    }
    public Car() {
        make="blank";
        colour="blank";
    }

    private String twoThings(String s, String a){
        System.out.println("Im here!");
        return "Up the arsenal";
    }

    private static class EngineSizeCompare implements Comparator<Car>{
        @Override
        public int compare(Car o1, Car o2) {
            if(o1.engineSize> o2.engineSize) return 1;
            if(o1.engineSize< o2.engineSize) return -1;
            return 0;
        }
    }
    private static class EngineSizeComp implements Comparator{
        @Override
        public int compare(Object o1, Object o2) {
            if(((Car)o1).engineSize> ((Car)o2).engineSize) return 1;
            if(((Car)o1).engineSize< ((Car)o2).engineSize) return -1;
            return 0;
        }
    }

    public String toString(){
        return colour+" "+make+" with "+doors+" doors";
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
    static ArrayList<Car> createRandomCars(int n) {
        ArrayList<Car> cars = new ArrayList<>(n);
        CarMakes[] makes = CarMakes.values();
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            cars.add(new Car(makes[rand.nextInt(makes.length)].toString()));
        }
        return cars;
    }

    public static void main(String[] args) {
        Comparator<Car> cmp = (a,b) -> a.doors-b.doors;
        ArrayList<Car> c=createCars();
        System.out.printf(" diff in doors car 1 and 2 ="+cmp.compare(c.get(0),c.get(1)));

    }
}
