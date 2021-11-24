package week_9_demo.reflection;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class ReflectionBasics {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
    //Demo of reflection
        FileInputStream fos = new FileInputStream("Object.ser");
        ObjectInputStream out = new ObjectInputStream(fos);
        Object obj=null;
        try {
            obj = out.readObject();
        }
        catch(ClassNotFoundException epx) {
            System.out.println(" Class not found ");
        }
        catch(IOException ex2){
            System.out.println(" IO Exception");
        }
        finally {
            out.close();
        }
        Class objClass = obj.getClass();
        System.out.println(" Class is  = "+objClass);
        String name = objClass.getSimpleName();
        System.out.println(" Class is  = "+name);
        Method[] methods = objClass.getDeclaredMethods();
        System.out.println(" Method 1 = "+methods[0].getName());
        System.out.println(" Num methods = "+methods.length);
        Field[] fields = objClass.getFields();
        System.out.println(" All public field names = ");
        for(Field s:fields)
            System.out.println(" "+s.getName());
        fields = objClass.getDeclaredFields();
        System.out.println(" All field names = ");
        for(Field s:fields)
            System.out.println(" "+s.getName());
        ArrayList<String> str=null;
        if(obj instanceof ArrayList){
 //         if(objClass.isAssignableFrom(ArrayList.class)) {
              str = (ArrayList<String>) obj;
              for (String s : str)
                  System.out.println(s);
          }

    }



}
