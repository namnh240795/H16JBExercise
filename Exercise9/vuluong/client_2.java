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
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TLC
 */
public class client_2 {

    static Socket socket = null;
    static BufferedWriter bw = null;
    static BufferedReader br = null;

    public static void main(String[] args) {

        try {
            socket = new Socket("localhost", 567);

            //client ghi du lieu duoc nhap tu ban phim sang server
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            System.out.print("nhap dong du lieu de gui sang server: ");
            bw.write(new Scanner(System.in).nextLine());
            bw.newLine();
            bw.flush();


            //doc du lieu tu server gui tra lai:
            try {
                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String mesNhan = br.readLine();
                System.out.println("server: " + mesNhan);
            } catch (IOException ex) {
                Logger.getLogger(client_2.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(client_2.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(client_2.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                socket.close();
            } catch (IOException ex) {
                Logger.getLogger(client_2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
