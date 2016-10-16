/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap.exercise9.bai3;

import baitap.exercise9.bai2.client_2;
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
public class client3 {

    public static int nhap() {
        Scanner nhap = new Scanner(System.in);
        int a = 0;
        int c = 0;
        boolean check = false;
        while (check == false) {
            System.out.print(" ");
            try {
                a = nhap.nextInt();
                if (a >= 1 && a < 9) {

                    c = a;
                    check = true;
                } else {

                    System.out.println("phai la 1 so tu 1 den 9!: ");
                }
            } catch (Exception e) {
                System.out.println("phai la 1 so tu 1 den 9!: ");
                nhap.nextLine();
            }
        }
        return a;
    }
    static Socket socket = null;
    static BufferedWriter bw = null;
    static BufferedReader br = null;

    public static void main(String[] args) throws Exception {
        socket = new Socket("localhost", 1111);

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//                    String str = br.readLine();
//                    System.out.println("server: "+str);
////                    br.close();
//                } catch (IOException ex) {
//                    Logger.getLogger(client3.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }).start();
        //ghi du lieu len socket
        while (true) {

            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write(nhap());
            bw.flush();
            System.out.println("");

            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String str = br.readLine();
            System.out.println("server: " + str);

        }
//            bw.close();
//            socket.close();

    }

}
