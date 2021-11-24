
package week_9_demo.serialisation.persistent_shopsimulator;

import week_9_demo.serialisation.Serialisation;

import java.io.Serializable;

/**
 *
 * @author ajb
 */
public class ShopSimulatorExample implements Serializable{
    int nosShoppers=20;
    Shop s;
    Shopper[] c;
    public ShopSimulatorExample(){
      s= new Shop();
      c=new Shopper[nosShoppers];
        for(int i=0;i<c.length;i++){
            c[i]=new Shopper("Shopper"+(i+1),"A",s);
        }
    }
    public static void basicShop(){
        ShopSimulatorExample sim= new ShopSimulatorExample();
        sim.s.start();
        for(int i=0;i<sim.c.length;i++)
            sim.c[i].start();
        try{
            Thread.sleep(5000);
            System.out.println("Closing Shop");
            sim.s.open=false;
            Thread.sleep(1000);
        }catch(InterruptedException e){
            System.out.println(" Basic shop interrupted, exit program"+e);
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Saving simulation");

        Serialisation.writeToFile(sim,"sim.ser");
    }
    public static void main(String[] args){
        basicShop();
    }
    
}
