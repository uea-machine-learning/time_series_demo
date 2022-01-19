/*
Class for Task 1 on threads
 */

package week_12_demo.task1;

/**
 *
 * @author ajb
 */
public class Adder implements Runnable{
    @Override
    public void run() {
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            System.out.println(" LET ME SLEEP");
        }
        Application.sharedData+=50;
        System.out.println(" HELLO");
    }
}
