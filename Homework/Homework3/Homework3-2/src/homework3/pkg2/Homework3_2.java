/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework3.pkg2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author tylerreardon
 */
public class Homework3_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> numbers = new ArrayList();
        Scanner in = new Scanner(System.in);
        try {
            System.out.println("Enter three sides of a triangle:\n");
            for (int i = 0; i < 3; i++) {
                numbers.add(in.nextInt());
            }
            Triangle tri = new Triangle(numbers.get(0), numbers.get(1), numbers.get(2));
            System.out.printf("Triangle Area: %f, Triangle Perimeter %f\n", tri.getArea(), tri.getPerimeter());
            
            System.out.println("Enter two sides of a rectangle:\n");
            numbers.clear();
            for (int i = 0; i<2; i++){
                numbers.add(in.nextInt());
            }
            Rectangle rect = new Rectangle(numbers.get(0), numbers.get(1));
            System.out.printf("Rectangle Area: %f, Rectangle Perimeter %f\n", rect.getArea(), rect.getPerimeter());
            
            System.out.println("Enter width and height of ellipse:\n");
            numbers.clear();
            for (int i = 0; i<2; i++){
                numbers.add(in.nextInt());
            }
            Ellipse ellipse = new Ellipse(numbers.get(0), numbers.get(1));
            System.out.printf("Ellipse Area: %f, Ellipse Perimeter %f\n", ellipse.getArea(), ellipse.getPerimeter());
        } catch (Exception e) {
            System.out.printf("Error: %s", e.getMessage());
        }

    }

}
