/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs372.calculatingpi;

/**
 *
 * @author tylerreardon
 */
public class CS372CalculatingPI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length>0){
            PI pi = new PI(); //create new PI
            //pi.calculatePI(200000);
            pi.calculatePI(Integer.parseInt(args[0])); //calculate PI
        }
    }
    
}
