/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr1_5.random.numbers;
import java.io.PrintStream;
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
        Random rand = new Random();
        
        for (int i = 0; i<25; i++){
            int j = rand.nextInt(100) + 1;
            int k = rand.nextInt(100) + 1;
            
            if (k>j){
             System.out.printf("First (%d) is greater than second (%d)\n", j,k);
            }else if(j>k){
             System.out.printf("Second (%d) is greater than first (%d)\n", k,j);  
            }else{
             System.out.printf("First and second are equal\n");   
            }
        }
    
    }
    
}
