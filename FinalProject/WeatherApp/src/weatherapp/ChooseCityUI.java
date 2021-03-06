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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * Gives the user the option to choose a city they inputted
 *
 * @author tylerreardon
 */
public class ChooseCityUI extends javax.swing.JFrame {

    private ArrayList<City> cities = new ArrayList();
    private static WeatherAppUI _weatherApp;
    private FileIO file = new FileIO();

    /**
     * Creates new form ChooseCityUI
     *
     * @param weatherAppUI
     * @throws java.net.MalformedURLException
     * @throws org.xml.sax.SAXException
     * @throws javax.xml.parsers.ParserConfigurationException
     */
    public ChooseCityUI(WeatherAppUI weatherApp) throws MalformedURLException, SAXException, ParserConfigurationException {
        initComponents();
        //update the array of cities
        cities = file.makeCities();
        updateList();
        _weatherApp = weatherApp;
    }

    /**
     * Updates the list of cities currently available
     */
    private void updateList() {
        //update list
        DefaultListModel listModel = new DefaultListModel();
        for (int i = 0; i < cities.size(); i++) {
            listModel.addElement(cities.get(i).getCityName()+", "+cities.get(i).getState());
        }

        //set list
        CitiesList.setModel(listModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Enter = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();
        CityListLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CitiesList = new javax.swing.JList();
        Delete = new javax.swing.JButton();
        Modify = new javax.swing.JButton();
        Add = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Enter.setText("Enter");
        Enter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnterActionPerformed(evt);
            }
        });

        Cancel.setText("Cancel");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });

        CityListLabel.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        CityListLabel.setText("Choose City:");

        CitiesList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(CitiesList);

        Delete.setForeground(new java.awt.Color(204, 0, 0));
        Delete.setText("Delete Item");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        Modify.setText("Modify Item");
        Modify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifyActionPerformed(evt);
            }
        });

        Add.setForeground(new java.awt.Color(0, 153, 51));
        Add.setText("Add Item");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CityListLabel))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                    .addGap(4, 4, 4)
                    .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(Modify, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(Add))
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Cancel)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Enter)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(CityListLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Delete)
                    .addComponent(Modify)
                    .addComponent(Add))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Enter)
                    .addComponent(Cancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_CancelActionPerformed

    /**
     * Deletes a location from the list of locations
     *
     * @param evt
     */
    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        if (CitiesList.isSelectionEmpty()) { //don't do anything if user didn't select anything
            return;
        } else {

            try {
                //update cities array
                cities = file.makeCities();
                //remove item from list
                cities.remove(CitiesList.getAnchorSelectionIndex());

                updateList();
                file.modifyOrRemoveCity(cities);
                _weatherApp.updateWeatherUI();

            } catch (FileNotFoundException ex) {
                Logger.getLogger(ChooseCityUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(ChooseCityUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(ChooseCityUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SAXException | ParserConfigurationException | IOException ex) {
                Logger.getLogger(ChooseCityUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_DeleteActionPerformed

    /**
     * Runs the modify window
     *
     * @param evt
     */
    private void ModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifyActionPerformed
        ModifyUI modify = null;
        if (CitiesList.isSelectionEmpty()) {
            return;
        } else {
            try {
                cities = file.makeCities();
                modify = new ModifyUI(CitiesList.getAnchorSelectionIndex());
                modify.runModify();
            } catch (MalformedURLException | SAXException | ParserConfigurationException ex) {
                Logger.getLogger(ChooseCityUI.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        this.dispose();
        try {
            _weatherApp.updateWeatherUI();
        } catch (IOException | SAXException | ParserConfigurationException ex) {
            Logger.getLogger(ChooseCityUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ModifyActionPerformed

    /**
     * Runs the AddCity window
     *
     * @param evt
     */
    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        try {
            AddCityUI add = new AddCityUI();
            add.runAddCity();
            this.dispose();
        } catch (MalformedURLException | SAXException | ParserConfigurationException ex) {
            Logger.getLogger(ChooseCityUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AddActionPerformed

    /**
     * Sets the preferred city for application startup
     *
     * @param evt
     */
    private void EnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnterActionPerformed
        int preferredCityIndex;
        
        if (CitiesList.isSelectionEmpty()){
            this.dispose();
            return;
        }
        
        try {
            cities = file.makeCities();
            preferredCityIndex = CitiesList.getAnchorSelectionIndex();
            file.setPreferredCity(cities.get(preferredCityIndex));
            _weatherApp.updateWeatherUI();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ChooseCityUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ChooseCityUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException | ParserConfigurationException | IOException ex) {
            Logger.getLogger(ChooseCityUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
     
    }//GEN-LAST:event_EnterActionPerformed

    /**
     */
    public static void runChooseCity() {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                try {
                    //Opens window in the middle of the screen
                    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                    ChooseCityUI choose = new ChooseCityUI(_weatherApp);
                    choose.setLocation(dim.width / 2 - choose.getSize().width / 2, dim.height / 2 - choose.getSize().height / 2);
                    choose.setVisible(true);
                } catch (MalformedURLException | SAXException | ParserConfigurationException ex) {
                    Logger.getLogger(ChooseCityUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton Cancel;
    private javax.swing.JList CitiesList;
    private javax.swing.JLabel CityListLabel;
    private javax.swing.JButton Delete;
    private javax.swing.JButton Enter;
    private javax.swing.JButton Modify;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
