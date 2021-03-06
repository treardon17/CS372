/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * Gives the user the option to add locations to their list
 * @author tylerreardon
 */
public class AddCityUI extends javax.swing.JFrame {

    private ArrayList<City> cities = new ArrayList();
    private FileIO file = new FileIO();
    private String stateString;
    private String cityNameString;
    
    /**
     * Creates new form AddCityUI
     * @throws java.net.MalformedURLException
     * @throws org.xml.sax.SAXException
     * @throws javax.xml.parsers.ParserConfigurationException
     */
    public AddCityUI() throws MalformedURLException, SAXException, ParserConfigurationException {
        initComponents();
        cityName.setText("");
        cities = file.makeCities();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addCityDescr = new javax.swing.JLabel();
        stateDescr = new javax.swing.JLabel();
        cityNameDescr = new javax.swing.JLabel();
        cityName = new javax.swing.JTextField();
        enter = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        state = new javax.swing.JTextField();
        messageCenter = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        addCityDescr.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        addCityDescr.setText("Add a Location:");

        stateDescr.setText("Country/State:");

        cityNameDescr.setText("City Name:");

        enter.setText("Enter");
        enter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterActionPerformed(evt);
            }
        });

        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(addCityDescr))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(cityNameDescr)))
                        .addGap(0, 62, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(cancel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(enter))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(stateDescr)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(messageCenter, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cityName, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                        .addComponent(state)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addCityDescr)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stateDescr)
                    .addComponent(state, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cityNameDescr)
                    .addComponent(cityName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(messageCenter, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enter)
                    .addComponent(cancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Cancels the AddCity window
     * @param evt 
     */
    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        this.dispose();
        //ChooseCityUI choose = new ChooseCityUI();
        ChooseCityUI.runChooseCity();
    }//GEN-LAST:event_cancelActionPerformed

    /**
     * Adds a new location to the users list of cities
     * @param evt 
     */
    private void enterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterActionPerformed

        
        //if the user didn't enter all the required information, prevent the location from being added
        if ("".equals(cityName.getText()) || cityName.getText().contains("~") || "".equals(state.getText()) || state.getText().contains("~")){
            messageCenter.setText("Invalid entry.");
        }
        else {
            cityNameString = cityName.getText();
            stateString = state.getText();

            try {
                //create a new city with user specifications
                file.addCity(stateString, cityNameString);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AddCityUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(AddCityUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AddCityUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SAXException | ParserConfigurationException ex) {
                Logger.getLogger(AddCityUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            //close window and update list of cities
            this.dispose();
            //ChooseCityUI choose = new ChooseCityUI();
            ChooseCityUI.runChooseCity();
        }
    }//GEN-LAST:event_enterActionPerformed

    /**
     * @param args the command line arguments
     */
    public void runAddCity() {
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    //Opens window in the middle of the screen
                    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                    AddCityUI addCity = new AddCityUI();
                    addCity.setLocation(dim.width/2-addCity.getSize().width/2, dim.height/2-addCity.getSize().height/2);
                    addCity.setVisible(true);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(AddCityUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SAXException ex) {
                    Logger.getLogger(AddCityUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParserConfigurationException ex) {
                    Logger.getLogger(AddCityUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addCityDescr;
    private javax.swing.JButton cancel;
    private javax.swing.JTextField cityName;
    private javax.swing.JLabel cityNameDescr;
    private javax.swing.JButton enter;
    private javax.swing.JLabel messageCenter;
    private javax.swing.JTextField state;
    private javax.swing.JLabel stateDescr;
    // End of variables declaration//GEN-END:variables
}
