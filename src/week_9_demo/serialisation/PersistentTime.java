package week_9_demo.serialisation;


import java.io.*;
import java.util.*;

/*
PersistentTime object used in Lecture 4
 
 * @author ajb
 */
public class PersistentTime implements Serializable
{
    private static final long serialVersionUID = 111L;
    int x=1;
    int y=2333;
 	private Date time;
 	transient private String password;
        private void setPassword(String s){password=s;}
        
        public void resetTime(String passwd){
                if(passwd.equals(password))  
                        time =Calendar.getInstance().getTime();
                else  System.out.println(" Wrong password");
        }

	public PersistentTime(){
            time = Calendar.getInstance().getTime();
	}
	public Date getTime(){return time;}
        
        public static void writeSerExample(String filename){
            PersistentTime time = new PersistentTime();
            try{
                FileOutputStream fos = new FileOutputStream(filename);
                ObjectOutputStream out = new ObjectOutputStream(fos);
                out.writeObject(time);
//                out.close();
           }
          catch(IOException ex) {
                ex.printStackTrace();
           }                      
        }
        public static PersistentTime readSerExample(String filename) {       
            PersistentTime time=null;
            try{
                FileInputStream fis = new FileInputStream(filename);
                ObjectInputStream in = new ObjectInputStream(fis);
                time =(PersistentTime)in.readObject();
                in.close();
            }
            catch(Exception ex){
                ex.printStackTrace();
           }                      
            return time;

        }
        public static void main(String[] args){
  //          writeSerExample("c://temp//time.ser");
            PersistentTime t=readSerExample("c://Temp//time.ser");
            System.out.println(t.getTime());
  //          sleep(1000);
            writeSerExample("c://temp//time.ser");
            
            
        }
        
}

