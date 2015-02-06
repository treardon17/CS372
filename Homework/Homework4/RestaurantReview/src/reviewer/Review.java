/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reviewer;

/**
 * Represents a review object
 * @author tylerreardon
 */
public class Review {
    private final String name;
    private final String address;
    private final String restaurant;
    private final String review;
    private final String rating;
    
    /**
     * Creates a review based on the user input
     * @param name
     * @param address
     * @param restaurant
     * @param rating
     * @param review 
     */
    public Review (String name, String address, String restaurant, String rating, String review){
        this.name = name;
        this.address = address;
        this.restaurant = restaurant;
                this.rating = rating; //PT -- verify that rating in [1,5]
        this.review = review;
    }

    
    public String getName(){
        return name;
    }
    //PT -- javadoc? -4
    public String getAddress(){
        return address;
    }
    
    public String getRestaurant(){
        return restaurant;
    }
    
    public String getReview(){
        return review;
    }
    
    public String getRating(){
        return rating;
    }
    
    /**
     * Formats the information from the review into a file-friendly string
     * @return 
     */
    public String format(){
        return name + "\n" + address + "\n" +
                restaurant + "\n" + rating + 
                "\n" + review + "\n<endElement>\n";
    }

    
}
