/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket.mutil_thread_socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TLC
 */
public class server5 {
    public static void main(String[] args) {
        ServerSocket serverSock=null;
    int port=9000;int a=2;
        try {
             serverSock = new ServerSocket(1111,a);
            while(true){
                //dang cho ke tnoi toi server5;
                System.out.println("dang ket noi toi server...");
                Socket socket=serverSock.accept();
                new ThreadSocket5(socket,port++).start();
                
                System.out.println("da ket noi! dang xu ly...");
                System.out.println("serversocket: "+serverSock);
                System.out.println("ten thread:  "+Thread.currentThread().getName());
                System.out.println("id thread ket noi: "+Thread.currentThread().getId());
            }
        } catch (IOException ex) {
            Logger.getLogger(server5.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
