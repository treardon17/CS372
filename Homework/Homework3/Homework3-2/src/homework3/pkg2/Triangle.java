/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework3.pkg2;
import java.math.*;
/**
 *  Represents a triangle
 * @author tylerreardon
 */
public class Triangle extends Shape {

    private double _s1, _s2, _s3;

    /**
     * Creates a valid triangle
     * @param s1
     * @param s2
     * @param s3
     * @throws Exception 
     */
    public Triangle(int s1, int s2, int s3) throws Exception {
        //PT -- you disallow 0-length sides, but not negative sides? -3
        
        if (s1 + s2 <= s3 || s2 + s3 <= s1 || s3 + s1 <= s2 || s1 == 0 || s2 == 0 || s3 == 0) {
            throw new IllegalArgumentException("Invalid Sides");
        }
        _s1 = s1;
        _s2 = s2;
        _s3 = s3;
    }

    /**
     * Calculates the perimeter of a Triangle
     * @return the perimeter of a triangle
     */
    @Override
    public double getPerimeter(){
        return _s1+_s2+_s3; //adds up sides of trinagle
    }
    /**
     * Calculates the area of a Triangle
     * @return the area of a triangle
     */
    public double getArea(){
        double halfP;
        double area;
        halfP = getPerimeter()/2;
        area = Math.sqrt(halfP*(halfP-_s1)*(halfP-_s2)*(halfP-_s3)); //formula to find the perimeter of triangle
        return area;
    }
}
