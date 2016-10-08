/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise6;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author quang
 */
public class Bai7 extends javax.swing.JFrame {

    ArrayList<String> check = new ArrayList<>();
    public Bai7() {
        initComponents();
//        cbBold.addItemListener((ItemListener) this);
//        cbItalic.addItemListener((ItemListener) this);
    }

//    public void ItemStateChanged(ItemEvent evt){
//        int bold = Font.BOLD;
//        int italic = Font.ITALIC;
//        if(evt.getSource() == cbBold){
//            txtText.setFont(new Font("Tahoma", bold, 11));
//        }
//        if(evt.getSource() == cbItalic){
//            txtText.setFont(new Font("Tahoma", italic, 11));
//        }
//        if(evt.getSource() == cbBold && evt.getSource() == cbItalic){
//            txtText.setFont(new Font("Tahoma", italic + bold, 11));
//        }
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtText = new javax.swing.JTextField();
        cbBold = new javax.swing.JCheckBox();
        cbItalic = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbBold.setText("Bold");
        cbBold.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbBoldItemStateChanged(evt);
            }
        });

        cbItalic.setText("Italic");
        cbItalic.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbItalicItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(txtText, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(cbBold)
                        .addGap(55, 55, 55)
                        .addComponent(cbItalic)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(txtText, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbBold)
                    .addComponent(cbItalic))
                .addContainerGap(142, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbBoldItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbBoldItemStateChanged
        if(!txtText.getText().equals("")){
            if(evt.getStateChange() == ItemEvent.SELECTED){
                check.add("bold");
                if(check.size() == 1){
                    txtText.setFont(txtText.getFont().deriveFont(Font.BOLD));
                }
                if(check.size() == 2){
                    txtText.setFont(txtText.getFont().deriveFont(Font.BOLD | Font.ITALIC));
                }
                
                System.out.println(check.size());
            }else{
                check.remove("bold");
                if(check.size() == 1){
                    txtText.setFont(txtText.getFont().deriveFont(Font.ITALIC));
                }
                if(check.isEmpty()){
                    txtText.setFont(txtText.getFont().deriveFont(Font.PLAIN));
                }
                
                System.out.println(check.size());
            }
        }else{
            JOptionPane.showMessageDialog(null, "Bạn chưa nhập dữ liệu...");
            txtText.requestFocus();
        }
        
    }//GEN-LAST:event_cbBoldItemStateChanged

    private void cbItalicItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbItalicItemStateChanged
        if(!txtText.getText().equals("")){
            if(evt.getStateChange() == ItemEvent.SELECTED){
                check.add("italic");
                if(check.size() == 1){
                    txtText.setFont(txtText.getFont().deriveFont(Font.ITALIC));
                }
                if(check.size() == 2){
                    txtText.setFont(txtText.getFont().deriveFont(Font.BOLD | Font.ITALIC));
                }
                System.out.println(check.size());
            }else{
                check.remove("italic");
                if(check.size() == 1){
                    txtText.setFont(txtText.getFont().deriveFont(Font.BOLD));
                }
                if(check.isEmpty()){
                    txtText.setFont(txtText.getFont().deriveFont(Font.PLAIN));
                }
                System.out.println(check.size());
            }
        }else{
            JOptionPane.showMessageDialog(null, "Bạn chưa nhập dữ liệu...");
            txtText.requestFocus();
        }
    }//GEN-LAST:event_cbItalicItemStateChanged

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
            java.util.logging.Logger.getLogger(Bai7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bai7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bai7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bai7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bai7().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbBold;
    private javax.swing.JCheckBox cbItalic;
    private javax.swing.JTextField txtText;
    // End of variables declaration//GEN-END:variables
}
