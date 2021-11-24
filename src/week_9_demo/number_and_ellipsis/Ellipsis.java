package week_9_demo.number_and_ellipsis;

public class Ellipsis {
    public static double average(Double...numbers){
        double s=0;
        for(int i=0;i<numbers.length;i++)
            s+=numbers[i];
        return s/numbers.length;
    }
    public static double average(Integer...numbers){
        double s=0;
        for(int i=0;i<numbers.length;i++)
            s+=numbers[i];
        return s/numbers.length;
    }

    public static void main(String[] args){
        double d1=100,d2=33,d3=333;
        double mean;
        mean=average(d1);
        mean=average(d1,d2);
        mean=average(d1,d2,d3);

        double x=average(11,12,13);
        System.out.println("x = "+x);
    }

}
