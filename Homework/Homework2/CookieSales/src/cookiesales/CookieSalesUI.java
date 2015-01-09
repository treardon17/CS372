/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cookiesales;

import com.sun.glass.events.KeyEvent;

/**
 *
 * @author tylerreardon
 */
public class CookieSalesUI extends javax.swing.JFrame {

    CookieSales sales = new CookieSales(); //create CookieSales object

    /**
     * Creates new form CookieSalesUI
     */
    public CookieSalesUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        TitleLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CookiesSold = new javax.swing.JTextField();
        ThinMint = new javax.swing.JCheckBox();
        Samoa = new javax.swing.JCheckBox();
        ChocolateChip = new javax.swing.JCheckBox();
        submit = new javax.swing.JButton();
        thinmintDescr = new javax.swing.JLabel();
        samoaDescr = new javax.swing.JLabel();
        chocolatechipDescr = new javax.swing.JLabel();
        totalsalesDescr = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        ThinMintSales = new javax.swing.JTextField();
        SamoaSales = new javax.swing.JTextField();
        ChocolateChipSales = new javax.swing.JTextField();
        TotalSales = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TitleLabel.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        TitleLabel.setText("Cookie Sales");
        getContentPane().add(TitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        jLabel2.setText("Cookies Sold:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 103, -1, -1));

        CookiesSold.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CookiesSoldKeyPressed(evt);
            }
        });
        getContentPane().add(CookiesSold, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 97, 104, -1));

        ThinMint.setText("Thin Mint");
        getContentPane().add(ThinMint, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 62, -1, -1));

        Samoa.setText("Samoa");
        getContentPane().add(Samoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 62, -1, -1));

        ChocolateChip.setText("Chocolate Chip");
        getContentPane().add(ChocolateChip, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 62, -1, -1));

        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        getContentPane().add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 98, -1, -1));

        thinmintDescr.setText("Thin Mints ($3):");
        getContentPane().add(thinmintDescr, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 167, -1, -1));

        samoaDescr.setText("Samoas ($4):");
        getContentPane().add(samoaDescr, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 207, -1, -1));

        chocolatechipDescr.setText("Chocolate Chip ($5):");
        getContentPane().add(chocolatechipDescr, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 251, -1, -1));

        totalsalesDescr.setText("Total Sales:");
        getContentPane().add(totalsalesDescr, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 301, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 147, 10));
        getContentPane().add(ThinMintSales, new org.netbeans.lib.awtextra.AbsoluteConstraints(366, 161, 80, -1));
        getContentPane().add(SamoaSales, new org.netbeans.lib.awtextra.AbsoluteConstraints(366, 201, 80, -1));
        getContentPane().add(ChocolateChipSales, new org.netbeans.lib.awtextra.AbsoluteConstraints(366, 245, 80, -1));
        getContentPane().add(TotalSales, new org.netbeans.lib.awtextra.AbsoluteConstraints(366, 295, 80, -1));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 279, 429, 10));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(356, 229, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
 * When button is pressed, calculate totals
 * @param evt 
 */
    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        if (CookiesSold.getText() != null) {
            int numSold = Integer.parseInt(CookiesSold.getText());

            if (ThinMint.isSelected()) {
                sales.addThinMints(numSold);
            }
            if (Samoa.isSelected()) {
                sales.addSamoas(numSold);
            }
            if (ChocolateChip.isSelected()) {
                sales.addChocolateChip(numSold);
            }
        }
        String mintString = String.format("$%.2f", sales.getThinMintSales()); //convert to string
        ThinMintSales.setText(mintString);

        String numMintString = String.format("Thin Mints: (%d sold at $3)", sales.getNumThinMints()); //convert to string
        thinmintDescr.setText(numMintString);

        String samoaString = String.format("$%.2f", sales.getSamoaSales()); //convert to string
        SamoaSales.setText(samoaString);

        String numSamoaString = String.format("Samoas: (%d sold at $4)", sales.getNumSamoas()); //convert to string
        samoaDescr.setText(numSamoaString);

        String chipString = String.format("$%.2f", sales.getChocolateChipSales()); //convert to string
        ChocolateChipSales.setText(chipString);

        String numChipString = String.format("ChocolateChip: (%d sold at $5)", sales.getNumChocolateChip()); //convert to string
        chocolatechipDescr.setText(numChipString);

        String totalString = String.format("$%.2f", sales.getTotalSales()); //convert to string
        TotalSales.setText(totalString);

        //calculate average price of cookies
        String numTotalString = String.format("Total: (%d cookies sold at an average price of $%.2f)", sales.getTotalNum(), sales.getTotalSales() / sales.getTotalNum()); //convert to string
        totalsalesDescr.setText(numTotalString);

        CookiesSold.setText("");
    }//GEN-LAST:event_submitActionPerformed

    /**
     * When enter is pressed, calculate totals
     * @param evt 
     */
    private void CookiesSoldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CookiesSoldKeyPressed
        if (evt.getKeyCode() != KeyEvent.VK_ENTER) {
            return;
        }
        if (CookiesSold.getText() != null) {
            int numSold = Integer.parseInt(CookiesSold.getText());

            if (ThinMint.isSelected()) {
                sales.addThinMints(numSold);
            }
            if (Samoa.isSelected()) {
                sales.addSamoas(numSold);
            }
            if (ChocolateChip.isSelected()) {
                sales.addChocolateChip(numSold);
            }
        }
        String mintString = String.format("$%.2f", sales.getThinMintSales()); //convert to string
        ThinMintSales.setText(mintString);

        String numMintString = String.format("Thin Mints: (%d sold at $3)", sales.getNumThinMints()); //convert to string
        thinmintDescr.setText(numMintString);

        String samoaString = String.format("$%.2f", sales.getSamoaSales()); //convert to string
        SamoaSales.setText(samoaString);

        String numSamoaString = String.format("Samoas: (%d sold at $4)", sales.getNumSamoas()); //convert to string
        samoaDescr.setText(numSamoaString);

        String chipString = String.format("$%.2f", sales.getChocolateChipSales()); //convert to string
        ChocolateChipSales.setText(chipString);

        String numChipString = String.format("ChocolateChip: (%d sold at $5)", sales.getNumChocolateChip()); //convert to string
        chocolatechipDescr.setText(numChipString);

        String totalString = String.format("$%.2f", sales.getTotalSales()); //convert to string
        TotalSales.setText(totalString);

        //calculate average price of cookies
        String numTotalString = String.format("Total: (%d cookies sold at an average price of $%.2f)", sales.getTotalNum(), sales.getTotalSales() / sales.getTotalNum()); //convert to string
        totalsalesDescr.setText(numTotalString);

        CookiesSold.setText("");
    }//GEN-LAST:event_CookiesSoldKeyPressed

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
            java.util.logging.Logger.getLogger(CookieSalesUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CookieSalesUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CookieSalesUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CookieSalesUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CookieSalesUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ChocolateChip;
    private javax.swing.JTextField ChocolateChipSales;
    private javax.swing.JTextField CookiesSold;
    private javax.swing.JCheckBox Samoa;
    private javax.swing.JTextField SamoaSales;
    private javax.swing.JCheckBox ThinMint;
    private javax.swing.JTextField ThinMintSales;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JTextField TotalSales;
    private javax.swing.JLabel chocolatechipDescr;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel samoaDescr;
    private javax.swing.JButton submit;
    private javax.swing.JLabel thinmintDescr;
    private javax.swing.JLabel totalsalesDescr;
    // End of variables declaration//GEN-END:variables
}