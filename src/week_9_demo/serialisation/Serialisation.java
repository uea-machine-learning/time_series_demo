package week_9_demo.serialisation;

import java.io.*;
import java.util.ArrayList;

public class Serialisation {


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Student alice = new Student("Alice",99);
        FileOutputStream fos = new FileOutputStream("Alice.ser");
        ObjectOutputStream out = new ObjectOutputStream(fos);
        out.writeObject(alice);
        out.close();


        FileInputStream inf= new FileInputStream("Alice.ser");
        ObjectInputStream ino = new ObjectInputStream(inf);
        Object ob = ino.readObject();
        System.out.println(ob);
    }



    static ArrayList<String> makeArray(){
//Create and save an array list
        ArrayList<String> myList=new ArrayList<>();
        myList.add("forty");
        myList.add("nine");
        myList.add("forty");
        myList.add("nine");
        myList.add("undefeated");
        myList.add("forty");
        myList.add("nine");
        myList.add("forty");
        myList.add("nine ");
        myList.add("I");
        myList.add("say");
        myList.add("forty");
        myList.add("nine");
        myList.add("forty");
        myList.add("nine");
        myList.add("undefeated");
        myList.add("playing");
        myList.add("football");
        myList.add("the");
        myList.add("arsenal");
        myList.add("way");
        return myList;
    }
    public static void writeToFile(Serializable s, String filename){
        try{
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(s);
            out.close();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    public static Object readFromFile(String filename) {
        Object obj=null;
        try{
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fis);
            obj =in.readObject();
            in.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return obj;

    }

}
