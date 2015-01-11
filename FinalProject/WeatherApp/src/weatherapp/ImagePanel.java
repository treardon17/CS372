/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

/**
 *
 * @author tylerreardon
 */
public class ImagePanel extends JPanel
{
   private final Image image;

   public ImagePanel(Image image) 
   {
      this.image = image;
      this.setPreferredSize(new Dimension(936,889));
    }

   @Override
   protected void paintComponent(Graphics g) 
   {
      g.drawImage(image, 0, 0, null);
   }
}
