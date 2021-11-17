package week_8_demo.nestedclasses;

public class AnonymousNestedClassExample {
    interface Testy{
        void bar();
    }
    public static void main(String[] args) {
        int sum=100;
        Testy temp = new Testy() {
            @Override
            public void bar() {
                System.out.println(" IN A METHOD!!"+sum);
            }
        };
        temp.bar();
    }
}
