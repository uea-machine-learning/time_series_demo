/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package week_9_demo.serialisation.persistent_shopsimulator;

import java.io.Serializable;

/**
 *
 * @author ajb
 */
public class Shopper extends Thread implements Serializable{
    private String name;
    private String desiredGood;
    Shop s;    
    public Shopper(String a, String b, Shop s){
        name =a;
        desiredGood =b;
        this.s=s;
    }
    @Override
    public void run(){
        while(s.open){
            //See if they have the good
            if(s.search(desiredGood)){
                boolean b=s.buy(desiredGood);
                System.out.print(" Shopper "+name+" tries to buy good "+desiredGood);
                if(!b)
                    System.out.println(" BUT FAILS");
                else
                    System.out.println(" AND SUCCEEDS");
           //Wait for a bit
            try{
                Thread.sleep(2);
            }catch(InterruptedException e){
                
            }

        
        }
    }
    }
}
