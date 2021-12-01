package week_10_demo.generics_topic11;
//Code demo: Topic 11: Advanced generics: Writing generic data structures

import week_10_demo.generics_topic10.Student;
import week_10_demo.generics_topic10.Teacher;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 1. Writing simple generic data structures
 * 2. Generics in nested classes
 * 3. Bounded type parameters
 * 4. Generic methods
 * 5. Wildcards: loosening restrictions
 */

public class GenericsAdvanced {


    public static void main(String[] args) {
        // 1. Writing simple generic data structures. Write a Pair class, make MyArrayList generic
        Pair raw = new Pair();
//        raw.key="Anything I want";
        raw.value=new Teacher("Tony");
        raw.key = 4444;
//        Pair<String,Teacher> typed = new Pair<>();
        Pair<Integer,Teacher> typed2 = new Pair<>();

//        typed.key = "Tony";
//        typed.value = new Teacher("Gavin");
        ArrayList<String> ssss;
        MyArrayList<Number> xxx;

        // 2. Generics in nested classes. Write static Comparator for Pair. Write inner class Iterator for MyArrayList
        MyArrayList<String> foo= new MyArrayList<>();


        // 3. Bounded type parameters. Enforce types on Pair with extends. Make MyArray List for Comparable only
        Pair<Double,String> simple = new Pair<>(10.0,"Hello");
        Pair<Double,String> simple2 = new Pair<>(40.0,"World");
        System.out.println(" Compare pair = "+simple.compareTo(simple2));
        Pair xxxx= new Pair();














        //4. Generic methods: InsertionSort example from lecture. Pain for the programmer, not the user!

        // 5. Wildcards: loosening restrictions. Use wildcards for MyArrayList

        // finally: Read the real ArrayList class
    }

}
