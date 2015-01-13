/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework3.pkg1;

import java.util.*;

/**
 *
 * @author tylerreardon
 */
public class Homework3_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>(); //make an ArrayList
        Scanner in = new Scanner(System.in);
        System.out.println("Input 10 Integers:\n"); //prompt user for 10 integers
        for (int i = 0; i < 10; i++) {
            try {
                numbers.add(in.nextInt()); //add the number the user entered into the ArrayList
            } catch (Exception e) { //if the user didn't type a number
                System.out.println("oops...must be a number"); //print out message
                in.nextLine();
                i--; //decrement i, so that user can enter all 10 numbers
            }
        }
        Calculate calculate = new Calculate();
        System.out.printf("Average: %f\n", calculate.average(numbers)); //calculates and prints average 
        System.out.printf("Max: %d\n", calculate.max(numbers)); //calculates and prints max
        System.out.printf("Min: %d\n", calculate.min(numbers)); //calculates and prints min
    }

}
