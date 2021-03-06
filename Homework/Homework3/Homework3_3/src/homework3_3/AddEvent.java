/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework3_3;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.MutableComboBoxModel;

/**
 * Allows a user to add an event to the event list
 * @author tylerreardon
 */
public class AddEvent extends javax.swing.JFrame {

    ArrayList<Event> events = new ArrayList<>();
    static EventList eventList;

    public void setEventList(EventList e) {
        eventList = e;
    }

    /**
     * Creates new form AddEvent
     */
    public AddEvent() {
        initComponents();
        name.setText("");
        location.setText("");
        year.setText("");
        date.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        calendarDescr = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        nameDescr = new javax.swing.JLabel();
        locationDescr = new javax.swing.JLabel();
        location = new javax.swing.JTextField();
        year = new javax.swing.JTextField();
        monthDescr = new javax.swing.JLabel();
        dateDescr = new javax.swing.JLabel();
        yearDescr = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        month = new javax.swing.JComboBox();
        date = new javax.swing.JComboBox();
        messageCenter = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        calendarDescr.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        calendarDescr.setText("Calendar");

        nameDescr.setText("Name:");

        locationDescr.setText("Location:");

        year.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                yearFocusLost(evt);
            }
        });
        year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearActionPerformed(evt);
            }
        });
        year.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                yearPropertyChange(evt);
            }
        });

        monthDescr.setText("Month:");

        dateDescr.setText("Date:");

        yearDescr.setText("Year:");

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        month.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthActionPerformed(evt);
            }
        });

        date.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nameDescr)
                                .addComponent(locationDescr)
                                .addComponent(yearDescr))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(name)
                                .addComponent(location, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                .addComponent(year)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(monthDescr)
                                .addComponent(dateDescr))
                            .addGap(20, 20, 20)
                            .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(submitButton)
                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(calendarDescr)
                        .addGap(18, 18, 18)
                        .addComponent(messageCenter, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(calendarDescr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(messageCenter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameDescr))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(locationDescr)
                    .addComponent(location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yearDescr)
                    .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(monthDescr)
                    .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateDescr)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submitButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * When submit button pressed, add a new event to the list
     * @param evt 
     */
    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        if ("".equals(location.getText()) //if all fields have a valid value
                || "".equals(year.getText()) 
                || year.getText().length() < 4 
                || year.getText().length() > 4
                || "".equals(name.getText())) {
            return;
        }
        try{
            int yearInt = Integer.parseInt(year.getText()); //if the text in the year field is a number
        }catch (Exception e){
            System.out.println("Invalid year."); //else print debugging message
            return;
        }

        ArrayList<Event> events = new ArrayList<>(); //make 
        FileIO file = new FileIO();
        try {
            events = file.readEvents();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //assign string values to variables
        String nameString = name.getText();
        String locationString = location.getText();
        String monthString = (String) month.getSelectedItem();
        String dateString = date.getSelectedItem().toString();
        String yearString = year.getText();

        //make an event object
        Event e1 = new Event(nameString, locationString, monthString, dateString, yearString);
        events.add(e1); //add to array
        file.saveEvents(events); //save to file
        this.dispose();

        eventList.setEventList(events); //update list
    }//GEN-LAST:event_submitButtonActionPerformed

    /**
     * When the user selects a month, it sets the amount of days allowed to be selected for the date
     * @param evt 
     */
    private void monthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthActionPerformed
       
        date.setEnabled(true); //prevent users from selecting day until month is chosen
        String selection = (String) month.getSelectedItem();
        date.removeAllItems();//make the list empty
        
        //depending on the month, add the correct amount of days to the list
        if ("January".equals(selection)) {
            for (int i = 0; i < 31; i++) {
                date.addItem(i+1);
            }
        } else if ("February".equals(selection)) {
            for (int i = 0; i < 28; i++) {
                date.addItem(i+1);
            }
        } else if ("March".equals(selection)) {
            for (int i = 0; i < 31; i++) {
                date.addItem(i+1);
            }
        } else if ("April".equals(selection)) {
            for (int i = 0; i < 30; i++) {
                date.addItem(i+1);
            }
        } else if ("May".equals(selection)) {
            for (int i = 0; i < 31; i++) {
                date.addItem(i+1);
            }
        } else if ("June".equals(selection)) {
            for (int i = 0; i < 30; i++) {
                date.addItem(i+1);
            }
        } else if ("July".equals(selection)) {
            for (int i = 0; i < 31; i++) {
                date.addItem(i+1);
            }
        } else if ("August".equals(selection)) {
            for (int i = 0; i < 31; i++) {
                date.addItem(i+1);
            }
        } else if ("September".equals(selection)) {
            for (int i = 0; i < 30; i++) {
                date.addItem(i+1);
            }
        } else if ("October".equals(selection)) {
            for (int i = 0; i < 31; i++) {
                date.addItem(i+1);
            }
        } else if ("November".equals(selection)) {
            for (int i = 0; i < 30; i++) {
                date.addItem(i+1);
            }
        } else if ("December".equals(selection)) {
            for (int i = 0; i < 31; i++) {
                date.addItem(i+1);
            }
        }
        
        try{
        //accounts for leap year
        if (Integer.parseInt(year.getText()) % 4 == 0 && "February".equals(selection)){
            date.removeAll();
            for (int i = 0; i < 29; i++) {
                date.addItem(i+1);
            }
        }
        } catch (Exception e){
            messageCenter.setText("Must Enter Year!");
        }

    }//GEN-LAST:event_monthActionPerformed

    private void yearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearActionPerformed

    }//GEN-LAST:event_yearActionPerformed

    /**
     * Checks if year was changed and updates for a leap year
     * @param evt 
     */
    private void yearFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_yearFocusLost
        try{
        //accounts for leap year
        if (Integer.parseInt(year.getText()) % 4 == 0 
                && "February".equals((String) month.getSelectedItem())){
            date.removeAll();
            for (int i = 0; i < 29; i++) {
                date.addItem(i+1);
            }
        }
        } catch (Exception e){
            messageCenter.setText("Must Enter Year!");
        }
    }//GEN-LAST:event_yearFocusLost

    private void yearPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_yearPropertyChange
    
    }//GEN-LAST:event_yearPropertyChange

    /**
     * @param args the command line arguments
     */
    public static void runAddEvent(EventList el) {
        eventList = el;

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
            java.util.logging.Logger.getLogger(AddEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddEvent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel calendarDescr;
    private javax.swing.JComboBox date;
    private javax.swing.JLabel dateDescr;
    private javax.swing.JTextField location;
    private javax.swing.JLabel locationDescr;
    private javax.swing.JLabel messageCenter;
    private javax.swing.JComboBox month;
    private javax.swing.JLabel monthDescr;
    private javax.swing.JTextField name;
    private javax.swing.JLabel nameDescr;
    private javax.swing.JButton submitButton;
    private javax.swing.JTextField year;
    private javax.swing.JLabel yearDescr;
    // End of variables declaration//GEN-END:variables
}
