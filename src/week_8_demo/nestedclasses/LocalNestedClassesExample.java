package week_8_demo.nestedclasses;

/**
 * I can think of no sensible scenario where I would use these
 */
public class LocalNestedClassesExample {
    int a,b;

    LocalNestedClassesExample(int a, int b){
        this.a=a;
        this.b=b;
    }
    public void foo() {
        int sum=100;
        class LocalInner {
            public int blah() {
                return a+b+sum;
            }
        }
        LocalInner x=new LocalInner();
        System.out.println(" returns "+x.blah());
    }
    public static void main(String[] args) {
        LocalNestedClassesExample lne= new LocalNestedClassesExample(1,2);
        lne.foo();
    }
}
