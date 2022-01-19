
package week_12_demo.task2;

import java.text.DecimalFormat;
import java.util.Random;

/**
 *
 * @author ajb
 */

public class Topic13Task2 {


    public static void question1ArraySum(){
        DecimalFormat df= new DecimalFormat("###.####");
        Random rf= new Random();
        System.out.println("n, sequential, concurrent (10 threads)");
        for(int size=100;size<50000;size+=100){
            SumArray.grandSum=0;
            SumArray.data=new int[size];
            for(int i=0;i<size;i++)
                SumArray.data[i]=rf.nextInt(100);
            long t1=System.nanoTime();
            int x=SumArray.sequentialSumArray(SumArray.data,0,SumArray.data.length);
            long t2=System.nanoTime();


            System.out.print(size+","+df.format((t2-t1)));
            t1=System.nanoTime();
            try {
                SumArray.threadSum();
            } catch (Exception e) {
                System.out.println(" catch exceptions properly");
            }
            t2=System.nanoTime();
            System.out.println(","+df.format((t2-t1))+",");

        }
    }


    public static void main(String[] args) {
        question1ArraySum();
    }

}
