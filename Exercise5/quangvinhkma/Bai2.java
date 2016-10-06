/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise5;

import java.awt.Color;

/**
 *
 * @author quang
 */
public class Bai2 extends javax.swing.JFrame {

    /**
     * Creates new form Bai2
     */
    public Bai2() {
        initComponents();
        changeColor();
       
    }

    public final void changeColor(){
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        rdRed = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        rdGreen = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        rdBlue = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        rdBlack = new javax.swing.JRadioButton();
        pnDisplay = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.FlowLayout());

        jPanel3.setPreferredSize(new java.awt.Dimension(200, 300));
        jPanel3.setLayout(new java.awt.GridLayout(5, 0));

        buttonGroup1.add(rdRed);
        rdRed.setText("Red");
        rdRed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdRedActionPerformed(evt);
            }
        });
        jPanel1.add(rdRed);

        jPanel3.add(jPanel1);

        buttonGroup1.add(rdGreen);
        rdGreen.setText("Green");
        rdGreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdGreenActionPerformed(evt);
            }
        });
        jPanel2.add(rdGreen);

        jPanel3.add(jPanel2);

        buttonGroup1.add(rdBlue);
        rdBlue.setText("Blue");
        rdBlue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdBlueActionPerformed(evt);
            }
        });
        jPanel4.add(rdBlue);

        jPanel3.add(jPanel4);

        buttonGroup1.add(rdBlack);
        rdBlack.setText("Black");
        rdBlack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdBlackActionPerformed(evt);
            }
        });
        jPanel5.add(rdBlack);

        jPanel3.add(jPanel5);

        pnDisplay.setLayout(new java.awt.BorderLayout());
        jPanel3.add(pnDisplay);

        getContentPane().add(jPanel3);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdRedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdRedActionPerformed
        pnDisplay.setBackground(Color.red);
    }//GEN-LAST:event_rdRedActionPerformed

    private void rdGreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdGreenActionPerformed
        pnDisplay.setBackground(Color.green);
    }//GEN-LAST:event_rdGreenActionPerformed

    private void rdBlueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdBlueActionPerformed
        pnDisplay.setBackground(Color.blue);
    }//GEN-LAST:event_rdBlueActionPerformed

    private void rdBlackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdBlackActionPerformed
        pnDisplay.setBackground(Color.black);
    }//GEN-LAST:event_rdBlackActionPerformed

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
            java.util.logging.Logger.getLogger(Bai2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bai2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bai2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bai2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bai2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel pnDisplay;
    private javax.swing.JRadioButton rdBlack;
    private javax.swing.JRadioButton rdBlue;
    private javax.swing.JRadioButton rdGreen;
    private javax.swing.JRadioButton rdRed;
    // End of variables declaration//GEN-END:variables
}
