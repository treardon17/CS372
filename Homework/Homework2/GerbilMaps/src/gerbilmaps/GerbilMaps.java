/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerbilmaps;
import java.util.*;
import GerbilArrayList.*;
/**
 * This program puts gerbils into maps and makes them hop <br>
 * Outputs the gerbil name and makes it hop
 * @author tylerreardon
 */
public class GerbilMaps {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //PT -- remove the TODO comment (it's done)
        Map<String,Gerbil> gerbilMap = new HashMap<String,Gerbil>(); //make a map
        for (int i = 0; i<10; i++){
            Gerbil g1 = new Gerbil(i); //make Gerbil object
            String name = i + "Gerbil"; //make unique name
            gerbilMap.put(name, g1); //put objects into the map
        }
        
        Iterator e = gerbilMap.keySet().iterator(); //make iterator for map
        while(e.hasNext()){
            String name = e.next().toString(); //get name
            System.out.printf("%s\n", name); //output name
            gerbilMap.get(name).hop(); //make gerbil hop
        }
    }
}
