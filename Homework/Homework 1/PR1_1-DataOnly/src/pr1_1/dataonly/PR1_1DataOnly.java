/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr1_1.dataonly;

/**
 *
 * @author tylerreardon
 */

class DataOnly{ //create DataOnly class
    int i;
    float f;
    boolean b;
}

public class PR1_1DataOnly {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DataOnly d = new DataOnly(); //create instance of DataOnly class
        //assign values to variables
        d.i = 12;
        d.f = (float) 4.2;
        d.b = true;
        
        System.out.printf("Int: %d, Float: %f, Bool: %b", (int)d.i, d.f, d.b); //print
    }
    
}
