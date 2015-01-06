/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr1_4.area.of.a.circle;
import java.util.Scanner;
/**
 * This program calculates the area of a circle when the user provides the radius
 * @author tylerreardon
 */

public class PR1_4AreaOfACircle {
    /**
     * Calculates the area of a circle <br>
     * @param radius value of radius given by user
     * @return the contents of <code> area </code>
     */
    public static double calculateArea(float radius){
        final double PI = 3.14;
        double area = PI*radius*radius;
        return area;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        float radius;
        System.out.println("Radius of circle: ");
        Scanner input = new Scanner(System.in);
        radius = input.nextFloat();
        System.out.printf("Area of circle: %f\n", calculateArea(radius));
    }
    
}
