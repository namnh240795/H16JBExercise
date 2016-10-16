/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket.mutil_thread_socket;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TLC
 */
public class ThreadSocket5 extends Thread {
    int port;
    Socket socket =null;
    BufferedReader fromClient=null;
    public ThreadSocket5 (Socket socket,int port ){
        this.socket = socket;
        this.port=port;
        System.out.println("tao ket noi toi client: "+this.port+ " at: "+socket.toString());
    }
    
    public String xuly(String s) {
        //mang so nguyen a
        //lay so nho nhat trong mang so nguyen a
        //out ra so nho nhat duoi dang string
        //neu khong phai thi tr lai tring sai ding dang
        String mau = "(nhonhat)\\s\\d{1}";
        if ("thoat".equals(s)) {
            return "thoat";
        } else if (s.matches(mau)) {
            String a[] = s.split(" ");
            int c=Integer.parseInt(a[1]);
            int min = 1000;
            int mang[]= new int[c];
            Random m = new Random();
            int b = m.nextInt(1000);
            for(int i=0;i<c;i++){
                mang[i]=b;
                if(min>mang[i]){
                    min=mang[i];
                }
            }
            
            return "KETQUA: "+min;
        }else return "sai dinh dang";

    }
    public void run(){
        try {
            PrintStream ps = new PrintStream(socket.getOutputStream());
             fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while(true){
                String mesFromClient = fromClient.readLine();//chuoi nhan duoc tu client;
                System.err.println("client: "+mesFromClient);
                if("quit".equals(mesFromClient)){
                    String mes = "tam biet!";
                    ps.println(mes);
                    break;
                }
                String mesToClient = xuly(mesFromClient);
                ps.println(mesToClient);
                System.out.println("ten cua thread dang chay: "+Thread.currentThread().getName());
                System.out.println("id cua thread dang chay: "+Thread.currentThread().getId());
                
            }
        } catch (IOException ex) {
            Logger.getLogger(ThreadSocket5.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
