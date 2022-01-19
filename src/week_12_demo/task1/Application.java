/*
Class for Task 1 on threads
*/

package week_12_demo.task1;

import java.util.ArrayList;

/**
 *
 * @author ajb
 */
public class Application {
    public static int sharedData=0;
    static String str;
    //Shared memory
    public static ArrayList<Integer> sharedMemory = new ArrayList<>();

    public synchronized static void subtract(int x){
        sharedData-=x;
    }

    public static void main(String[] args) {
        Adder myAdder= new Adder();
        Subtracter first=new Subtracter();
        Subtracter second=new Subtracter();
        long t=System.nanoTime();
        System.out.println(" shared data = "+Application.sharedData);
        Thread temp = new Thread(myAdder);
        temp.start();
        first.start();
        second.start();
        try {
            temp.join();
            first.join();
            second.join();
        } catch (InterruptedException e) {
            System.out.println(" interrupted main");
        }

        System.out.println(" shared data = "+Application.sharedData);
        t=System.nanoTime()-t;
        t/=1000000000;
        System.out.println(" shared data = "+Application.sharedData);
        System.out.println(" time taken = "+t+" seconds");

    }



 
    
}
