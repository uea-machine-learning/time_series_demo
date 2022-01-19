package week_12_demo.live_example;

public class Application {


    public static void main(String[] args) {
        ClassA first=new ClassA();
        ClassB second=new ClassB();

        first.connect(second);
        second.connect(first);


        first.start();
        second.start();
    }

}
