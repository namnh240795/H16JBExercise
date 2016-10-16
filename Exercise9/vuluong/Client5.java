/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket.mutil_thread_socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TLC
 */
public class Client5 {
    
    static int nhap() {
        Scanner scan = new Scanner(System.in);
        System.out.println("nhập số thứ tự của sinh viên: ");
        int a = 0;
        boolean check = true;
        do {
            try {
                a = scan.nextInt();
                check = false;
            } catch (Exception e) {
                System.out.print("nhập lại:");
                scan.nextLine();
            }

        } while (check == true);
        return a;
    }

    public static void main(String[] args) {
        String mesSend;
        String mesReceive;
        try {
            Scanner nhap = new Scanner(System.in);
            int so=nhap();
            int port =9000+so;
            
            
//            InetSocketAddress adr = new InetSocketAddress("localshot", 9009);
            Socket socket = new Socket("localhost", 1111,InetAddress.getByName("localhost"),port);
            
            System.out.println("OK. chào sinh viên số: "+ so+" đã kết nối tới Server! ");
            
            System.out.println("cong ket noi: "+socket);
            
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintStream ps = new PrintStream(socket.getOutputStream());
                System.out.println("nhap 1 dong gui sang server: ");
            while (true) {

                mesSend = nhap.nextLine();
                ps.println(mesSend);
                
                mesReceive = inFromServer.readLine();
                if("tam biet!".equals(mesReceive)){
                System.err.println("server: " + mesReceive);
                    break;
                }else
                System.err.println("server: " + mesReceive);
            }
        } catch (IOException ex) {
            Logger.getLogger(Client5.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
