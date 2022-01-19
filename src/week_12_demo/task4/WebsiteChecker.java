/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package week_12_demo.task4;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author ajb
 */
public class WebsiteChecker extends Thread{
    public static String[] urlNames={"http://www.bbc.co.uk/","http://www.timeseriesclassification.com/",
        "http://www.theguardian.com/","http://www.telegraph.co.uk/","http://weka.sourceforge.net/doc.dev/",
        "http://www.dailymail.co.uk/home/index.html"};
    int nosLines;
    String website;
    URL myURL;
    boolean updated;
    
    public WebsiteChecker(String htpp) throws IOException{
        updated=false;
        this.website=htpp;
        myURL = new URL(website);
        HttpURLConnection huc =  (HttpURLConnection)  myURL.openConnection(); 
        InputStream in=huc.getInputStream(); 
        int http_status = huc.getResponseCode();
        BufferedReader buff;
        buff = new BufferedReader(new InputStreamReader(in));
        nosLines=countLines(buff);
  
    }

    public void run(){
        int checkCount=0;
        while(!updated){
            try {
                sleep(1000);
                checkCount++;
                System.out.println("Check number "+checkCount+" website "+website);
                updated=checkForChanges();
            } catch (IOException e) {
                System.out.println(" IO EXCEPTION");
            }
            catch (InterruptedException e) {
                System.out.println(" INTERRUPTED EXCEPTION");
            }
        }
        System.out.println(" Website "+website+" has been updated");
    }

    public final boolean checkForChanges() throws IOException{
        myURL = new URL(website);
        HttpURLConnection huc =  (HttpURLConnection)  myURL.openConnection(); 
        InputStream in=huc.getInputStream(); 
        int http_status = huc.getResponseCode();
//        System.out.print("Website status ="+http_status);
 //       System.out.print("Input stream ="+in);
        BufferedReader buff;
        buff = new BufferedReader(new InputStreamReader(in));
        int c=countLines(buff);
        if (c==nosLines)
            return false;
        nosLines=c;
        return true;
            
    }
    public final int countLines(BufferedReader b) throws IOException{
        int c=0;
        String inputLine;
        while ((inputLine = b.readLine()) != null)
            c++;
        return c;
   }

    public static void task3Part1(){
        boolean updated=false;
        WebsiteChecker[] web=new WebsiteChecker[urlNames.length];
        for(int i=0;i<web.length;i++){
            try{
                web[i] = new WebsiteChecker(urlNames[i]);
            }catch(IOException e){
                System.out.println("ERROR loading the websites, quit program ");
                System.exit(0);
            }
        }
        int checkCount=0;

        while(!updated){
            int i;
            for(i=0;i<web.length && !updated; i++){
                try{
                    System.out.println("Checking "+ web[i].website);
                    updated=web[i].checkForChanges();
                }catch(IOException e){
                    System.out.println("Unable to load website  "+web[i].website);
                }
            }
            if(updated)
                System.out.println("First page to update ="+web[i].website);
            checkCount++;
            System.out.println("Checked "+ checkCount+" times");
        }

    }
    public static void task3Part2() {
        WebsiteChecker[] web=new WebsiteChecker[urlNames.length];
        for(int i=0;i<web.length;i++){
            try{
                web[i] = new WebsiteChecker(urlNames[i]);
            }catch(IOException e){
                System.out.println("ERROR loading the websites, quit program ");
                System.exit(0);
            }
        }
        for(int i=0;i<web.length;i++)
            web[i].start();
        try {
            for (int i = 0; i < web.length; i++)
                web[i].join();
        }
        catch(InterruptedException e){
            System.out.println("ERROR loading the websites, quit program ");
            System.exit(0);
        }
    }
    public static void main(String[] args) {
//        task3Part1();
        task3Part2();
    }

 
}
