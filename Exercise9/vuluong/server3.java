/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap.exercise9.bai3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TLC
 */
public class server3 {

    public static String chuyen(int a) {
        String str = "";
        switch (a) {
            case 1:
                str = "ban nhap vao so mot";
                break;
            case 2:
                str = "ban nhap vao so hai";
                break;
            case 3:
                str = "ban nhap vao so ba";
                break;
            case 4:
                str = "ban nhap vao so bon";
                break;
            case 5:
                str = "ban nhap vao so nam";
                break;
            case 6:
                str = "ban nhap vao so sau";
                break;
            case 7:
                str = "ban nhap vao so bay";
                break;
            case 8:
                str = "ban nhap vao so tam";
                break;
            case 9:
                str = "ban nhap vao so chin";
                break;
        }
        return str;
    }

    static ServerSocket serverSocket;
    static Socket socket = null;
    static BufferedWriter bw = null;
    static BufferedReader br = null;

    public static void main(String[] args) throws Exception {
        serverSocket = new ServerSocket(1111);
        System.out.println("doi ket noi toi server...");
        socket = serverSocket.accept();
        System.out.println("ket noi thanh cong");

        int a;
        while (true) {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            a = br.read();
            System.out.println("client: " + a);

//            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//            bw.write(chuyen(a));
//            bw.flush();
            PrintStream ps = new PrintStream(socket.getOutputStream());
            ps.println(chuyen(a));

        }
//            bw.close();
//            br.close();
//            socket.close();

    }
}
