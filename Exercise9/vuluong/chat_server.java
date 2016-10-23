/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat_vuluong;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author TLC
 */
public class chat_server extends javax.swing.JFrame {

    /**
     * Creates new form chat_server
     */
    DefaultListModel< String> model;
    public ArrayList<String> users;
    public ArrayList ListDataOuttoClient;

    public class xuLyClient implements Runnable {

        Socket sock;
        DataOutputStream dataOut;
        DataInputStream dataIn;

        public xuLyClient(Socket socket, DataOutputStream data) {
            dataOut = data;
            try {
                sock = socket;
                dataIn = new DataInputStream(sock.getInputStream());
            } catch (IOException ex) {
                Logger.getLogger(chat_server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        public void run() {
            String[] data = null;
            try {

                while (true) {//de xu ly du lieu lien tuc
                    //nhan du lieu tu 1 client?
                    //gui du lieu cho cac client khac?
                    dataIn = new DataInputStream(sock.getInputStream());
                    String mes = dataIn.readUTF();
                    msg_show.append(mes + "\n");

                    //du lieu nhan duoc ben client se co dang: user:+(thong tin chat)
                    //vi vay nen can xu ly
                    data = mes.split(":");
                    if ("connectted".equals(data[1])) {
                        users.add(data[0]);
                        model = new DefaultListModel<>();
                        for (String a : users) {
                            model.addElement(a);
                        }
                        jList1.setModel(model);
                        for (int i=0;i<jList1.getModel().getSize();i++) {
                            sendToAll("online:"+(String)jList1.getModel().getElementAt(i));
                        }
                    }

                    sendToAll(mes);

                }
            } catch (IOException ex) {
                Logger.getLogger(chat_server.class.getName()).log(Level.SEVERE, null, ex);
                ListDataOuttoClient.remove(dataOut);
                sendToAll(data[0] + ":Has Disconnect!");
                
                msg_show.append(data[0] + ": Disconnect!\n");
                users.remove(data[0]);
                model = new DefaultListModel<>();
                for (String a : users) {
                    model.addElement(a);
                    sendToAll("online:"+a);
                }
                jList1.setModel(model);
                for (int i=0;i<jList1.getModel().getSize();i++) {
                            sendToAll("online:"+(String)jList1.getModel().getElementAt(i));
                        }

            }
        }

    }

    public class serverStart implements Runnable {

        //truoc khi khoi dong can tao danh sach cac client ket noi toi
        public void run() {
            ListDataOuttoClient = new ArrayList();
            users = new ArrayList();
            try {
                ServerSocket ss = new ServerSocket(1111);
                msg_show.append("server đã khởi động phục vụ anh em!\n");
                while (true) {
                    Socket sock = ss.accept();
                    DataOutputStream data = new DataOutputStream(sock.getOutputStream());
                    Thread th = new Thread(new xuLyClient(sock, data));
                    th.start();
                    ListDataOuttoClient.add(data);
                    System.out.println("client ket noi: " + ListDataOuttoClient.size());
                }

            } catch (IOException ex) {
                Logger.getLogger(chat_server.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public void sendToAll(String mes) {
        Iterator ite = ListDataOuttoClient.iterator();
        while (ite.hasNext()) {
            try {
                DataOutputStream da = (DataOutputStream) ite.next();
                da.writeUTF(mes);
                da.flush();
            } catch (IOException ex) {
                Logger.getLogger(chat_server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void sendonline(String str) {
        Iterator ite = ListDataOuttoClient.iterator();
        while (ite.hasNext()) {
            try {
                DataOutputStream da = (DataOutputStream) ite.next();
                da.writeUTF(str);
                da.flush();
            } catch (IOException ex) {
                Logger.getLogger(chat_server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public chat_server() {
        initComponents();
        new Thread(new serverStart()).start();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        msg_show = new javax.swing.JTextArea();
        btn_disconnect = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        msg_show.setColumns(20);
        msg_show.setRows(5);
        jScrollPane1.setViewportView(msg_show);

        btn_disconnect.setText("Stop Server( 5'  )");
        btn_disconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_disconnectActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(jList1);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel1.setText("User Online");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel2.setText("Server Chat tong");

        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_disconnect, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_disconnect, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_disconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_disconnectActionPerformed
        try {
            Thread.sleep(5000);
            sendToAll("Server Stop! vui long connect lai");
        } catch (InterruptedException ex) {
            Logger.getLogger(chat_server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_disconnectActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     msg_show.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(chat_server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chat_server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chat_server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chat_server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new chat_server().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_disconnect;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea msg_show;
    // End of variables declaration//GEN-END:variables
}
