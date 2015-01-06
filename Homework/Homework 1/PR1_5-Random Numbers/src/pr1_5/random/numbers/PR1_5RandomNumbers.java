/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr1_5.random.numbers;
import java.util.*;
/**
 *
 * @author tylerreardon
 */
public class PR1_5RandomNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random rand = new Random(); //seed random number
        
        for (int i = 0; i<25; i++){ //loop 25 times
            int j = rand.nextInt(100) + 1; //create first random number
            int k = rand.nextInt(100) + 1; //create second random number
            
            if (k>j){ //if k is greater than j, then print
             System.out.printf("First (%d) is greater than second (%d)\n", j,k);
            }else if(j>k){ //if j is greater than k, then print
             System.out.printf("Second (%d) is greater than first (%d)\n", k,j);  
            }else{ //if they are equal, then print
             System.out.printf("First and second are equal\n");   
            }
        }
    }
    
}
