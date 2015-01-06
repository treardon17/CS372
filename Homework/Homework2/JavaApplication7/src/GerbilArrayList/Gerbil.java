/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GerbilArrayList;

/**
 *
 * @author tylerreardon
 */
public class Gerbil {
    public int gerbilNumber;
    
    public Gerbil (int gerbilNumber){
        this.gerbilNumber = gerbilNumber;
    }
    
    public void hop(){
        System.out.printf("Gerbil Number %d is hopping!\n", (int)gerbilNumber);
    }
}
