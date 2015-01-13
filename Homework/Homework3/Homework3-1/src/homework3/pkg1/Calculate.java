/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework3.pkg1;
import java.util.*;
/**
 *Gives the ability to calculate the max, min, and average of numbers in an ArrayList
 * @author tylerreardon
 */
public class Calculate {
    /**
     * Calculates the average of an ArrayList of integers
     * @param numbers
     * @return the average of all the numbers in the ArrayList
     */
    public double average(ArrayList<Integer> numbers){
        double total = 0;
        for (int i = 0; i<numbers.size(); i++){
            total += numbers.get(i); //total all numbers in list
        }
        return total/numbers.size(); //calculate average
    }
    /**
     * Finds the max number in an ArrayList
     * @param numbers
     * @return <code> current_max </code> which is the max number in the ArrayList
     */
    public int max(ArrayList<Integer> numbers){
        int current_max = 0; //max is 0
        if (numbers.size()>0){ //do this only if the array is greater than 0
            current_max = numbers.get(0); //set the max to the first number
        }
        for (int i = 1; i<numbers.size(); i++){
            if(numbers.get(i)>current_max){
                current_max = numbers.get(i); //if the next number is larger than the current max
            }
        }
        return current_max;
    }
    /**
     * c
     * @param numbers
     * @return <code> current_min </code> which is the smallest number in the ArrayList
     */
    public int min(ArrayList<Integer> numbers){
        int current_min = 0;
        if (numbers.size()>0){
            current_min = numbers.get(0);
        }
        for (int i = 1; i<numbers.size(); i++){
            if(numbers.get(i)<current_min){
                current_min = numbers.get(i);
            }
        }
        return current_min;
    }
}
