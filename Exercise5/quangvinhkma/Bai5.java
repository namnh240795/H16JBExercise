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
public class Bai5 extends javax.swing.JFrame {

    float a,b,c,x1,x2,delta;
    public Bai5() {
        initComponents();
    }

    public boolean getData(){
        try {
            a = Float.valueOf(txtA.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nhập sai kiểu dữ liệu...");
            txtA.requestFocus();
            return false;
        }
        try {
            b = Float.valueOf(txtB.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nhập sai kiểu dữ liệu...");
            txtB.requestFocus();
            return false;
        }
        try {
            c = Float.valueOf(txtC.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nhập sai kiểu dữ liệu...");
            txtC.requestFocus();
            return false;
        }
        return true;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtA = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtB = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtC = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lbKetqua = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnGiaipt = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 600));
        getContentPane().setLayout(new java.awt.BorderLayout(0, 5));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Nhập dữ liệu"));
        jPanel1.setToolTipText("");
        jPanel1.setLayout(new java.awt.GridLayout(4, 0, 0, 5));

        jLabel2.setText("Hệ số a");
        jPanel4.add(jLabel2);

        txtA.setMinimumSize(new java.awt.Dimension(150, 40));
        txtA.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel4.add(txtA);

        jPanel1.add(jPanel4);

        jLabel3.setText("Hệ số b");
        jPanel5.add(jLabel3);

        txtB.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel5.add(txtB);

        jPanel1.add(jPanel5);

        jLabel4.setText("Hệ số c");
        jPanel6.add(jLabel4);

        txtC.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel6.add(txtC);

        jPanel1.add(jPanel6);

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Kết quả");
        jLabel5.setPreferredSize(new java.awt.Dimension(60, 20));
        jPanel7.add(jLabel5);

        lbKetqua.setPreferredSize(new java.awt.Dimension(300, 50));
        jPanel7.add(lbKetqua);

        jPanel1.add(jPanel7);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 50));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Giải phương trình bậc 2");
        jPanel2.add(jLabel1);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Thao tác"));
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 80));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10));

        btnGiaipt.setText("Giải phương trình");
        btnGiaipt.setPreferredSize(new java.awt.Dimension(150, 40));
        btnGiaipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiaiptActionPerformed(evt);
            }
        });
        jPanel3.add(btnGiaipt);

        btnXoa.setText("Xóa trắng");
        btnXoa.setPreferredSize(new java.awt.Dimension(150, 40));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel3.add(btnXoa);

        btnThoat.setText("Thoát");
        btnThoat.setPreferredSize(new java.awt.Dimension(150, 40));
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });
        jPanel3.add(btnThoat);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_END);
        jPanel3.getAccessibleContext().setAccessibleName("Chọn thao tác"); // NOI18N
        jPanel3.getAccessibleContext().setAccessibleParent(jPanel3);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        txtA.setText("");
        txtB.setText("");
        txtC.setText("");
        lbKetqua.setText("");
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnGiaiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiaiptActionPerformed
        if(getData()){
            float check = b*b - 4*a*c;
            if(check < 0){
                lbKetqua.setText("Phương trình vô nghiệm");
            }else if(check == 0){
                lbKetqua.setText("Phương trình có nghiệm kép x = "+(-b / (2*a)));
            }else{
                delta = (float) Math.sqrt(check);
                x1 = (-b + delta)/(4*a);
                x2 = (-b - delta)/(4*a);
                lbKetqua.setText("x1 = "+x1+" ;  x2 = "+x2);
            }
        }
        
    }//GEN-LAST:event_btnGiaiptActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnThoatActionPerformed

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
            java.util.logging.Logger.getLogger(Bai5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bai5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bai5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bai5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bai5().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGiaipt;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lbKetqua;
    private javax.swing.JTextField txtA;
    private javax.swing.JTextField txtB;
    private javax.swing.JTextField txtC;
    // End of variables declaration//GEN-END:variables
}
