package week_12_demo;

public class ClassB extends Thread{
    ClassA bar;
    public String name;
    public int score;
    public String colour;
    void connect(ClassA x){
        bar=x;
    }
    @Override
    public void run() {
        System.out.println("Going to sleep");
        try {
            for(int i=0;i<1000000000;i++);

            synchronized(bar) {

                bar.wait();
            }
//            bar.interrupt();

//            synchronized(this) {
//                notifyAll();
//            }

        } catch (InterruptedException e) {
            System.out.println(" B interrupted");
        }
        System.out.println("AWAKE");


    }


}
