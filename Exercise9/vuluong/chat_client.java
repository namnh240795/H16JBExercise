/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat_vuluong;

import java.awt.ComponentOrientation;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author TLC
 */
public class chat_client extends javax.swing.JFrame {

    /**
     * Creates new form chat_client
     */
    DefaultListModel<String> model;
    DefaultListModel<String> model2;
    public DataInputStream dataIn;
    public DataOutputStream dataOut;
    Socket sock;
    ArrayList<String> users;
    HashMap<String, String> map = new HashMap<String, String>();

    public class connectToServer implements Runnable {

        @Override
        public void run() {

            try {
                users = new ArrayList();
                model = new DefaultListModel<>();
                model2 = new DefaultListModel<>();
                model2.addElement("");
                while (true) {
                    String text = "";
//                    if(dataIn.readUTF()==null){
                    String[] data;
                    String mes = dataIn.readUTF();
                    data = mes.split(":");
//                    if(mes=="online: 1"){
                    boolean check = data[0].equals("online");
                    boolean checkDis = data[1].equals("Has Disconnect!");
//                    boolean remove = 

                    if (check == false) {
                        msg_show.append(mes + "\n");
                    }
                    if (check == true) {
                        System.out.println("data: " + data[1]);
//                        text = text+data[1]+"\n";
                        map.put(data[1], data[1]);
                    }
                    for (String key : map.keySet()) {
                        String ma = key;
                        System.out.println("key: " + key);
                        text = text + ma + "\n";
                    }
                    jTextArea1.setText(text);
                    System.out.println("text: " + text);

                    if (checkDis == true) {
                        map.remove(data[0]);
                        text = "";
                        for (String key : map.keySet()) {
                            String ma = key;
                            System.out.println("key: " + key);
                            text = text + ma + "\n";
                        }
                        jTextArea1.setText(text);
                    }

                }
//            }

            } catch (IOException ex) {
                Logger.getLogger(chat_client.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public void connecting() {
        Thread th = new Thread(new connectToServer());
        th.start();
    }

    public void capnhatUser() {

    }

    public void sendData() {
        String mesSend;
        mesSend = tf_user.getText() + ":  " + tf_chat.getText();
        try {
            dataOut.writeUTF(mesSend);
            dataOut.flush();
            tf_chat.setText("");

        } catch (IOException ex) {
            msg_show.append("khong gui duoc tin nhan" + "\n");
        }

    }

    public chat_client() {
        initComponents();
//        jList1.setVisible(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt_send = new javax.swing.JButton();
        tf_chat = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        msg_show = new javax.swing.JTextArea();
        bt_connect = new javax.swing.JButton();
        bt_disConnect = new javax.swing.JButton();
        tf_user = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bt_send.setText("Send");
        bt_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sendActionPerformed(evt);
            }
        });

        tf_chat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_chatActionPerformed(evt);
            }
        });

        msg_show.setColumns(20);
        msg_show.setRows(5);
        jScrollPane1.setViewportView(msg_show);

        bt_connect.setText("Connect");
        bt_connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_connectActionPerformed(evt);
            }
        });

        bt_disConnect.setText("Disconnect");
        bt_disConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_disConnectActionPerformed(evt);
            }
        });

        jLabel1.setText("Chose User");

        jTextArea1.setColumns(7);
        jTextArea1.setFont(new java.awt.Font("Comic Sans MS", 3, 13)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setToolTipText("");
        jScrollPane2.setViewportView(jTextArea1);

        jLabel2.setText("Ae dang Online");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(25, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tf_user, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(bt_connect)
                        .addGap(18, 18, 18)
                        .addComponent(bt_disConnect))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(tf_chat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_send, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_connect, bt_disConnect});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_connect, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_disConnect)
                    .addComponent(tf_user, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_chat, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_send, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_connect, bt_disConnect});

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void TestUser() {
        String user = tf_user.getText();
        for (String key : map.keySet()) {
            if (key == user) {
                JOptionPane.showMessageDialog(null, "tên hiện tại đã có trên server ");
                tf_user.requestFocus();
            }
        }
    }


    private void bt_connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_connectActionPerformed
//        if (!"".equals(user)) {
        TestUser();
        String user = tf_user.getText();
        Thread th = new Thread(new connectToServer());

        try {
            sock = new Socket("localhost", 1111);
            dataIn = new DataInputStream(sock.getInputStream());
            dataOut = new DataOutputStream(sock.getOutputStream());

            String mes = user + ":connectted";
            dataOut.writeUTF(mes);
            dataOut.flush();
            th.start();
            tf_user.setEditable(false);
            tf_user.setEnabled(false);

//        }
//        connecting();
        } catch (IOException ex) {
            Logger.getLogger(chat_client.class.getName()).log(Level.SEVERE, null, ex);
            msg_show.append("không gửi được tin nhắn" + "\n");
        }
    }//GEN-LAST:event_bt_connectActionPerformed

    private void bt_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sendActionPerformed

        sendData();
    }//GEN-LAST:event_bt_sendActionPerformed

    private void tf_chatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_chatActionPerformed

        bt_sendActionPerformed(evt);
    }//GEN-LAST:event_tf_chatActionPerformed

    private void bt_disConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_disConnectActionPerformed
        try {
            tf_user.setEditable(true);
            sock.close();
        } catch (IOException ex) {
            Logger.getLogger(chat_client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bt_disConnectActionPerformed

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
            java.util.logging.Logger.getLogger(chat_client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chat_client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chat_client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chat_client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new chat_client().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_connect;
    private javax.swing.JButton bt_disConnect;
    private javax.swing.JButton bt_send;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea msg_show;
    private javax.swing.JTextField tf_chat;
    private javax.swing.JTextField tf_user;
    // End of variables declaration//GEN-END:variables
}
