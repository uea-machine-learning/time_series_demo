package week_12_demo.task4;

import java.io.IOException;

public class Topic13Task4 {


    public static void task4Sequential(){
        boolean updated=false;
        WebsiteChecker[] web=new WebsiteChecker[WebsiteChecker.urlNames.length];
        for(int i=0;i<web.length;i++){
            try{
                web[i] = new WebsiteChecker(WebsiteChecker.urlNames[i]);
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
                    updated=web[i].checkForChanges();
                }catch(IOException e){
                    System.out.println("Unable to load website  "+web[i].website);
                }
            }
            if(updated)
                System.out.println("First page to update ="+web[i].website);
            checkCount++;
            System.out.println("Checked "+checkCount+" times");



        }

    }


}
