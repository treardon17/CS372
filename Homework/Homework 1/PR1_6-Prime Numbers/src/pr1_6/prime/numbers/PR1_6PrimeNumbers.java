/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr1_6.prime.numbers;

/**
 *
 * @author tylerreardon
 */
public class PR1_6PrimeNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        for (int i = 2; i<100; i++){
            boolean prime = true;
            for (int j = 2; j<i-1; j++){
                if ((i%j) == 0){
                    prime = false;
                }
            }
            if (prime){
                System.out.printf("%d\n", i);
            }
        }
    }
}
