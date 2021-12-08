
package week_11_demo.threads;

/* Thread example 1: Basic first example of threads and the use of
join for one thread to wait for another to finish
*/

public class ThreadsBasics extends Thread{
//public class ThreadsBasics implements Runnable{


    public String threadName;
    public ThreadsBasics(String s){
        threadName=s;
    }

    @Override
    public void run(){
        for(int i=0;i<100000;i++) {
            if (i % 10000 == 0) {
                for (int j = 0; j < id; j++){
                    System.out.print("\t ");
                }
                System.out.println(threadName + " iteration " + i);
            }
        }
    }

    public int id=0;
    public void setID(int x){id=x;}

    public ThreadsBasics(String name, int n){
        threadName=name;
        id=n;
    }

    public static void main(String[] args){
        ThreadsBasics t1=new ThreadsBasics(" Object 1");
        ThreadsBasics t2=new ThreadsBasics(" Object 2");
        System.out.println(" THREAD EXAMPLE 1");
        Thread myThread = new Thread(t1);
        Thread myThread2 = new Thread(t2);
        t1.run();
        System.out.println("**********************************************");
        t2.run();
        System.out.println("**********************************************");
        t1.start();
        System.out.println("**********************************************");
        t2.start();
















/*        t1.start();
        t2.start();
        t1.setID(66);
       try{
            t1.join();
            t2.join();
        }catch(InterruptedException e){
            System.out.println("EXIT with error "+e);
            System.exit(0);
        }
        for(int i=0;i<10000;i++)
            if(i%1000==0)
                System.out.println("Main Thread iteration:"+i);
        System.out.println(" FINISHED in MAIN");
*/
    }

}
