package week_8_demo.nestedclasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class CarFleet implements Iterable<Car>{
    ArrayList<Car> mycars;

    CarFleet(){
        mycars=Car.createCars();
    }

    @Override
    public Iterator<Car> iterator() {
        return new FleetIterator();
    }

    public class FleetIterator implements Iterator<Car>{
        int pos=0;
        @Override
        public boolean hasNext() {
            return pos<mycars.size();
        }
        @Override
        public Car next() {
            return mycars.get(pos++);
        }
    }

    public static class CompareSize implements Comparator<CarFleet>{

        @Override
        public int compare(CarFleet o1, CarFleet o2) {
            return o1.mycars.size()-o2.mycars.size();
        }
    }

    public static void main(String[] args) {
        CarFleet c1=new CarFleet();
        CarFleet c2=new CarFleet();
        Comparator<CarFleet> cmp=new CompareSize();
        int x=cmp.compare(c1,c2);
        System.out.println(" Comparison  = "+x);

        Iterator<Car> it1=c1.new FleetIterator();
        Iterator<Car> it2=c2.new FleetIterator();


        class CarSelector implements Comparator<Car>{
            int field=0; //What to select on: 0: engine size, 1: doors
            CarSelector(int x){
                field=x;
            }
            @Override
            public int compare(Car o1, Car o2) {
                if(field ==0)// Compare cars on engine size
                    return (int)(o1.engineSize-o2.engineSize);
                else if(field ==1 )
                    return o1.doors-o2.doors;
                return 0;
            }
        }
        Scanner s= new Scanner(System.in);
        while(it1.hasNext() && it2.hasNext()){
            Car player1=it1.next();
            Car player2=it2.next();
            System.out.println(" Choose doors (1) or engine size (0) to compare");
            int res=s.nextInt();
            Comparator<Car> carCmp; //=new CarSelector(x);
            switch(res){
                case 0:
                    carCmp= new Comparator<Car>(){
                        @Override
                        public int compare(Car o1, Car o2) {
                            return (int)(o1.engineSize-o2.engineSize);
                        }
                    };
                    break;
                case 1: default:
                    carCmp=new Comparator<Car>(){

                        @Override
                        public int compare(Car o1, Car o2) {
                            return o1.doors-o2.doors;
                        }
                    };
                    break;
            }


            int c=carCmp.compare(player1,player2);
            if(c>0)
                System.out.println(" player 1 wins the card");
            else
                System.out.println(" player 2 wins the card");
        }








    }
}
