/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise5;

import javax.swing.JOptionPane;


/**
 *
 * @author quang
 */
public final class Bai1 extends javax.swing.JFrame {

    double x, y;
    double rs;
    public Bai1() {
        initComponents();
        
    }
    
    public boolean getData(){
        try {
            x = Double.valueOf(txtX.getText());
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nhập sai kiểu dữ liệu...");
            txtX.requestFocus();
            return false;
        }
        try {
            y = Double.valueOf(txtY.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nhập sai kiểu dữ liệu...");
            txtY.requestFocus();
            return false;
        }
        return true;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtX = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtY = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnCong = new javax.swing.JButton();
        btnTru = new javax.swing.JButton();
        btnNhan = new javax.swing.JButton();
        btnChia = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lbKetqua = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(4, 0));

        jLabel1.setText("Số X");
        jPanel1.add(jLabel1);

        txtX.setPreferredSize(new java.awt.Dimension(200, 50));
        jPanel1.add(txtX);

        getContentPane().add(jPanel1);

        jLabel2.setText("Số Y");
        jPanel2.add(jLabel2);

        txtY.setMinimumSize(new java.awt.Dimension(200, 50));
        txtY.setPreferredSize(new java.awt.Dimension(200, 50));
        jPanel2.add(txtY);

        getContentPane().add(jPanel2);

        btnCong.setText("+");
        btnCong.setPreferredSize(new java.awt.Dimension(80, 40));
        btnCong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCongActionPerformed(evt);
            }
        });
        jPanel3.add(btnCong);

        btnTru.setText("-");
        btnTru.setPreferredSize(new java.awt.Dimension(80, 40));
        btnTru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTruActionPerformed(evt);
            }
        });
        jPanel3.add(btnTru);

        btnNhan.setText("*");
        btnNhan.setPreferredSize(new java.awt.Dimension(80, 40));
        btnNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanActionPerformed(evt);
            }
        });
        jPanel3.add(btnNhan);

        btnChia.setText("/");
        btnChia.setPreferredSize(new java.awt.Dimension(80, 40));
        btnChia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiaActionPerformed(evt);
            }
        });
        jPanel3.add(btnChia);

        getContentPane().add(jPanel3);

        lbKetqua.setPreferredSize(new java.awt.Dimension(250, 60));
        jPanel4.add(lbKetqua);

        btnReset.setText("Reset");
        btnReset.setPreferredSize(new java.awt.Dimension(80, 40));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel4.add(btnReset);

        getContentPane().add(jPanel4);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCongActionPerformed
        if(getData()){
            rs = x + y;
            lbKetqua.setText("x + y = "+rs);
        }
        
    }//GEN-LAST:event_btnCongActionPerformed

    private void btnTruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTruActionPerformed
        if(getData()){
            rs = x - y;
            lbKetqua.setText("x - y = "+rs);
        }
    }//GEN-LAST:event_btnTruActionPerformed

    private void btnNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanActionPerformed
        if(getData()){
            rs = x * y;
            lbKetqua.setText("x * y = "+rs);
        }
    }//GEN-LAST:event_btnNhanActionPerformed

    private void btnChiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiaActionPerformed
        if(getData()){
            if(y == 0){
                JOptionPane.showMessageDialog(null, "Not by zero");
                txtY.requestFocus();
            }else{
                rs = x / y;
                lbKetqua.setText("x / y = "+rs);
            }
        }
        
    }//GEN-LAST:event_btnChiaActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtX.setText("");
        txtY.setText("");
        lbKetqua.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    
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
            java.util.logging.Logger.getLogger(Bai1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bai1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bai1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bai1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bai1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChia;
    private javax.swing.JButton btnCong;
    private javax.swing.JButton btnNhan;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnTru;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbKetqua;
    private javax.swing.JTextField txtX;
    private javax.swing.JTextField txtY;
    // End of variables declaration//GEN-END:variables
}
