/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

/**
 * This class demonstrates how to use JavaDoc
 * @author tylerreardon
 */
public class Problem2 {

    /**
     * @param args the command line arguments  <br>
     * The program expects three arguments to be passed in
     */
    public static void main(String[] args) {
       
        if (args.length > 0) //if the arguments are greater than zero...
            System.out.println(args[0]); //print out the message
        if (args.length > 1)
            System.out.println(args[1]);
        if (args.length > 2)
            System.out.println(args[2]);
    }
    
}
