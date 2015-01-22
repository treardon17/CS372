/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animations;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.animation.Animation;
import javax.swing.Timer;

/**
 *
 * @author tylerreardon
 */
public class Animations {

    int x1, x2, y1, y2;
    int xend, yend;
    Timer tm;
    int state = 0;

    public void draw(Graphics g, int x1, int x2, int y1, int y2) {
        if (state != 0) return;
        state = 1;
        
        this.x1 = x1;
        this.x2 = x1;
        this.y1 = y1;
        this.y2 = y1;
        this.xend = x2;
        this.yend = y2;
        
        Graphics2D g2d = (Graphics2D) g;
        tm = new Timer(30, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Animation.this.x2+=2;
                g2d.drawLine(x1, y1, x2, y2);
                
                if (Animation.this.x2 == Animation.this.xend) {
                    tm.stop();
                    state = 2;
                }          
            }
        });
        tm.start();
    }


    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
