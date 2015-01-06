/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr1_4.area.of.a.circle;
import java.util.Scanner;
/**
 *
 * @author tylerreardon
 */

public class PR1_4AreaOfACircle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final double PI = 3.14;
        float radius;
        System.out.println("Radius of circle: ");
        Scanner input = new Scanner(System.in);
        radius = input.nextFloat();
        double area = PI*radius*radius;
        System.out.printf("Area of circle: %f\n", area);
    }
    
}
