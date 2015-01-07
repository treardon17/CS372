/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GerbilArrayList;

/**
 * This gerbil class will will name a gerbil and make it hop
 * @author tylerreardon
 */
public class Gerbil {
    public int gerbilNumber;
    
    /**
     * Assigns the gerbilNumber to gerbilNumber
     * @param gerbilNumber 
     */
    public Gerbil (int gerbilNumber){
        this.gerbilNumber = gerbilNumber;
    }
    /**
     * Makes the gerbil hop and returns nothing
     */
    public void hop(){
        System.out.printf("Gerbil Number %d is hopping!\n", (int)gerbilNumber);
    }
}
