/*
Class for Task 1 on threads
 */

package week_12_demo.task1;

/**
 *
 * @author ajb
 */
public class Subtracter extends Thread{

    @Override
    public void run() {
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(" Dont wake me up!");
        }
        Application.subtract(10);

//        synchronized(Application.class) {
//            Application.sharedData -= 10;
//        }
        System.out.println("WORLD");
    }

}
