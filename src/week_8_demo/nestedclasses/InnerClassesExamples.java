package week_8_demo.nestedclasses;

public class InnerClassesExamples {
    int a;
    int b;
    PublicInnerClass myInner=new PublicInnerClass();
    public InnerClassesExamples(int x, int y){
        a=x;
        b=y;
    }
    public void foo(){
        PublicInnerClass temp=new PublicInnerClass();
        int a=temp.findSum();
    }
    public static void bar(){
// ERROR        PublicInnerClass temp=new PublicInnerClass();
    }
    public class PublicInnerClass{
        int findSum(){
            return a+b;
        }
    }
    private class PrivateInnerClass{

    }

    public static void main(String[] args) {
        InnerClassesExamples outer= new InnerClassesExamples(1,2);
        PublicInnerClass inner =outer.new PublicInnerClass();
//      PublicInnerClass inner = new PublicInnerClass(); ERROR
        int s= inner.findSum();

    }
}
