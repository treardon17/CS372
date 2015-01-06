/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr1_6.prime.numbers;
import java.util.Scanner;
/**
 *
 * @author tylerreardon
 */
public class PR1_6PrimeNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Max Number: ");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt(); //read in max number from user
        for (int i = 2; i<num; i++){
            boolean prime = true; //default to setting each number to prime
            for (int j = 2; j<i-1; j++){
                if ((i%j) == 0){ //if the number is divisible by more than just itself and 1...
                    prime = false; //set prime to false
                }
            }
            if (prime){ //if the number was only divisible by itself and 1, it is prime
                System.out.printf("%d\n", i); //output the prime number
            }
        }
    }
}
