/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework3.pkg2;

/**
 * Represents a rectangle
 * @author tylerreardon
 */
public class Rectangle extends Shape {
    private double _width;
    private double _height;
    
    /**
     * Creates a rectangle with valid sides
     * @param width
     * @param height
     * @throws Exception 
     */
    public Rectangle(int width, int height) throws Exception{
        if (width <= 0 || height <= 0){
            throw new IllegalArgumentException("Sides cannot be equal to or less than 0");
        }
        _width = width;
        _height = height;
    }
    /**
     * Calculates the perimeter of a rectangle
     * @return the perimeter of the rectangle
     */
    @Override
    public double getPerimeter(){
        return ((2*_width)+(2*_height)); //formula for the perimeter
    }
    /**
     * Calculates the area of a rectangle
     * @return the area of a rectangle
     */
    @Override
    public double getArea(){
        return _width*_height; //formula for the area of a rectangle
    }
}
