package week_9_demo.lambdas;

import java.util.ArrayList;

public class solutions {
    public static ArrayList<Car> selectCars(ArrayList<Car> cars, Selector<Car> sel){
        ArrayList<Car> selected=new ArrayList<>();
        for(Car c: cars){
            if(sel.select(c))
                selected.add(c);
        }
        return selected;
    }

//Task 1. Use lambda expressions with your Selector
    public static void task1(){
        ArrayList<Car> myCars=Car.createCars();
        Selector<Car> redSelect=(Car c)->c.getColour().toUpperCase().equals("RED");
        ArrayList<Car> redCars=selectCars(myCars,redSelect);
        for(Car c:redCars)
            System.out.println(c);

    }
//    Task 2. Use lambda expressions for an ActionListener with Smiley
    //See Smiley
//Add one as a lambda
//ActionListener lambdaAction = e -> { buttons.get(1).setText("Blurgh");};
//        buttons.get(0).addActionListener(lambdaAction);
//Task 3: Car class: See CarTest
//           1. write a Selector class to select all BMWs
//          2. Write a Comparator class to sort by engine size
//            In CarTest: (Verify each operation works by printing the resulting array out)
 //           1. Use your Selector and the method selectFromList to find all BMWs.
//            2. Use your use Comparator to sort all cars.
//            3. Use an anonymous inner class to select all 2 door cars from the list
//            4. Use an anonymous inner class to sort the list by colour.
//            5. Use a lambda expression to repeat (5) and (6)

    public static void main(String[] args) {
        task1();
    }

}
