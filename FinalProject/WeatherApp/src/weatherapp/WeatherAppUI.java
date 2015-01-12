/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author tylerreardon
 */
public class WeatherAppUI extends javax.swing.JFrame {

    //WeatherApp app = new WeatherApp();

    /**
     * Creates new form WeatherAppUI
     */
    public WeatherAppUI() {
        initComponents();
        BufferedImage image = null;
        try {
            File weatherFile = new File("resources/images/sunny/sunny_boardwalk.jpeg");
            image = ImageIO.read(weatherFile);
            weatherImage.setIcon((Icon) new ImageIcon(image));
        } catch (IOException ex) {
            System.out.println("Could not find image!\n");
        }
       //temperature.setOpaque(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        baseLayer = new javax.swing.JLayeredPane();
        temperature = new javax.swing.JLabel();
        weatherImage = new javax.swing.JLabel();
        MenuBar = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        Preferences = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 900, 550));
        setMaximumSize(new java.awt.Dimension(950, 550));
        setPreferredSize(new java.awt.Dimension(900, 550));

        baseLayer.setPreferredSize(new java.awt.Dimension(1000, 500));

        temperature.setFont(new java.awt.Font("Heiti TC", 1, 24)); // NOI18N
        temperature.setText("Temperature:");

        javax.swing.GroupLayout baseLayerLayout = new javax.swing.GroupLayout(baseLayer);
        baseLayer.setLayout(baseLayerLayout);
        baseLayerLayout.setHorizontalGroup(
            baseLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(baseLayerLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(temperature, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(786, Short.MAX_VALUE))
            .addGroup(baseLayerLayout.createSequentialGroup()
                .addComponent(weatherImage, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        baseLayerLayout.setVerticalGroup(
            baseLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(weatherImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(baseLayerLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(temperature, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(304, Short.MAX_VALUE))
        );
        baseLayer.setLayer(temperature, javax.swing.JLayeredPane.PALETTE_LAYER);
        baseLayer.setLayer(weatherImage, javax.swing.JLayeredPane.DEFAULT_LAYER);

        getContentPane().add(baseLayer, java.awt.BorderLayout.LINE_START);

        File.setText("File");

        Preferences.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        Preferences.setText("Preferences");
        Preferences.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreferencesActionPerformed(evt);
            }
        });
        File.add(Preferences);

        MenuBar.add(File);

        setJMenuBar(MenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Opens window, allowing user to specify which location to display
     * @param evt 
     */
    private void PreferencesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreferencesActionPerformed
        ChooseCityUI choose = new ChooseCityUI();
        choose.runChooseCity();
    }//GEN-LAST:event_PreferencesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WeatherAppUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WeatherAppUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WeatherAppUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WeatherAppUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WeatherAppUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu File;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem Preferences;
    private javax.swing.JLayeredPane baseLayer;
    private javax.swing.JLabel temperature;
    private javax.swing.JLabel weatherImage;
    // End of variables declaration//GEN-END:variables
}
