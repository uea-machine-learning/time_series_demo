/*
Lab sheet 2
 */

package week_12_demo.task2;

/**
 *
 * @author ajb
 */
public class SumArray extends Thread{

/* Static method to find the sum of an array a from sstart to end positions, 
    i.e.        a[start]+a[start+1]+...a[end]
    */    
    public static int sequentialSumArray(int[] a, int start, int end){
        int sum=a[start];
        for(int i=start+1;i<end;i++)
            sum+=a[i];
        return sum;
    }
/* To thread this operation, we need to use SumArray objects. Each one will
    be given a different start and end point, and will run in its own thread,
    then add its result to the global variable grandSum
    */    
    static Integer grandSum=0;
    static int[] data;
    public int start;
    public int end;
    String name;
    public SumArray(int s, int e, String str){
        start=s;
        end=e;
        name=str;
    }
    static synchronized void addToGrandSum(int x){
        grandSum+=x;
    }
    public void run(){
//Question 1:, write the code to find the sum of data from start to end-1,
        int localSum=0;
        for(int i=start;i<end;i++)
            localSum+=data[i];
        synchronized(SumArray.grandSum) {
            grandSum += localSum;
        }
    }
    
    public static void threadSum() throws Exception{
        int numThreads=10;
        SumArray[] s=new SumArray[numThreads];
//HERE: Question 1: Exercise to implement threaded summing of array
//Each thread should sum 1/10th of the array. Assume for simplicity 
//that the length is divisible by 10
        int size=100;
        data=new int[size];
        for(int i=0;i<size;i++)
            data[i]=i+1;
        int intervalLength=data.length/numThreads;
        for(int i=0;i<numThreads;i++)
            s[i] = new SumArray(i*intervalLength,(i+1)*intervalLength, "Thread"+i);

        for(int i=0;i<numThreads;i++)
            s[i].start();
        for(int i=0;i<numThreads;i++)
            s[i].join();
    }

    public static void main(String[] args) throws Exception {
        threadSum();
        System.out.println(" Grand sum = "+grandSum+" should be = "+(100*(100+1)/2));
    }

}
