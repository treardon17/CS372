/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs372.calculatingpi;

/**
 * This class represents PI
 * @author tylerreardon
 */
public class PI {
    /**
     * CalculatePI calculates PI to the user specified accuracy
     * Updates the variable PI
     * @param reps 
     */
    public void calculatePI (int reps){
        double PI = 0; //the sum of PI
        int denominator = 1; //set denominator
            for (int i = 0; i<reps; i++){ //loop specified number of times
                if(i%2 == 0){ //number corresponds to 1+2x, subtract this value
                    PI += (double)4/denominator;
                }
                else{ //otherwise add the value
                    PI -= (double)4/denominator;
                }
                denominator += 2; //increment denominator by two
                System.out.printf("%d: %f\n", (int)i+1, PI); //outputs the PI
        }
            
    }   
}
