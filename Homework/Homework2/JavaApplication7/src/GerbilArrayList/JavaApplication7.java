/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GerbilArrayList;
import java.util.*; //to use List and ArrayList
/**
 *
 * @author tylerreardon
 */
public class JavaApplication7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List gerbilList = new ArrayList(); //make list of Gerbils
        for (int i = 0; i < 10; i++){ //make 10 Gerbils
            Gerbil g1 = new Gerbil(i);
            gerbilList.add(g1);
        }
        
        /*
        //Problem 1
        for (int i = 0; i<10; i++){ //loop 10 times and make gerbil hop with .get method
            ((Gerbil)gerbilList.get(i)).hop();
        }
        */
        
        //Problem 2
        Iterator e = gerbilList.iterator(); //make iterator for list
        while(e.hasNext()){
            ((Gerbil)e.next()).hop(); //make gerbil hop using iterator
        }
        

    }
    
}
