/*
 Code for Lab Sheet 3 demonstraing Functors vs Lambdas
 */
package week_9_demo.lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author ajb
 */
public class CarTest {
    static ArrayList<Car> selectFromList(List<Car> a, Selector<Car> s) {
        ArrayList a2 = new ArrayList();
        for (Car ob : a) {
            if (s.select(ob))
                a2.add(ob);
        }
        return a2;
    }

    static ArrayList<Car> selectFromList(List<Car> a, Predicate<Car> s) {
        ArrayList a2 = new ArrayList();
        for (Car ob : a) {
            if (s.test(ob))
                a2.add(ob);
        }
        return a2;
    }

    public static void task3_1(ArrayList<Car> cars) {
//Select all BMWs
        Selector<Car> sel = new Car.BMWSelect();
        for (Car c : cars)
            if (sel.select(c))
                System.out.println(" Selected " + c);
    }

    public static void task3_2(ArrayList<Car> cars) {
//Sort by engine size
        Comparator<Car> cmp = new Car.CompareEngine();
        Collections.sort(cars, cmp);
        for (Car c : cars)
            System.out.println(c);
    }

    public static void task3_3(ArrayList<Car> cars) {
//Select all 2 door using anonymous
        Selector<Car> sel = new Selector<Car>() {
            @Override
            public boolean select(Car o) {
                return o.doors == 2;//Oops, public!
            }
        };
        for (Car c : cars)
            if (sel.select(c))
                System.out.println(" Selected " + c);
    }

    public static void task3_4(ArrayList<Car> cars) {
//Sort by colour with anonymous inner
        Comparator<Car> cmp = new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.colour.compareTo(o2.colour);
            }
        };
        Collections.sort(cars, cmp);
        for (Car c : cars)
            System.out.println(c);
    }

    public static void task3_5(ArrayList<Car> cars) {
//Lambdas to select and sort
        System.out.println(" SELECTING WITH LAMBDA");
        Selector<Car> sel = o -> o.doors == 2;//Oops, public!
        for (Car c : cars)
            if (sel.select(c))
                System.out.println(" Selected " + c);

        System.out.println(" SORTING WITH LAMBDA");
        Comparator<Car> cmp = (o1, o2) -> o1.colour.compareTo(o2.colour);
        Collections.sort(cars, cmp);
        for (Car c : cars)
            System.out.println(c);
    }

//Task 4. Functional Interfaces.
    public static void task4(ArrayList<Car> cars){
//Predicate to store a selector lambda
        System.out.println(" SELECTING WITH LAMBDA predicate for 2 doors");
       Predicate<Car> twoDoor= c -> c.doors==2;
       for(Car c:cars)
           if(twoDoor.test(c))
               System.out.println(c);
        Function<Car,Boolean> oneDoor= c -> c.doors==1;
        System.out.println(" SELECTING WITH LAMBDA Function for 1 door");
        for(Car c:cars)
            if(twoDoor.test(c))
                System.out.println(c);
        System.out.println(" SORTING WITH LAMBDA BiFunction for # doors");
        BiFunction<Car,Car,Integer> cmp= (o1, o2) -> o1.doors-o2.doors;
//Cant actually use a BiFunction, must be a comparator
//        cars.sort(cmp);
//        for (Car c : cars)
//            System.out.println(c);



    }



    public static void main(String[] args) {
        ArrayList<Car> c = Car.createCars();
        System.out.println(" Part 1: find BMW with selector ");
        task3_1(c);
        System.out.println(" Part 2: Sort cars with BMWComparator ");
        task3_2(c);
        System.out.println(" Part 3: select 2 doors with anonymous inner ");
        task3_3(c);
        System.out.println(" Part 4: sort by colour with anonymous inner ");
        task3_4(c);
        System.out.println(" Part 5: Do parts 3 and 4 with a lambda ");
        task3_5(c);
        task4(c);
        System.exit(0);
//More hackery
//1. Select all blue cars using an anonymous inner
        Selector<Car> sel1 = new Selector<Car>() {
            @Override
            public boolean select(Car o) {
                return o.colour.toLowerCase().equals("blue");
            }
        };
//2. Select all Tony car using a lambda
        Selector<Car> sel2 = o -> o.colour.toLowerCase().equals("blue");
        ArrayList<Car> blue = selectFromList(c, sel1);
        for (Car cr : blue)
            System.out.println(cr);
        System.out.println(" WITH LAMBDA  ");
        blue = selectFromList(c, sel2);
        for (Car cr : blue)
            System.out.println(cr);

        sel2 = (Car o) -> {
            return o.colour.toLowerCase().equals("blue") && o.make.toLowerCase().equals("bmw");
        };
        blue = selectFromList(c, sel2);
        for (Car cr : blue)
            System.out.println(cr);

//3. Select all Tony car using a Predicate lambda
        Predicate<Car> sel3 = (car) -> car.doors == 4;
        blue = selectFromList(c, sel3);
        for (Car cr : blue)
            System.out.println(cr);


    }

}
