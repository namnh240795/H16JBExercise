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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TLC
 */
public class server4 {

    static String xuLy(String s) {
        String a[] = s.split(" ");
        int result=0;
        switch (a[0]) {
            case "+":
                result = Integer.parseInt(a[1]) + Integer.parseInt(a[2]);
                break;
            case "-":
                result = Integer.parseInt(a[1]) - Integer.parseInt(a[2]);
                break;
            case "*":
                result = Integer.parseInt(a[1]) * Integer.parseInt(a[2]);
                break;
            case "/":
                result = Integer.parseInt(a[1]) / Integer.parseInt(a[2]);
                break;
        }

//        if("+".equals(a[0])){
//            
//        }
        return "bieu thuc: ( "+a[1]+" "+a[0]+" "+ a[2]+ " ) co gia tri la: "+result;
    }
    static Socket socket = null;
    static BufferedWriter bw = null;
    static BufferedReader br = null;

    public static void main(String[] args) throws Exception {
        try {
            ServerSocket severSocket = new ServerSocket(1111);
            System.out.println("Đang chờ kết nối .....");
            socket = severSocket.accept();
            System.out.println("kết nối thành công! đang xử lý dữ liệu.... ");
            while (true) {

                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String in = br.readLine();
                System.out.println("dữ liệu nhận: " + in);
                System.out.println(": "+xuLy(in));
                //xử lý dữ liệu


                PrintStream ps = new PrintStream(socket.getOutputStream());
                ps.println(xuLy(in));
//                bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//                bw.write(xuLy(in));
//                bw.flush();

            }

        } catch (IOException ex) {
            Logger.getLogger(server4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
