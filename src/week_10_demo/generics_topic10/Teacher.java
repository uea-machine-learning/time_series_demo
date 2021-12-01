package week_10_demo.generics_topic10;

public class Teacher {
    String name;
    int age;
    public Teacher(String str){
        name=str;
    }
    @Override
    public String toString(){
        return name;
    }

}
