/*
Simple IntegerArray wrapper to illustrate week_9_demo.serialisation.Serialisation
 */

package week_9_demo.serialisation;

import java.io.IOException;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Random;

/**
 * Example class to demonstrate bespoke week_9_demo.serialisation
 * @author ajb
 */
public class IntegerArray extends AbstractList<Integer> implements Serializable {
    private static final long serialVersionUID =101l;
    transient int[] d;
    int maxSize;
    int currentSize;
    public static int GLOBALMAXSIZE=1000;
    public IntegerArray(){
        maxSize=GLOBALMAXSIZE;
        d=new int[maxSize];
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return currentSize==0;
    }

    @Override
    public Integer get(int index) {
        return d[index];
    }
    public  void generateSparseData(){
        Random r= new Random();
        maxSize=10000000;
        d=new int[maxSize];
        int nosEntries=maxSize/1000;
        for(int i=0;i<nosEntries;i++) {
            d[r.nextInt(maxSize)] = r.nextInt();
        }
        currentSize=maxSize;
        
    }
//Sparse representation saving
//There is probably a better way to do this!
//could use a pair
    public static class Pair implements Serializable{
        int pos;
        int val;
        Pair(int i, int v){
            pos=i;
            val=i;
        }
    }

    private void writeObject(java.io.ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        Pair p;
       for(int i=0;i<currentSize;i++){
            if(d[i]!=0){
              s.writeInt(i);
               s.writeInt(d[i]);
            }
        }
    }
    private void readObject(java.io.ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        d=new int[maxSize];
        for(int i=0;i<currentSize;i++){
            int pos=s.readInt();
            int val=s.readInt();
//            Pair p = (Pair)s.readObject();
            d[pos]=d[val];
        }

    }


    public static void main(String[] args){
//BEFORE: Save Sparse data
        IntegerArray ar= new IntegerArray();
        ar.generateSparseData();
        Serialisation.writeToFile(ar,"IntegerArraySparse.ser");


    }
}
