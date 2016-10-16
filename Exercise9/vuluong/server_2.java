/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap.exercise9.bai2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TLC
 */
public class server_2 {

    static ServerSocket serverSocket;
    static Socket socket = null;
    static BufferedWriter bw = null;
    static BufferedReader br = null;

    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(567);
            System.out.println("dang cho ket noi...");
            socket = serverSocket.accept();
            System.out.println("ket noi thanh cong: ...");

            //gui dong du lieu String toi client;
            
            try {
                String mes = "da nhan duoc du lieu!";
                bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                bw.write(mes);

                bw.flush();
            } catch (IOException ex) {
                Logger.getLogger(server_2.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //server nhan dong du lieu tu client roi hien thi len 
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String mesNhan = br.readLine();
                System.out.println("client: " + mesNhan);

        } catch (IOException ex) {
            Logger.getLogger(server_2.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(server_2.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                socket.close();
            } catch (IOException ex) {
                Logger.getLogger(server_2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
