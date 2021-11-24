/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package week_9_demo.serialisation.persistent_shopsimulator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author ajb
 */
public class Shop extends Thread implements Serializable{
    public static String goodsList="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static Random r = new Random();
    private ArrayList<String> goods= new ArrayList<>();
    volatile boolean open=true;	
    
    public Shop(){
        restock();
        for(String s:goods)
            System.out.print(s);
            System.out.print("\n");
    }
    public boolean search(String s){
        return goods.contains(s);
	}
	public boolean buy(String s){ 
            System.out.println(" Someone trying to buy "+s+" present ="+goods.contains(s));
            if(!goods.contains(s)) return false;
            goods.remove(s);
            return true;	//Removes the good s from goods 
	}


    public void run(){
        while(open){
            //Check stock levels
            if(goods.size()<10) //Reorder
                restock();
        }
    }
    public final  synchronized void restock(){
        for (int i=0;i<26;i++){
            String s="";
            s+=goodsList.charAt(i);
            goods.add(s);
//            System.out.println(" Adding good "+s);
        }
            
    }       
}
