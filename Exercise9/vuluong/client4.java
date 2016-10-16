/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap.exercise9.bai3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TLC
 */
public class client4 {

    static String nhap() {
        String mau3 = "([-]|[*|+|/ ])\\s\\d{1,9}\\s\\d{1,9}";
        Scanner nhap = new Scanner(System.in);
        String chuoi;
        do {
            System.out.print("nhập vào biểu thức:  ");
            chuoi = nhap.nextLine();

        } while (!chuoi.matches(mau3));
        return chuoi;
    }
    static Socket socket = null;
    static BufferedWriter bw = null;
    static BufferedReader br = null;

    public static void main(String[] args) throws Exception {
        try {
            socket = new Socket("localhost", 1111);
            while (true) {
                bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                bw.write(nhap());
                bw.newLine();
                bw.flush();

                //doc du lieu tu server gui lai:
                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String mes = br.readLine();
                System.err.println("server: " + mes);
            }
        } catch (IOException ex) {
            Logger.getLogger(client4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
