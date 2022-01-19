package week_12_demo.live_example;

public class ClassA extends Thread{
    ClassB foo;

    void connect(ClassB x){
        foo=x;
    }


    public void run(){
        System.out.println("Going to sleep");
        foo.interrupt();

        try {
            sleep(1000);

        } catch (InterruptedException e) {
            System.out.println("INTERRUPTED "+e);
        }
        System.out.println("AWAKE");


    }





}
