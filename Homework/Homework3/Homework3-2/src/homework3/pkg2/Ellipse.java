/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework3.pkg2;

/**
 * Represents an ellipse
 * @author tylerreardon
 */
public class Ellipse extends Shape{
    private double _r1;
    private double _r2;
    
    /**
     * Makes an ellipse with valid sides
     * @param r1
     * @param r2
     * @throws Exception if sizes are less than or equal to zero
     */
    public Ellipse(int r1, int r2) throws Exception{
        if (r1 <= 0 || r2 <= 0){
            throw new IllegalArgumentException("Sides cannot be equal to or less than 0");
        }
        _r1 = r1;
        _r2 = r2;
    }
    /**
     * Estimates the perimeter of an Ellipse
     * @return the area of an ellipse
     */
    @Override
    public double getPerimeter(){
        return 2*Math.PI*Math.sqrt(((_r1*_r1)+(_r2*_r2))/2); //equation for perimeter estimation
    }
    /**
     * Calculates the area of an ellipse
     * @return the area of an ellipse
     */
    @Override
    public double getArea(){
        return Math.PI*_r1*_r2; //formula for area
    }
}
