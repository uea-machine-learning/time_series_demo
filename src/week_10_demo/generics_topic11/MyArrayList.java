/*
Simple MyArrayList wrapper to illustrate week_9_demo.serialisation.Serialisation
 */

package week_10_demo.generics_topic11;

import week_9_demo.serialisation.Serialisation;

import java.io.IOException;
import java.io.Serializable;
import java.util.Random;

/**
 * MyArrayList to demonstrate generics
 * @author ajb
 */
public class MyArrayList implements Serializable {
    private static final long serialVersionUID =101l;
    transient Integer[] d;
    int maxSize;
    int currentSize;
    public static int GLOBALMAXSIZE=1000;
    public MyArrayList(){
        maxSize=GLOBALMAXSIZE;
        d=new Integer[maxSize];
    }

    public int size() {
        return currentSize;
    }

    public boolean isEmpty() {
        return currentSize==0;
    }

    public Integer get(int index) {
        return d[index];
    }
    public  void generateSparseData(){
        Random r= new Random();
        maxSize=10000000;
        d=new Integer[maxSize];
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
        d=new Integer[maxSize];
        for(int i=0;i<currentSize;i++){
            int pos=s.readInt();
            int val=s.readInt();
//            Pair p = (Pair)s.readObject();
            d[pos]=d[val];
        }

    }


    public static void main(String[] args){
//BEFORE: Save Sparse data
        MyArrayList ar= new MyArrayList();
        ar.generateSparseData();
        Serialisation.writeToFile(ar,"IntegerArraySparse.ser");


    }
}
