/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Allows user to modify an item in the list of cities
 * @author tylerreardon
 */
public class ModifyUI extends javax.swing.JFrame {
    private int _index;
    private FileIO file = new FileIO();
    private ArrayList<City> cities = new ArrayList();
    /**
     * Creates new form ModifyUI
     */
    public ModifyUI(int index) {
        initComponents();
        _index = index;
        cities = file.makeCities();
        states.getModel().setSelectedItem(cities.get(index).getState());
        zipcode.setText(cities.get(index).getZipCode());
        cityName.setText(cities.get(index).getCityName());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cityName = new javax.swing.JTextField();
        zipcodeDescr = new javax.swing.JLabel();
        stateDescr = new javax.swing.JLabel();
        cityNameDescr = new javax.swing.JLabel();
        modifyLocationDescr = new javax.swing.JLabel();
        zipcode = new javax.swing.JTextField();
        Cancel = new javax.swing.JButton();
        Enter = new javax.swing.JButton();
        states = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(cityName, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 120, 144, -1));

        zipcodeDescr.setText("Zipcode");
        getContentPane().add(zipcodeDescr, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 154, -1, -1));

        stateDescr.setText("State");
        getContentPane().add(stateDescr, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 42, -1, -1));

        cityNameDescr.setText("City Name");
        getContentPane().add(cityNameDescr, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 98, -1, -1));

        modifyLocationDescr.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        modifyLocationDescr.setText("Modify Location:");
        getContentPane().add(modifyLocationDescr, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));
        getContentPane().add(zipcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 176, 144, -1));

        Cancel.setText("Cancel");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });
        getContentPane().add(Cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 228, -1, -1));

        Enter.setText("Enter");
        Enter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnterActionPerformed(evt);
            }
        });
        getContentPane().add(Enter, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 228, -1, -1));

        states.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choose...", "Alabama ", "Alaska ", "Arizona ", "Arkansas ", "California ", "Colorado ", "Connecticut ", "Delaware ", "Florida ", "Georgia ", "Hawaii ", "Idaho ", "Illinois Indiana ", "Iowa ", "Kansas ", "Kentucky ", "Louisiana ", "Maine ", "Maryland ", "Massachusetts ", "Michigan ", "Minnesota ", "Mississippi ", "Missouri ", "Montana Nebraska ", "Nevada ", "New Hampshire ", "New Jersey ", "New Mexico ", "New York ", "North Carolina ", "North Dakota ", "Ohio ", "Oklahoma ", "Oregon ", "Pennsylvania Rhode Island ", "South Carolina ", "South Dakota ", "Tennessee ", "Texas ", "Utah ", "Vermont ", "Virginia ", "Washington ", "West Virginia ", "Wisconsin ", "Wyoming" }));
        getContentPane().add(states, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 190, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Cancels modify window
     * @param evt 
     */
    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        this.dispose();
        //ChooseCityUI choose = new ChooseCityUI();
        ChooseCityUI.runChooseCity();
    }//GEN-LAST:event_CancelActionPerformed

    /**
     * Modifies city
     * @param evt 
     */
    private void EnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnterActionPerformed
        //Print debugging message if user doesn't specify an item
        String stateString = (String) states.getSelectedItem();
        if ("".equals(zipcode.getText()) || "".equals(cityName.getText()) || "Choose...".equals(stateString)){
            System.out.println("User didn't specify an item..."); //debugging
        }
        else {
            String zipcodeString = zipcode.getText();
            String cityNameString = cityName.getText();
            cities.get(_index).setState(stateString);
            cities.get(_index).setCityName(cityNameString);
            cities.get(_index).setZipCode(zipcodeString);

            try {
                file.modifyOrRemoveCity(cities); //modify city
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AddCityUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(AddCityUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
            //ChooseCityUI choose = new ChooseCityUI();
            ChooseCityUI.runChooseCity();
        }
    }//GEN-LAST:event_EnterActionPerformed

    /**
     * @param args the command line arguments
     */
    public void runModify() {
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
            java.util.logging.Logger.getLogger(ModifyUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifyUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifyUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifyUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifyUI(_index).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancel;
    private javax.swing.JButton Enter;
    private javax.swing.JTextField cityName;
    private javax.swing.JLabel cityNameDescr;
    private javax.swing.JLabel modifyLocationDescr;
    private javax.swing.JLabel stateDescr;
    private javax.swing.JComboBox states;
    private javax.swing.JTextField zipcode;
    private javax.swing.JLabel zipcodeDescr;
    // End of variables declaration//GEN-END:variables
}
