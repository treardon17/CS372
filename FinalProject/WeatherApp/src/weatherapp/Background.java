/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Creates the image background of the application
 * @author tylerreardon
 */
public class Background extends JPanel {

    private final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    //private final LineAnimation line = new LineAnimation();
    private BufferedImage image;
    private JFrame frame;

    /**
     * No argument constructor
     */
    public Background() {}

    /**
     * Sets the image contents and the frame it's placed on
     * @param image
     * @param frame 
     */
    public void setBackground(BufferedImage image, JFrame frame) {
        this.frame = frame;
        this.image = enlarge(image, 2);
        this.frame.repaint();

    }

    /**
     * Paints background when frame changes size
     * @param g 
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        //THIS ADDS A GRADIENT BACKGROUND
        /*
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth();
        int h = getHeight();
        Color color1 = Color.GRAY;
        Color color2 = Color.WHITE;
        GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
                */
        
        //Draw image to JFrame
        drawScaledImage(image, frame, g2d);
    }

    /**
     * Keeps the image at the same aspect ratio while filling the window
     * @param image
     * @param canvas
     * @param g 
     */
    public static void drawScaledImage(Image image, Component canvas, Graphics g) {
        int imgWidth = image.getWidth(null);
        int imgHeight = image.getHeight(null);

        double imgAspect = (double) imgHeight / imgWidth;

        int canvasWidth = canvas.getWidth();
        int canvasHeight = canvas.getHeight();

        double canvasAspect = (double) canvasHeight / canvasWidth;

        int x1 = 0; // top left X position
        int y1 = 0; // top left Y position
        int x2 = 0; // bottom right X position
        int y2 = 0; // bottom right Y position

        if (imgWidth < canvasWidth && imgHeight < canvasHeight) {
            // the image is smaller than the canvas
            x1 = (canvasWidth - imgWidth) / 2;
            y1 = (canvasHeight - imgHeight) / 2;
            x2 = imgWidth + x1;
            y2 = imgHeight + y1;

        } else {
            if (canvasAspect < imgAspect) { // (> makes the image fit the screen instead of fill)
                y1 = canvasHeight;
                // keep image aspect ratio
                canvasHeight = (int) (canvasWidth * imgAspect);
                y1 = (y1 - canvasHeight) / 2;
            } else {
                x1 = canvasWidth;
                // keep image aspect ratio
                canvasWidth = (int) (canvasHeight / imgAspect);
                x1 = (x1 - canvasWidth) / 2;
            }
            x2 = canvasWidth + x1;
            y2 = canvasHeight + y1;
        }

        g.drawImage(image, x1, y1, x2, y2, 0, 0, imgWidth, imgHeight, null);
    }

    /**
     * Make the image larger by pixel duplication
     * @param image
     * @param n
     * @return 
     */
    public static BufferedImage enlarge(BufferedImage image, int n) {

        int w = n * image.getWidth();
        int h = n * image.getHeight();

        BufferedImage enlargedImage = new BufferedImage(w, h, image.getType());

        for (int y = 0; y < h; ++y) {
            for (int x = 0; x < w; ++x) {
                enlargedImage.setRGB(x, y, image.getRGB(x / n, y / n));
            }
        }
        return enlargedImage;
    }
}
