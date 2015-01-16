/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reviewer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Allows for fast file input and output
 * @author tylerreardon
 */
public class FileIO {
    
    /**
     * Creates an array of reviews from a file
     * @return the array of reviews
     * @throws IOException 
     */
    public ArrayList<Review> getReviews() throws IOException{
       ArrayList<Review> reviews = new ArrayList<>();
        File f = new File("src/reviews.txt");
        String line;
        String name = "";
        String address = "";
        String restaurant = "";
        String review = "";
        String rating = "";
        try {
            BufferedReader rdr = new BufferedReader(new FileReader(f));
            int index = 0;
            //read in line by line
            //the index of the line starts with name and ends with an <endElement> tag
            while ((line = rdr.readLine()) != null) { //read to the end of the file
                if (index ==0){name = line;}
                else if (index==1){address = line;}
                else if (index==2){restaurant = line;}
                else if (index==3){review = line;}
                else if (index >=4 && !line.contains("<endElement>")){rating = line;}
                index++;
                //if the end of the element is reached, create the review object and add it to the ArrayList
                if (line.contentEquals("<endElement>")){
                    //reset the index
                   index = 0;
                   Review r1 = new Review(name, address, restaurant, review, rating); //constructs object with file information
                   reviews.add(r1); //add item to array
                }

            }
            rdr.close();
        } catch (Exception ex) {
            System.out.println("Error!");
        }
        return reviews; //return the ArrayList
        
    }
    
    /**
     * Saves the ArrayList of reviews to a file
     * @param reviews 
     */
    public void saveReviews(ArrayList<Review> reviews){
        File file = new File("src/reviews.txt");
        try {
            BufferedWriter wrtr = new BufferedWriter(new FileWriter(file));
            String line;
            
            //formats the reviews
            for (int i = 0; i < reviews.size(); i++) {
                line = reviews.get(i).format();
                wrtr.write(line);
            }

            wrtr.close();
        } catch (Exception ex) {
            System.out.println("Invalid File!");
        }
    }
}
