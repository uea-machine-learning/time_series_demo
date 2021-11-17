package week_8_demo.nestedclasses;

public class Examples {
    String foo;

    public static class Nested{
        String bah;
    }

    public class Inner{
        String meh;
        public Inner(){
            meh=foo;
        }


    }

    public static void main(String[] args) {
        Examples first = new Examples();
        Examples.Nested second = new Examples.Nested();
        class MyLocalClass{
            int x,y;
        }
        MyLocalClass bob= new MyLocalClass();
        bob.x=100;
        bob.y=55;
        MyLocalClass alice = new MyLocalClass();
        alice.x=66;
        alice.y=88;


    }
}

