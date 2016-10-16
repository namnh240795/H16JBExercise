/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap.exercise9.bai1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TLC
 */
public class bai1_server1 {
 
    public static void main(String[] args) {
    ServerSocket serverSocket;
        BufferedWriter bos=null;
    Socket socket=null;
        try {
             serverSocket = new ServerSocket(1233);
            System.out.println("dang cho ket noi");
             socket = serverSocket.accept();
             System.out.println("ket noi thanh cong! dang gui mesager! .....");
            //cho client ket noi toi server!
            //tu server se gui du lieu cho client
            // 
            
           OutputStream out = socket.getOutputStream();
           bos  = new BufferedWriter(new OutputStreamWriter(out));
            //gui sang client 1 chuoi 
            
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY ");
            
            String mes = dateFormat.format(date);
            bos.write(mes);
            bos.flush();
            
        } catch (IOException ex) {
            Logger.getLogger(bai1_server1.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                
            bos.close();
            } catch (Exception e) {
                System.out.println("ket noi loi");
            }
            try {
                socket.close();
            } catch (Exception e) {
            }
        }
        
    }
}
 
