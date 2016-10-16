/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap.exercise9.bai1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TLC
 */
public class client_1 {

    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader bis=null;
        
        try {
            System.out.println("dang ket noi toi sever...");
             socket = new Socket("localhost", 1233);
            
            //lay du lieu tu server
             bis = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            String mes=bis.readLine();
            System.out.println("du lieu nhan tu server: "+mes);
        } catch (IOException ex) {
            Logger.getLogger(client_1.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                bis.close();
            } catch (Exception e) {
            }
            try {
                socket.close();
            } catch (Exception e) {
            }
        }
    }
  
}
 

