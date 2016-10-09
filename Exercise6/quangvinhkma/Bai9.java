/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise6;

import java.awt.Color;
import java.awt.Component;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;

/**
 *
 * @author quang
 */
public class Bai9 extends javax.swing.JFrame {

    int value;
    ArrayList<Integer> arr_Toden = new ArrayList<>();
    ArrayList<Integer> arr_value = new ArrayList<>();
    public Bai9() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnSochan = new javax.swing.JButton();
        btnSole = new javax.swing.JButton();
        btnSNT = new javax.swing.JButton();
        btnBotoden = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnTinhtong = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtSo = new javax.swing.JTextField();
        btnNhap = new javax.swing.JButton();
        cbSoam = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        List = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        lbTong = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thao tác trên JList - CheckBox");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Chọn thao tác"));
        jPanel1.setLayout(new java.awt.GridLayout(6, 0, 5, 10));

        btnSochan.setText("Tô đen số chẵn");
        btnSochan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSochanActionPerformed(evt);
            }
        });
        jPanel1.add(btnSochan);

        btnSole.setText("Tô đen số lẻ");
        btnSole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSoleActionPerformed(evt);
            }
        });
        jPanel1.add(btnSole);

        btnSNT.setText("Tô đen số nguyên tố");
        btnSNT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSNTActionPerformed(evt);
            }
        });
        jPanel1.add(btnSNT);

        btnBotoden.setText("Bỏ tô đen");
        btnBotoden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBotodenActionPerformed(evt);
            }
        });
        jPanel1.add(btnBotoden);

        btnXoa.setText("Xóa các số đang được tô đen");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel1.add(btnXoa);

        btnTinhtong.setText("Tính tổng các số");
        btnTinhtong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTinhtongActionPerformed(evt);
            }
        });
        jPanel1.add(btnTinhtong);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Nhập thông tin"));

        btnNhap.setText("Nhập");
        btnNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapActionPerformed(evt);
            }
        });

        cbSoam.setText("Nhập số âm");

        jScrollPane1.setViewportView(List);

        jLabel2.setText("Tổng các số");

        lbTong.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lbTong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(cbSoam)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtSo, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNhap)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNhap))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbSoam)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbTong, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        btnClose.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnClose.setText("Đóng chương trình");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(181, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapActionPerformed
        if(txtSo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Chưa nhập số.");
            txtSo.requestFocus();
        }else{
            DefaultListModel model = new DefaultListModel();
            try {
                value = Integer.parseInt(txtSo.getText());
                
                if(value < 0){
                    if(!cbSoam.isSelected()){
                        JOptionPane.showMessageDialog(null, "Chưa chọn tính năng nhập số âm...");
                        txtSo.requestFocus();
                    }
                    if(cbSoam.isSelected()){
                        arr_value.add(value);
                    }
                }else{
                    arr_value.add(value);
                }
                for(int i = 0; i < arr_value.size(); i++){
                    model.addElement(arr_value.get(i));
                }
                List.setModel(model);
                txtSo.setText("");
            } catch (NumberFormatException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, "Nhập sai kiểu dữ liệu...");
                txtSo.requestFocus();
            }
            
        }
    }//GEN-LAST:event_btnNhapActionPerformed

    private void btnSochanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSochanActionPerformed
        arr_Toden.clear();
        List.setCellRenderer(new ListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                MyCell mycell = new MyCell();
                if(((int) value % 2) == 0){
                    mycell.setText(String.valueOf(value));
                    mycell .setMyBackground(Color.gray);
                    arr_Toden.add((int) value);
                }
                else{
                    mycell.setText(String.valueOf(value));
                    mycell.setMyBackground(Color.white);
                }     
                
                return mycell;
            }
        });
    }//GEN-LAST:event_btnSochanActionPerformed

    private void btnSoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSoleActionPerformed
        arr_Toden.clear();
        List.setCellRenderer(new ListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                 MyCell mycell = new MyCell();
                if(((int) value % 2) != 0){
                    mycell.setText(String.valueOf(value));
                    mycell .setMyBackground(Color.gray);
                    arr_Toden.add((int) value);
                }
                else{
                    mycell.setText(String.valueOf(value));
                    mycell.setMyBackground(Color.white);
                }     
                return mycell;
            }
        });
    }//GEN-LAST:event_btnSoleActionPerformed

    private void btnBotodenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBotodenActionPerformed
        arr_Toden.clear();
        List.setCellRenderer(new ListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                MyCell mycell = new MyCell();
                mycell.setText(String.valueOf(value));
                mycell .setMyBackground(Color.white);
                return mycell;
            }
        });
    }//GEN-LAST:event_btnBotodenActionPerformed

    private void btnSNTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSNTActionPerformed
        arr_Toden.clear();
        List.setCellRenderer(new ListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                MyCell mycell = new MyCell();
            if(ktraSNT((int) value)){
                mycell.setText(String.valueOf(value));
                mycell .setMyBackground(Color.gray);
                arr_Toden.add((int) value);
            }
            else{
                mycell.setText(String.valueOf(value));
                mycell.setMyBackground(Color.white);
            }
            return mycell;
            }
        });
        System.out.println(arr_Toden.size());
    }//GEN-LAST:event_btnSNTActionPerformed
    
    public boolean ktraSNT(int n){
        if(n == 0 || n == 1)
            return false;
        for(int i = 2; i <= Math.sqrt(n); i++){
             if(n % i == 0)
                return false;
        }
        return true;
    }  
    
    private void btnTinhtongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTinhtongActionPerformed
        int sum = 0;
        for(int i = 0; i < arr_value.size(); i++){
            sum += arr_value.get(i);
        }
        lbTong.setText(String.valueOf(sum));
    }//GEN-LAST:event_btnTinhtongActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        Iterator iter = arr_value.iterator();
        while(iter.hasNext()){
            for(int i = 0; i < arr_Toden.size(); i++){
                if(arr_Toden.get(i)== iter.next()){
                    System.out.println(arr_Toden.get(i));
                    iter.remove();
                }
            }
        }
        
        DefaultListModel model = new DefaultListModel();
        for(int i = 0; i < arr_value.size(); i++){
            model.addElement(arr_value.get(i));
        }
        List.setModel(model);
    }//GEN-LAST:event_btnXoaActionPerformed

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
            java.util.logging.Logger.getLogger(Bai9.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bai9.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bai9.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bai9.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bai9().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> List;
    private javax.swing.JButton btnBotoden;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnNhap;
    private javax.swing.JButton btnSNT;
    private javax.swing.JButton btnSochan;
    private javax.swing.JButton btnSole;
    private javax.swing.JButton btnTinhtong;
    private javax.swing.JButton btnXoa;
    private javax.swing.JCheckBox cbSoam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTong;
    private javax.swing.JTextField txtSo;
    // End of variables declaration//GEN-END:variables
}


//class MyListCellRenderSochan implements ListCellRenderer{
//
//    @Override
//    public Component getListCellRendererComponent(JList list,
//            Object value, int index, boolean isSelected, boolean cellHasFocus) {
//        
//        MyCell mycell = new MyCell();
//        if(((int) value % 2) == 0){
//            mycell.setText(String.valueOf(value));
//            mycell .setMyBackground(Color.gray);
//        }
//        else{
//            mycell.setText(String.valueOf(value));
//            mycell.setMyBackground(Color.white);
//        }     
//        
//        return mycell;
//    }
//    
//}
//class MyListCellRenderSole implements ListCellRenderer{
//    @Override
//    public Component getListCellRendererComponent(JList list,
//            Object value, int index, boolean isSelected, boolean cellHasFocus) {
//        MyCell mycell = new MyCell();
//        if(((int) value % 2) != 0){
//            mycell.setText(String.valueOf(value));
//            mycell .setMyBackground(Color.gray);
//        }
//        else{
//            mycell.setText(String.valueOf(value));
//            mycell.setMyBackground(Color.white);
//        }     
//        
//        return mycell;
//    }
//    
//}
//class MyListCellRenderSNT implements ListCellRenderer{
//    @Override
//    public Component getListCellRendererComponent(JList list,
//            Object value, int index, boolean isSelected, boolean cellHasFocus) {
//        MyCell mycell = new MyCell();
//        if(new MyListCellRenderSNT().ktraSNT((int) value)){
//            System.out.println(value);
//            mycell.setText(String.valueOf(value));
//            mycell .setMyBackground(Color.gray);
//        }
//        else{
//            mycell.setText(String.valueOf(value));
//            mycell.setMyBackground(Color.white);
//        }     
//        return mycell;
//    }
//    
//    public boolean ktraSNT(int n){
//        if(n == 0 || n == 1)
//            return false;
//        for(int i = 2; i <= Math.sqrt(n); i++){
//             if(n % i == 0)
//                return false;
//        }
//        return true;
//    }  
//    
//}