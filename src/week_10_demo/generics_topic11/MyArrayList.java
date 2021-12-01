/*
Simple MyArrayList wrapper to illustrate week_9_demo.serialisation.Serialisation
 */

package week_10_demo.generics_topic11;

import week_10_demo.generics_topic10.Teacher;
import week_9_demo.serialisation.Serialisation;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * MyArrayList to demonstrate generics
 * @author ajb
 */
public class MyArrayList<E> implements Serializable {
    private static final long serialVersionUID =101l;
    transient E[] d;
    int maxSize;
    int currentSize;
    public static int GLOBALMAXSIZE=1000;

    public class MyIterator implements Iterator<E> {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }


    }

















    public MyArrayList(){
        maxSize=GLOBALMAXSIZE;
        d=(E[])new Object[maxSize];
    }

    public int size() {
        return currentSize;
    }

    public boolean isEmpty() {
        return currentSize==0;
    }

    public E get(int index) {
        return d[index];
    }
    public  void generateSparseData(){
        Random r= new Random();
        maxSize=10000000;
        d=(E[])new Object[maxSize];
        int nosEntries=maxSize/1000;
        for(int i=0;i<nosEntries;i++) {
//            d[r.nextInt(maxSize)] = r.nextInt();
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



    public static void main(String[] args) {
        // 1. Writing simple generic data structures. Write a Pair class, make MyArrayList generic
        week_10_demo.generics_topic11.Pair raw = new week_10_demo.generics_topic11.Pair();
//        raw.key="Anything I want";
        raw.value=new Teacher("Tony");
        raw.key = 4444;
        week_10_demo.generics_topic11.Pair<Integer,Teacher> typed2 = new week_10_demo.generics_topic11.Pair<>();

        MyArrayList<Number> xxx;

        // 2. Generics in nested classes. Write static Comparator for Pair. Write inner class Iterator for MyArrayList
        MyArrayList<String> foo= new MyArrayList<>();
        MyArrayList<Integer> bar= new MyArrayList<>();
        Iterator<String> fooIterator = foo.new MyIterator();
        // 3. Bounded type parameters. Enforce types on Pair with extends. Make MyArray List for Comparable only








        //4. Generic methods: InsertionSort example from lecture. Pain for the programmer, not the user!

        // 5. Wildcards: loosening restrictions. Use wildcards for MyArrayList

        // finally: Read the real ArrayList class
    }


}
