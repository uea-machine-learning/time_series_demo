package week_9_demo.serialisation;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Part1Solution {
/*
    \item In the project you have downloaded is the file Object.ser. Load it into an \texttt{Object} reference and print it out.
    \item Get an \texttt{Iterator} from the object by casting it to \texttt{Iterable} and calling \texttt{iterator()}.
    \item Iterate across the object printing out its contents.
    \item Create any \texttt{excluded.ArrayList} of strings with the message of your choice, save it as a .ser object and send it to a friend in the lab. Get them to read it and send back a response.

 */

    public static void main(String[] args) {
        Object obj=null;
        String filename  = "Object.ser";
        try{
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fis);
            obj =in.readObject();
            in.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
            System.exit(0);
        }
        System.out.println(" Loaded object  = "+obj);
        Iterator it =((Iterable)obj).iterator();
        while(it.hasNext())
            System.out.println(it.next());
        ArrayList<String> arr=new ArrayList<>();
        arr.add("when");
        arr.add("I");
        arr.add("was");
        arr.add("just");
        arr.add("a");
        arr.add("small");
        arr.add("boy");
        arr.add("I");
        arr.add("asked");
        arr.add("my");
        arr.add("mother");
        arr.add("what");
        arr.add("will");
        arr.add("I");
        arr.add("be?");
        try{
            FileOutputStream fos = new FileOutputStream("Object2.ser");
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(arr);
            out.close();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }



    }
}
